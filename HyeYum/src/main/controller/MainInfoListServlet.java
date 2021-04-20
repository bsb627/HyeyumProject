package main.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import book.model.service.BookService;
import book.model.vo.BookInfo;
import member.model.service.DonateService;
import movie.model.vo.MovieInfo;
import reply.model.service.ReplyService;
import reply.model.vo.Reply;
import show.model.service.ShowService;
import show.model.vo.ShowInfo;

/**
 * Servlet implementation class ShowBoardDeleteServlet
 */
@WebServlet("/main/Info/list")
public class MainInfoListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainInfoListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bookAllCount = new DonateService().countAllBook() ;
		int movieAllCount = new DonateService().countAllMovie();
		int showAllCount = new DonateService().countAllShow();
		String memberAllCount = Integer.toString(new DonateService().countAllMember()); //참여자 수 
		String postAllCount = Integer.toString(bookAllCount+movieAllCount+showAllCount); //총 게시글 수
		String companyAllCount = Integer.toString(new DonateService().countAllCompany()); //총 기업 수 
		String donateAllCount = Integer.toString((bookAllCount+movieAllCount+showAllCount)*1000); // 총 기부금 액
		
	
		ArrayList<ShowInfo> iList = new ShowService().getShowInfoList();
		ArrayList<BookInfo> bList = new ShowService().getBookInfoList();
		ArrayList<MovieInfo> mList = new ShowService().getMovieInfoList();
 		if(!iList.isEmpty() && !bList.isEmpty()&& !mList.isEmpty()) {
 			
 			request.setAttribute("companyAllCount", companyAllCount);
 			request.setAttribute("memberAllCount", memberAllCount);
 			request.setAttribute("postAllCount", postAllCount);
 			request.setAttribute("donateAllCount", donateAllCount);
			request.setAttribute("iList", iList);
			request.setAttribute("bList", bList);
			request.setAttribute("mList", mList);

			request.getRequestDispatcher("/index.jsp").forward(request, response);
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
