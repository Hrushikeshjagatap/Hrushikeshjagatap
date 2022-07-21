package contrller_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookDAO;
import Model.Bookpojo;

/**
 * Servlet implementation class AddBook
 */
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String author=request.getParameter("author");
		double price=Double.parseDouble(request.getParameter("price"));

		Bookpojo bobj=new Bookpojo(id,name,author,price);

		BookDAO dao=new BookDAO();

		boolean r=dao.addBook(bobj);

		if(r)
		{
			request.getRequestDispatcher("ShowBooks").forward(request, response);

		}
		else
		{
			response.setContentType("text/html");
			pw.write("book all ready persent<br>");
			request.getRequestDispatcher("AddBook.html").include(request, response);


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
