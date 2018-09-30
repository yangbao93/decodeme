package com.azuray.decodeme.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.azuray.decodeme.entity.vo.Demo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/demo")
@Api(value = "DemoController", description = "DemoController的API")
public class DemoController {

    @ApiOperation(value = "测试接口1", notes = "测试输出")
    @ApiImplicitParam(name = "value", value = "打印字段", dataType = "String")
    @RequestMapping(value = "/say", method = RequestMethod.POST)
    public String demo(String value) {
        System.out.println(value);
        return "hello spring boot!";
    }

    @RequestMapping(value = "/say2", method = RequestMethod.GET)
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
