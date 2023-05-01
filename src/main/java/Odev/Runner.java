package Odev;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

  /* - Type code to ask user to enter the int elements and add elements into the list
        - Ask user to enter the elements to remove, then remove that element from list.
        - Ask user to enter the element to update, then update it.

        Kullanıcıdan int öğelerini girmesini ve listeye öğe eklemesini istemek için kod yazın
         - Kullanıcıdan kaldırılacak öğeleri girmesini isteyin, ardından bu öğeyi listeden kaldırın.
         - Kullanıcıdan güncellemek için öğeyi girmesini isteyin, ardından güncelleyin.

  */

public class Runner {

    public static void main(String[] args) {
        //1. Adım: Driver'a kaydol
        //2. Adım: Datbase'e bağlan
        Connection connection = JdbcUtils.connectToDataBase("localhost","postgres","postgres","Bismillah1982.");

        //3. Adım: Statement oluştur.
        Statement statement = JdbcUtils.createStatement();

        //4. Adım: Query çalıştır.
        //JdbcUtils.execute("CREATE TABLE students (name VARCHAR(20), id INT, address VARCHAR(80))");

        //JdbcUtils.createTable("def","classes VARCHAR(20)","teacher_name VARCHAR(20)","id INT");

        //Table'a data girme methodu
        JdbcUtils.insertDataIntoTable("countries","country_name 'Turkey'","country_id 'TR'","region_id 1");//VARARG değerleri ' ' içine alınız.

        //Sütun Değerlerini List içerisine alan method
        //List<Object> list = JdbcUtils.getColumnList("country_id","countries");
       // System.out.println("list = " + list);

        //5. Adım: Bağlantı ve Statement'ı kapat.
        JdbcUtils.closeConnectionAndStatement();

    }

}
