package jdbc1;


import org.postgresql.util.PSQLException;

import java.sql.*;

public class JdbcStatementDemo1 {

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Bismillah1982.");

            Statement statement = connection.createStatement();

                String ddlSql = "CREATE TABLE IF NOT EXISTS employees"
                        + "(emp_id int PRIMARY KEY AUTO_INCREMENT, name varchar(30),"
                        + "position varchar(30), salary double)";
        System.out.println(statement.execute(ddlSql));

        String insertSql = "INSERT INTO employees(name, position, salary) VALUES('john', 'developer', 2000)";

                if (statement.executeUpdate(insertSql) == 1) {

                    String selectSql = "SELECT * FROM employees";
                    ResultSet resultSet = statement.executeQuery(selectSql);

                    while (resultSet.next()) {
                        String employee = "Id : '" + resultSet.getInt(1) + "' name : '"
                                + resultSet.getString(2) + "' position : '"
                                + resultSet.getString(3) + "' salary : '"
                                + resultSet.getDouble(4) + "'";
                        System.out.println(employee);
                    }
                }
            }

    }
