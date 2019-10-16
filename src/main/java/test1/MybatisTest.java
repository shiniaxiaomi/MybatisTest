package test1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by Administrator on 2019/10/15.
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver");//加载mysql驱动

        String url="jdbc:mysql://127.0.0.1:3306/test";//数据库地址
        String userName="root";//用户名
        String password="123456";//密码

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try {
            connection = DriverManager.getConnection(url, userName, password);
            String sql="select * from user where id=?";//要执行的sql语句
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,2);//设置参数(id=2)

            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                System.out.println(resultSet.getString("name"));//获取字段名name的值
                System.out.println(resultSet.getString("age"));//获取字段名age的值
            }
        }finally {
            //在finally中关闭之前打开的资源
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }
    }
}
