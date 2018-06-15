package com.azuray.decodeme.controller;

import com.azuray.decodeme.entity.Demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("demo")
public class DemoController {

    @RequestMapping(value = "say",method = RequestMethod.GET)
    public String demo() {
        return "hello spring boot!";
    }


    @RequestMapping(value = "say2",method = RequestMethod.GET)
    public Demo demo2() {
        Demo demo = new Demo();
        demo.setKey("key");
        demo.setValue("value");
        return demo;
    }
}
