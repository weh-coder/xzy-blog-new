import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) throws SQLException {
        Connection connection = MyConnection.connection_mysql();
        PreparedStatement presql1;   //预处理对象
        String sql = "insert into user values(?,?)";
        presql1 = connection.prepareStatement(sql);
        presql1.setInt(1,4);
        presql1.setString(2,"小灵123");
        int res = presql1.executeUpdate(); //成功插入式返回1
        if(res==1){
            System.out.println("插入成功");
        }
        connection.close();
    }
}
