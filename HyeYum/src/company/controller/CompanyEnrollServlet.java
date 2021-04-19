package company.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import company.model.service.CompanyService;
import company.model.vo.Company;

/**
 * Servlet implementation class CompanyEnrollServlet
 */
@WebServlet("/company/enroll")
public class CompanyEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompanyEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/views/board/companyList.jsp").forward(request, response); 
		// 경로..? ? ? ? ? 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enroll 서블릿=======================");
		request.setCharacterEncoding("UTF-8");
		
		Company company = new Company();
		
		company.setCompanyName(request.getParameter("company-name"));
		company.setCompanyNumber(request.getParameter("company-no"));
		company.setPhone(request.getParameter("company-phone"));
		company.setEmail(request.getParameter("company-email"));
		
		System.out.println(company.getCompanyCode());
		System.out.println(company.getCompanyName());
		System.out.println(company.getCompanyNumber());
		System.out.println(company.getPhone());
		System.out.println(company.getContents());
		System.out.println(company.getAddress());
		System.out.println(company.getEmail());
		System.out.println(company.getPartnership());
		System.out.println(company.getEnrollDate());
		
		int result = new CompanyService().registerCompany(company);
		if(result > 0) {
		
			request.getRequestDispatcher("/company/list").forward(request, response);
		}else {
			
		}
		}
		/// 모르곘음...
	
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

