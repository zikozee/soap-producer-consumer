package com.zikozee.spring.soap.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @author : zikoz
 * @created : 24 Aug, 2021
 */

@Configuration
public class SoapConfig {

    @Bean
    public Jaxb2Marshaller marshaller(){
        Jaxb2Marshaller marsh = new Jaxb2Marshaller();
        marsh.setPackagesToScan("com.zikozee.spring.soap.api.loaneligibility");
        return marsh;
    }
}
