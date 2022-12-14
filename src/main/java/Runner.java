
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Runner {

    public static void main(String[] args) throws SQLException {
        //1.adim:Drivera kaydol
        //2.adim:Database baglan
        Connection connection = JdbcUtils.connectToDataBase("localhost", "postgres", "postgres", "Bismillah1982.");


        //3. Adım: Statement oluştur.
        Statement statement = JdbcUtils.createStatement();

        //4. Adım: Query çalıştır.
        //JdbcUtils.execute("CREATE TABLE students (name VARCHAR(20), id INT, address VARCHAR(80))");
        JdbcUtils.createTable("def","classe Varchar(20)","teacher_name varchar(20)","id int");

        //5. Adım: Bağlantı ve Statement'ı kapat.

        JdbcUtils.closeConnectionAndStatement();

    }
}
