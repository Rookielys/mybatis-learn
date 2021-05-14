package org.apache.ibatis.mytest;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

  User selectUserById(@Param("user") User user);

  int updateUser(Integer id);
}
