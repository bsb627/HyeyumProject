package notice.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.vo.Notice;

public class NoticeDAO {

	// 전체출력리스트
	public ArrayList<Notice> selectAllList(Connection conn, int currentPage) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		ArrayList<Notice> nList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC) AS NUM, NOTICE_NO, TITLE, CONTENTS, USER_ID, ENROLL_DATE , HITS FROM NOTICE) WHERE NUM BETWEEN ? AND ?"; 
		
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);					
			pstmt.setInt(2, end);				
			rset = pstmt.executeQuery();		
			nList = new ArrayList<Notice>(); 
			while(rset.next()) { 
				Notice notice = new Notice(); 
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("TITLE"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
				notice.setHits(rset.getInt("HITS"));
				nList.add(notice); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
	} finally {
		JDBCTemplate.close(rset);
		JDBCTemplate.close(pstmt);
	}
		System.out.println("DAO.." + nList);
	return nList;

}
	public String getPageNavi(Connection conn, int currentPage) {
		int recordTotalCount = totalCount(conn);
		int recordCountPerPage = 10;
		int pageTotalCount = 0;
		if ( recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int naviCountPerPage = 10;
		int startNavi = ((currentPage -1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) {
			sb.append("<li class='page-item'><a class='page-link' href='/notice/list?currentPage=" + (startNavi-1)+ "'> < </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<li class='page-item'><a class='page-link' href='/notice/list?currentPage=" + i + "'>"+ i + " </a><li>");
		}
		if(needNext) {
			sb.append("<li class='page-item'><a class='page-link' href='/notice/list?currentPage=" + (endNavi +1) + "'> > </a><li>");
		}
		return sb.toString();
	}
	
	// 전체조회
	private int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE";
		int recordTotalCount = 0;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return recordTotalCount;
	}
	
	
	

	// 리스트 하나만 출력
	public Notice selectOne(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		Notice notice = null;
		String query = "SELECT * FROM NOTICE WHERE NOTICE_NO = ?"; 
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			rset = pstmt.executeQuery();
			if(rset.next()) { 
				notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("TITLE"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setUserId(rset.getString("USER_ID"));
				notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
				notice.setHits(rset.getInt("HITS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return notice;
	}
	
	// 리스트 검색 목록 제목으로 검색가넝~
	
	public ArrayList<Notice> selectSearchNoticeList(Connection conn, String search, String searchCategory, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query =  "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY NOTICE_NO DESC) AS NUM, NOTICE_NO, TITLE, CONTENTS, ENROLL_DATE, HITS, USER_ID FROM NOTICE WHERE "+ searchCategory + " LIKE ?  ) WHERE NUM BETWEEN ? AND ?";// 위치홀더 작성 및 세미콜론 삭제
		ArrayList<Notice> nList = null;
		int recordCountPerPage = 10 ; //페이지에 몇개의 게시물을 보여줄건지 나타내는 변수
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search +"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			System.out.println("rset : " + rset);
			nList = new ArrayList<Notice>();
			while(rset.next()) {
				Notice notice = new Notice();
				notice.setNoticeNo(rset.getInt("NOTICE_NO"));
				notice.setTitle(rset.getString("TITLE"));
				notice.setContents(rset.getString("CONTENTS"));
				notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
				notice.setHits(rset.getInt("HITS"));
				notice.setUserId(rset.getString("USER_ID"));
				nList.add(notice);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("nList" + nList);
		return nList;
	}
	

	// 관리자 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!//

	// 등록
	public int insertNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO NOTICE "
				+ "VALUES(SEQ_NOTICE.NEXTVAL,?,?,?,SYSDATE)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContents());
			pstmt.setString(3, notice.getUserId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	// 수정
	public int updateNotice(Connection conn, Notice notice) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE "
				+ "SET TITLE = ?, CONTENTS =? WHERE NOTICENO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContents());
			pstmt.setInt(3, notice.getNoticeNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 삭제
	
	public int deleteNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null; 
		int result = 0; String query ="DELETE FROM NOTICE WHERE NOTICENO = ?"; 
		try { 
			pstmt = conn.prepareStatement(query); 
			pstmt.setInt(1, noticeNo); 
			result =pstmt.executeUpdate(); 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	// 검색총조회수
	private int searchNoticeTotalCount(Connection conn, String search, String searchCategory) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE " + searchCategory+ " LIKE ? ";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%" + search + "%" );
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
	}
	
	public int noticeHits(Connection conn, int noticeNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	


	
	
	
	//검색리스트
//	public ArrayList<Notice> selectSearchList(Connection conn, String search, int currentPage) {
	//	PreparedStatement pstmt = null;
		//ResultSet rset = null;
	//	String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY NOTICENO DESC) AS NUM, NOTICENO, SUBJECT, CONTENTS, USERID, REGDATE FROM NOTICE WHERE SUBJECT LIKE ?) WHERE NUM BETWEEN ? AND ?";// 위치홀더 작성 및 세미콜론 삭제
		//ArrayList<Notice> nList = null;
//int recordCountPerPage = 10;
//		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
	//	int end = currentPage*recordCountPerPage;
	//	try {
	//		pstmt = conn.prepareStatement(query);
	//		pstmt.setString(1, "%"+search+"%");
	//		pstmt.setInt(2, start); 
	//		pstmt.setInt(3, end); 
	//		rset = pstmt.executeQuery(); 
	//		nList = new ArrayList<Notice>();
	//		while(rset.next()) {
	//			Notice notice = new Notice();
	//			notice.setNoticeNo(rset.getInt("NOTICE_NO"));
	//			notice.setTitle(rset.getString("TITLE"));
	//			notice.setContents(rset.getString("CONTENTS"));
	//			notice.setUserId(rset.getString("USER_ID"));
	//			notice.setEnrollDate(rset.getDate("ENROLL_DATE"));
	//			nList.add(notice); 
	//		}
	//	} catch (SQLException e) {
	//		// TODO Auto-generated catch block
	//		e.printStackTrace();
	//	}  finally {
	//		JDBCTemplate.close(rset);
	//		JDBCTemplate.close(pstmt);
	//	}
	//	return nList;
//	}

	/*
	 * public String getSearchPageNavi(Connection conn, String search, int
	 * currentPage) { int recordCountPerPage = 10; int naviCountPerPage = 10; int
	 * recordTotalCount = searchTotalCount(conn, search); int pageTotalCount = 0;
	 * if(recordTotalCount % recordCountPerPage > 0) { pageTotalCount =
	 * recordTotalCount / recordCountPerPage + 1; }else { pageTotalCount =
	 * recordTotalCount / recordCountPerPage; } if(currentPage < 1) { currentPage =
	 * 1; }else if(currentPage > pageTotalCount) { currentPage = pageTotalCount; }
	 * int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage +
	 * 1; int endNavi = startNavi + naviCountPerPage - 1; if(endNavi >
	 * pageTotalCount) { endNavi = pageTotalCount; } boolean needPrev = true;
	 * boolean needNext = true; if(startNavi == 1) { needPrev = false; } if(endNavi
	 * == pageTotalCount) { needNext = false; } StringBuilder sb = new
	 * StringBuilder(); if(needPrev) { // 1 2 3 4 5, 6 7 8 9 10
	 * sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+(
	 * startNavi-1)+"'> 이전 </a>"); } for(int i = startNavi; i <= endNavi; i++) {
	 * sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+i+
	 * "'>" + i + " </a>"); } if(needNext) {
	 * sb.append("<a href='/notice/search?searchKeyword="+search+"&currentPage="+(
	 * endNavi+1)+"'> 다음 </a>"); } return sb.toString();
	 * 
	 * }
	 */

	//검색 조회수
	/*
	 * private int searchTotalCount(Connection conn, String search) {
	 * PreparedStatement pstmt = null; ResultSet rset = null; String query =
	 * "SELECT COUNT(*) AS TOTALCOUNT FROM NOTICE WHERE TITLE LIKE ?"; int
	 * recordTotalCount = 0; try { pstmt = conn.prepareStatement(query);
	 * pstmt.setString(1, "%"+search+"%"); rset = pstmt.executeQuery();
	 * if(rset.next()) { recordTotalCount = rset.getInt("TOTALCOUNT"); } } catch
	 * (SQLException e) { // TODO Auto-generated catch block e.printStackTrace(); }
	 * finally { JDBCTemplate.close(rset); JDBCTemplate.close(pstmt); } return
	 * recordTotalCount; }
	 */

	
	
	
	
	
	

	
	public String getSearchNoticePageNavi(Connection conn, String search, String searchCategory, int currentPage) {
		PreparedStatement pstmt= null;
		
		int recordCountPerPage = 10;
		int naviCountPerPage = 10; 
		int recordTotalCount = searchNoticeTotalCount(conn, search, searchCategory); 
		
		int pageTotalCount = 0; 
		if( recordTotalCount % recordCountPerPage > 0) { 
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// ====오류 방지용 코드 ==== //
		if (currentPage < 1 ) {
			currentPage = 1; // 
		} else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount; 
		}
							
		int startNavi = ((currentPage -1) / naviCountPerPage ) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage -1; 
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
	
		// a태그 만드는 코드
				StringBuilder sb = new StringBuilder();
				if(needPrev) {
					sb.append("<a href='/notice/search?search-keyword="+search+ "&currentPage="+ (startNavi-1)+"'> 이전 </a>");
				}
				for(int i = startNavi; i <= endNavi; i++) {
					sb.append("<a href='/notice/search?search-keyword="+search+ "&currentPage=" + i + "'>"+ i + "    </a>");
				}
				if(needNext) {
					sb.append("<a href='/notice/search?search-keyword="+search+ "&currentPage="+ (endNavi+1)+"'> 다음 </a>");
				}
				return sb.toString();
	}
	public int updateHitsNotice(Connection conn, int noticeNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE NOTICE SET HITS = NVL(HITS,0) + 1 WHERE NOTICE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, noticeNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
		
	}
}

