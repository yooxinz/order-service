package yooxinz.springcloud.service;

import yooxinz.springcloud.dto.User;

/**
 * Created by star on 2018/9/23.
 */
public interface UserService {

    User getUserNameById(Long userId);

    void executeAsyncTask(Integer i);
}
