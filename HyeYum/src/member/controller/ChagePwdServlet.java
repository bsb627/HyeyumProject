package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class DeletePassServlet
 */
@WebServlet("/member/chagePwd")
public class ChagePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChagePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/chagePwd.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.setCharacterEncoding("UTF-8");
		 * response.setCharacterEncoding("UTF-8");
		 * response.setContentType("text/html; charset=UTF-8");
		 * 
		 * HttpSession session = request.getSession(); String userId =
		 * (String)session.getAttribute("userId"); String userPwd =
		 * request.getParameter("user-pass");
		 * 
		 * Member member = new MemberService().selectOneMember(userId, userPwd);
		 * 
		 * if(member!=null) { request.setAttribute("member", member); RequestDispatcher
		 * view =
		 * request.getRequestDispatcher("/WEB-INF/views/member/deleteMember.jsp");
		 * view.forward(request, response); }
		 */
	}

}
