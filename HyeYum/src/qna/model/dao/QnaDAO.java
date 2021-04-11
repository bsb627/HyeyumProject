package qna.model.dao;

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
			System.out.println("rset: " + rset);
			qnaList = new ArrayList<Qna>();
			while(rset.next()) {
				Qna qna = new Qna();
				qna.setQnaNo(rset.getInt("QNA_NO"));
				qna.setCategory(rset.getString("CATEGORY"));
				qna.setTitle(rset.getString("TITLE"));
				qna.setNick(rset.getString("USER_ID"));
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
		System.out.println("dao" + qnaList);
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
			sb.append("<a href='#'" + (startNavi-1) + "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='#'" + i + "'>" + i + "   </a>");
		}
		if( needNext) {
			sb.append("<a href='#'" + (endNavi + 1) + "'> > </a>");
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

	public Qna selectOne(Connection conn, int qnaNo) {
		// TODO Auto-generated method stub
		return null;
	}

	public int insertQuestion(Connection conn, Qna qna) {
		PreparedStatement pstmt = null;
		int result  = 0;
		String query = "INSERT INTO QNA VALUES(QNA_NO.NEXTVAL,?,?,?,?,?,SYSDATE,0,NEW_Q.NEXTVAL,0)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, qna.getCategory());
			pstmt.setString(2, qna.getTitle());
			pstmt.setString(3, qna.getNick());
			pstmt.setString(4, qna.getQuestionPwd());
			pstmt.setString(5, qna.getContents());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertAnswer(Connection conn, Qna qna) {
		
		return 0;
	}

	public int deleteQna(Connection conn, ArrayList<Qna> qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int updateQna(Connection conn, Qna qna) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<Qna> selectSearchList(Connection conn, String search, String searchCategory, int currentPage) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSearchPageNavi(Connection conn, String search, String searchCategory, int currentPage) {
		PreparedStatement pstmt= null;
		
		int recordCountPerPage = 10; // 게시물을 10개씩 
		int naviCountPerPage = 10; // 네비를 10개씩 보여줄거
		int recordTotalCount = searchTotalCount(conn, search, searchCategory); // 전체 게시물 수
		return null;
	}


	private int searchTotalCount(Connection conn, String search, String searchCategory) {
		return 0;
		
	}

	public int updateHitsQna(Connection conn, int qnaNo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
