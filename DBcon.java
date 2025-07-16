import java.io.*;
import java.sql.*;
public class DBcon
{
public static void main(String arg[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");

if(con!=null)
{
System.out.println("Connection Established");
}
con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}