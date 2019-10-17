package test2;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * Created by Yingjie.Lu on 2019/10/16.
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        // 指定全局配置文件
        String resource = "test2/mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 获取sqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //查询
            User user = sqlSession.selectOne("MyMapper.selectUser", 1);//(命令空间+id,传入的参数)
            User user1 = sqlSession.selectOne("MyMapper.selectUser", 1);//(命令空间+id,传入的参数)
            System.out.println(user);
//            //新增
//            int insert = sqlSession.insert("MyMapper.insertUser", new User("zhangsan", 1));
//            System.out.println(insert);
//            //修改
//            int update = sqlSession.update("MyMapper.updateUser", new User(1, null, 2));
//            System.out.println(update);
//            //删除
//            int delete = sqlSession.delete("MyMapper.deleteUser", 1);
//            System.out.println(delete);


//            User user = sqlSession.selectOne("MyMapper.selectTest", new User(1, "1", 1));
//            System.out.println(user);

//            int update = sqlSession.update("MyMapper.upateTest", new User(1, null, 1));
//            System.out.println(update);

            //提交事务
//            sqlSession.commit();
        } finally {
            //关闭sqlSession
            sqlSession.close();
        }
    }
}
