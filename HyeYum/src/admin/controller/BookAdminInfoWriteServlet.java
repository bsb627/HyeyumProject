package admin.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import admin.model.service.BookAdminService;
import book.model.vo.BookInfo;
import file.model.service.BookFileService;
import file.model.vo.FileData;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/bookInfo/write")
public class BookAdminInfoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdminInfoWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BookInfo> bList = new BookAdminService().printAllBookInfoList();
		
		if(!bList.isEmpty()) {
			request.setAttribute("bList", bList);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/bookInfoWrite.jsp").forward(request, response);
			
		}else {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("써블릿");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
//		String fileUserId = (String)session.getAttribute("userId");
		String fileUserId = "admin";
		String uploadFilePath = request.getServletContext().getRealPath("/upload/info/book");
		int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		BookInfo info = new BookInfo();
		
		info.setBookName(multi.getParameter("book-name"));
		info.setGenre(multi.getParameter("info-type"));
		info.setAuthor(multi.getParameter("author"));
		info.setPublisher(multi.getParameter("publisher"));
		info.setIntro(multi.getParameter("intro"));
		System.out.println("bookName : " + multi.getParameter("book-name"));
		System.out.println("genre : " + multi.getParameter("genre"));
		System.out.println("author : " + multi.getParameter("author"));
		System.out.println("publisher : " + multi.getParameter("publisher"));
		System.out.println("intro : " + multi.getParameter("intro"));
		
		
		
		int result = new BookAdminService().registerBookInfo(info);
		System.out.println("result"+result);
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
			//fileData.setFileType("book");
			System.out.println("fileName : " + fileName);
			System.out.println("filePath : " + filePath);
			System.out.println("fileSize : " + fileSize);
			System.out.println("fileUserId : " + fileUserId);
			System.out.println("uploadTime : " + uploadTime);
			
			int fileResult = new BookFileService().registerFileInfo(fileData, info);
		
			request.getRequestDispatcher("/admin/bookInfo/list").forward(request, response);
		}else {
			
		}
		
	}

}
