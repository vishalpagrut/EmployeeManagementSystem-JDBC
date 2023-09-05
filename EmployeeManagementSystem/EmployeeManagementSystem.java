package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

//import FileHandling.CreatingMenuProgram;

/*
There are 5 steps to connect the jdbc with mysql

1.load the driver

2.create the connection(url, username, password)
mysql default port number : 3306 
jdbc:mysql://localhost:3306/yourdatabaseName

3.create the statement

4.execute the query

5.close the connection  // optional from jdk 1.8
	pc - ip address (localhost)
*/

public class EmployeeManagementSystem 
{
	
	public void input()
	{
		int n1;
		do
		{
			
			Scanner sc=new Scanner(System.in);
			System.out.println("Enter your choice from the following menu:");
			
			System.out.println(" 1. Add employee info \n 2. All employee  \n 3. update the employee information \n 4. Search "
								+ "	the employee  \n 5. Remove the employee. \n 6. exit");
			int ch=sc.nextInt();
			if(ch==6)
			{	
				System.out.println("Exit from system");
				break;
			}
			switch(ch)
			{
			case 1 :
				
				System.out.println("Enter id");
				String id=sc.next();
				
				System.out.println("Enter passwaord");
				String pass=sc.next();
				
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",id,pass);
					
					String sql="insert into EMS values(?,?,?,?,?,?)";
					
					PreparedStatement ps =con.prepareStatement(sql);
					ps.setInt(1, 414);
					ps.setString(2, "nilesh");
					ps.setInt(3, 32000);
					ps.setString(4, "mumbai");
					ps.setString(5, "27-08-1995");
					ps.setString(6, "at pune");
					ps.executeUpdate();
				
					
					System.out.println("data has been succesfully updated");
					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			break;
		case 2 :
				
	
	System.out.println("Enter id");
	String id3=sc.next();
	System.out.println("Enter passwaord");
	String pass3=sc.next();
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",id3,pass3);
		
		String sql="select *from EMS";
		PreparedStatement ps =con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+" "+rs.getString(2));
		}
		
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
				
			break;
			
			
			case 3 :
				
				try
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","vishal@123");
					
					System.out.println("Enter name : ");
					String name=sc.next();
					
					System.out.println("Enter id : ");
					int id1 =sc.nextInt();
					
					String sql= "update EMS set name=? where id=?";
					
					PreparedStatement ps =con.prepareStatement(sql);
					
					ps.setString(1, name);
					ps.setInt(2, id1);
					
					 ps.executeUpdate();
					
					 System.out.println("Data updated succesfully");
					
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			break;
			
			case 4:
				
				try
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","vishal@123");
					
					System.out.println("Enter id to search the data : ");
					int id4 =sc.nextInt();
					
					String sql= "select *from EMS where id = "+id4;
					
					PreparedStatement ps =con.prepareStatement(sql);
					
					ResultSet rs = ps.executeQuery();
				
					while(rs.next())
					{
						System.out.println(rs.getInt(1)+" "+rs.getString(2));
					}	
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
				
			break;
			
			case 5 :
				
				int status =0;
				
				try
				{
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","vishal@123");
					
					System.out.println("Enter id to delete the data : ");
					int id4=sc.nextInt();
					
					String sql= "delete from EMS where id = "+id4;
					
					PreparedStatement ps =con.prepareStatement(sql);
					
					status = ps.executeUpdate();
					
					if(status>0)
					
					System.out.println("Deleted data successfully....");	
					else
						System.out.println("Data not found");
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
				
				break;
			case 6:
				System.out.println("Exit from system");
			break;
				
				default : 
					System.out.println("Invalid Choice");
					break;
			}
				
			System.out.println("Press 1 to continue  and pres 6 for exit : ");
			n1 = sc.nextInt();
			
//			if(n1==6)
//			{
//				System.out.println("Exit from system");
//				break;
//			}
		}while(n1==1);
	}

	public static void main(String[] args) {
		
		EmployeeManagementSystem ob = new EmployeeManagementSystem();
		ob.input();
		

	}

}