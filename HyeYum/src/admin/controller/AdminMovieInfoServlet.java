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

import admin.model.service.AdminMovieService;
import file.model.service.FileService;
import file.model.service.MovieFileService;
import file.model.vo.FileData;
import movie.model.vo.MovieInfo;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/movieInfo/list")
public class AdminMovieInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminMovieInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MovieInfo> mList = new AdminMovieService().printAllMovieInfoList();
		FileData fd = new FileData();
		fd.setFileType("movie");
		ArrayList<FileData> fList = new MovieFileService().printMovieInfoFileList();
		
		
		
		 System.out.println(mList); 
		 System.out.println(fList);
		 
		
		if(!mList.isEmpty()) {
			request.setAttribute("mList", mList);
			request.setAttribute("fList", fList);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/movieInfo.jsp").forward(request, response);
		} else {
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}
