package com.azuray.decodeme.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azuray.decodeme.entity.vo.Demo;

@RestController
@RequestMapping("/demo")
public class DemoController {

    @Value("${default.key}")
    private String sentence;

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String demo() {
        System.out.println(sentence);
        return "hello spring boot!";
    }


    @RequestMapping(value = "/say2",method = RequestMethod.GET)
    public Demo demo2() {
        Demo demo = new Demo();
        demo.setKey("key");
        demo.setValue("value");
        return demo;
    }

    @RequestMapping(value = "say3", method = RequestMethod.GET)
    public void demo3() {

    }
}
