package com.haojiabao.service.serviceImpl;

import com.haojiabao.entity.User;
import com.haojiabao.repository.UserRepository;
import com.haojiabao.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Resource
    private UserRepository userRepository;

    /**
     * 保存对象
     * @param user User
     * @return User
     */
    @Override
    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    /**
     *
     * 根据id删除对象
     * @param id 主键id
     */
    @Override
    public void delete(int id){
        userRepository.deleteById(id);
    }

    /**
     * 查询所有数据
     * @return 返回所有User对象
     */
    @Override
    public Iterable<User> getAll(){
        return userRepository.findAll();
    }

    /**
     * 根据id查询数据
     * @param id 主键id
     * @return User对象
     */
    @Override
    public User gerById(Integer id){
        //根据id查询对应的持久化对象
        Optional<User> op=userRepository.findById(id);
        return op.get();
    }

    /**
     * 更新User
     * @param user user对象
     */
    @Override
    public void update(User user){
        Optional<User> userdo=userRepository.findById(user.getId());
        userdo.get().setUsername(user.getUsername());
        userdo.get().setPassword(user.getPassword());
        userdo.get().setRole(user.getRole());
        userdo.get().setState(user.getState());
        userRepository.save(userdo.get());
    }
}
