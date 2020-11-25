package org.apache.ibatis.mytest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

// 二级缓存需要可序列化
//@Alias("user")
@Data
@AllArgsConstructor
public class User implements Serializable {
  private Integer id;
  private String name;
}
