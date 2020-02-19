package com.meiyukai;

import com.meiyukai.domain.User;
import com.meiyukai.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class jpaTest {

    @Resource(name = "userRepository")
    private UserRepository userRepository;

    @Test
    public void testFindAll(){
    List<User> users  =  userRepository.findAll();
    for(User user : users ){
        System.out.println("user :  "   + user);
    }
    }

}
