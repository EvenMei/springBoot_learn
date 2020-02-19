package com.meiyukai;

import com.meiyukai.dao.UserMapper;
import com.meiyukai.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class mybatisTest {

    @Autowired
    private UserMapper mapper;

    @Test
    public void test(){
        List<User> users = mapper.findAll();
        for(User user : users){
            System.out.println("user   :   " + user);
        }
    }

}
