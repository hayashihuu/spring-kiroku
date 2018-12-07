package com.syun.springsessionredis.controller;

import com.syun.springsessionredis.service.RedisLockHelper;
import com.syun.springsessionredis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

/**
 * @description:
 * @program: spring-session-redis
 * @author: syun
 * @create: 2018-11-08 14:58
 */
@Controller
public class RedisTestController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private RedisLockHelper lockHelper;


    @RequestMapping("/testredis")
    @ResponseBody
    public String test02() {
        System.out.println("testtestredis");
        redisService.List();
        return "success";

    }

    @RequestMapping("/test03")
    @ResponseBody
    public String test03(){
        redisService.hash();
        return "hash";
    }

    @RequestMapping("/test04")
    @ResponseBody
    public String test04(){
        redisService.sortSet();
        return "zset";
    }

    @RequestMapping("/object")
    @ResponseBody
    public List<Object> testObject(){

        return redisService.object();

    }


    @RequestMapping("/testLock")
    @ResponseBody
    public String testLock(@RequestParam("id") String id) {

        if (lockHelper.lock(id, new Date().toString(), 10L)) {
            return "success";
        }else {
            return "now option";
        }
//        redisService.setnxTest(id);
//        return "success";
    }



}
