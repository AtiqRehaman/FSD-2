import java.io.*;
import java.sql.*;
public class updateTab
{
public static void main(String arg[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");


String sql="update msusers set password='8019' where user_name='Atiq'";

Statement stmt = con.createStatement();

stmt.executeUpdate(sql);
System.out.println("Update success!");

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}