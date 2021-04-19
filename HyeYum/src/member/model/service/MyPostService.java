package member.model.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.jsp.tagext.PageData;

import book.model.dao.BookDAO;
import book.model.vo.BookPageData;
import common.JDBCTemplate;
import member.model.dao.MyPostDAO;
import member.model.vo.MyPostPageData;
import message.model.dao.MessageDAO;
import message.model.vo.Message;
import message.model.vo.MsgPageData;
import movie.model.dao.MovieDAO;
import movie.model.vo.MoviePageData;
import movie.model.vo.MovieReview;
import show.model.dao.ShowDAO;
import show.model.vo.ShowPageData;

public class MyPostService {

	private JDBCTemplate factory;
	
	public MyPostService() {
		factory = JDBCTemplate.getConnection();
	}
	public MyPostPageData printAll(int currentPage, String userId) {
		Connection conn = null;
		MyPostPageData pd = new MyPostPageData();
		try {
			conn = factory.createConnection();
			pd.setMyPList(new MyPostDAO().selectAll(conn, currentPage,userId));
			pd.setPageNavi(new MyPostDAO().getPageNavi(conn, currentPage,userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return null;
	}
	public BookPageData printAllBookReview(int currentPage, String userId) {
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
			pd.setReviewList(new MyPostDAO().selectAllBookReview(conn, currentPage,userId));
			pd.setPageNavi(new BookDAO().getReviewPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	// BookShare
	public BookPageData printAllBookShare(int currentPage, String userId) {
		Connection conn = null;
		BookPageData pd = new BookPageData();
		try {
			conn = factory.createConnection();
			pd.setShareList(new BookDAO().selectAllBookShare(conn, currentPage));
			pd.setPageNavi(new BookDAO().getSharePageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	// MovieReview
	public MoviePageData printAllMovieReviewList(int currentPage, String userId) {
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		try {
			conn = factory.createConnection();
			mpd.setReviewList(new MyPostDAO().selectAllMovieReview(conn, currentPage, userId));
			mpd.setPageNavi(new MovieDAO().getMovieReviewPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}
	// MovieRecommend
	public MoviePageData printAllMovieRecommend(int currentPage, String userId) {
		Connection conn = null;
		MoviePageData mpd = new MoviePageData();
		try {
			conn = factory.createConnection();
			mpd.setRecommendList(new MyPostDAO().selectAllMovieRecommend(conn, currentPage, userId));
			mpd.setPageNavi(new MovieDAO().getMovieReviewPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return mpd;
	}
	
	// showReview
	public ShowPageData printAllShowReview(int currentPage, String userId) { // 내가 쓴 글 보기
		Connection conn = null;
		ShowPageData pd = new ShowPageData();
		try {
			conn = factory.createConnection();
			pd.setReviewList(new MyPostDAO().selectAllReviewList(conn, currentPage, userId));
			pd.setPageNavi(new ShowDAO().getReviewPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	


}
