package show.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import file.model.service.FileService;
import file.model.vo.FileData;
import show.model.service.ShowService;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

/**
 * Servlet implementation class ShowBoardEnrollServlet
 */
@WebServlet("/showReview/write")
public class ShowReviewWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowReviewWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ShowInfo> iList = new ShowService().getShowInfoList();
		
		if(! iList.isEmpty()) {
			request.setAttribute("iList", iList);
			request.getRequestDispatcher("/WEB-INF/views/show/showReviewWrite.jsp").forward(request, response);
			
		}else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String fileUserId = (String)session.getAttribute("userId");
		String uploadFilePath = request.getServletContext().getRealPath("/upload/show");
		int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		ShowReview review = new ShowReview();
		
		
		/*
		 * review.setInfoNo(Integer.parseInt(request.getParameter("info-no")));
		 * review.setTitle(request.getParameter("show-title"));
		 * review.setContents(request.getParameter("show-content"));
		 * review.setSnsLink(request.getParameter("sns-link"));
		 * review.setTicketNumber(request.getParameter("ticket-number"));
		 * review.setNick((String)session.getAttribute("userId"));
		 */
		
		review.setInfoNo(Integer.parseInt(multi.getParameter("info-no")));
		review.setTitle(multi.getParameter("show-title"));
		review.setContents(multi.getParameter("show-content"));
		review.setSnsLink(multi.getParameter("sns-link"));
		review.setTicketNumber(multi.getParameter("ticket-number"));
		review.setNick((String)session.getAttribute("userId"));
		 
		 
		
		int result = new ShowService().registerShowReview(review);
		if(result > 0) {
			
			File uploadFile = multi.getFile("up-file");
			
			String fileName = multi.getFilesystemName("up-file");
			String filePath = uploadFile.getPath();
			long fileSize = uploadFile.length();
			
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
			
			FileData fileData = new FileData();
			fileData.setFileName(fileName);
			fileData.setFilePath(filePath);
			fileData.setFileSize(fileSize);
			fileData.setFileUser(fileUserId);
			fileData.setUploadTime(uploadTime);
			fileData.setFileType("show");
		
			int fileResult = new FileService().registerFileInfo(fileData, review);
		
			
			System.out.println(uploadFilePath);
			request.getRequestDispatcher("/showReview/list").forward(request, response);
		}else {
			
		}
		
	}

}
