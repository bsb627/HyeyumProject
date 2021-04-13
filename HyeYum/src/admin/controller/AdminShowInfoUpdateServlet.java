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

import admin.model.service.AdminService;
import file.model.service.FileService;
import file.model.vo.FileData;
import show.model.vo.ShowInfo;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/admin/showInfo/update")
public class AdminShowInfoUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowInfoUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int infoNo = Integer.parseInt(request.getParameter("infoNo"));
		
		ShowInfo info = new AdminService().printOneShowInfo(infoNo);
		
		if(info != null) {
			request.setAttribute("info", info);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/showInfoUpdate.jsp").forward(request, response);
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
		String uploadFilePath = request.getServletContext().getRealPath("/upload/info/show");
		int uploadFileSizeLimit = 5* 1024 * 1024 * 1024;
		String encType = "UTF-8";
		MultipartRequest multi = new MultipartRequest(request, uploadFilePath, uploadFileSizeLimit, encType, new DefaultFileRenamePolicy());
		
		ShowInfo info = new ShowInfo();
		
		System.out.println(multi.getParameter("type"));
		System.out.println(multi.getParameter("genre"));
		System.out.println(multi.getParameter("region"));
		System.out.println(multi.getParameter("place"));
		System.out.println(multi.getParameter("age-group"));
		System.out.println(multi.getParameter("run-time"));
		System.out.println(multi.getParameter("price"));
		System.out.println(multi.getParameter("cast"));
		System.out.println(multi.getParameter("start-date"));
		System.out.println(multi.getParameter("end-date"));
		System.out.println(multi.getParameter("show-name"));
		//System.out.println(multi.getParameter("up-file"));
		
		String startDate = multi.getParameter("start-date");
		String endDate = multi.getParameter("end-date");
		String termDate = startDate+"~"+endDate;
		System.out.println(termDate);
		
		info.setType(multi.getParameter("type"));
		info.setGenre(multi.getParameter("genre"));
		info.setRegion(multi.getParameter("region"));
		info.setPlace(multi.getParameter("place"));
		info.setAgeGroup(multi.getParameter("age-group"));
		info.setRunTime(Integer.parseInt(multi.getParameter("run-time")));
		info.setPrice(Integer.parseInt(multi.getParameter("price")));
		info.setCast(multi.getParameter("cast"));
		info.setTermDate(termDate);
		info.setShowName(multi.getParameter("show-name"));
		
		int result = new AdminService().registerShowInfo(info);
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
			fileData.setFileType("show");
		
			int fileResult = new FileService().registerFileShowInfo(fileData, info);
		
			
			System.out.println(uploadFilePath);
			request.getRequestDispatcher("/admin/showInfo/list").forward(request, response);
		}else {
			
		}
		
		
		
		
		
	}

}
