package book.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import book.model.service.BookService;
import book.model.vo.BookShare;
import file.model.service.BookFileService;
import file.model.vo.FileData;

/**
 * Servlet implementation class BookBoardEnrollServlet
 */
@WebServlet("/bookShare/enroll")
public class BookShareEnrollServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShareEnrollServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/book/bookShareEnroll.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		if(session != null && (session.getAttribute("userId")) != null) {
			String fileUserId = (String)session.getAttribute("userId");
			String uploadFilePath = request.getServletContext().getRealPath("/upload/book");
			int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
			String encType = "UTF-8";
			
			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
			
			BookShare share = new BookShare();
		
//			share.setNo(Integer.parseInt(multi.getParameter("share-no")));
			share.setRegion(multi.getParameter("region"));
			share.setTitle(multi.getParameter("share-title"));
			share.setContents(multi.getParameter("share-content"));
			share.setUserId((String)session.getAttribute("userId"));
//			share.setNo(Integer.parseInt(multi.getParameter("share-no")));
			//????????? ????????? NULL ?????????
			// Enroll.jsp?????? ?????????(do post??? ?????????) share-no??? ????????? share VO??? ?????????
			// ?????? ????????? ????????? ???????????? ??? share??? ????????? ?????? ????????? share-no??? ?????? 
			// DB??? ??????????????? ???
			System.out.println("????????? region : " + share.getRegion());
			System.out.println("????????? title : " + share.getTitle());
			System.out.println(share.getContents());
			System.out.println(share.getUserId());
			int result = new BookService().registerBookShare(share); 
			System.out.println("result : " + result);
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
				fileData.setFileType("share");
				
				System.out.println("Enroll??????????????? shareNo :" + fileData.getNo());
				
				int fileResult = new BookFileService().registerFileShare(fileData, share);
				// share??? ????????? ??? share??? shareNo??? ????????? DB??? shareNo??? ???????????? ?????? ???
				
				request.getRequestDispatcher("/bookShare/list").forward(request, response);
			}else {
				
			}
		}
	}
}