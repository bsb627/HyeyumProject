package member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.service.BookService;
import book.model.vo.BookPageData;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import member.model.service.MyPostService;
import member.model.vo.MyPost;
import member.model.vo.MyPostPageData;
import movie.model.service.MovieService;
import movie.model.vo.MoviePageData;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;
import show.model.service.ShowService;
import show.model.vo.ShowPageData;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class MessagePrintServlet
 */
@WebServlet("/myPost")
public class MyPostListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPostListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset = UTF-8");
		
		
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		request.setAttribute("userId", userId);
		
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
//		request.getParameter("board-name");
		 
		//MyPostPageData pPageData = new MyPostService().printAllList(currentPage,userId);
		BookPageData brPageData = new MyPostService().printAllBookReview(currentPage,userId); 
		BookPageData bsPageData = new MyPostService().printAllBookShare(currentPage,userId); 
		MoviePageData mrvPageData = new MyPostService().printAllMovieReviewList(currentPage,userId);
		MoviePageData mrcPageData = new MyPostService().printAllMovieRecommend(currentPage,userId);
		ShowPageData sPageData = new MyPostService().printAllShowReview(currentPage, userId);
		System.out.println("brPageData : "+brPageData);
		System.out.println("bsPageData : "+bsPageData);
		System.out.println("mrvPageData : "+mrvPageData);
		System.out.println("mrcPageData : "+mrcPageData);
		System.out.println("sPageData : "+sPageData);
		//ArrayList<MyPost> pList = pPageData.getMyPList();
		ArrayList<BookReview> brList = brPageData.getReviewList();
		ArrayList<BookShare> bsList = bsPageData.getShareList();
		ArrayList<MovieReview> mrvList = mrvPageData.getReviewList();
		ArrayList<MovieRecommend> mrcList = mrcPageData.getRecommendList();
		ArrayList<ShowReview> srList = sPageData.getReviewList();
		System.out.println("brList : "+brList);
		System.out.println("bsList : "+bsList);
		System.out.println("mrvList : "+mrvList);
		System.out.println("mrcList : "+mrcList);
		System.out.println("srList : "+srList);
		
		//String pPageNavi = pPageData.getPageNavi();
		String brPageNavi = brPageData.getPageNavi();
		String bsPageNavi = bsPageData.getPageNavi();
		String mrvPageNavi = mrvPageData.getPageNavi();
		String mrcPageNavi = mrcPageData.getPageNavi();
		String sPageNavi = sPageData.getPageNavi();
		if(!brList.isEmpty()) {
			
			//request.setAttribute("pList", pList);
			request.setAttribute("brList", brList);
			request.setAttribute("bsList", bsList);
			request.setAttribute("mrvList", mrvList);
			request.setAttribute("mrcList", mrcList);
			request.setAttribute("srList", srList);
			
			//request.setAttribute("pageNavi", pPageNavi);
			request.setAttribute("pageNavi", brPageNavi);
			request.setAttribute("pageNavi", bsPageNavi);
			request.setAttribute("pageNavi", mrvPageNavi);
			request.setAttribute("pageNavi", mrcPageNavi);
			request.setAttribute("pageNavi", sPageNavi);
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/myPostList.jsp");
			view.forward(request, response);
		}else {
			
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
