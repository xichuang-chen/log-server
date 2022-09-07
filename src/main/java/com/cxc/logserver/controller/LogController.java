package com.cxc.logserver.controller;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("log")
public class LogController {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private static final Logger shortMessageLogger = LogManager.getLogger("shortMessageLogger");

    @GetMapping("/test11")
    public String test11(@RequestHeader("X-Transaction-Id") String traceId) {
        System.out.println("traceId: " + traceId);
        return traceId;
    }

    @GetMapping("/test")
    public String test() {

        logger.info("this is for logger");
        shortMessageLogger.info("this is for self log");

        return "success";
    }
}
