package com.azuray.decodeme.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @describe swagger2相关配置，用于后端测试和提供接口文档
 * @url 登录界面：http://localhost:8888/swagger-ui.html#/
 * @author yb
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                .select()
                //当前包路径
                .apis(RequestHandlerSelectors.basePackage("com.azuray.decodeme.controller"))
                .paths(PathSelectors.any())
                .build();

    }

    //构建api文档的详细信息函数
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("decodeme项目RESTful API")
                //创建人
                .contact(new Contact("admin", "", ""))
                //版本号
                .version("1.0")
                //描述
                .description("decodeme项目中接口").build();
    }

}
