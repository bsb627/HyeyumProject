package qna.model.dao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import qna.model.vo.Qna;

public class QnaDAO {
	
	//전체 출력
	public ArrayList<Qna> selectAllList(Connection conn, int currentPage) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Qna> qnaList = null;
		String query = "SELECT *FROM ( SELECT ROW_NUMBER() OVER (ORDER BY FAMILY DESC)AS NUM, QNA_NO, CATEGORY, TITLE, USER_ID, QUESTION_PWD, CONTENTS, ENROLL_DATE, HITS, FAMILY, STEP FROM QNA ORDER BY FAMILY DESC, STEP ASC ) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			qnaList = new ArrayList<Qna>();
			while(rset.next()) {
				Qna qna = new Qna();
				qna.setQnaNo(rset.getInt("QNA_NO"));
				qna.setCategory(rset.getString("CATEGORY"));
				qna.setTitle(rset.getString("TITLE"));
				qna.setUserId(rset.getString("USER_ID"));
				qna.setQuestionPwd(rset.getString("QUESTION_PWD"));
				qna.setContents(rset.getString("CONTENTS"));
				qna.setEnrollDate(rset.getDate("ENROLL_DATE"));
				qna.setHits(rset.getInt("HITS"));
				qna.setFamily(rset.getInt("FAMILY"));
				qna.setStep(rset.getInt("STEP"));
				qnaList.add(qna);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return qnaList;
	}

