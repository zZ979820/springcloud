package com.itheima;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.mapper.userMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootMybatisApplication.class)
public class redisTest {
    @Autowired
    private RedisTemplate<String,String> redis;

    @Autowired
    private userMapper userMapper;
    @Test
    public void redisTest() throws JsonProcessingException {
        //1.从redis中获取数据
        String s = redis.boundValueOps("user").get();
        //2.判断redis中有没有数据
        if(s == null){
            // 没有则从数据库获取
            List<User> users = userMapper.queryUserList();
            //转成Json格式
            ObjectMapper objectMapper=new ObjectMapper();
            s = objectMapper.writeValueAsString(users);
            //保存到缓存中
            redis.boundValueOps("user").set(s);
            System.out.println("从数据库中获取得数据........");
        }else {
            System.out.println("从缓存中获取得数据......");
        }

        //打印结果
        System.out.println(s);
    }
}
