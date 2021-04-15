package book.controller;

import java.io.IOException;
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

/**
 * Servlet implementation class BookBoardEnrollServlet
 */
@WebServlet("/bookShare/modify")
public class BookShareModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookShareModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("share-no"));
		
		BookShare share = new BookService().printOneBookShare(no);
		if(share != null) {
			request.setAttribute("share", share);
			request.getRequestDispatcher("/WEB-INF/views/book/bookShareModify.jsp").forward(request, response);
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
		String uploadFilePath = request.getServletContext().getRealPath("/upload/book");
		int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		
		BookShare share = new BookShare();
		
		share.setNo(Integer.parseInt(multi.getParameter("share-no")));
		share.setTitle(multi.getParameter("share-title"));
		share.setRegion(multi.getParameter("region"));
		share.setContents(multi.getParameter("share-content"));
		share.setNick((String)session.getAttribute("userId"));
		System.out.println("share-no 서블릿 :" + share.getNo());
		int result = new BookService().modifyBookShare(share);
		if(result > 0) {
			
//			File uploadFile = multi.getFile("up-file");
//			if( uploadFile != null) {
//			
//			String fileName = multi.getFilesystemName("up-file");
//			String filePath = uploadFile.getPath();
//			long fileSize = uploadFile.length();
//			
//			
//			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//			Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
//			
//			FileData fileData = new FileData();
//			fileData.setFileName(fileName);
//			fileData.setFilePath(filePath);
//			fileData.setFileSize(fileSize);
//			fileData.setFileUser(fileUserId);
//			fileData.setUploadTime(uploadTime);
//			fileData.setFileType("show");
//		
//			int fileResult = new FileService().updateFileInfo(fileData, review);
//		
//			
//			System.out.println(uploadFilePath);
//			}
			request.setAttribute("share-no", share.getNo());
			request.getRequestDispatcher("/bookShare/detail").forward(request, response);
		}else {
			
		}
		
			
			}

}
