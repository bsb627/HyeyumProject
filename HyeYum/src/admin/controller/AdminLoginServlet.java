package admin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import admin.model.dao.AdminDAO;
import admin.model.service.AdminService;
import member.model.service.DonateService;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		request.setCharacterEncoding("UTF-8");
		String userId = request.getParameter("user-id");
		String userPwd = request.getParameter("user-pwd");
		
		Member member = new MemberService().selectOneMember(userId, userPwd);
		HttpSession session = request.getSession();
		session.setAttribute("userId", member.getUserId());

		int bookAllCount = new DonateService().countAllBook();
		int movieAllCount = new DonateService().countAllMovie();
		int showAllCount = new DonateService().countAllShow();
		int memberAllCount = new DonateService().countAllMember();
		
		if(member!=null && userId.equals("admin") ) {
			request.setAttribute("bookAllCount", bookAllCount);
			request.setAttribute("movieAllCount", movieAllCount);
			request.setAttribute("showAllCount", showAllCount);
			request.setAttribute("memberAllCount", memberAllCount);
			
			RequestDispatcher view = request.getRequestDispatcher("/admin/index.jsp");
			view.forward(request, response);
		}else {
			
		}
	}

}
