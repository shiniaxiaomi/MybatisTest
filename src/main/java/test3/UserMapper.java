package test3;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import test2.User;

/**
 * Created by Yingjie.Lu on 2019/10/16.
 */
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User selectUser(int id);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);

    @Update("update user set age=#{age} where id=#{id}")
    int updateUser(User user);

    @Insert("insert into user (name,age) values (#{name},#{age})")
    int addUser(User user);
}
