package org.hao.homedepot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class StatusController {

    Logger logger = LoggerFactory.getLogger(StatusController.class);



    @GetMapping(value = "")
    public String getStatus() {

        logger.info("getStatus");

        return "it works";
    }
}
