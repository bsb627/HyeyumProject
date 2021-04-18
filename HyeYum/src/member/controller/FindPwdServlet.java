package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import member.model.service.FindService;
import member.model.vo.Member;

/**
 * Servlet implementation class FindPwdServlet
 */
@WebServlet("/member/find/pwd")
public class FindPwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("user-id");
		Member member = new FindService().findOneId(userId);
		
		if(member!=null) {
			request.setAttribute("member", member);
			RequestDispatcher view = request.getRequestDispatcher("/intro/find/findPwd2.jsp");
			view.forward(request, response);
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('입력하신 아이디를 찾을 수가 없습니다.') return false </script>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String userName = request.getParameter("user-name");
//		String email = request.getParameter("email");
//		String newPwd = request.getParameter("new-pwd");
//		Member member = new FindService().findOneNameEmail(userName, email);
//		
//		if(member!=null) {
//			new FindService().updatePwd(userName, newPwd);
//			System.out.println("여기오냐..?");
//			request.setAttribute("member", member);
//			response.sendRedirect("/intro/find/pwdSuccess.jsp");
//			
//		} else {
//			PrintWriter out = response.getWriter();
//			out.println("<script>alert('입력하신 이름과 이메일이 일치하지 않습니다.');history.back(); </script>");
//		}
		
	}

}
