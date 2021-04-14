package book.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import book.model.service.BookService;
import book.model.vo.BookReview;
import file.model.service.FileService;
import file.model.vo.FileData;

/**
 * Servlet implementation class ShowBoardEnrollServlet
 */
@WebServlet("/bookReview/enroll")
public class BookReviewEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookReviewEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/book/bookReviewWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session != null && (session.getAttribute("userId")) != null) {
			String fileUserId = (String)session.getAttribute("userId");
			String uploadFilePath = request.getServletContext().getRealPath("/upload/show");
			int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
			String encType = "UTF-8";
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			
			BookReview review = new BookReview();
		
			review.setInfoNo(Integer.parseInt(multi.getParameter("info-no")));
			review.setDivision(multi.getParameter("info-type"));
			review.setTitle(multi.getParameter("review-title"));
			review.setContents(multi.getParameter("review-content"));
			review.setUserId((String)session.getAttribute("userId"));
			
			System.out.println(review.getInfoNo());
			System.out.println(review.getDivision());
			System.out.println(review.getTitle());
			System.out.println(review.getContents());
			System.out.println(review.getUserId());
			int result = new BookService().registerBookReview(review);
			if(result > 0) {
//				File uploadFile = multi.getFile("up-file");
//				
//				String fileName = multi.getFilesystemName("up-file");
//				String filePath = uploadFile.getPath();
//				long fileSize = uploadFile.length();
//				
//				
//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//				Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
//				
//				FileData fileData = new FileData();
//				fileData.setFileName(fileName);
//				fileData.setFilePath(filePath);
//				fileData.setFileSize(fileSize);
//				fileData.setFileUser(fileUserId);
//				fileData.setUploadTime(uploadTime);
//				fileData.setFileType("show");
			
//				int fileResult = new FileService().registerFileInfo(fileData, review);
			
				
				System.out.println(uploadFilePath);
				request.getRequestDispatcher("/bookReview/list").forward(request, response);
			}else {
				
			}
		}
	}
}