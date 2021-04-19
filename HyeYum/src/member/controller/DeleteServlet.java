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
@WebServlet("/member/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.getAttribute("userId");
        
		String userId = (String)session.getAttribute("userId");
		Member member = new MemberService().selectOneById(userId);
		
		if (member != null) {
			request.setAttribute("member", member);
			
			request.getRequestDispatcher("/WEB-INF/views/member/deletePwd.jsp").forward(request, response);
		}  else {
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	
		
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
		
		int result = new MemberService().deleteMember(userId);
		if(result > 0) {

			PrintWriter out=response.getWriter();
            out.println("<script>");
            out.println("alert('회원탈퇴가 정상적으로 되었습니다.');");
			/* out.println("location.href='/member/logout';"); */
            out.println("location.href='/index.jsp';");
            out.println("</script>");
            
            session.invalidate();
            
		} else {
			response.sendRedirect("/member/memberError.html");
		}

	}

}
