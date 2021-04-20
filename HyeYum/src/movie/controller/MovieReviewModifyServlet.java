package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.model.service.MovieService;
import movie.model.vo.MovieReview;

/**
 * Servlet implementation class MovieReviewModifyServlet
 */
@WebServlet("/movieReview/modify")
public class MovieReviewModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieReviewModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int reviewNo = Integer.parseInt(request.getParameter("review-no"));
		MovieReview movieReview = new MovieService().printOneMovieReview(reviewNo);
		if(movieReview != null ) {
			request.setAttribute("movieReview", movieReview);
			request.getRequestDispatcher("/WEB-INF/views/movie/movieInfoList.jsp").forward(request, response);
		} else {
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
		
		int reviewNo = Integer.parseInt(request.getParameter("review-no"));
		int star = Integer.parseInt(request.getParameter("star-rating"));
		//String star = request.getParameter("star-rating"));
		int infoNo = Integer.parseInt(request.getParameter("info-no"));
		String content = request.getParameter("content");
		String spoiler = request.getParameter("spoiler");
		
		System.out.println("review-no :" + reviewNo);
		
		MovieReview movieReview = new MovieReview();
		movieReview.setInfoNo(infoNo);
		movieReview.setReNo(reviewNo);
		movieReview.setStarRating(star);
		movieReview.setContents(content);
		movieReview.setSpoiler(spoiler);
		int result = new MovieService().modifyMovieReview(movieReview);
		
		if (result > 0) {
			// response.sendRedirect("/movieRecommend/list");
			PrintWriter out = response.getWriter();

			out.println("<script> alert('게시글이 수정되었습니다.');");
			out.println("location.href='/movieReview/list';");
			out.println("</script>");
		} else {
			request.getRequestDispatcher("/WEB-INF/views/movie/movieError.html").forward(request, response);
		}
	}

}
