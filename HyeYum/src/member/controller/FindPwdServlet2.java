package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.service.FindService;
import member.model.vo.Member;

/**
 * Servlet implementation class FindPwdServlet2
 */
@WebServlet("/member/find/pwd/2")
public class FindPwdServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindPwdServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("name");
		String email = request.getParameter("email");
		String newPwd = request.getParameter("newPwd");
		Member member = new FindService().findOneNameEmail(userName, email);
		
		if(member!=null) {
			new FindService().updatePwd(userName, newPwd);
			System.out.println("여기오냐..?");
			request.setAttribute("member", member);
			response.sendRedirect("/intro/find/pwdSuccess.jsp");
			
		} else {
			PrintWriter out = response.getWriter();
			out.println("<script>alert('입력하신 이름과 이메일이 일치하지 않습니다.');history.back(); </script>");
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
