package RailwayLogIn;

import java.util.*;
import java.sql.*;

public class Registration 
{
	public static void main(String[] args) throws SQLSyntaxErrorException
	{
		Scanner sc=new Scanner(System.in);
		try(sc;)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##radha123","radhika123");
				PreparedStatement ps1=con.prepareStatement("insert * userReg values(?,?,?,?,?,?,?)");
				PreparedStatement ps2=con.prepareStatement("select * from userReg where username=? and password=?");
				while(true)
				{
					System.out.println("*********choice*********");
					System.out.println("\t1.Registration"+
										"\n\t2.LogIn"+
										"\n\t3.Exit");
					System.out.println("Enter the choice....");
					int choice=sc.nextInt();
					
					switch(choice)
					{
					case 1:
						System.out.println("********Registration***********");
						System.out.println("Enter the userName :");
						String uname=sc.next();
						System.out.println("Enter the First name :");
						String fname=sc.next();
						System.out.println("Enter the last name :");
						String lname=sc.next();
						System.out.println("Enter the your address :");
						String add=sc.next();
						System.out.println("Enter the your Email :");
						String mail=sc.next();
						System.out.println("Enter your password :");
						String pass=sc.next();
						System.out.println("Enter your mobile number :");
						//int mob=Integer.parseInt(sc.nextLine());
						int mob=sc.nextInt();
						ps1.setString(1, uname);
						ps1.setString(2, fname);
						ps1.setString(3, lname);
						ps1.setString(4, add);
						ps1.setString(5, mail);
						ps1.setString(6, pass);
						ps1.setInt(7, mob);
						int k=ps1.executeUpdate();
						if(k>0)
						{
							System.out.println("Registration successfully....");
						}
						break;
					case 2:
						System.out.println("Enter the username :");
						String uname1=sc.nextLine();
						System.out.println("Enter the password :");
						String pass1=sc.nextLine();
						ps2.setString(1, uname1);
						ps2.setString(2, pass1);
						ResultSet rs2=ps2.executeQuery();
						if(rs2.next())
						{
							System.out.println("username : "+rs2.getString(1)+
												"\nFname :"+rs2.getString(2)+
												"\nLname :"+rs2.getString(3)+
												"\naddress :"+rs2.getString(4)+
												"\nmailId:"+rs2.getString(5)+
												"\npassword :"+rs2.getString(6)+
												"\nPhoneNo :"+rs2.getInt(7));
						}
						else
						{
							System.out.println("Invalid username and pass.....");
						}
						break;
					case 3:
						System.out.println("Operations Stopped....");
						System.exit(0);
					default :
						System.out.println("Invalid choice.....");
						}
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
	}

}
