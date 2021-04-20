package member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/member/enroll")
public class EnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("들어옴");
		request.getRequestDispatcher("/WEB-INF/views/member/enroll.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  request.setCharacterEncoding("UTF-8"); 
		  // user-id, user-pwd , user-repwd,user-name, user-nick, user-email,
		   // user-address, 
		  String address1 = request.getParameter("user-address1");
		  String address2 = request.getParameter("user-address2");
		  String address = address1 + " " + address2;
		  Member member = new Member(); 
		  
		  member.setUserId(request.getParameter("user-id"));
		  member.setUserPwd(request.getParameter("user-pwd"));
		  member.setUserName(request.getParameter("user-name"));
		  member.setUserNick(request.getParameter("user-nick"));
		  member.setUserEmail(request.getParameter("user-email"));
		  member.setUserAddress(address);
		
		  
		 int result = new MemberService().registerMember(member); 
		  if (result > 0) { //회원가입 성공 
			  response.sendRedirect("/index.jsp"); 
		  } else {
		 response.sendRedirect("/WEB-INF/views/member/memberError.html"); }
		
		
	}

}
