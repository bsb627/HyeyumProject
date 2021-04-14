package movie.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import movie.model.vo.MovieInfo;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;

public class MovieDAO {
	
	// 이 달의 영화
	public ArrayList<MovieInfo> selectAllMovieInfoList(Connection conn) { // 영화정보 전체보기
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MovieInfo> mInfo = null;
		String query = "SELECT * FROM MOVIE_INFO";
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			mInfo = new ArrayList<MovieInfo>();
			while(rset.next()) {
				MovieInfo movieInfo = new MovieInfo();
				// INFO_NO,MOVIE_NAME, GENRE, CAST, DIRECTOR, AGE_GROUP, RUNTIME, SYNOPSIS, ENROLL_DATE
				movieInfo.setInfoNo(rset.getInt("INFO_NO"));
				movieInfo.setMovieName(rset.getString("MOVIE_NAME"));
				movieInfo.setGenre(rset.getString("GENRE"));
				movieInfo.setCast(rset.getString("CAST"));
				movieInfo.setDirector(rset.getString("DIRECTOR"));
				movieInfo.setAgeGroup(rset.getString("AGE_GROUP"));
				movieInfo.setRunTime(rset.getString("RUNTIME"));
				movieInfo.setSynopsis(rset.getString("SYNOPSIS"));
				movieInfo.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mInfo.add(movieInfo);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
		}
		return mInfo;
	}
	
	public MovieInfo selectOneMovieInfo(Connection conn,int infoNo) { // 영화정보 상세보기
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOVIE_INFO WHERE INFO_NO ='" + infoNo + "'";
		MovieInfo movieInfo = null;
		
		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			// INFO_NO,MOVIE_NAME, GENRE, CAST, DIRECTOR, AGE_GROUP, RUNTIME, SYNOPSIS, ENROLL_DATE
			if(rset.next()) {
				movieInfo = new MovieInfo();
				movieInfo.setInfoNo(rset.getInt("INFO_NO"));
				movieInfo.setMovieName(rset.getString("MOVIE_NAME"));
				movieInfo.setGenre(rset.getString("GENRE"));
				movieInfo.setCast(rset.getString("CAST"));
				movieInfo.setDirector(rset.getString("DIRECTOR"));
				movieInfo.setAgeGroup(rset.getString("AGE_GROUP"));
				movieInfo.setRunTime(rset.getString("RUNTIME"));
				movieInfo.setSynopsis(rset.getString("SYNOPSIS"));
				//movieInfo.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
		}
		return movieInfo;
	}
	
