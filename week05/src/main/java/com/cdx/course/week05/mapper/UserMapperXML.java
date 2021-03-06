package com.cdx.course.week05.mapper;


import com.cdx.course.week05.entity.User;
import com.cdx.course.week05.entity.User2;
import org.apache.ibatis.annotations.Mapper;

/**
 * 这是操作数据库的mapper
 * 如果Mapper类特别多的话 可以省略这个注解，但是一定需要在 Application 中使用@MapperScan代替，否则mapper接口无效
 */
@Mapper
public interface UserMapperXML {

  void insertUser(User user);

  int deleteUserById(Integer uId);

  void updateUser(User2 user);

  User2 getUserById(Integer uId);

}