	public String getPageNavi(Connection conn, int currentPage) {
		int recordTotalCount = totalCount(conn);
		int pageTotalCount = 0;
		int recordCountPerPage = 10;
		if ( recordTotalCount % recordCountPerPage > 0 ) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if(currentPage < 1 ) {
			currentPage = 1;
		} else if(currentPage >  pageTotalCount) {
			currentPage = pageTotalCount;
		}
		
		int naviCountPerPage = 10;
		int startNavi = ((currentPage -1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// 오류방지 코드
		if( endNavi > pageTotalCount) {
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
		if( needPrev ) {
			sb.append("<a href='/qna/list?currentPage=" + (startNavi-1) + "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if( currentPage == i) { sb.append("<a href='/qna/list?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary active' value = '"+ i + "'>  </a>");}
			else { sb.append("<a href='/qna/list?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary' value = '"+ i + "'>  </a>"); }
		}
		if( needNext) {
			sb.append("<a href='/qna/list?currentPage=" + (endNavi + 1) + "'> > </a>");
		}
		return sb.toString();
	}
	
	public int totalCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QNA";
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return recordTotalCount;
	}

	public Qna selectOne(Connection conn, int qnaNo, String qnaPass) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna qna = new Qna();
		String query = "SELECT * FROM QNA WHERE QNA_NO = ? AND QUESTION_PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			pstmt.setString(2, qnaPass);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				qna.setQnaNo(rset.getInt("QNA_NO"));
				qna.setCategory(rset.getString("CATEGORY"));
				qna.setTitle(rset.getString("TITLE"));
				qna.setUserId(rset.getString("USER_ID"));
				qna.setQuestionPwd(rset.getString("QUESTION_PWD"));
				qna.setContents(rset.getString("CONTENTS"));
				qna.setEnrollDate(rset.getDate("ENROLL_DATE"));
				qna.setHits(rset.getInt("HITS"));
				qna.setFamily(rset.getInt("FAMILY"));
				qna.setStep(rset.getInt("STEP"));
			}
		} catch (NullPointerException e){
		

		
		}catch (SQLException e) {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return qna;
	}

	public int insertQuestion(Connection conn, Qna qna) {
		PreparedStatement pstmt = null;
		int result  = 0;
		String query = "INSERT INTO QNA VALUES(QNA_NO.NEXTVAL,?,?,?,?,?,SYSDATE,0,NEW_Q.NEXTVAL,0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getCategory());
			pstmt.setString(2, qna.getTitle());
			pstmt.setString(3, qna.getUserId());
			pstmt.setString(4, qna.getQuestionPwd());
			pstmt.setString(5, qna.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	


	public int deleteQna(Connection conn, int family) {
		PreparedStatement pstmt = null;
		String query = "DELETE FROM QNA WHERE FAMILY = ?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, family);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateQna(Connection conn, Qna qna) {
		
		PreparedStatement pstmt = null;
		String query = "UPDATE QNA SET TITLE = ?, QUESTION_PWD = ?, CATEGORY = ?, CONTENTS = ? WHERE QNA_NO = ?";
		int result = 0;
	
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getTitle());
			pstmt.setString(2, qna.getQuestionPwd());
			pstmt.setString(3, qna.getCategory());
			pstmt.setString(4, qna.getContents());
			pstmt.setInt(5, qna.getQnaNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Qna> selectSearchList(Connection conn, String search, String searchCategory, int currentPage) {
		PreparedStatement pstmt  = null;
		ResultSet rset = null;
		String query = "SELECT *FROM ( SELECT ROW_NUMBER() OVER (ORDER BY FAMILY DESC)AS NUM, QNA_NO, CATEGORY, TITLE, USER_ID, QUESTION_PWD, CONTENTS, ENROLL_DATE, HITS, FAMILY, STEP FROM QNA WHERE "+ searchCategory + " LIKE ? ORDER BY FAMILY DESC, STEP ASC ) WHERE NUM BETWEEN ? AND ?";
		ArrayList<Qna> searchList = null;
		int recordCountPerPage = 10 ; //페이지에 몇개의 게시물을 보여줄건지 나타내는 변수
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, searchCategory);
			pstmt.setString(1, "%" + search +"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			System.out.println("rset : " + rset);
			searchList = new ArrayList<Qna>();
			while(rset.next()) {
				Qna qna = new Qna();
				qna.setQnaNo(rset.getInt("QNA_NO"));
				qna.setCategory(rset.getString("CATEGORY"));
				qna.setTitle(rset.getString("TITLE"));
				qna.setUserId(rset.getString("USER_ID"));
				qna.setQuestionPwd(rset.getString("QUESTION_PWD"));
				qna.setContents(rset.getString("CONTENTS"));
				qna.setEnrollDate(rset.getDate("ENROLL_DATE"));
				qna.setHits(rset.getInt("HITS"));
				qna.setFamily(rset.getInt("FAMILY"));
				qna.setStep(rset.getInt("STEP"));
				searchList.add(qna);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return searchList;
	}

	public String getSearchPageNavi(Connection conn, String search, String searchCategory, int currentPage) {
		PreparedStatement pstmt= null;
		
		int recordCountPerPage = 10;
		int naviCountPerPage = 10; 
		int recordTotalCount = searchTotalCount(conn, search, searchCategory); 
		
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
			sb.append("<a href='/qna/search?search-keyword="+search+ "&currentPage="+ (startNavi-1)+"'> 이전 </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/qna/search?search-keyword="+search+ "&currentPage=" + i + "'>"+ i + "    </a>");
		}
		if(needNext) {
			sb.append("<a href='/qna/search?search-keyword="+search+ "&currentPage="+ (endNavi+1)+"'> 다음 </a>");
		}
		return sb.toString();
	}


	
	private int searchTotalCount(Connection conn, String search, String searchCategory) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM QNA WHERE " + searchCategory+ " LIKE ? ";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			//pstmt.setString(1, searchCategory);
			pstmt.setString(1, "%" + search + "%" );
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return recordTotalCount;
		
	}

	public int updateHitsQna(Connection conn, int qnaNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE QNA SET HITS = NVL(HITS,0) + 1 WHERE QNA_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	

	
	
////////////////////////////////관리자///////////////////////////////////////
	public ArrayList<Qna> selectAllQna(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Qna> qnaList = null;
		String query = "SELECT * FROM QNA ORDER BY FAMILY DESC, STEP ASC";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset!=null) {
				qnaList = new ArrayList<Qna>();
				while(rset.next()) {
					Qna qna = new Qna();
					qna.setQnaNo(rset.getInt("QNA_NO"));
					qna.setCategory(rset.getString("CATEGORY"));
					qna.setTitle(rset.getString("TITLE"));
					qna.setUserId(rset.getString("USER_ID"));
					qna.setQuestionPwd(rset.getString("QUESTION_PWD"));
					qna.setContents(rset.getString("CONTENTS"));
					qna.setEnrollDate(rset.getDate("ENROLL_DATE"));
					qna.setHits(rset.getInt("HITS"));
					qna.setFamily(rset.getInt("FAMILY"));
					qna.setStep(rset.getInt("STEP"));
					qnaList.add(qna);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return qnaList;
	}
	
	
	public int insertAnswer(Connection conn, Qna qna) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO QNA VALUES(QNA_NO.NEXTVAL, ?,?,?,?,?,SYSDATE,0,?,1)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1," ");
			pstmt.setString(2, "  답변입니다.");
			pstmt.setString(3, "admin");
			pstmt.setString(4, qna.getQuestionPwd());
			pstmt.setString(5, qna.getContents());
			pstmt.setInt(6, qna.getFamily());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public Qna selectOneAdmin(Connection conn, int qnaNo, int family) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Qna qna = new Qna();
		String query = "SELECT * FROM QNA WHERE QNA_NO = ? AND FAMILY = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, qnaNo);
			pstmt.setInt(2, family);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				
				qna.setQnaNo(rset.getInt("QNA_NO"));
				qna.setCategory(rset.getString("CATEGORY"));
				qna.setTitle(rset.getString("TITLE"));
				qna.setUserId(rset.getString("USER_ID"));
				qna.setQuestionPwd(rset.getString("QUESTION_PWD"));
				qna.setContents(rset.getString("CONTENTS"));
				qna.setEnrollDate(rset.getDate("ENROLL_DATE"));
				qna.setHits(rset.getInt("HITS"));
				qna.setFamily(rset.getInt("FAMILY"));
				qna.setStep(rset.getInt("STEP"));
			}
		} catch (SQLException e) {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		
		return qna;
	}
	
	public int deleteQnaAdmin(Connection conn, String qnaNo) {
		Statement stmt = null;
		String query = "DELETE FROM QNA WHERE QNA_NO IN ("+qnaNo+")";
		int result = 0;
		
		try {
			stmt = conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
		}
		return result;
	}

	public int updateQnaAdmin(Connection conn, Qna qna) {
		PreparedStatement pstmt = null;
		String query = "UPDATE QNA SET CONTENTS = ? WHERE QNA_NO = ?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getContents());
			pstmt.setInt(2, qna.getQnaNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public Qna printParentAdmin(Connection conn, int family) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM QNA WHERE FAMILY = ? AND STEP = 0";
		Qna qna = new Qna();
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, family);
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				qna.setQnaNo(rset.getInt("QNA_NO"));
				qna.setCategory(rset.getString("CATEGORY"));
				qna.setTitle(rset.getString("TITLE"));
				qna.setUserId(rset.getString("USER_ID"));
				qna.setQuestionPwd(rset.getString("QUESTION_PWD"));
				qna.setContents(rset.getString("CONTENTS"));
				qna.setEnrollDate(rset.getDate("ENROLL_DATE"));
				qna.setHits(rset.getInt("HITS"));
				qna.setFamily(rset.getInt("FAMILY"));
				qna.setStep(rset.getInt("STEP"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return qna;
		
	}

	
	
}
