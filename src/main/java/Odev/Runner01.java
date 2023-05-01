package Odev;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Runner01 {
    public static void main(String[] args) {
       Connection con= JdbcUtils.connectToDataBase("localhost","postgres","postgres","Bismillah1982.");
        Statement st=JdbcUtils.createStatement();
        boolean ex=JdbcUtils.execute("CREATE TABLE Gunay_Ailesi (isim VARCHAR(20),soyisim varchar(20), yaslar INT, address VARCHAR(80))");
        JdbcUtils.createTable("Gunay_Ailesi", "isim","soyisim","yas","adres");
        ResultSet rs=JdbcUtils.executeQuery("select * from Gunay_Ailesi");
        JdbcUtils.insertDataIntoTable("Gunay_Ailesi","Salih","Gunay","40","Turkei");
        List<Object> list = JdbcUtils.getColumnList("isim","soyisim");
        System.out.println("list = " + list);




    }


}
