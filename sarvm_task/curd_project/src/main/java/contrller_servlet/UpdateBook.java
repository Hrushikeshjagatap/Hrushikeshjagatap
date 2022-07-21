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
 * Servlet implementation class UpdateBook
 */
public class UpdateBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		String name=request.getParameter("name");
		double price=Double.parseDouble(request.getParameter("price"));
		Bookpojo bobj=new Bookpojo();
		bobj.setName(name);
		bobj.setPrice(price);
		BookDAO dao=new BookDAO();
		boolean r=dao.updateBook(bobj);
		if(r==true)
		{
			pw.write("Book Update....");
			request.getRequestDispatcher("ShowBooks").forward(request, response);

		}
		else
		{
			response.setContentType("text/html");
			pw.write("Book not found...<br>");
			request.getRequestDispatcher("UpdateBook.html").include(request, response);
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
