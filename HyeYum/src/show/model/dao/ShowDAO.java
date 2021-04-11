package show.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import qna.model.vo.Qna;
import show.model.vo.ShowData;
import show.model.vo.ShowInfo;
import show.model.vo.ShowReview;

public class ShowDAO {
	public ArrayList<ShowInfo> selectAllInfoList(Connection conn, int currentPage) { // 공연정보 전체보기
		return null;
	}
	
	public ShowInfo selectOneInfo(Connection conn, int infoNo) { // 공연정보 상세보기
		return null;
	}

	public int insertInfo(Connection conn, ShowInfo showInfo) { // 공연정보 등록
		return 0;
	}

	public int updateInfo(Connection conn, ShowInfo showInfo) { // 공연정보 수정
		return 0;
	}
	
	public int deleteInfo(Connection conn, String infoNo) { // 공연정보 삭제
		return 0;
	}
	
	public String getInfoPageNavi(Connection conn, int currentPage) { // 공연정보 페이징
		return null;
	}
	
	public int totaInfoCount(Connection conn) { // 공연정보 총 게시글 수
		return 0;
	}
	
	public ArrayList<ShowReview> selectAllReviewList(Connection conn, int currentPage) { // 관람후기 전체보기
		
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ShowReview> showList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM,REVIEW_NO,TITLE,CONTENTS,SNS_LINK,HITS,TICKET_NUMBER,ENROLL_DATE,USER_ID,NICK,INFO_NO FROM SHOW_REVIEW JOIN MEMBER USING(USER_ID)) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 6;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			if (rset != null) {
				showList = new ArrayList<ShowReview>();
				while(rset.next()) {
					ShowReview review = new ShowReview();
					review.setNo(rset.getInt("REVIEW_NO"));
					review.setTitle(rset.getString("TITLE"));
					review.setContents(rset.getString("CONTENTS"));
					review.setSnsLink(rset.getString("SNS_LINK"));
					review.setHits(rset.getInt("HITS"));
					review.setTicketNumber(rset.getString("TICKET_NUMBER"));
					review.setEnrollDate(rset.getDate("ENROLL_DATE"));
					review.setNick(rset.getString("NICK"));
					review.setInfoNo(rset.getInt("INFO_NO"));
					showList.add(review);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return showList;
	}
	
	public ShowReview selectOneReview(Connection conn, int showNo) { // 관람후기 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ShowReview review = null;
		String query = "SELECT REVIEW_NO,TITLE,CONTENTS,SNS_LINK,HITS,TICKET_NUMBER,ENROLL_DATE,USER_ID,NICK,INFO_NO FROM SHOW_REVIEW JOIN MEMBER USING (USER_ID) WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, showNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				review = new ShowReview();
				review.setNo(rset.getInt("REVIEW_NO"));
				review.setTitle(rset.getString("TITLE"));
				review.setContents(rset.getString("CONTENTS"));
				review.setSnsLink(rset.getString("SNS_LINK"));
				review.setHits(rset.getInt("HITS"));
				review.setTicketNumber(rset.getString("TICKET_NUMBER"));
				review.setEnrollDate(rset.getDate("ENROLL_DATE"));
				review.setNick(rset.getString("NICK"));
				review.setInfoNo(rset.getInt("INFO_NO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return review;
	}

	public int insertReview(Connection conn, ShowReview review) { // 관람후기 등록
		
		PreparedStatement pstmt = null;
		int result = 0;
		String query="INSERT INTO SHOW_REVIEW VALUES(SEQ_SHOW_REVIEW_NO.NEXTVAL,?,?,?,0,?,SYSDATE,?,?)";
		
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContents());
			pstmt.setString(3, review.getSnsLink());
			pstmt.setString(4, review.getTicketNumber());
			pstmt.setString(5, review.getNick());
			pstmt.setInt(6, review.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	public int updateReview(Connection conn, ShowReview review) { // 관람후기 수정
		return 0;
	}
	
	public int deleteReview(Connection conn, String reviewNo) { // 관람후기 삭제
		return 0;
	}
	
	public String getReviewPageNavi(Connection conn, int currentPage) { // 관람후기 페이징
		int recordTotalCount = totalReviewCount(conn);
		int pageTotalCount = 0;
		int recordCountPerPage = 6;
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
			sb.append("<li><a href='/showReview/list?currentPage="+ (startNavi-1) + "'> 이전 </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(currentPage == i) {
				sb.append("<li class='active'><a href='/showReview/list?currentPage="+ i +"'>" + i + "</a></li>");
			}else {
				sb.append("<li><a href='/showReview/list?currentPage="+ i +"'>" + i + "</a></li>");
			}
		}
		if( needNext) {
			sb.append("<li><a href='/showReview/list?currentPage="+ (endNavi + 1) + "'> 다음 </a></li>");
		}
		return sb.toString();
	}
	
	public int totalReviewCount(Connection conn) { // 관람후기 총 게시글 수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM SHOW_REVIEW";
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
	
	public ArrayList<ShowReview> selectSearchReviewList(Connection conn, int currentPage, String search, String searchCategory) { // 관람후기 검색결과 전체보기
		return null;
	}

	public String getSearchReviewPageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 관람후기 검색 페이징
		return null;
	}

	public int searchTotalReviewCount(Connection conn, String search, String searchCategory) { // 관람후기 검색 총 게시글 수
		return 0;
	}
	
	public int updateHitsReview(Connection conn, int showNo) { // 해당 게시글 조회수 증가
		return 0;
	}
	
	public int insertLikesReview(Connection conn, int showNo, String userId) { // 해당 게시글 좋아요 등록
		return 0;
	}
	
	public int updateLikesReview(Connection conn, int showNo, String userId) { // 해당 게시글 좋아요 취소
		return 0;
	}

	public ArrayList<ShowData> selectReplyCount(Connection conn) {
		
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT,REVIEW_NO FROM SHOW_REVIEW_REPLY GROUP BY REVIEW_NO";
		ArrayList<ShowData> rList = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				rList = new ArrayList<ShowData>();
				while (rset.next()) {
					ShowData data = new ShowData();
					data.setShowNo(rset.getInt("REVIEW_NO"));
					data.setTotalCount(rset.getInt("TOTALCOUNT"));
					rList.add(data);
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return rList;
	}
	
	

	
}
