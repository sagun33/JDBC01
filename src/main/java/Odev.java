import java.sql.Connection;
import java.sql.Statement;

public class Odev {
    /* - Type code to ask user to enter the int elements and add elements into the list
        - Ask user to enter the elements to remove, then remove that element from list.
        - Ask user to enter the element to update, then update it.
        
        Kullanıcıdan int öğelerini girmesini ve listeye öğe eklemesini istemek için kod yazın
         - Kullanıcıdan kaldırılacak öğeleri girmesini isteyin, ardından bu öğeyi listeden kaldırın.
         - Kullanıcıdan güncellemek için öğeyi girmesini isteyin, ardından güncelleyin.

  */
    public static void main(String[] args) {

        Connection con=JdbcUtils.connectToDataBase("localhost","postgres,","postgres","Bismillah1982." );
        Statement st=JdbcUtils.createStatement();
        
        String sql1="create table Ogrenci_Listesi,isim varchar(20),soyisim varchar(20),ogrenci_id int";
        boolean sqlb1=JdbcUtils.execute(sql1);
        System.out.println("sqlb1 = " + sqlb1);

        

    }
}
