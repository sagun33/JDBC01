import java.sql.*;

public class JdbcUtils {

    private static Connection connection;
    private static Statement statement;


    //1. Adım: Driver'a kaydol
    //2. Adım: Datbase'e bağlan
    public static Connection connectToDataBase(String hostName, String dbName, String username, String password) {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


        try {
            connection = DriverManager.getConnection("jdbc:postgresql://" + hostName + ":5432/" + dbName, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (connection != null) {
            System.out.println("Connection Success");
        } else {
            System.out.println("Connection Fail");
        }

        return connection;
    }

    //3. Adım: Statement oluştur.
    public static Statement createStatement() {


        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return statement;
    }

    //4. Adım: Query çalıştır.
    public static boolean execute(String sql) {
        boolean isExecute;
        try {
            isExecute = statement.execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return isExecute;
    }

    //5.adim
    public static ResultSet resultSet(String sql)  {
        String sql2 = "SELECT * FROM companies WHERE number_of_employees = (SELECT MIN(number_of_employees) FROM companies)";

        ResultSet resultSet1 = null;
        try {
            resultSet1 = statement.executeQuery(sql2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        while (true) {
            try {
                if (!resultSet1.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                System.out.println(resultSet1.getInt(1) + "--" + resultSet1.getString(2) + "--" + resultSet1.getInt(3));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

        return resultSet1;
    }

    //6. Adım: Bağlantı ve Statement'ı kapat.
    public static void closeConnectionAndStatement() {

        try {
            connection.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            if (connection.isClosed() && statement.isClosed()) {
                System.out.println("Connection and statement closed!");

            } else {
                System.out.println("Connection and statement NOT closed!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Table oluşturan method
    public static void createTable(String tableName, String... columnName_dataType) {
        StringBuilder columnName_dataValue = new StringBuilder("");

        for (String w : columnName_dataType) {

            columnName_dataValue.append(w).append(",");

        }

        columnName_dataValue.deleteCharAt(columnName_dataValue.length() - 1);

        try {
            statement.execute("CREATE TABLE " + tableName + "  " + columnName_dataValue + "  ");

            System.out.println("Table "+ tableName+" succesfully created");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
