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
 * Servlet implementation class DeleteBook
 */
public class DeleteBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBook() {
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
		try
		{
		Bookpojo bobj=new Bookpojo();

		bobj.setName(name);
		BookDAO dao=new BookDAO();
		boolean r=dao.deleteBook(bobj);
		if(r)
		{
			pw.write("book Delete");
			request.getRequestDispatcher("ShowBooks").forward(request, response);


				}
		else
		{
			request.getRequestDispatcher("DeleteBook.html").include(request, response);

		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
