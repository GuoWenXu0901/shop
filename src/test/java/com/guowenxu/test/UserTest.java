package com.guowenxu.test;

import com.guowenxu.entiy.User;
import com.guowenxu.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    /**
     * 测试保存操作
     */
    @Test
    public void testSave(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        User user = new User("admin", "123");

        userService.save(user);
    }

    /**
     * 测试删除操作
     */
    @Test
    public void testDelete(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.delete(3);
    }

    /**
     * 测试修改操作
     */
    @Test
    public void testUpdate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        User user = new User(2,"admin", "123");

        userService.update(user);
    }

    /**
     * 测试查询全部操作
     */
    @Test
    public void testFindAll(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.findAll();
    }

    /**
     * 测试查询单个操作
     */
    @Test
    public void testFindOne(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);

        userService.findOne(1);
    }

}
