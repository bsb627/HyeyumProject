package admin.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import common.JDBCTemplate;
import movie.model.vo.MovieInfo;
import movie.model.vo.MovieReview;

public class AdminMovieDAO {

	public ArrayList<MovieInfo> selectAllMovieInfoList(Connection conn) { // 관리자 영화 리스트 전체 출력
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MovieInfo> mList = null;
		String query = "SELECT * FROM MOVIE_INFO ORDER BY ENROLL_DATE DESC";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			if (rset != null) {
				mList = new ArrayList<MovieInfo>();
				while (rset.next()) {
					MovieInfo mInfo = new MovieInfo();
					mInfo.setInfoNo(rset.getInt("INFO_NO"));
					mInfo.setMovieName((rset.getString("MOVIE_NAME")));
					mInfo.setGenre(rset.getString("GENRE"));
					mInfo.setCast(rset.getString("CAST"));
					mInfo.setDirector(rset.getString("DIRECTOR"));
					mInfo.setAgeGroup(rset.getString("AGE_GROUP"));
					mInfo.setRunTime(rset.getString("RUNTIME"));
					mInfo.setSynopsis(rset.getString("SYNOPSIS"));
					mInfo.setEnrollDate(rset.getDate("ENROLL_DATE"));
					mList.add(mInfo);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(stmt);
		}
		return mList;
	}

	public int insertMovieInfo(Connection conn, MovieInfo movieInfo) { // 관리자 영화 정보 등록
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "INSERT INTO MOVIE_INFO VALUES(SEQ_MOVIE_INFO.NEXTVAL, ?, ?, ?, ?, ?, ?,?, SYSDATE";
		// INSERT INTO MOVIE_INFO VALUES(SEQ_MOVIE_INFO.NEXTVAL, MOVIE_NAME, GENRE,
		// CAST, DIRECTOR, AGE_GROUP, RUNTIME, SYSDATE);

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, movieInfo.getMovieName());
			pstmt.setString(2, movieInfo.getGenre());
			pstmt.setString(3, movieInfo.getCast());
			pstmt.setString(4, movieInfo.getDirector());
			pstmt.setString(5, movieInfo.getAgeGroup());
			pstmt.setString(6, movieInfo.getRunTime());
			pstmt.setString(6, movieInfo.getSynopsis());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public MovieInfo selectOneMovieInfo(Connection conn, int infoNo) { // 영화 정보 상세 조회
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = "SELECT * FROM MOVIE_INFO WHERE INFO_NO = ?";
		MovieInfo mInfo = new MovieInfo();

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
			rset = pstmt.executeQuery();
			if (rset.next()) {
				mInfo.setInfoNo(rset.getInt("INFO_NO"));
				mInfo.setMovieName((rset.getString("MOVIE_NAME")));
				mInfo.setGenre(rset.getString("GENRE"));
				mInfo.setCast(rset.getString("CAST"));
				mInfo.setDirector(rset.getString("DIRECTOR"));
				mInfo.setAgeGroup(rset.getString("AGE_GROUP"));
				mInfo.setRunTime(rset.getString("RUNTIME"));
				mInfo.setSynopsis(rset.getString("SYNOPSIS"));
				mInfo.setEnrollDate(rset.getDate("ENROLL_DATE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rset);
			JDBCTemplate.close(pstmt);
		}
		return mInfo;
	}

	public int deleteMovieInfo(Connection conn, int infoNo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "DELETE FROM MOVIE_INFO WHERE INFO_NO = ?";
		// DELETE FROM MOVIE_INFO WHERE INFO_NO = '3';

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public int updateMovieInfo(Connection conn, MovieInfo movieInfo) {
		PreparedStatement pstmt = null;
		int result = 0;
		String query = "UPDATE MOVIE_INFO SET MOVIE_NAME = ? , GENRE = ?, CAST = ?, DIRECTOR =?, AGE_GROUP =?, RUNTIME = ? , SYNOPSIS = ? WHERE INFO_NO = ?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, movieInfo.getMovieName());
			pstmt.setString(2, movieInfo.getGenre());
			pstmt.setString(3, movieInfo.getCast());
			pstmt.setString(4, movieInfo.getDirector());
			pstmt.setString(5, movieInfo.getAgeGroup());
			pstmt.setString(6, movieInfo.getRunTime());
			pstmt.setString(6, movieInfo.getSynopsis());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}

	public ArrayList<MovieReview> selectAllMovieReviewList(Connection conn) { // 관리자 영화 리뷰 전체 출력 
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<MovieReview> mList = null;
		String query = "SELECT * FROM (SELECT ROW_NUMBER() OVER(ORDER BY A.ENROLL_DATE DESC) AS NUM, REVIEW_NO, A.USER_ID, TICKET_NUMBER, MOVIE_NAME,CONTENTS,NICK,(A.ENROLL_DATE), STAR_RATING,SPOILER, B.GENRE, B.INFO_NO FROM MOVIE_REVIEW A JOIN MOVIE_INFO B ON A.INFO_NO=B.INFO_NO JOIN MEMBER C ON A.USER_ID=C.USER_ID) WHERE NUM BETWEEN ? AND ?";
		try {
			stmt = conn.prepareStatement(query);
			rset = stmt.executeQuery(query);
			if (rset.next()) {
				mList = new ArrayList<MovieReview>();
				while (rset.next()) {
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
					mReview.setNick(rset.getString("NICK"));
					mReview.setUserId(rset.getString("USER_ID"));
					mList.add(mReview);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(stmt);
			JDBCTemplate.close(rset);
		}
		return mList;
	}

	public int deleteMovieReview(Connection conn, int reviewNo) { // 관리자 영화리뷰 삭제
		int result = 0;
		PreparedStatement pstmt = null;
		String query = "DELETE FROM MOVIE_REVIEW WHERE REVIEW_NO = ? ";

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
		System.out.println("result : " + result);
		return result;
	}
	
	public int deleteMovieRecommend(Connection conn, int recommendNo) { // 관리자 영화추천글 삭제
		PreparedStatement pstmt = null;
		int result = 0;
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
}