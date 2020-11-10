package org.apache.ibatis.mytest;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

  //@Select("select * from myuser where id = #{id}")
  User selectUserById(Integer id);

  int updateUser(Integer id);
}
