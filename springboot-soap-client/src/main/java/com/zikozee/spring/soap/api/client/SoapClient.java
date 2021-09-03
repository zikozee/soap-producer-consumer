package com.zikozee.spring.soap.api.client;


import com.zikozee.spring.soap.api.loaneligibility.Acknowledgement;
import com.zikozee.spring.soap.api.loaneligibility.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

/**
 * @author : zikoz
 * @created : 24 Aug, 2021
 */

@Service
@RequiredArgsConstructor
public class SoapClient {

    private final Jaxb2Marshaller marshaller;

    private WebServiceTemplate template;

    public Acknowledgement getLoanStatus(CustomerRequest request){
        template = new WebServiceTemplate(marshaller);
        Acknowledgement acknowledgement = (Acknowledgement) template.marshalSendAndReceive("http://localhost:8080/ws", request);
        return acknowledgement;

    }
}
