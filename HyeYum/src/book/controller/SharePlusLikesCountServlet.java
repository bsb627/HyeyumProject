package book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import book.model.service.BookService;



/**
 * Servlet implementation class AddHitsCountServlet
 */
@WebServlet("/bookShare/plusLikes")
public class SharePlusLikesCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SharePlusLikesCountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String)session.getAttribute("userId");
		int shareNo = Integer.parseInt(request.getParameter("share-no"));
		int likes = 0;
		int check = new BookService().checkLikesShare(shareNo,userId);
		System.out.println("check : " + check);
		if(check > 0) {
			 likes = new BookService().updateLikesCountShare(shareNo,userId,"1");
			 if(likes > 0) {
					request.setAttribute("likes", likes);
					request.setAttribute("share-no", shareNo);
					request.getRequestDispatcher("/bookShare/detail").forward(request, response);
				}else {
					
				}
			
		}else {
			 likes = new BookService().plusLikesCountShare(shareNo, userId);
			if(likes > 0) {
				request.setAttribute("likes", likes);
				request.setAttribute("share-no", shareNo);
				request.getRequestDispatcher("/bookShare/detail").forward(request, response);
			}else {
				
			}
			
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
