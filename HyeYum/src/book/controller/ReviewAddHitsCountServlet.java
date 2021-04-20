package book.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.service.BookService;
import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import file.model.service.FileService;
import file.model.vo.FileData;
import reply.model.service.ReplyService;
import reply.model.vo.Reply;
import show.model.service.ShowService;

/**
 * Servlet implementation class AddHitsCountServlet
 */
@WebServlet("/bookReview/hitsCount")
public class ReviewAddHitsCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewAddHitsCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("BookReviewHitsCountServlet ================================================================");
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int reviewNo = 0;
		try {
			reviewNo = Integer.parseInt(request.getParameter("review-no"));
			
		} catch (Exception e) {
			
			if(reviewNo == 0) {
				reviewNo = (int) request.getAttribute("no");
			}
		}
//		String replyType = "review";
		int currentPage = 0;
		if (request.getParameter("currentPage") == null) {
			currentPage = 1;
		}else {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int likes = 0;
		if (request.getParameter("likes") !=  null) {
			likes = Integer.parseInt(request.getParameter("likes"));
		}else {
			likes = new BookService().getLikesReview(userId,reviewNo);
		}
		
//		 ReplyPageData pageData = new ReplyService().printAllReply(currentPage,
//		 replyType,showNo); ArrayList<Reply> replyList = pageData.getReplyList();
//		 String pageNavi = pageData.getPageNavi();
		 
		ArrayList<Reply> rList = new ReplyService().printReplyList(reviewNo); 
		int totalCount = new ReplyService().totalCountBookReview(reviewNo);
		int addHitsResult = new BookService().addHitsCount(reviewNo);
		System.out.println(String.format("addHitsCount update result for reviewNo(%d) : %b", reviewNo, addHitsResult > 0));
		
		FileData fileData = new FileService().printFile(reviewNo);
		System.out.println("file : "+fileData);

		BookReview review = new BookService().printOneBookReview(reviewNo);
		System.out.println("addhits서블릿, review : " + review);

		if(review != null) {
			request.setAttribute("review", review);
			request.setAttribute("rList", rList);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("likes", likes);
			request.setAttribute("fileData", fileData);
			request.getRequestDispatcher("/bookReview/detail").forward(request, response);
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
