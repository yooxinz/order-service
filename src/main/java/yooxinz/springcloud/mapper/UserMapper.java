package yooxinz.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import yooxinz.springcloud.dto.User;

/**
 * Created by star on 2018/9/23.
 */
@Mapper
public interface UserMapper {

    User getUserNameById(Long userId);

}
