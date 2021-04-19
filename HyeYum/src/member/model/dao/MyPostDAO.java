package member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import book.model.vo.BookReview;
import common.JDBCTemplate;
import member.model.vo.MyPost;
import movie.model.vo.MovieRecommend;
import movie.model.vo.MovieReview;
import show.model.vo.ShowReview;

public class MyPostDAO {
	
	// 받은 메시지 전체 갯수 
	private int totalCount(Connection conn, String userId) {
			Statement stmt = null;
			ResultSet rset = null;
			String query = "SELECT COUNT (*) AS TOTALCOUNT FROM BOOK_REVIEW B1, BOOK_SHARE B2, MOVIE_REVIEW M, SHOW_REVIEW S, QNA Q WHERE B1.USER_ID = B2.USER_ID AND B2.USER_ID = M.USER_ID AND M.USER_ID = S.USER_ID AND S.USER_ID = Q.USER_ID"; 
//					"SELECT COUNT(*) AS TOTALCOUNT FROM MESSAGERE WHERE RECEIVER = '" + userId +"'";
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
	
//	// BookReview 받은 메시지 전체 출력 
//	public ArrayList<MyPost> selectAllList(Connection conn, int currentPage, String userId) {
//		PreparedStatement pstmt = null;
//		ResultSet rset = null;
//		ArrayList<MyPost> mList = null;
//		String query = "SELECT *FROM (SELECT ROW_NUMBER() OVER (ORDER BY ENROLL_DATE DESC) AS NUM, TITLE, ENROLL_DATE, HITS FROM BOOK_REVIEW WHERE USER_ID = ? ) WHERE NUM BETWEEN ? AND ?";
//		
//		int recordCountPerPage = 10;
//		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
//		int end = currentPage*recordCountPerPage;
//		try {
//			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1,userId);
//			pstmt.setInt(2, start);
//			pstmt.setInt(3, end);
//			rset = pstmt.executeQuery();
//			mList = new ArrayList<MyPost>();
//			while(rset.next()) {
//				MyPost post = new MyPost();
//				post.setTitle(rset.getString("TITLE"));
//				post.setEnrollDate(rset.getDate("ENROLL_DATE"));
//				post.setHits(rset.getInt("HITS"));
//				mList.add(post);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(rset);
//			JDBCTemplate.close(pstmt);
//		}
//		
//		return mList;
//	}
	// BookReview
	public ArrayList<BookReview> selectAllBookReview(Connection conn, int currentPage, String userId) { // 내가 쓴 글
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<BookReview> review = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER (ORDER BY ENROLL_DATE DESC) AS NUM, TITLE, ENROLL_DATE, HITS FROM BOOK_REVIEW WHERE USER_ID = ? )WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,  userId);
			pstmt.setInt(2,  start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			review = new ArrayList<BookReview>();
			if (rset != null) {
				while(rset.next()) {
					BookReview bReview = new BookReview();
					bReview.setTitle(rset.getString("TITLE")); 	
					bReview.setEnrollDate(rset.getDate("ENROLL_DATE"));
					bReview.setHits(rset.getInt("HITS"));
					review.add(bReview);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return review;
	}
	// movieReview
	public ArrayList<MovieReview> selectAllMovieReview(Connection conn,int currentPage,String userId) { // 내가 쓴 영화리뷰 
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MovieReview> review = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC) AS NUM, CONTENTS, ENROLL_DATE, STAR_RATING FROM MOVIE_REVIEW WHERE USER_ID = ? ) WHERE NUM BETWEEN ? AND ?";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			review = new ArrayList<MovieReview>();
			if (rset != null) {
				while(rset.next()) {
					MovieReview mReview = new MovieReview();
					mReview.setContents(rset.getString("CONTENTS"));
					mReview.setEnrollDate(rset.getDate("ENROLL_DATE"));
					mReview.setStarRating(rset.getInt("STAR_RATING"));
					review.add(mReview);
					}
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
	// MovieRecommend
	public ArrayList<MovieRecommend> selectAllMovieRecommend(Connection conn, int currentPage, String userId) { // 내가 쓴 글
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MovieRecommend> recommend = null;
		//RECOMMEND_NO, GENRE, TITLE, CONTENTS, HITS, ENROLL_DATE, USER_ID
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC) AS NUM, TITLE, ENROLL_DATE, HITS FROM MOVIE_RECOMMEND WHERE USER_ID = ?) WHERE NUM BETWEEN ? AND ? ";
		int recordCountPerPage = 10;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			recommend = new ArrayList<MovieRecommend>();
			if (rset != null) {
				while(rset.next()) {
					MovieRecommend mRecommend = new MovieRecommend();
					mRecommend.setTitle(rset.getString("TITLE"));
					mRecommend.setEnrollDate(rset.getDate("ENROLL_DATE"));
					mRecommend.setHits(rset.getInt("HITS"));
					recommend.add(mRecommend);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  finally { 
			JDBCTemplate.close(pstmt);
			JDBCTemplate.close(rset);
		}
			return recommend;
		}
	// showReview
	public ArrayList<ShowReview> selectAllReviewList(Connection conn, int currentPage, String userId) { // 내가 쓴 글 보기
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<ShowReview> showList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY ENROLL_DATE DESC)AS NUM,TITLE, ENROLL_DATE, HITS FROM SHOW_REVIEW WHERE USER_ID = ?) WHERE NUM BETWEEN ? AND ?";
		
		int recordCountPerPage = 8;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if (rset != null) {
				showList = new ArrayList<ShowReview>();
				while(rset.next()) {
					ShowReview review = new ShowReview();
					review.setTitle(rset.getString("TITLE"));
					review.setEnrollDate(rset.getDate("ENROLL_DATE"));
					review.setHits(rset.getInt("HITS"));
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
	
	
	
	public String getPageNaviRe(Connection conn, int currentPage, String userId) {
			int recordTotalCount = totalCount(conn, userId);
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
				sb.append("<a href='/message/receivedList?currentPage=" + (startNavi-1) + "'> < </a>");
			}
			for(int i = startNavi; i <= endNavi; i++) {
				if( currentPage == i) { sb.append("<a href='/message/receivedList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary active' value = '"+ i + "'>  </a>");}
				else { sb.append("<a href='/message/receivedList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary' value = '"+ i + "'>  </a>"); }
			}
			if( needNext) {
				sb.append("<a href='/message/receivedList?currentPage=" + (endNavi + 1) + "'> > </a>");
			}
			return sb.toString();
		}

	public ArrayList<MyPost> selectAll(Connection conn, int currentPage, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<MyPost> pList = null;
		String query = "SELECT B1.TITLE TITLE, B1.ENROLL_DATE ENROLL_DATE, B1.HITS HITS FROM BOOK_REVIEW B1, BOOK_SHARE B2, MOVIE_REVIEW M, SHOW_REVIEW S WHERE B1.USER_ID = B2.USER_ID AND B2.USER_ID = M.USER_ID AND M.USER_ID = S.USER_ID AND S.USER_ID = ?";
		
		int recordCountPerPage = 8;
		int start = currentPage*recordCountPerPage - (recordCountPerPage - 1);
		int end = currentPage*recordCountPerPage;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);
			rset = pstmt.executeQuery();
			if (rset != null) {
				pList = new ArrayList<MyPost>();
				while(rset.next()) {
					MyPost post = new MyPost();
					post.setTitle(rset.getString("TITLE"));
					post.setEnrollDate(rset.getDate("ENROLL_DATE"));
					post.setHits(rset.getInt("HITS"));
					pList.add(post);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return pList;
	}
	
	public String getPageNavi(Connection conn, int currentPage, String userId) {
		int recordTotalCount = totalCount(conn, userId);
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
			sb.append("<a href='/message/receivedList?currentPage=" + (startNavi-1) + "'> < </a>");
		}
		for(int i = startNavi; i <= endNavi; i++) {
			if( currentPage == i) { sb.append("<a href='/message/receivedList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary active' value = '"+ i + "'>  </a>");}
			else { sb.append("<a href='/message/receivedList?currentPage=" + i + "'>" +"<input type = 'button' class = 'btn btn-outline-primary' value = '"+ i + "'>  </a>"); }
		}
		if( needNext) {
			sb.append("<a href='/message/receivedList?currentPage=" + (endNavi + 1) + "'> > </a>");
		}
		return sb.toString();
	}


}
