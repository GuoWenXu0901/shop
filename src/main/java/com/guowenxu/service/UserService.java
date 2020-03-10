package com.guowenxu.service;

import com.guowenxu.entiy.User;

import java.util.List;

public interface UserService {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    boolean save(User user);

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    boolean delete(Integer id);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    boolean update(User user);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 查找一个用户
     *
     * @return
     */
    User findOne(Integer id);
}
