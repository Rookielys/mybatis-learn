/**
 *    Copyright 2009-2020 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.mytest;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;
import java.util.List;

// 二级缓存需要可序列化
//@Alias("user")
//@Data
//@AllArgsConstructor
public class User implements Serializable {
  private Integer id;
  private String name;
  private List<Info> infos;
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

  public List<Info> getInfos() {
    return infos;
  }

  public void setInfos(List<Info> infos) {
    this.infos = infos;
  }

  public Info getInfo() {
    return info;
  }

  public void setInfo(Info info) {
    this.info = info;
  }
}
