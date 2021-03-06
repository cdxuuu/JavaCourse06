package com.cdx.course.week05.controller;

import com.cdx.course.week05.entity.User;
import com.cdx.course.week05.entity.User2;
import com.cdx.course.week05.mapper.UserMapper;
import com.cdx.course.week05.mapper.UserMapperXML;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;
import java.util.UUID;

@RestController
@RequestMapping("/user/")
public class UserController {

  @Resource
  private UserMapper userMapper;

  @Resource
  private UserMapperXML userMapperXML;

  @Resource
  private SqlSessionTemplate sqlSessionTemplate;

  /**
   * 增加一个用户
   */
  @RequestMapping(value = "/insert")
  public User insertUser(User user) {
    /**
     * 这里有一个问题，就是插入成功后，不会返回主键u_id
     * 需要使用 @Options注解
     */
    //    userMapper.insertUser(user);
    userMapperXML.insertUser(user);
    //    sqlSessionTemplate.insert("user-namespace.insertUser",user);
    return user;
  }

  /**
   * 删除一个用户
   */
  @RequestMapping(value = "/delete/{pathId}")
  public String deleteUser(@PathVariable("pathId") Integer uId) {
    //    int i = userMapper.deleteUserById(uId);
    int i = userMapperXML.deleteUserById(uId);
    //    int i = sqlSessionTemplate.delete("user-namespace.deleteUserById",uId);
    if (i != 0) {
      return "删除成功";
    } else {
      return "删除失败";
    }
  }

  /**
   * 更新一个用户
   */
  @RequestMapping(value = "/update/{pathId}")
  public User2 updatetUser(@PathVariable("pathId") Integer uId) {
    User2 user = userMapperXML.getUserById(uId);
    user.setName("名字" + new Random().nextInt(10));
    user.setAge(new Random().nextInt(100));
    user.setTestField(UUID.randomUUID().toString());
    //    userMapper.updateUser(user);
    userMapperXML.updateUser(user);
    //    sqlSessionTemplate.update("user-namespace.updateUser", user);
    return userMapperXML.getUserById(uId);
  }

  /**
   * 查询一个用户
   */
  @GetMapping(value = "/get/{pathId}")
  public User2 getUser(@PathVariable("pathId") Integer uId) {
    //    return userMapper.getUserById(uId);
    return userMapperXML.getUserById(uId);
    //    return sqlSessionTemplate.selectOne("user-namespace.getUserById", uId);
  }


  /**
   * 多数据源查询一个用户
   */
  @GetMapping(value = "/datasource/{uId}")
  public String testDataSource(@PathVariable("uId") Integer uId) {
    User user = userMapper.getUserById(uId);
    User2 user2 = userMapperXML.getUserById(uId);
    return user.toString() + "\n" + user2.toString();
  }

}
