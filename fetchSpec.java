import java.io.*;
import java.sql.*;
import java.util.Scanner;
public class fetchSpec
{
	public static void main(String arg[])
	{
		try
		{
			Scanner s = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
			System.out.print("Enter user id to see details:");
			String uid = s.next();
			
			String sql="select * from msusers where user_id='"+uid+"'";
			
			Statement stmt = con.createStatement();
			
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				System.out.println("User_id:"+rs.getString(1));
				System.out.println("User_name:"+rs.getString(2));
				System.out.println("password:"+rs.getString(3));
				System.out.println("Role:"+rs.getString(4));
				System.out.println();
			}
			
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