	public int insertMovieInfo(Connection conn, MovieInfo movieInfo) { // 영화정보 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MOVIE_INFO VALUES(?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			pstmt = conn.prepareStatement(query);
			// INFO_NO,MOVIE_NAME, GENRE, CAST, DIRECTOR, AGE_GROUP, RUNTIME, SYNOPSIS, ENROLL_DATE
			pstmt.setInt(1, movieInfo.getInfoNo());
			pstmt.setString(2, movieInfo.getMovieName());
			pstmt.setString(3, movieInfo.getGenre());
			pstmt.setString(4, movieInfo.getCast());
			pstmt.setString(5, movieInfo.getDirector());
			pstmt.setString(6, movieInfo.getAgeGroup());
			pstmt.setString(7, movieInfo.getRunTime());
			pstmt.setString(8, movieInfo.getSynopsis());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateMovieInfo(Connection conn, MovieInfo movieInfo) { // 영화정보 수정
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MOVIE_INFO SET MOVIE_NAME = ?, GENRE = ?, CAST = ?, DIRECTOR = ?, AGE_GROUP = ?, RUNTIME = ?, SYNOPSIS = ? WHERE INFO_NO =?";
		
		try {
			pstmt = conn.prepareStatement(query);
			// INFO_NO의 정보 변경 => MOVIE_NAME, GENRE, CAST, DIRECTOR, AGE_GROUP, RUNTIME, SYNOPSIS
			pstmt.setString(1, movieInfo.getMovieName());
			pstmt.setString(2, movieInfo.getGenre());
			pstmt.setString(3, movieInfo.getCast());
			pstmt.setString(4, movieInfo.getDirector());
			pstmt.setString(5, movieInfo.getAgeGroup());
			pstmt.setString(6, movieInfo.getRunTime());
			pstmt.setString(7, movieInfo.getSynopsis());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMovieInfo(Connection conn, int infoNo) { // 영화정보 삭제
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MOVIE_INFO WHERE INFO_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	// 영화 리뷰
	public ArrayList<MovieReview> selectAllMovieReview(Connection conn,int currentPage) { // 영화리뷰 전체보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MovieReview> review = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY A.ENROLL_DATE DESC) AS NUM, REVIEW_NO, A.USER_ID, TICKET_NUMBER, MOVIE_NAME,CONTENTS,NICK,(A.ENROLL_DATE), STAR_RATING,SPOILER, B.GENRE, B.INFO_NO FROM MOVIE_REVIEW A JOIN MOVIE_INFO B ON A.INFO_NO=B.INFO_NO JOIN MEMBER C ON A.USER_ID=C.USER_ID) WHERE NUM BETWEEN ? AND ?";
		// REVIEW_NO, INFO_NO, STAR_RATING, CONTENTS, ENROLL_DATE, SPOILER, TICKET_NUMBER, USER_ID
		// SELECT MOVIE_NAME,CONTENTS,NICK,A.ENROLL_DATE,STAR_RATING,SPOILER,REVIEW_NO,B.INFO_NO FROM MOVIE_REVIEW A JOIN MOVIE_INFO B ON (A.INFO_NO=B.INFO_NO) JOIN MEMBER C ON (A.USER_ID=C.USER_ID)
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			review = new ArrayList<MovieReview>();
			while(rset.next()) {
				MovieReview mReview = new MovieReview();
				mReview.setNo(rset.getInt("NUM"));
				mReview.setReNo(rset.getInt("REVIEW_NO"));
				mReview.setInfoNo(rset.getInt("INFO_NO"));
				mReview.setMovieName(rset.getString("MOVIE_NAME"));
				mReview.setStarRating(rset.getInt("STAR_RATING"));
				mReview.setContents(rset.getString("CONTENTS"));
				mReview.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mReview.setSpoiler(rset.getString("SPOILER"));
				mReview.setGenre(rset.getString("GENRE"));
				mReview.setTicketNumber(rset.getString("TICKET_NUMBER"));
				mReview.setNick("NICK");
				mReview.setUserId("USER_ID");
				review.add(mReview);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally { 
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return review;
	}
	
	public String getMovieReviewPageNavi(Connection conn, int currentPage) { // 영화리뷰 페이징
		int recordTotalCount = totalReviewCount(conn); // 전체 게시물
		int recordCountPerPage = 10; // 5개씩
		int pageTotalCount = 0;
		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1; // 1 : 나머지 게시물 담는 곳
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 오류방지 코드
		if (currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int naviCountPerPage = 5; // 페이지 바, 5개씩 ( 이전 1 2 3 4 5 다음 )
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// 오류방지 코드
		if (endNavi > pageTotalCount) {
			endNavi = pageTotalCount; // 마지막 페이지를 표시할 때
		}
		boolean needPrev = true;
		boolean needNext = true;
		if (startNavi == 1) {
			needPrev = false;
		}
		if (endNavi == pageTotalCount) {
			needNext = false;
		}

		StringBuilder sb = new StringBuilder();
		if (needPrev) { // 이전 페이지 ( < )
			sb.append("<a href='/movieReview/list?currentPage=" + (startNavi - 1) + "'> 이전 </a>");
		}
		for (int i = startNavi; i <= endNavi; i++) {
			sb.append("<a href='/movieReview/list?currentPage=" + i + "'>" + i + " </a>");
		}
		if (needNext) { // 다음 페이지 ( > )
			sb.append("<a href='/movieReview/list?currentPage=" + (endNavi + 1) + "'> 다음 </a>");
		}
		return sb.toString();
	}

	public int totalReviewCount(Connection conn) { // 영화리뷰 총 게시글 수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MOVIE_REVIEW";
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
	
	public MovieReview selectOneMovieReview(Connection conn, int reNo) { // 영화리뷰 상세보기
		PreparedStatement pstmt = null; 
		ResultSet rset = null;
		MovieReview review = null;
		String query = "SELECT * FROM MOVIE_REVIEW WHERE REVIEW_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, reNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				MovieReview mReview = new MovieReview();
				mReview.setReNo(rset.getInt("REVIEW_NO"));
				mReview.setInfoNo(rset.getInt("INFO_NO"));
				mReview.setStarRating(rset.getInt("STAR_RATING"));
				mReview.setContents(rset.getString("CONTENTS"));
				mReview.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mReview.setSpoiler(rset.getString("SPOILER"));
				mReview.setTicketNumber(rset.getString("TICKET_NUMBER"));
				mReview.setNick("NICK");
				mReview.setUserId("USER_ID");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally { 
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return review;
	}
	
	public int insertMovieReview(Connection conn, MovieReview movieReview) { // 영화리뷰 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MOVIE_REVIEW VALUES(SEQ_MOVIE_REVIEW.NEXTVAL, ?,?,?,SYSDATE, ?,?,?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, movieReview.getInfoNo());
			pstmt.setInt(2, movieReview.getStarRating());
			pstmt.setString(3, movieReview.getContents());
			pstmt.setString(4, movieReview.getSpoiler());
			pstmt.setString(5, movieReview.getTicketNumber());
			pstmt.setString(6, movieReview.getNick());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateMovieReview(Connection conn, MovieReview movieReview) { // 영화리뷰 수정
		int result = 0;
		
		return result;
	}
	
	public int deleteMovieReview(Connection conn, ArrayList<Integer> reviewNo) { // 영화리뷰 삭제
		int result = 0;
		
		return result;
	}
	
	public ArrayList<MovieReview> selectSearchReviewList(Connection conn, int currentPage, String search, String searchCategory) { // 영화리뷰 검색결과 전체보기
		ArrayList<MovieReview> review = null;
		
		return review;
	}
	
	public String getSearchReviewPageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 영화리뷰 검색 페이징
		return null;
	}
	
	public int searchTotalReviewCount(Connection conn, String search, String searchCategory) { // 영화리뷰 검색 총 게시글 수
		return 0;
	}
	
	public int insertLikesReview(Connection conn, int reviewNo, String userId) { // 해당 게시글 좋아요 등록
		return 0;
	}
	
	public int updateLikesReview(Connection conn, int reviewNo, String userId) { // 해당 게시글 좋아요 취소
		return 0;
	}
	
	
	// 추천혜윰
	public ArrayList<MovieRecommend> selectAllMovieRecommend(Connection conn, int currentPage) { // 추천글 전체보기
		System.out.println("리스트dao 들어옴");
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MovieRecommend> recommend = null;
		//RECOMMEND_NO, GENRE, TITLE, CONTENTS, HITS, ENROLL_DATE, USER_ID
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC) AS NUM, RECOMMEND_NO, GENRE, TITLE, CONTENTS, HITS, ENROLL_DATE, NICK,USER_ID FROM MOVIE_RECOMMEND JOIN MEMBER USING (USER_ID)) WHERE NUM BETWEEN ? AND ? ";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rset = pstmt.executeQuery();
			recommend = new ArrayList<MovieRecommend>();
			while(rset.next()) {
				MovieRecommend mRecommend = new MovieRecommend();
				mRecommend.setRowNo(rset.getInt("RECOMMEND_NO")); // 인덱스 번호 
				mRecommend.setNo(rset.getInt("NUM")); // 행 번호
				mRecommend.setGenre(rset.getString("GENRE"));
				mRecommend.setTitle(rset.getString("TITLE"));
				mRecommend.setContents(rset.getString("CONTENTS"));
				mRecommend.setHits(rset.getInt("HITS"));
				mRecommend.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mRecommend.setNick(rset.getString("NICK"));
				mRecommend.setUserId(rset.getString("USER_ID"));
				recommend.add(mRecommend);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally { 
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
			System.out.println("dao 받아옴" + recommend);
			return recommend;
		}
	
	public String getMovieRecommendPageNavi(Connection conn, int currentPage)  { // 추천글 페이징
		int recordTotalCount = totalRecommendCount(conn); // 전체 게시물
		int recordCountPerPage = 10; // 5개씩
		int pageTotalCount = 0;
		if (recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1; // 1 : 나머지 게시물 담는 곳
		} else { 
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		// 오류방지 코드
					if(currentPage < 1 ) {
					currentPage=1;
				} else if (currentPage > pageTotalCount) {
					currentPage = pageTotalCount;
				}
		int naviCountPerPage = 5; // 페이지 바, 5개씩 ( 이전 1 2 3 4 5 다음 )
		int startNavi = ((currentPage - 1 ) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		// 오류방지 코드
				if(endNavi > pageTotalCount) {
					endNavi = pageTotalCount; // 마지막 페이지를 표시할 때 
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
			if(needPrev) { // 이전 페이지 ( < )
				sb.append("<li><a href='/movieRecommend/list?currentPage=" + (startNavi-1) + "'> 이전 </a></li>");
			}
			for(int i = startNavi; i<=endNavi; i++) {
				sb.append("<li><a href='/movieRecommend/list?currentPage=" + i + "'>" + i + " </a></li>");
			}
			if(needNext) { // 다음 페이지 ( > )
				sb.append("<li><a href='/movieRecommend/list?currentPage=" + (endNavi+1) + "'> 다음 </a></li>");
			}
		return sb.toString();
	}
	
	public int totalRecommendCount(Connection conn) { // 추천글 총 게시글 수
		Statement stmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MOVIE_RECOMMEND";
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
	
	public MovieRecommend selectOneMovieRecommend(Connection conn, int recommendNo) { // 추천글 상세보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		MovieRecommend mRecommend = null;
		String query = "SELECT * FROM MOVIE_RECOMMEND JOIN MEMBER USING (USER_ID) WHERE RECOMMEND_NO = ?" ;
		// SELECT * FROM MOVIE_RECOMMEND JOIN MEMBER USING(USER_ID) WHERE RECOMMEND_NO= '3' ;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1,recommendNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				mRecommend = new MovieRecommend();
				mRecommend.setNo(rset.getInt("RECOMMEND_NO"));
				mRecommend.setGenre(rset.getString("GENRE"));
				mRecommend.setTitle(rset.getString("TITLE"));
				mRecommend.setContents(rset.getString("CONTENTS"));
				mRecommend.setHits(rset.getInt("HITS"));
				mRecommend.setEnrollDate(rset.getDate("ENROLL_DATE"));
				mRecommend.setNick(rset.getString("NICK"));
				mRecommend.setUserId(rset.getString("USER_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mRecommend;
	}
	
	public int insertMovieRecommend(Connection conn, MovieRecommend movieRecommend) { // 추천글 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MOVIE_RECOMMEND VALUES(SEQ_MOVIE_RECOMMEND.NEXTVAL, ?, ?, ?, 0, SYSDATE, ?)";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, movieRecommend.getGenre());
			pstmt.setString(2, movieRecommend.getTitle());
			pstmt.setString(3, movieRecommend.getContents());
			pstmt.setString(4, movieRecommend.getNick());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int updateMovieRecommend(Connection conn, MovieRecommend movieRecommend) { // 추천글 수정
		PreparedStatement pstmt = null;
		int result = 0;
		String query ="UPDATE MOVIE_RECOMMEND SET GENRE=? ,TITLE=? , CONTENTS=? WHERE RECOMMEND_NO = ? ";
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, movieRecommend.getGenre());
			pstmt.setString(2, movieRecommend.getTitle());
			pstmt.setString(3, movieRecommend.getContents());
			pstmt.setInt(4, movieRecommend.getNo());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int deleteMovieRecommend(Connection conn, int recommendNo) { // 추천글 삭제
		PreparedStatement pstmt = null;
		int result = 0;
			System.out.println("no:"  + recommendNo);
		String query = "DELETE FROM MOVIE_RECOMMEND WHERE RECOMMEND_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, recommendNo);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally {
			JDBCTemplate.close(pstmt);
		}
			System.out.println("result : " + result);
		return result;
	}
	
	public ArrayList<MovieRecommend> selectSearchRecommendList(Connection conn, int currentPage, String search, String searchCategory) { //추천글 검색결과 전체보기
		PreparedStatement pstmt = null;
		ResultSet rset= null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC ) AS NUM, RECOMMEND_NO, GENRE, TITLE, CONTENTS, HITS, ENROLL_DATE, NICK FROM MOVIE_RECOMMEND JOIN MEMBER USING (USER_ID) WHERE " + searchCategory + " LIKE ? ) WHERE NUM BETWEEN ? AND ?";
		ArrayList<MovieRecommend> mRecommend = null;
		int recordCountPerPage = 5;
		int start = currentPage*recordCountPerPage - (recordCountPerPage -1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, '%' + search + '%');
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
				System.out.println("rset :" + rset);
			mRecommend = new ArrayList<MovieRecommend>();
			while(rset.next()) {
				MovieRecommend recommend = new MovieRecommend();
				recommend.setRowNo(rset.getInt("RECOMMEND_NO")); // 인덱스 번호 
				recommend.setNo(rset.getInt("NUM")); // 행 번호
				recommend.setGenre(rset.getString("GENRE"));
				recommend.setTitle(rset.getString("TITLE"));
				recommend.setContents(rset.getString("CONTENTS"));
				recommend.setHits(rset.getInt("HITS"));
				recommend.setEnrollDate(rset.getDate("ENROLL_DATE"));
				recommend.setNick(rset.getString("NICK"));
				mRecommend.add(recommend);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
			System.out.println("search DAO mRecommend : " + mRecommend);
		return mRecommend;
	}
	
	public String getSearchRecommendPageNavi(Connection conn, int currentPage, String search, String searchCategory) { // 추천글 검색 페이징
		int recordCountPerPage = 5;
		int naviCountPerPage = 5; // 1 2 3 4 5 6 7 8 9 10, 1 2 3 4 5
		int recordTotalCount =searchTotalRecommendCount(conn, search, searchCategory);
		// 123개의 게시물을 10개씩 보여준다고 가정할 때 페이지의 갯수는 13개
		int pageTotalCount = 0; // 페이지의 갯수
		if(recordTotalCount % recordCountPerPage > 0) {
			pageTotalCount = recordTotalCount / recordCountPerPage + 1;
		} else {
			pageTotalCount = recordTotalCount / recordCountPerPage;
		}
		if(currentPage < 1) {
			currentPage = 1;
		} else if (currentPage > pageTotalCount) {
			currentPage = pageTotalCount;
		}
		int startNavi = ((currentPage - 1) / naviCountPerPage) * naviCountPerPage + 1;
		int endNavi = startNavi + naviCountPerPage - 1;
		if(endNavi > pageTotalCount) {
			endNavi = pageTotalCount;
		}
		boolean needPrev = true;
		boolean needNext = true;
		if(startNavi == 1 ) {
			needPrev = false;
		}
		if(endNavi == pageTotalCount) {
			needNext = false;
		}
		// a 태그를 만드는 코드
		StringBuilder sb = new StringBuilder();
		if(needPrev) { ///notice/search?currentPage=1&searchKeyword=search
			sb.append("<a href='/movieRecommend/search?search-keyword=" + search + "&currentPage=" + (startNavi-1) + "'> 이전 </a>");
		}
		for(int i = startNavi; i<=endNavi; i++) {
			sb.append("<a href='/movieRecommend/search?search-keyword=" + search + "&currentPage=" + i + "'>" + i + " </a>");
		}
		if(needNext) {
			sb.append("<a href='/movieRecommend/search?search-keyword=" + search + "&currentPage=" + (endNavi+1) + "'> 다음 </a>");
		}
		return sb.toString();
	}
	
	public int searchTotalRecommendCount(Connection conn, String search, String searchCategory) { // 추천글 검색 총 게시글 수
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String qeury = "SELECT COUNT(*) AS TOTALCOUNT FROM MOVIE_RECOMMEND WHERE TITLE LIKE ?";
		int recordTotalCount = 0;
		
		try {
			pstmt = conn.prepareStatement(qeury);
			pstmt.setString(1,'%' + search + '%');
			rset = pstmt.executeQuery();
			if(rset.next()) {
				recordTotalCount = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
		return recordTotalCount;
	}
	
	public int updateHitsRecommend(Connection conn, int recommendNo) { // 해당 게시글 조회수 증가
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = "UPDATE MOVIE_RECOMMEND SET HITS = NVL(HITS,0) + 1 WHERE RECOMMEND_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, recommendNo);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
	
	public int insertLikesRecommend(Connection conn, int recommendNo, String userId) { // 해당 게시글 좋아요 등록
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT COUNT(*) AS TOTALCOUNT FROM MOVIE_LIKES WHERE RECOMMEND_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, recommendNo);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				count = rset.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		
		return count;
	}
	
	public int updateLikesRecommend(Connection conn, int recommendNo, String userId) { // 해당 게시글 좋아요 취소
		return 0;
	}
	
}
