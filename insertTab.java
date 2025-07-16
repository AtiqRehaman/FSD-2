import java.io.*;
import java.sql.*;
public class insertTab
{
public static void main(String arg[])
{
try
{
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");


String sql="insert into MsUsers values ('101', 'Atiq', '5454', 'Student')";

Statement stmt = con.createStatement();

stmt.executeUpdate(sql);
System.out.println("Inserted data!");

con.close();
}
catch(Exception e)
{
System.out.println(e);
}
}
}