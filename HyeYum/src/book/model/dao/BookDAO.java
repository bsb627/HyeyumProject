package book.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.BookInfo;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import common.JDBCTemplate;

public class BookDAO {
	//BookInfo
	public ArrayList<BookInfo> selectAllBookInfo(Connection conn){ // 책정보 전체보기
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<BookInfo>bList = null;
		String query = "SELECT A.BOOKNO, A.TITLE, A.NICK, A.REGDATE, A.HITS, A.LIKES FROM (SELECT BOOKNO, TITLE, NICK, REGDATE, HITS, LIKES ORDER BY REGDATE) A WHERE ROWNUM BETWEEN ? AND ?";
				
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			bList = new ArrayList<BookInfo>();
			while(rset.next()) {
				
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
	public BookInfo selectOneBookInfo(Connection conn, int infoNo) { // 책정보 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT A.BOOKNO, A.TITLE, A.NICK, A.REGDATE, A.HITS, A.LIKES FROM (SELECT BOOKNO, TITLE, NICK, REGDATE, HITS, LIKES ORDER BY REGDATE) A WHERE ROWNUM BETWEEN ? AND ?";
		BookInfo info = null;
		
		return info;
	}
	public int insertBookInfo(Connection conn, BookInfo bookInfo) { // 책정보 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1, bookInfo.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int updateBookInfo(Connection conn, BookInfo bookInfo) { // 책정보 수정
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setLong(1,  bookInfo.getInfoNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int deleteBookInfo(Connection conn, int no) { // 책정보 삭제
		PreparedStatement pstmt = null;
		int result = 0;
		return result;
	}
	
	// BookReview
	public ArrayList<BookReview> selectAllBookReview(Connection conn, int currentPage){ // 책리뷰 전체보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookReview> bList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY ENROLL_DATE DESC) AS NUM, REVIEW_NO, DIVISION, TITLE, NICK, ENROLL_DATE, HITS FROM BOOK_REVIEW JOIN MEMBER USING(USER_ID))WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			bList = new ArrayList<BookReview>();
			while(rset.next()) {
				BookReview review = new BookReview();
				review.setNo(rset.getInt("REVIEW_NO"));
				review.setDivision(rset.getString("DIVISION"));
				review.setTitle(rset.getString("TITLE"));
				review.setNick(rset.getString("NICK"));
				review.setEnrollDate(rset.getDate("ENROLL_DATE"));
				review.setHits(rset.getInt("HITS"));
				review.setLikes(getLikeCount(conn,rset.getInt("REVIEW_NO")));
				review.setReplys(getReplyCount(conn,rset.getInt("REVIEW_NO")));
				bList.add(review);
				System.out.println("DAO review selectall, review : "+review );
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("allselect DAO, bList : " + bList);
		return bList;
	}
	
	public BookReview selectOneBookReview(Connection conn, int reviewNo) { //책리뷰 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookReview review = null;
		String query = "SELECT DIVISION, REVIEW_NO, TITLE, CONTENTS, ENROLL_DATE, HITS, NICK, USER_ID FROM BOOK_REVIEW JOIN MEMBER USING(USER_ID)WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				review = new BookReview();
				review.setNo(rset.getInt("REVIEW_NO"));
				review.setDivision(rset.getString("DIVISION"));
				review.setTitle(rset.getString("TITLE"));
				review.setNick(rset.getString("NICK"));
				review.setContents(rset.getString("CONTENTS"));
				review.setEnrollDate(rset.getDate("ENROLL_DATE"));
				review.setHits(rset.getInt("HITS"));
				review.setUserId(rset.getString("USER_ID"));
				System.out.println("selectOne에서 getHits()" + review.getHits());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("DAO selectOne, review : HIT값확인 " + review.getHits());
		return review;
	}
	public int getLikeCount(Connection conn, int reviewNo) { // 좋아요 수 가져오기
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT FROM BOOK_LIKES WHERE REVIEW_NO = ? AND IS_CHECK = 1";
		
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
		String query = "SELECT COUNT(*)AS TOTALCOUNT FROM BOOK_REVIEW_REPLY WHERE REVIEW_NO = ?";
		
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
	public int insertBookReview(Connection conn, BookReview review) { // 책리뷰 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK_REVIEW VALUES(SEQ_BOOK_REVIEW.NEXTVAL,?,?,?,SYSDATE,0,?,?,?)";
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, review.getDivision());
				pstmt.setString(2, review.getTitle());
				pstmt.setString(3, review.getContents());
				pstmt.setString(4, review.getUserId());
				pstmt.setInt(5, review.getInfoNo());
				pstmt.setString(6, review.getGenre());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(conn);
			}
			System.out.println("DAO, review.getGenre" + review.getGenre());
			System.out.println("result :" +result);
		return result;
	}
	public int updateBookReview(Connection conn, BookReview review) { // 책리뷰 수정
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE BOOK_REVIEW SET DIVISION = ?, TITLE = ?, CONTENTS = ?, INFO_NO=?, GENRE= ? WHERE REVIEW_NO = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, review.getDivision());
			pstmt.setString(2, review.getTitle());
			pstmt.setString(3, review.getContents());
			pstmt.setInt(4, review.getInfoNo());
			pstmt.setString(5, review.getGenre());
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
	public int deleteBookReview(Connection conn, int no) { // 책리뷰 삭제
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM BOOK_REVIEW WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, no);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public String getReviewPageNavi(Connection conn, int currentPage) { // 책리뷰 페이징
		int recordTotalCount = totalReviewCount(conn);
		int recordCountPerPage = 10;
		// 10개로 안떨어지는 상황 떄문에 추가로 변수 선언
		int pageTotalCount = 0;
		if ( recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 오류방지코드
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int naviCountPerPage = 10;
		int startNavi = ((currentPage -1)/ naviCountPerPage) * naviCountPerPage + 1;
		
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount; 
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) { // 맨 처음 페이지
			needPrev = false;
		}
		if(endNavi == pageTotalCount) { // 맨마지막 페이지
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) { 
			sb.append("<a href='/bookReview/list?currentPage="+ (startNavi-1)+"'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/bookReview/list?currentPage=" + i + "'>" + i + " </a>"); // 버튼을 눌렀을 때 다음페이지로 넘어가도록 주소를 줌
		}
		if(needNext) {
			sb.append("<a href='/bookReview/list?currentPage=" + (endNavi+1)+ "'> > </a>");
		}
		return sb.toString();
	}
	public int totalReviewCount(Connection conn) { //책리뷰 총 게시글 수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOOK_REVIEW";
		// 전체 게시물의 개수
		// AS 는 별칭을 준 것. 컬럼명이 있어야 필드값 가져올 수 있기 때문에
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
	public ArrayList<BookReview> selectSearchReviewList(Connection conn, int currentPage, String searchCategory){ // 책리뷰 검색결과 전체보기
		return null;
	}
	public String getSearchReviewPageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 책리뷰 검색 페이징
		return null;
	}
	public int searchTotalReviewCount(Connection conn, String search, String searchCategory) { // 책리뷰 검색
		return 0;
	}
	public int updateHitsReview(Connection conn, int reviewNo) { //  게시글 조회수 증가 
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE BOOK_REVIEW SET HITS = (SELECT HITS FROM BOOK_REVIEW WHERE REVIEW_NO = ?)+1 WHERE REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.setInt(2, reviewNo);
			System.out.println(String.format("%s %d", query, reviewNo));
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		System.out.println("DAO hits, result : " + result);
		return result;
	}
	// Review 좋아요
	public int insertLikesReview(Connection conn, int reviewNo, String userId) { // 게시글 좋아요 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK_LIKES VALUES(SEQ_BOOK_REVIEW_LIKES.NEXTVAL,1,?,0,?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reviewNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateLikesReview(Connection conn, int reviewNo, String userId, String state) { // 좋아요 취소
		PreparedStatement pstmt = null;
		int likes = 0;
		String query = "UPDATE BOOK_LIKES SET IS_CHECK = ? WHERE USER_ID = ? AND REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, state);
			pstmt.setString(2, userId);
			pstmt.setInt(3, reviewNo);
			likes = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return likes;
	}
	public int selectLikesReview(Connection conn, String userId, int reviewNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int likes = 0;
		String query = "SELECT * FROM BOOK_LIKES WHERE USER_ID = ? AND REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, reviewNo);
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
	public int checkLikesReview(Connection conn, int reviewNo, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int check = 0;
		String query = "SELECT COUNT(*)AS ISCHECK FROM BOOK_LIKES WHERE USER_ID = ? AND REVIEW_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, reviewNo);
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
		System.out.println("DAO check review : "+check);
		return check;
	}
	
	
	// BookShare start
	public ArrayList<BookShare> selectAllBookShare(Connection conn, int currentPage){ // 책나눔 전체보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookShare> sList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY ENROLL_DATE DESC) AS NUM, SHARE_NO, REGION, TITLE, NICK, ENROLL_DATE, HITS FROM BOOK_SHARE JOIN MEMBER USING(USER_ID))WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,  start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			sList = new ArrayList<BookShare>();
			while(rset.next()) {
				BookShare share = new BookShare();
				share.setNo(rset.getInt("SHARE_NO"));
				share.setRegion(rset.getString("REGION"));
				share.setTitle(rset.getString("TITLE"));
				share.setNick(rset.getString("NICK"));
				share.setEnrollDate(rset.getDate("ENROLL_DATE"));
				share.setHits(rset.getInt("HITS"));
				share.setLikes(getLikeCountShare(conn,rset.getInt("SHARE_NO")));
				share.setReplys(getReplyCountShare(conn,rset.getInt("SHARE_NO")));
				sList.add(share);
//				System.out.println("DAO sList : " + sList);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return sList;
	}
	public BookShare selectOneBookShare(Connection conn, int shareNo) { // 책나눔 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		BookShare share = null;
		String query = "SELECT REGION, SHARE_NO, TITLE, CONTENTS, ENROLL_DATE, HITS, NICK, USER_ID FROM BOOK_SHARE JOIN MEMBER USING(USER_ID)WHERE SHARE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				share = new BookShare();
				share.setRegion(rset.getString("REGION"));
				share.setNo(rset.getInt("SHARE_NO"));
				share.setTitle(rset.getString("TITLE"));
				share.setContents(rset.getString("CONTENTS"));
				share.setEnrollDate(rset.getDate("ENROLL_DATE"));
				share.setHits(rset.getInt("HITS"));
				share.setNick(rset.getString("NICK"));
				share.setUserId(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		System.out.println("share :" + share);
		return share;
	}
	public int insertBookShare(Connection conn, BookShare share) { // 책나눔 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK_SHARE VALUES(SEQ_BOOK_SHARE.NEXTVAL,?,?,?,SYSDATE,0,?)";
		
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, share.getRegion());
				pstmt.setString(2, share.getTitle());
				pstmt.setString(3, share.getContents());
				pstmt.setString(4, share.getUserId());
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				JDBCTemplate.close(conn);
			}
			System.out.println("DAOresult:" + result);
		return result;
	}
	public int updateBookShare(Connection conn, BookShare share) { // 책나눔 수정
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE BOOK_SHARE SET SHARE_NO = ?, REGION= ?, TITLE = ?, CONTENTS = ?  WHERE SHARE_NO=? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, share.getNo());
			pstmt.setString(2, share.getRegion());
			pstmt.setString(3, share.getTitle());
			pstmt.setString(4, share.getContents());
			pstmt.setInt(5, share.getNo());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int deleteBookShare(Connection conn, int shareNo) { // 책나눔 삭제
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM BOOK_SHARE WHERE SHARE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
			result = pstmt.executeUpdate();
			System.out.println("sharenoDAO:" + shareNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	// 책나눔 페이징
	public String getSharePageNavi(Connection conn, int currentPage) { 
		int recordTotalCount = totalShareCount(conn);
		int recordCountPerPage = 10;
		// 10개로 안떨어지는 상황 떄문에 추가로 변수 선언
		int pageTotalCount = 0;
		if ( recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		}else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 오류방지코드
		if(currentPage < 1) {
			currentPage = 1;
		}else if(currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int naviCountPerPage = 10;
		int startNavi = ((currentPage -1)/ naviCountPerPage) * naviCountPerPage + 1;
		
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount; 
		}
		
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1) { // 맨 처음 페이지
			needPrev = false;
		}
		if(endNavi == pageTotalCount) { // 맨마지막 페이지
			needNext = false;
		}
		StringBuilder sb = new StringBuilder();
		if(needPrev) { 
			sb.append("<a href='/bookShare/list?currentPage="+ (startNavi-1)+"'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/bookShare/list?currentPage=" + i + "'>" + i + " </a>"); // 버튼을 눌렀을 때 다음페이지로 넘어가도록 주소를 줌
		}
		if(needNext) {
			sb.append("<a href='/bookShare/list?currentPage=" + (endNavi+1)+ "'> > </a>");
		}
		return sb.toString();
	}
	public int totalShareCount(Connection conn) { // 책나눔 총 게시글 수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM BOOK_SHARE";
		// 전체 게시물의 개수
		// AS 는 별칭을 준 것. 컬럼명이 있어야 필드값 가져올 수 있기 때문에
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
	private int getReplyCountShare(Connection conn ,int shareNo) { // 나눔 리플 수 가져오기
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT FROM BOOK_SHARE_REPLY WHERE SHARE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
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
	public ArrayList<BookShare>selectSearchBookShare(Connection conn, int currentPage, String search, String searchCategory){
		
		return null;
	}
	public String getSearchSharePageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 책나눔 검색 페이징
		
		return null;
	}
	public int searchTotalShareCount(Connection conn, String search, String searchCategory ) {
		return 0;
	}
	public int  updateHitsShare(Connection conn, int shareNo) { // 조회수 증가
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE BOOK_SHARE SET HITS = (SELECT HITS FROM BOOK_SHARE WHERE SHARE_NO = ?)+1 WHERE SHARE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
			pstmt.setInt(2, shareNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		System.out.println("DAO hits, result : " + result);
		return result;
	}
	
	// Share 좋아요
	public int insertLikesShare(Connection conn, int shareNo, String userId) { // 좋아요 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO BOOK_LIKES VALUES(SEQ_BOOK_SHARE_LIKES.NEXTVAL,1,0,?,?)";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
			pstmt.setString(2, userId);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	public int updateLikesShare(Connection conn, int shareNo, String userId, String state) { //좋아요 취소
		PreparedStatement pstmt = null;
		int likes = 0;
		String query = "UPDATE BOOK_LIKES SET IS_CHECK = ? WHERE USER_ID = ? AND SHARE_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, state);
			pstmt.setString(2, userId);
			pstmt.setInt(3, shareNo);
			likes = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return likes;
	}
	public int selectLikesShare(Connection conn, String userId, int shareNo) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int likes = 0;
		String query = "SELECT * FROM BOOK_LIKES WHERE USER_ID = ? AND SHARE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, shareNo);
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
	public int checkLikesShare(Connection conn, int shareNo, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int check = 0;
		String query = "SELECT COUNT(*)AS ISCHECK FROM BOOK_LIKES WHERE USER_ID = ? AND SHARE_NO = ?";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, shareNo);
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
	public int getLikeCountShare(Connection conn, int shareNo) { // 좋아요 수 가져오기
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*)AS TOTALCOUNT FROM BOOK_LIKES WHERE SHARE_NO = ? AND IS_CHECK = 1";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, shareNo);
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


}
