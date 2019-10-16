package test3;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import test2.User;

import java.io.InputStream;

/**
 * Created by Yingjie.Lu on 2019/10/16.
 */
public class MybatisTest {

    public static void main(String[] args) throws Exception {

        // 指定全局配置文件
        String resource = "test3/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 由于使用注解,所以再主配置文件中没有mapper,需要再代码中显示注册该mapper接口
        sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);//注册注解类Mapper

        //开启一个会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try{

            //通过接口类获取到对应的注解Mapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);

            //查询
            User user = mapper.selectUser(2);
            System.out.println(user);

            //删除
            int delete = mapper.deleteUser(3);
            System.out.println(delete);

            //更改
            int update = mapper.updateUser(new User(4, "zhangsan", 4));
            System.out.println(update);

            //新增
            int insert = mapper.addUser(new User("232", 534));
            System.out.println(insert);


            //提交事务
            sqlSession.commit();
        }finally {

            //关闭会话
            sqlSession.close();
        }


    }

}
