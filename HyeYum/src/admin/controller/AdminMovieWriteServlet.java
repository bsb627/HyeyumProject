package admin.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

import admin.model.service.AdminMovieService;
import file.model.service.BookFileService;
import file.model.service.MovieFileService;
import file.model.vo.FileData;
import movie.model.vo.MovieInfo;

/**
 * Servlet implementation class AdminMovieWriteServlet
 */
@WebServlet("/admin/movieInfo/write")
public class AdminMovieWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MovieInfo> mList = new AdminMovieService().printAllMovieInfoList();

		if (!mList.isEmpty()) {
			System.out.println("write서블릿 mList : " + mList);
			request.setAttribute("mList", mList);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/movieInfoWrite.jsp").forward(request, response);
		} else {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("write 서블릿 IN");
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
//		String ageGroup = request.getParameter("ageGroup");
//		String cast = request.getParameter("cast");
//		String director = request.getParameter("director");
//		String genre = request.getParameter("genre");
//		String movieName = request.getParameter("movieName");
//		String runTime = request.getParameter("runTime");
//		String synopsis = request.getParameter("synopsis");
		
	/*	HttpSession session = request.getSession();
		if(session != null && (session.getAttribute("userId")) != null) {
			String userId = (String)session.getAttribute("userId");*/
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
//		String fileUserId = (String)session.getAttribute("userId");
		String fileUserId = "admin";
		String uploadFilePath = request.getServletContext().getRealPath("/upload/info/movie");
		int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		
			MovieInfo info = new MovieInfo();
			
			info.setAgeGroup(multi.getParameter("ageGroup"));
			info.setCast(multi.getParameter("cast"));
			info.setDirector(multi.getParameter("director"));
			info.setGenre(multi.getParameter("genre"));
			info.setMovieName(multi.getParameter("movieName"));
			info.setRunTime(multi.getParameter("runTime"));
			info.setSynopsis(multi.getParameter("synopsis"));
			int result = new AdminMovieService().registerMovieInfo(info);
			
			System.out.println("등록result" + result);
			
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
				System.out.println("fileName : " + fileName);
				System.out.println("filePath : " + filePath);
				System.out.println("fileSize : " + fileSize);
				System.out.println("fileUserId : " + fileUserId);
				System.out.println("uploadTime : " + uploadTime);
				System.out.println("infoNo: " + uploadTime);
				
				
				int fileResult = new MovieFileService().registerFileMovieInfo(fileData, info);
				
				
				
				PrintWriter out = response.getWriter();

				out.println("<script> alert('영화 컨텐츠가 등록되었습니다.');");
				out.println("location.href='/admin/movieInfo/list';");
				out.println("</script>");
				
				//request.getRequestDispatcher("/admin/movieInfo/list").forward(request, response);
			} else {
				
			}
			
		}
		
	
	}
