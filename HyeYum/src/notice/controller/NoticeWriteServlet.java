package notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.service.NoticeService;
import notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet("/hyeyumNotice/write")
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/hyeyumNoticeWrite.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8"); // 보내는 내용에 한글이 있을 수 있기 때문에 인코딩해요
		
		/*//String title = request.getParameter("title");
		//String content = request.getParameter("content"); // 여기 파란색 subject, content는 어디랑 같아야
														 // 하나요?
		//HttpSession session = request.getSession(); // 로그인한 사용자니까 세션에서 정보 가져오기
		//if(session != null && (session.getAttribute("userId")) != null) {
			
			//String userId = (String)session.getAttribute("userId");
			
			//Notice notice = new Notice();
			// notice.setTitle(title);
			 // notice.setContents(contents);
			 //notice.setUserId(userId);
			
			int result = new NoticeService().registerNotice(notice);
			if(result > 0) {
				response.sendRedirect("/notice/list"); // 여기서 전달값으로 페이지를 주는 것이 아니라
														// url을 넘겨준다는 것을 보셔야합니다.
			}else {
				RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/noticeError.html");
				view.forward(request, response);
			}
		}else {
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/notice/serviceFailed.html");
			view.forward(request, response);*/
		}
		
	}




















