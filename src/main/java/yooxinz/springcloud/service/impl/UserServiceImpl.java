package yooxinz.springcloud.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import yooxinz.springcloud.dto.User;
import yooxinz.springcloud.mapper.UserMapper;
import yooxinz.springcloud.service.UserService;

/**
 * Created by star on 2018/9/23.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserNameById(Long userId) {
        return userMapper.getUserNameById(userId);
    }

    @Async
    @Override
    public void executeAsyncTask(Integer i){
        System.out.println("执行异步任务" + i);
    }
}
