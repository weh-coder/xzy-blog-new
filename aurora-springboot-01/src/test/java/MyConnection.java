import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @Description: 连接数据库
 * @Author: weh
 * @Date: 2022/4/21 11:42
 */
public class MyConnection {

    private static final String JDBC_Driver;
    private static final String url;
    private static final String userName;
    private static final String userPd;

    static {
        JDBC_Driver = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://192.168.174.134:3306/test?useSSL=false&characterEncoding=UTF-8&serverTimezone=UTC";
        userName = "root";
        userPd = "weh123456";
    }


    public static Connection connection_mysql() {
        Connection connection = null;
        try {
            Class.forName(JDBC_Driver);//启动加载数据库驱动
            System.out.println("加载成功！");
        } catch (Exception e) {
            System.out.println("加载失败！");
        }
        try {
            connection = DriverManager.getConnection(url, userName, userPd);
            if (connection != null) {
                System.out.println("连接数据库启动成功！");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public static void close(Connection connection){
        try {
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
