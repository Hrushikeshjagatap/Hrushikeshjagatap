package contrller_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookDAO;

/**
 * Servlet implementation class ShowBooks
 */
public class ShowBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowBooks() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		BookDAO dao = new BookDAO();
		try {
			ResultSet rs=dao.getAllBooks();
			pw.write("<html><table border='1'>"
			+"<tr>"
			+"<td>BookId</td>"
			+"<td>BookName</td>"
			+"<td>Author</td>"
			+"<td>Price</td></tr>");
			while(rs.next())
			{
				pw.write("<tr>");
				pw.write("<td>"+rs.getInt(1)
				+"</td><td>"+rs.getString(2)
				+"</td><td>"+rs.getString(3)
				+"</td><td>"+rs.getDouble(4)
				+"</td></tr>");

			}
			pw.write("</table></html>");
			pw.write("<a href='index.html'>IndexPage</a>");	
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
