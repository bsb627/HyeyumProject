package admin.controller;

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

import admin.model.service.AdminMovieService;
import file.model.service.BookFileService;
import file.model.service.MovieFileService;
import file.model.vo.FileData;
import movie.model.vo.MovieInfo;
import show.model.vo.ShowInfo;

/**
 * Servlet implementation class AdminMovieModifyServlet
 */
@WebServlet("/admin/movieInfo/modify")
public class AdminMovieModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int infoNo = Integer.parseInt(request.getParameter("infoNo"));
		MovieInfo mInfo = new AdminMovieService().printOneMovieInfo(infoNo);
		
		if(mInfo != null) {
			request.setAttribute("mInfo",mInfo);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/movieInfoUpdate.jsp").forward(request, response);
		} else {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
//		String fileUserId = (String)session.getAttribute("userId");
		String fileUserId = "admin";
		String uploadFilePath = request.getServletContext().getRealPath("/upload/info/movie");
		int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		MovieInfo info = new MovieInfo();

		info.setInfoNo(Integer.parseInt(multi.getParameter("infoNo")));
		info.setAgeGroup(multi.getParameter("ageGroup"));
		info.setCast(multi.getParameter("cast"));
		info.setDirector(multi.getParameter("director"));
		info.setGenre(multi.getParameter("genre"));
		info.setMovieName(multi.getParameter("movieName"));
		info.setRunTime(multi.getParameter("runTime"));
		info.setSynopsis(multi.getParameter("synopsis"));

		
		int result = new AdminMovieService().updateMovieInfo(info);
		
		System.out.println("Modify result " + result);
		
		if (result > 0) {
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
			fileData.setFileType("movie");

			int fileResult = new MovieFileService().updateFileMovieInfo(fileData, info);
			
				/*
				 * PrintWriter out = response.getWriter();
				 * 
				 * out.println("<script> alert('게시글이 수정되었습니다.');");
				 * out.println("location.href='/admin/movieInfo/list';");
				 * out.println("</script>");
				 */
			System.out.println("modify 서블릿 들어옴");
			}
			System.out.println("modify 서블릿 들어옴2222");
			request.getRequestDispatcher("/admin/movieInfo/list").forward(request, response);
			} else {

			}

		}
	}