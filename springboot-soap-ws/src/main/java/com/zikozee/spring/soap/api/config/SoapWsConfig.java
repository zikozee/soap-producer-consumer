package com.zikozee.spring.soap.api.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import static com.zikozee.spring.soap.api.endpoint.LoanEligibilityIndicatorEndpoint.NAMESPACE;

/**
 * @author : zikoz
 * @created : 24 Aug, 2021
 */

@Configuration
@EnableWs
public class  SoapWsConfig {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "loanEligibility")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema){
        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
        defaultWsdl11Definition.setPortTypeName("LoanEligibilityIndicatorEndpoint");
        defaultWsdl11Definition.setLocationUri("/ws");
        defaultWsdl11Definition.setTargetNamespace(NAMESPACE);
        defaultWsdl11Definition.setSchema(schema);
        return defaultWsdl11Definition;
    }

    //todo call ::::http://localhost:8080/ws/<BEAN_NAME>.wsdl

//    @Bean(name = "loanEligibility2")
//    public DefaultWsdl11Definition defaultWsdl11Definition2(XsdSchema schema){
//        DefaultWsdl11Definition defaultWsdl11Definition = new DefaultWsdl11Definition();
//        defaultWsdl11Definition.setPortTypeName("LoanEligibilityIndicatorEndpoint");
//        defaultWsdl11Definition.setLocationUri("/ws");
//        defaultWsdl11Definition.setTargetNamespace(NAMESPACE);
//        defaultWsdl11Definition.setSchema(schema);
//        return defaultWsdl11Definition;
//    }

    //todo
    // we can define multiple bean endpoints as above and its respective schema location
   //checkout this for adding multiple: https://stackoverflow.com/questions/44760591/loading-multiple-beans-in-spring-boot-using-soap-web-service

    @Bean
    public XsdSchema schema(){
        return new SimpleXsdSchema(new ClassPathResource("xsd/loaneligibility.xsd"));
    }

}