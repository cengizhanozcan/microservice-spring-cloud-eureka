package com.ceng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cengizhan Ozcan on 26.04.2018.
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @RequestMapping("/default")
    public @ResponseBody String getDefaultAdress() {
        return "Ankara";
    }
}
