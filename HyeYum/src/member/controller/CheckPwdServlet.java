package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/member/checkPwd")
public class CheckPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * request.getRequestDispatcher("/WEB-INF/views/member/chagePwd.jsp").forward(
		 * request, response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  request.setCharacterEncoding("UTF-8");
		  response.setCharacterEncoding("UTF-8");
		  response.setContentType("text/html; charset=UTF-8");
		  HttpSession session = request.getSession(); 
		  String userId = (String)session.getAttribute("userId");
		  String userPwd = request.getParameter("password");
		  System.out.println("패스워드 : "+userPwd);
		  Member member = new MemberService().selectOneMember(userId, userPwd);
		  
		  PrintWriter out = response.getWriter();
		  if(member!=null) {
			  out.print("1");
		  }else {
			  out.print("0");
		  }

	}
}
