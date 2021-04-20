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
import book.model.vo.BookShare;
import file.model.service.FileService;
import file.model.vo.FileData;
import reply.model.service.ReplyService;
import reply.model.vo.Reply;

/**
 * Servlet implementation class AddHitsCountServlet
 */
@WebServlet("/bookShare/addHits")
public class ShareAddHitsCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareAddHitsCountServlet() {
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
		int shareNo = 0;
		try {
			shareNo = Integer.parseInt(request.getParameter("share-no"));
			
		} catch (Exception e) {
			
			if(shareNo == 0) {
				shareNo = (int) request.getAttribute("no");
			}
		}
		System.out.println("shareNo addHits 서블릿 : " + shareNo);
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
			likes = new BookService().getLikesShare(userId,shareNo);
		}
		
//		ReplyPageData pageData = new ReplyService().printAllReply(currentPage,
//		replyType,showNo); ArrayList<Reply> replyList = pageData.getReplyList();
//		String pageNavi = pageData.getPageNavi();
		
		ArrayList<Reply> rList = new ReplyService().printReplyList(shareNo); 
		int totalCount = new ReplyService().totalCountBookShare(shareNo);
		int addHitsResult = new BookService().addHitsCountShare(shareNo);
		
		FileData fileData = new FileService().printFile(shareNo);
		System.out.println("file : "+fileData);

		BookShare share = new BookService().printOneBookShare(shareNo);
		System.out.println("addhits서블릿, share : " + share);
		
		if(share != null) {
			request.setAttribute("share", share);
			request.setAttribute("rList", rList);
			request.setAttribute("totalCount", totalCount);
			request.setAttribute("likes", likes);
			request.setAttribute("fileData", fileData);
			request.getRequestDispatcher("/bookShare/detail").forward(request, response);
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
