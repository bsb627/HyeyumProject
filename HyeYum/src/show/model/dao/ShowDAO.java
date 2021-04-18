package show.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.BookInfo;
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
		
		int recordCountPerPage = 8;
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
					review.setReplys(getReplyCount(conn,rset.getInt("REVIEW_NO")));
					review.setLikes(getLikeCount(conn,rset.getInt("REVIEW_NO")));
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
	
	public int getLikeCount(Connection conn, int reviewNo) { // 좋아요 수 가져오기
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT FROM SHOW_LIKES WHERE REVIEW_NO = ? AND IS_CHECK = 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return count;
	}

	private int getReplyCount(Connection conn ,int reviewNo) { // 리플 수 가져오기
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT FROM SHOW_REVIEW_REPLY WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count ;
	}

	public ShowReview selectOneReview(Connection conn, int showNo) { // 관람후기 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ShowReview review = null;
		String query = "SELECT REVIEW_NO,TITLE,CONTENTS,SNS_LINK,HITS,TICKET_NUMBER,ENROLL_DATE,A.USER_ID,NICK,INFO_NO,(SELECT COUNT(*) FROM SHOW_LIKES WHERE REVIEW_NO = ? AND IS_CHECK = 1) AS LIKES, (SELECT COUNT(*) FROM SHOW_REVIEW_REPLY WHERE REVIEW_NO=?) AS REPLYS FROM SHOW_REVIEW A JOIN MEMBER B ON A.USER_ID=B.USER_ID  WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, showNo);
			pstmt.setInt(2, showNo);
			pstmt.setInt(3, showNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				review = new ShowReview();
				review.setNo(rset.getInt("REVIEW_NO"));
				review.setTitle(rset.getString("TITLE"));
				review.setContents(rset.getString("CONTENTS"));
				review.setSnsLink(rset.getString("SNS_LINK"));
				review.setHits(rset.getInt("HITS"));
				review.setLikes(rset.getInt("LIKES"));
				review.setReplys(rset.getInt("REPLYS"));
				review.setTicketNumber(rset.getString("TICKET_NUMBER"));
				review.setEnrollDate(rset.getDate("ENROLL_DATE"));
				review.setNick(rset.getString("NICK"));
				review.setUserId(rset.getString("USER_ID"));
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
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE SHOW_REVIEW SET TITLE = ?, CONTENTS = ?, SNS_LINK = ?, TICKET_NUMBER = ?, INFO_NO=? WHERE REVIEW_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContents());
			pstmt.setString(3, review.getSnsLink());
			pstmt.setString(4, review.getTicketNumber());
			pstmt.setInt(5, review.getInfoNo());
			pstmt.setInt(6, review.getNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteReview(Connection conn, int reviewNo) { // 관람후기 삭제
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM SHOW_REVIEW WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public String getReviewPageNavi(Connection conn, int currentPage) { // 관람후기 페이징
		int recordTotalCount = totalReviewCount(conn);
		int pageTotalCount = 0;
		int recordCountPerPage = 8;
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
	
	public ArrayList<ShowReview> selectSearchReviewList(Connection conn, int currentPage, String search) { // 관람후기 검색결과 전체보기

		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ShowReview> showList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM,REVIEW_NO,TITLE,CONTENTS,SNS_LINK,HITS,TICKET_NUMBER,ENROLL_DATE,USER_ID,NICK,INFO_NO FROM SHOW_REVIEW JOIN MEMBER USING(USER_ID) WHERE TITLE LIKE ?  OR CONTENTS LIKE ? OR NICK LIKE ?) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 8;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, '%'+search+'%');
			pstmt.setString(2, '%'+search+'%');
			pstmt.setString(3, '%'+search+'%');
			pstmt.setInt(4, start);
			pstmt.setInt(5, end);
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
					review.setReplys(getReplyCount(conn,rset.getInt("REVIEW_NO")));
					review.setLikes(getLikeCount(conn,rset.getInt("REVIEW_NO")));
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

	public String getSearchReviewPageNavi(Connection conn, int currentPage, String search) { // 관람후기 검색 페이징
		int recordTotalCount = searchTotalReviewCount(conn, search);
		int pageTotalCount = 0;
		int recordCountPerPage = 8;
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
			sb.append("<li><a href='/showReview/list?search="+search+"&currentPage="+ (startNavi-1) + "'> 이전 </a></li>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if(currentPage == i) {
				sb.append("<li class='active'><a href='/showReview/list?search="+search+"&currentPage="+ i +"'>" + i + "</a></li>");
			}else {
				sb.append("<li><a href='/showReview/list?search="+search+"&currentPage="+ i +"'>" + i + "</a></li>");
			}
		}
		if( needNext) {
			sb.append("<li><a href='/showReview/list?search="+search+"currentPage="+ (endNavi + 1) + "'> 다음 </a></li>");
		}
		return sb.toString();
	}

	public int searchTotalReviewCount(Connection conn, String search) { // 관람후기 검색 총 게시글 수
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM SHOW_REVIEW JOIN MEMBER USING(USER_ID) WHERE TITLE LIKE ?  OR CONTENTS LIKE ? OR NICK LIKE ?";
		int recordTotalCount = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, '%'+search+'%');
			pstmt.setString(2, '%'+search+'%');
			pstmt.setString(3, '%'+search+'%');
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
	
	public int updateHitsReview(Connection conn, int showNo) { // 해당 게시글 조회수 증가
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE SHOW_REVIEW SET HITS = (SELECT HITS FROM SHOW_REVIEW WHERE REVIEW_NO = ?)+1 WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, showNo);
			pstmt.setInt(2, showNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return result;
		

	}
	
	public int insertLikesReview(Connection conn, int showNo, String userId) { // 해당 게시글 좋아요 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO SHOW_LIKES VALUES(SEQ_SHOW_LIKES_NO.NEXTVAL,1,?,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, showNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	public int updateLikesReview(Connection conn, int showNo, String userId, String state) { // 해당 게시글 좋아요 취소
		PreparedStatement pstmt = null;
		int likes = 0;
		String query = "UPDATE SHOW_LIKES SET IS_CHECK = ? WHERE USER_ID = ? AND REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, state);
			pstmt.setString(2, userId);
			pstmt.setInt(3, showNo);
			likes = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		return likes;
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
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		
		return rList;
	}

	public int selectLikes(Connection conn, String userId, int showNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int likes = 0;
		String query = "SELECT * FROM SHOW_LIKES WHERE USER_ID = ? AND REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, showNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				likes = Integer.parseInt(rset.getString("IS_CHECK"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return likes;
	}

	public int checkShowLikes(Connection conn, int showNo, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int check = 0;
		String query = "SELECT COUNT(*)AS ISCHECK FROM SHOW_LIKES WHERE USER_ID = ? AND REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, showNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				check = rset.getInt("ISCHECK");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return check;
	}

	public ArrayList<ShowData> selectLikesCount(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT,REVIEW_NO FROM SHOW_LIKES GROUP BY REVIEW_NO";
		ArrayList<ShowData> rList = null;
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				rList = new ArrayList<ShowData>();
				while (rset.next()) {
					ShowData data = new ShowData();
					data.setShowNo(rset.getInt("REVIEW_NO"));
					data.setLikesCount(rset.getInt("TOTALCOUNT"));
					rList.add(data);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return rList;
	}

	public ArrayList<ShowInfo> getShowInfoList(Connection conn) { // 공연 정보 가져오기
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM SHOW_INFO JOIN SHOW_FILE USING (INFO_NO) ORDER BY ENROLL_DATE DESC";
		ArrayList<ShowInfo> iList = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if( rset != null) {
				iList = new ArrayList<ShowInfo>();
				while(rset.next()) {
					ShowInfo info = new ShowInfo();
					
					info.setInfoNo(rset.getInt("INFO_NO"));
					info.setType(rset.getString("TYPE"));
					info.setGenre(rset.getString("GENRE"));
					info.setRegion(rset.getString("REGION"));
					info.setPlace(rset.getString("PLACE"));
					info.setShowName(rset.getString("SHOW_NAME"));
					info.setTermDate(rset.getString("TERM_DATE"));
					info.setAgeGroup(rset.getString("AGE_GROUP"));
					info.setRunTime(rset.getInt("RUN_TIME"));
					info.setCast(rset.getString("CAST"));
					info.setPrice(rset.getInt("PRICE"));
					info.setEnrollDate(rset.getDate("ENROLL_DATE"));
					info.setFileNo(rset.getInt("FILE_NO"));
					info.setFileName(rset.getString("FILE_NAME"));
					info.setFilePath(rset.getString("FILE_PATH"));
					iList.add(info);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return iList;
	}

	public ArrayList<String> getRegion(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<String> rList = null;
		String query = "SELECT REGION FROM SHOW_INFO GROUP BY REGION";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset != null) {
				rList = new ArrayList<String>();
				while(rset.next()) {
					String region  = rset.getString("REGION");
					rList.add(region);
				}
			}
		} catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return rList;
	}

	public ShowInfo getShowInfo(Connection conn, int no) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM SHOW_INFO JOIN SHOW_FILE USING (INFO_NO) WHERE INFO_NO = "+no+" ORDER BY ENROLL_DATE DESC";
		ShowInfo info = new ShowInfo();
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if(rset.next()) {
					info.setInfoNo(rset.getInt("INFO_NO"));
					info.setType(rset.getString("TYPE"));
					info.setGenre(rset.getString("GENRE"));
					info.setRegion(rset.getString("REGION"));
					info.setPlace(rset.getString("PLACE"));
					info.setShowName(rset.getString("SHOW_NAME"));
					info.setTermDate(rset.getString("TERM_DATE"));
					info.setAgeGroup(rset.getString("AGE_GROUP"));
					info.setRunTime(rset.getInt("RUN_TIME"));
					info.setCast(rset.getString("CAST"));
					info.setPrice(rset.getInt("PRICE"));
					info.setEnrollDate(rset.getDate("ENROLL_DATE"));
					info.setFileNo(rset.getInt("FILE_NO"));
					info.setFileName(rset.getString("FILE_NAME"));
					info.setFilePath(rset.getString("FILE_PATH"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return info;
	}

	public ArrayList<BookInfo> getBookInfoList(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM BOOk_INFO JOIN BOOK_INFO_FILE USING (INFO_NO) ORDER BY ENROLL_DATE DESC";
		ArrayList<BookInfo> bList = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if( rset != null) {
				bList = new ArrayList<BookInfo>();
				while(rset.next()) {
					BookInfo info = new BookInfo();
					
					info.setInfoNo(rset.getInt("INFO_NO"));
					info.setBookName(rset.getString("BOOK_NAME"));
					info.setGenre(rset.getString("GENRE"));
					info.setAuthor(rset.getString("AUTHOR"));
					info.setPublisher(rset.getString("PUBLISHER"));
					info.setIntro(rset.getString("INTRO"));
					info.setEnrollDate(rset.getDate("ENROLL_DATE"));
					info.setFileNo(rset.getInt("FILE_NO"));
					info.setFileName(rset.getString("FILE_NAME"));
					info.setFilePath(rset.getString("FILE_PATH"));
					bList.add(info);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		
		return bList;
	}
	
	

	
}
