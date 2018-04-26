package com.ceng.controller;

import com.ceng.model.ClientName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author Cengizhan Ozcan on 26.04.2018.
 */
@RestController
@RequestMapping("/webapp")
public class SentenceController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/sentence")
    public @ResponseBody String getSentence() {
        StringBuilder builder = new StringBuilder();
        builder.append("Name: ")
                .append(callEndpoint(ClientName.EUREKA_CLIENT_PERSON))
                .append("<br>")
                .append("City: ")
                .append(callEndpoint(ClientName.EUREKA_CLIENT_ADDRESS));

        return builder.toString();
    }

    @RequestMapping("/getClientUris")
    public @ResponseBody String getClientUris() {
        StringBuilder builder = new StringBuilder();
        builder.append(ClientName.EUREKA_CLIENT_ADDRESS.name())
                .append(": ")
                .append(getClientUri(ClientName.EUREKA_CLIENT_ADDRESS))
                .append("<br>")
                .append(ClientName.EUREKA_CLIENT_PERSON.name())
                .append(": ")
                .append(getClientUri(ClientName.EUREKA_CLIENT_PERSON));

        return builder.toString();
    }

    private String callEndpoint(ClientName clientName) {
        String clientUri = getClientUri(clientName);
        if (StringUtils.isEmpty(clientUri)) {
            return "";
        }

        String endpoint = "";
        switch (clientName) {
            case EUREKA_CLIENT_ADDRESS:
                endpoint = "/address/default";
                break;
            case EUREKA_CLIENT_PERSON:
                endpoint = "/person/info";
                break;
        }

        return (new RestTemplate()).getForObject(clientUri + endpoint, String.class);
    }

    private String getClientUri(ClientName clientName) {
        List<ServiceInstance> serviceInstances = client.getInstances(clientName.name());
        if (!CollectionUtils.isEmpty(serviceInstances)) {
            return serviceInstances.get(0).getUri().toString();
        }

        return "unknown uri";
    }

}
