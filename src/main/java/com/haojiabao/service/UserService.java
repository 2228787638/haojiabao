package com.haojiabao.service;

import com.haojiabao.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public interface UserService {
    /**
     * 保存对象
     * @param user User
     * @return User
     */
    @Transactional
    public User save(User user);
    /**
     *
     * 根据id删除对象
     * @param id 主键id
     */
    public void delete(int id);
    /**
     * 查询所有数据
     * @return 返回所有User对象
     */
    public Iterable<User> getAll();
    /**
     * 根据id查询数据
     * @param id 主键id
     * @return User对象
     */
    public User gerById(Integer id);
    /**
     * 更新User
     * @param user user对象
     */
    public void update(User user);
}
