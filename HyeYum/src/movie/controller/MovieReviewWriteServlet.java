package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import movie.model.service.MovieService;
import movie.model.vo.MovieReview;

/**
 * Servlet implementation class MovieReviewEnrollServlet
 */
@WebServlet("/movieReview/write")
public class MovieReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieReviewWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("인포라이트서블릿 ㅇㅇ");
		request.getRequestDispatcher("/WEB-INF/views/movie/movieInfoList.jsp").forward(request, response);
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

		int infoNo = Integer.parseInt(request.getParameter("info-no"));
		int star = Integer.parseInt(request.getParameter("star-rating"));
		String content = request.getParameter("content");
		String ticketNum = request.getParameter("ticket-number");
		String spoiler = request.getParameter("spoiler");

		HttpSession session = request.getSession();
		if (session != null && (session.getAttribute("userId")) != null) {
			String userId = (String) session.getAttribute("userId");
			MovieReview review = new MovieReview();
			review.setInfoNo(infoNo);
			review.setContents(content);
			review.setTicketNumber(ticketNum);
			review.setNick(userId);
			review.setStarRating(star);
			review.setSpoiler(spoiler);

			int result = new MovieService().registerMovieReview(review);
			if (result > 0) {
				PrintWriter out = response.getWriter();

				out.println("<script> alert('게시글이 등록되었습니다.');");
				out.println("location.href='/movieReview/list';");
				out.println("</script>");
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/views/movie/movieError.html").forward(request, response);
		}
	}

}
