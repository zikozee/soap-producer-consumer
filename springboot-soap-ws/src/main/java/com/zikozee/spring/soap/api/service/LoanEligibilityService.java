package com.zikozee.spring.soap.api.service;

import com.zikozee.spring.soap.api.loaneligibility.Acknowledgement;
import com.zikozee.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zikoz
 * @created : 24 Aug, 2021
 */

@Service
public class LoanEligibilityService {

    public Acknowledgement checkLoanEligibility(CustomerRequest request){
        Acknowledgement acknowledgement = new Acknowledgement();
        List<String> mismatchCriteriaList = acknowledgement.getCriteriaMismatch();  // remember we get list for mismatch because we used maxOccurs="unbounded"

        if(!(request.getAge() > 30 && request.getAge() <= 60))
            mismatchCriteriaList.add("Person age should be in between 30 to 60");
        if(request.getYearlyIncome() <= 200000 )
            mismatchCriteriaList.add("minimum income should be more than 200000");
        if(request.getCibilScore() <= 500)
            mismatchCriteriaList.add("Low CIBIL Score please try after 6 months");

        if(!mismatchCriteriaList.isEmpty()){
            acknowledgement.setApprovedAmount(0);
            acknowledgement.setIsEligible(false);
        }else{
            acknowledgement.setApprovedAmount(500000);
            acknowledgement.setIsEligible(true);
            mismatchCriteriaList.clear();
        }

        return acknowledgement;
    }
}
