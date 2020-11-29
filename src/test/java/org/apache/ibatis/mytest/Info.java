package org.apache.ibatis.mytest;

import java.io.Serializable;

public class Info implements Serializable {
  private Integer age;
  private String email;

  public Info() {}

  public Info(Integer age, String email) {
    this.age = age;
    this.email = email;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
