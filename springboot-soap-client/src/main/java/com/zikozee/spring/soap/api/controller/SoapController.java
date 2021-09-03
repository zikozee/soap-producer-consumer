package com.zikozee.spring.soap.api.controller;

import com.zikozee.spring.soap.api.client.SoapClient;
import com.zikozee.spring.soap.api.loaneligibility.Acknowledgement;
import com.zikozee.spring.soap.api.loaneligibility.CustomerRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zikoz
 * @created : 24 Aug, 2021
 */

@RestController
@RequiredArgsConstructor
public class SoapController {

    private final SoapClient soapClient;

    @PostMapping("/getLoanStatus")
    public ResponseEntity<Acknowledgement> getLoanStatus(@RequestBody CustomerRequest request){
        return new ResponseEntity<>(soapClient.getLoanStatus(request), HttpStatus.OK);
    }


}
