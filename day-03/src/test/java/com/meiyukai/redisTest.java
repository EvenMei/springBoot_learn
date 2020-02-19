package com.meiyukai;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meiyukai.domain.User;
import com.meiyukai.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class redisTest {

    @Autowired
    private RedisTemplate<String , String> redisTemplate;
    
    @Resource(name = "userRepository")
    private UserRepository userRepository;


    @Test
    public void testRedis() throws Exception {

        // 1. 从 redis 中获取数据
        String userListJson = redisTemplate.boundValueOps("user.findAll").get();

        //2. 判断 redis 中是否存在数据
        if (userListJson == null) {
            //3.不存在就去数据库中查询
            List<User> users = userRepository.findAll();
            //将 list 集合转换成json 格式的String字符串
            ObjectMapper om = new ObjectMapper();
            String jsonString = om.writeValueAsString(users);
            //4. 将返回的数据进行打印
            redisTemplate.boundValueOps("user.findAll").set(jsonString);
            System.out.println("------从数据库查询并保存的数据为 ： " + jsonString);
        } else {
            System.out.println("----- 从redis 中查询的数据为 ： " + userListJson);
        }

    }




}
