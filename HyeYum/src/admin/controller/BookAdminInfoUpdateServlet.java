package admin.controller;

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

import admin.model.service.AdminService;
import admin.model.service.BookAdminService;
import book.model.vo.BookInfo;
import file.model.service.BookFileService;
import file.model.vo.FileData;
import show.model.vo.ShowInfo;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/bookInfo/update")
public class BookAdminInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookAdminInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int infoNo = Integer.parseInt(request.getParameter("info-No"));
		
		BookInfo info = new BookAdminService().printOneBookInfo(infoNo);
		
		if(info != null) {
			request.setAttribute("info", info);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/bookInfoUpdate.jsp").forward(request, response);
		}else {
			
		}
 	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
//		String fileUserId = (String)session.getAttribute("userId");
		String fileUserId = "admin";
		String uploadFilePath = request.getServletContext().getRealPath("/upload/info/book");
		int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		BookInfo info = new BookInfo();
		
		info.setInfoNo(Integer.parseInt(multi.getParameter("info-no")));
		info.setBookName(multi.getParameter("bookName"));
		info.setGenre(multi.getParameter("genre"));
		info.setAuthor(multi.getParameter("author"));
		info.setIntro(multi.getParameter("intro"));
		info.setPublisher(multi.getParameter("publisher"));
		
		int result = new BookAdminService().updateBookInfo(info);
		if(result > 0) {
			File uploadFile = multi.getFile("up-file");
			if( uploadFile != null) {
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
		
			int fileResult = new BookFileService().updateFileInfo(fileData, info);
		
			System.out.println(uploadFilePath);
			}
			request.getRequestDispatcher("/admin/showInfo/list").forward(request, response);
		}else {
			
		}
	}

}
