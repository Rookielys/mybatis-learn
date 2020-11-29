package org.apache.ibatis.mytest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

// 二级缓存需要可序列化
//@Alias("user")
//@Data
//@AllArgsConstructor
public class User implements Serializable {
  private Integer id;
  private String name;
  private Info info;

  public User() {}

  public User(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }
}
