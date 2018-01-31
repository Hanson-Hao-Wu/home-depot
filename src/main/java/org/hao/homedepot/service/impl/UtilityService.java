package org.hao.homedepot.service.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UtilityService {

	@Value("${homeDepot.customerReview.curseWords}")
    String curseWords;

    Logger logger = LoggerFactory.getLogger(UtilityService.class);

    public boolean isHaveCurseWords(String customerReviewContent){

        List<String> curseWordsList = Arrays.asList(curseWords.split(","));

        return curseWordsList.stream().anyMatch(customerReviewContent.toLowerCase()::contains);

    }

}
