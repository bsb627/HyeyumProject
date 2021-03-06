package show.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import show.model.service.ShowService;
import show.model.vo.ShowInfo;

/**
 * Servlet implementation class ShowBoardDeleteServlet
 */
@WebServlet("/showInfo/list")
public class ShowInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowInfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<ShowInfo> iList = new ShowService().getShowInfoList();
		ArrayList<String> rList = new ShowService().getRegion();
		if(! iList.isEmpty()) {
			request.setAttribute("iList", iList);
			request.setAttribute("rList", rList);
		request.getRequestDispatcher("/WEB-INF/views/show/showInfoList.jsp").forward(request, response);
		}else {
					
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
