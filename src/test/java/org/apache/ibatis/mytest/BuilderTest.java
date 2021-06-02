/**
 *    Copyright 2009-2021 the original author or authors.
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

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.executor.BatchResult;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.*;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Before;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class BuilderTest {

  private DataSource dataSource;

  //@Before
  public void getDataSource() {
    DruidDataSource druidDataSource = new DruidDataSource();
    druidDataSource.setUrl("jdbc:mysql://172.21.116.209:3306/hello?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
    druidDataSource.setUsername("root");
    druidDataSource.setPassword("123456");
    this.dataSource = druidDataSource;
  }

  @Test
  public void Configure() {
    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = new Environment("development", transactionFactory, this.dataSource);
    Configuration configuration = new Configuration(environment);
    configuration.addMapper(UserMapper.class);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);
    SqlSession sqlSession = sqlSessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    System.out.println(userMapper.selectUserById(new User()));
  }

  @Test
  public void configXmlTest() throws Exception {
    String resource = "org/apache/ibatis/mytest/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    Configuration configuration = sqlSessionFactory.getConfiguration();
    SqlSession sqlSession = sqlSessionFactory.openSession();
//    SqlSession sqlSession2 = sqlSessionFactory.openSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    User user = new User();
    user.setName("Jack");
    System.out.println(userMapper.selectUserById(user));
//    User user = new User();
//    user.setId(1);
//    List<User> userList = sqlSession.selectList("org.apache.ibatis.mytest.UserMapper.selectTest", user);
    //System.out.println(userList.get(0).getInfo());;
    sqlSession.close();
//    List<User> userList2 = sqlSession2.selectList("org.apache.ibatis.mytest.UserMapper.selectUserById", 1);
//    sqlSession2.close();
//    int update = sqlSession.update("org.apache.ibatis.mytest.UserMapper.updateUser", 1);
//    List<BatchResult> batchResults = sqlSession.flushStatements();
//    sqlSession.commit();
//    System.out.println(Arrays.toString(batchResults.get(0).getUpdateCounts()));
  }

}
