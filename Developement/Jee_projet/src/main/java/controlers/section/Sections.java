package controlers.section;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Section;
import models.dao.SectionDAO;

import java.io.IOException;
import java.util.ArrayList;

import com.mysql.cj.xdevapi.Result;

/**
 * Servlet implementation class Sections
 */
public class Sections extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sections() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SectionDAO sectionDAO = new SectionDAO();
		String rech = request.getParameter("rech");
		ArrayList<Section> filter = sectionDAO.filterSections(rech);
		request.setAttribute("filterSection", filter);
		RequestDispatcher dispatcher = request.getRequestDispatcher("admin_sections.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
