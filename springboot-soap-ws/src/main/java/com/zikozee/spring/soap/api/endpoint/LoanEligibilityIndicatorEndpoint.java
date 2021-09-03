package com.zikozee.spring.soap.api.endpoint;

import com.zikozee.spring.soap.api.loaneligibility.Acknowledgement;
import com.zikozee.spring.soap.api.loaneligibility.CustomerRequest;
import com.zikozee.spring.soap.api.service.LoanEligibilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * @author : zikoz
 * @created : 24 Aug, 2021
 */

@Endpoint
@RequiredArgsConstructor
public class LoanEligibilityIndicatorEndpoint {

    public static final String NAMESPACE = "http://www.zikozee.com/spring/soap/api/loanEligibility";
    private final LoanEligibilityService service;

    @PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest") // localPart is same as @XmlRootElement
    @ResponsePayload
    public Acknowledgement getLoanStatus(@RequestPayload CustomerRequest request){
        return service.checkLoanEligibility(request);
    }
}
