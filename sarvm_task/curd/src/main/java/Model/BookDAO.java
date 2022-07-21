package Model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database_connectivity.DBService;

public class BookDAO implements DBService {
	Connection con;
	public BookDAO()  {


		try {
			con=getconnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public Connection getconnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/rushi";
		String user="root" ,pass="root";
		con=DriverManager.getConnection(url,user,pass);

		return con;
	}

		public ResultSet getAllBooks() throws SQLException{
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery("select *from book");
		return rs;
	}
		public boolean addBook(Bookpojo bobj)
		{
			boolean res=false;
			try {
				PreparedStatement ps=con.prepareStatement("insert into book values(?,?,?,?)");
				ps.setInt(1, bobj.getId());
				ps.setString(2,bobj.getName());
				ps.setString(3,bobj.getAuthor());
				ps.setDouble(4, bobj.getPrice());
				int ans=ps.executeUpdate();
				if(ans>0)
					res=true;

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return res;
		}
		public boolean updateBook(Bookpojo bobj)
		{
			boolean res=false;
			try {
				PreparedStatement ps=con.prepareStatement("update book set price=? where name=?");
				ps.setDouble(1, bobj.getPrice());
				ps.setString(2, bobj.getName());
				int ans=ps.executeUpdate();
				if(ans>0)
					res=true;


			} catch (SQLException e) {
				e.printStackTrace();
			}
			return res;

		}
		public boolean deleteBook(Bookpojo bobj) throws SQLException
		{
			boolean res=false;
			try
			{

			PreparedStatement ps=con.prepareStatement("delete from book where name=?");
			ps.setString(1, bobj.getName());
			int ans=ps.executeUpdate();

			if(ans>0)
				res=true;
		} catch (SQLException e) {
			e.printStackTrace();
		}


			return res;

		}





}