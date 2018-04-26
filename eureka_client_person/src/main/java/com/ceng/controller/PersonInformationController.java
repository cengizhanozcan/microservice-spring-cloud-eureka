package com.ceng.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Cengizhan Ozcan on 26.04.2018.
 */
@RestController
@RequestMapping("/person")
public class PersonInformationController {

    @RequestMapping("/info")
    public @ResponseBody String getPersonInfoById(){
        return "Cengizhan Ozcan";
    }
}
