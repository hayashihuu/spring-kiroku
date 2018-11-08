package com.syun.springsessionredis.service;

import com.syun.springsessionredis.config.RedisObjectSerializer;
import com.syun.springsessionredis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @program: spring-session-redis
 * @author: syun
 * @create: 2018-11-08 14:41
 */
@Service
@SuppressWarnings("unchecked")
public class RedisService {

    @Autowired
    private RedisTemplate redisTemplate;


    public  void setKey(String key,String value){
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        //1分钟过期
        ops.set(key,value,1, TimeUnit.MINUTES);
    }

    public String getValue(String key){
        ValueOperations<String, String> ops = this.redisTemplate.opsForValue();
        return ops.get(key);
    }

    /**
     * 测试list
     */
    public void List(){

        List<String> list = new ArrayList<>();
        list.add("this ");
        list.add("is ");
        list.add("lists");
        redisTemplate.opsForList().rightPushAll("list1",list);
        System.out.println(redisTemplate.opsForList().range("list1", 0, 10));
    }



    /**
     * 存储实体类
     * @return
     */
    public List<Object> object(){
        System.out.println(redisTemplate);
        redisTemplate.setValueSerializer(new RedisObjectSerializer());
        // 保存对象
        User user = new User("超人", 20);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("蝙蝠侠", 30);
        redisTemplate.opsForValue().set(user.getUsername(), user);

        user = new User("蜘蛛侠", 40);
        redisTemplate.opsForValue().set(user.getUsername(), user);
//        logger.info(redisTemplate.opsForValue().get("超人").getAge().longValue());
//        Assert.assertEquals(30, redisTemplate.opsForValue().get("蝙蝠侠").getAge().longValue());
//        Assert.assertEquals(40, redisTemplate.opsForValue().get("蜘蛛侠").getAge().longValue());

        List<Object> list = Arrays.asList(redisTemplate.opsForValue().get("超人"),
                redisTemplate.opsForValue().get("蝙蝠侠"),
                redisTemplate.opsForValue().get("蜘蛛侠"));
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        return list;
    }

    /**
     * 测试set
     */
    public void set(){
        Set<String> set = new HashSet<>();
        set.add("set1");
        set.add("set2");
        set.add("set3");
        SetOperations ops = redisTemplate.opsForSet();
        ops.add("set", set);
        System.out.println("redis set:" + ops.members("set"));
    }

    /**
     *测试hash
     */
    public void hash(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "syun");
        map.put("age", 11);
        HashOperations ops = redisTemplate.opsForHash();
        ops.putAll("syun", map);
        System.out.println("redis hash: " + ops.entries("syun"));
    }

    /**
     * sortSet的使用
     */
    public void sortSet(){
        ZSetOperations zops = redisTemplate.opsForZSet();
        zops.add("time", "a", 1);
        zops.add("time", "b", 2);
        zops.add("time", "c", 1);
        zops.incrementScore("time", "a", 2);
        System.out.println(zops.reverseRange("time", 0, 10));
    }






}
