package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.service.MemberService;
import member.model.vo.Member;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/member/modify")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("userId");

		String userId = (String) session.getAttribute("userId");
		// System.out.println(userId);
		Member member = new MemberService().selectOneById(userId);
		// System.out.println("=>" + member);
		if (member != null) {
			request.setAttribute("member", member);
			request.getRequestDispatcher("/WEB-INF/views/member/memberInfoDetail.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		// 불러올 정보:USER_ID 수정할 정보 : MEMBER_PWD, USER_PHONE, EMAIL, ADDRESS
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		HttpSession session = request.getSession();
		session.getAttribute("userId");

		String address1 = request.getParameter("userAddress1");
		String address2 = request.getParameter("userAddress2");
		String address = address1 + " " + address2;

		Member member = new Member();
		member.setUserId((String) session.getAttribute("userId"));
		member.setUserPwd(request.getParameter("userPwd"));
		member.setUserName(request.getParameter("userName"));
		member.setUserNick(request.getParameter("userNick"));
		member.setUserPhone(request.getParameter("userPhone"));
		member.setUserEmail(request.getParameter("userEmail"));
		member.setUserAddress(address);
		System.out.println("servlet:" + member);
		int result = new MemberService().modifyMember(member);
		System.out.println("member :" + result);
		if (result > 0) {
			// response.sendRedirect("/index.jsp"); // 성공 시 메인페이지
			PrintWriter out = response.getWriter();
			
			  out.println("<script> alert('정보수정이 완료되었습니다.');");
			  out.println("location.href='/member/myInfo';");
			  out.println("</script>");
			 
			/*
			 * request.getRequestDispatcher("/WEB-INF/views/member/beforeCheck.jsp").forward
			 * (request, response);
			 */
		} else {
			request.getRequestDispatcher("/member/memberError.html").forward(request, response);
			; // 실패
		}
	}

}
