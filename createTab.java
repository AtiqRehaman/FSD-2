import java.io.*;
import java.sql.*;
public class createTab
{
public static void main(String arg[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");


String sql="CREATE TABLE MsUsers(user_id varchar2(10) NOT NULL,user_name varchar(20), password varchar2(20), role varchar2(10))";

Statement stmt = con.createStatement();

stmt.executeUpdate(sql);
System.out.println("Table created!");

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}