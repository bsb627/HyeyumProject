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
@WebServlet("/admin/showInfo/write")
public class AdminShowInfoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminShowInfoWriteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<ShowInfo> sList = new AdminService().printAllShowInfoList();
		
		if(!sList.isEmpty()) {
			request.setAttribute("sList", sList);
			request.getRequestDispatcher("/WEB-INF/views/admin/contents/showInfoWrite.jsp").forward(request, response);
			
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
