import java.io.*;
import java.sql.*;
public class deleteTab
{
public static void main(String args[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");


String sql="delete from msusers where user_name='Mohan'";

Statement stmt = con.createStatement();

stmt.executeUpdate(sql);
System.out.println("Data Deleted!");

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}