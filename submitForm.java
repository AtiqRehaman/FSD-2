import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class submitForm extends Frame implements ActionListener
{
	Label i,n,p,r,msg;
	Button bs,bc;
	TextField uid,un,pwd,rol;
	submitForm()
	{
		setLayout(new GridLayout(6,2));
		i = new Label("UID:");
		n = new Label("Name:");
		p = new Label("Password:");
		r = new Label("Role:");
		msg = new Label("");
		uid = new TextField(20);
		un = new TextField(20);
		pwd = new TextField(20);
		rol = new TextField(20);
		
		pwd.setEchoChar('*');
		bs = new Button("Submit");
		bc = new Button("Cancle");
		
		this.add(i);
		this.add(uid);
		this.add(n);
		this.add(un);
		this.add(p);
		this.add(pwd);
		this.add(r);
		this.add(rol);
		this.add(bs);
		this.add(bc);
		this.add(msg);
		bs.addActionListener(this);
		bc.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		String u_id, u_n, u_pwd, u_rol;
		if(ae.getSource() == bs)
		{
			u_id = uid.getText();
			u_n = un.getText();
			u_pwd = pwd.getText();
			u_rol = rol.getText();
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");


				String sql="insert into MsUsers values('" + u_id + "', '" + u_n + "', '" + u_pwd + "', '" + u_rol + "')";

				Statement stmt = con.createStatement();

				stmt.executeUpdate(sql);
				//System.out.println("Inserted data!");
				msg.setText("Data Inserted Successfully");

				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		if(ae.getSource() == bc)
		{
			uid.setText("" );
			un.setText(" ");
			pwd.setText(" ");
			rol.setText(" ");
			msg.setText("Clear the Data");
		}
	}
	
	public static void main(String args[])
	{
		submitForm sf = new submitForm();
		sf.setVisible(true);
		sf.setSize(400,400);
		sf.setTitle("User Registration");
	}
}