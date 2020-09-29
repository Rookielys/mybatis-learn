package org.apache.ibatis.mytest;

import lombok.Data;
import org.apache.ibatis.type.Alias;

//@Alias("user")
@Data
public class User {
  private Integer id;
  private String name;
}
