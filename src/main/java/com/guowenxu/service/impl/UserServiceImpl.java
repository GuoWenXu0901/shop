package com.guowenxu.service.impl;

import com.guowenxu.dao.UserDao;
import com.guowenxu.entiy.User;
import com.guowenxu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource(name = "userDao")
    private UserDao userDao;

    /**
     * 保存
     *
     * @param user
     * @return
     */
    @Override
    public boolean save(User user) {
        return userDao.save(user);
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @Override
    public boolean delete(Integer id) {
        return userDao.delete(id);
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }

    /**
     * 查找所有
     *
     * @return
     */
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    /**
     * 查找一个
     *
     * @return
     */
    @Override
    public User findOne(Integer id) {
        return userDao.findOne(id);
    }
}
