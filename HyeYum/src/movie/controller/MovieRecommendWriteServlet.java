package movie.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import file.model.service.FileService;
import file.model.service.MovieFileService;
import file.model.vo.FileData;
import movie.model.service.MovieService;
import movie.model.vo.MovieRecommend;

/**
 * Servlet implementation class MovieRecommendEnrollServlet
 */
@WebServlet("/movieRecommend/write")
public class MovieRecommendWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieRecommendWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/movie/movieRecommendWrite.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String title = request.getParameter("movie-title");
		String content = request.getParameter("content");
		String genre = request.getParameter("genre");

		HttpSession session = request.getSession();
		if (session != null && (session.getAttribute("userId")) != null) {
			String userId = (String) session.getAttribute("userId");
//			String fileUserId = (String)session.getAttribute("userId");
//			String uploadFilePath = request.getServletContext().getRealPath("/upload/movie");
//			String encType = "UTF-8";
//			int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
//			MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
//			
			
			
			MovieRecommend recommend = new MovieRecommend();
			recommend.setTitle(title);
			recommend.setContents(content);
			recommend.setGenre(genre);
			recommend.setNick(userId);
//			recommend.setTitle(multi.getParameter("title"));
//			recommend.setContents(multi.getParameter("content"));
//			recommend.setGenre(multi.getParameter("genre"));
			//recommend.setNick(multi.getParameter("nick"));
			//recommend.setUserId(userId);
			System.out.println("id" + userId);
			//recommend.setUserId((String)session.getAttribute("userId"));
			//recommend.setNick((String)session.getAttribute("userId"));
			
			int result = new MovieService().registerMovieRecommend(recommend);
			
			if (result > 0) {
//				File uploadFile = multi.getFile("up-file");
//				
//				String fileName = multi.getFilesystemName("up-file");
//				String filePath = uploadFile.getPath();
//				long fileSize = uploadFile.length();
//				
				PrintWriter out = response.getWriter();

//				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
//				Timestamp uploadTime = Timestamp.valueOf(formatter.format(Calendar.getInstance().getTimeInMillis()));
//				
//				FileData fileData = new FileData();
//				fileData.setFileName(fileName);
//				fileData.setFilePath(filePath);
//				fileData.setFileSize(fileSize);
//				//fileData.setFileUser(fileUserId);
//				fileData.setUploadTime(uploadTime);
//				fileData.setFileType("movie");
//			
//				int fileResult = new MovieFileService().registerFileRecommend(fileData, recommend);
//			
//				
//				System.out.println(uploadFilePath);
//				
				
				out.println("<script> alert('게시글이 등록되었습니다.');");
				out.println("location.href='/movieRecommend/list';");
				out.println("</script>");
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} else {
			request.getRequestDispatcher("/WEB-INF/views/movie/movieError.html").forward(request, response);
		}
	}

}
