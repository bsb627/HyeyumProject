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

	//받은 메시지 전체 출력
//	public MyPostPageData printAllList(int currentPage, String userId) {
//		Connection conn = null;
//		MyPostPageData pd = new MyPostPageData();
//		try {
//			conn = factory.createConnection();
//			pd.setMyPList(new MyPostDAO().selectAllList(conn, currentPage, userId));
//			pd.setPageNavi(new MessageDAO().getPageNaviRe(conn, currentPage, userId));
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(conn);
//		}
//		return pd;
//	}
	// BookReview
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
	
	// 메시지 하나 출력
	public Message printOne(int messageNo, String table) {
		Connection conn = null;
		Message message = null;
		try {
			conn = factory.createConnection();
			message = new MessageDAO().selectOne(conn, messageNo, table);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return message;
	}
	
	
	// 보낸 메시지 테이블에 메시지 보내기
	public int sendMessage(Message message) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MessageDAO().insertMessage(conn, message);
			if( result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
		
	}
	
	//받은 메시지 테이블에 보내기
	public int sendMessage2(Message message) {
		Connection conn = null;
		int result2 = 0;
		try {
			conn = factory.createConnection();
			result2 = new MessageDAO().insertMessage2(conn, message);
			if( result2 > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result2;
		
	}
	
	
	

	// 메시지 전송 취소 - 보낸 메시지함 삭제
	public int cancelMessage(int messageNo) {

		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MessageDAO().deleteMessage(conn, messageNo);
			if( result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 메시지 전송 취소 - 받은 메시지함 삭제
	public int cancelMessage2(int messageNo) {

		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new MessageDAO().deleteMessage2(conn, messageNo);
			if( result > 0 ) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	// 받은  메시지   검색 
	public MsgPageData printSearchList( String searchCategory, String search,int currentPage, String userId) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectSearchList(conn,   searchCategory, search, currentPage, userId));
			pd.setPageNavi(new MessageDAO().getSearchPageNavi(conn,  searchCategory, search, currentPage, userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
		
	}
	// 보낸 메시지   검색 
	public MsgPageData printSearchListSent( String searchCategory, String search,int currentPage, String userId) {
		Connection conn = null;
		MsgPageData pd = new MsgPageData();
		
		try {
			conn = factory.createConnection();
			pd.setMsgList(new MessageDAO().selectSearchListSent(conn,   searchCategory, search, currentPage, userId));
			pd.setPageNavi(new MessageDAO().getSearchPageNaviSent(conn,  searchCategory, search, currentPage, userId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
		
	}
	
	// 보낸메시지 테이블 읽음여부 변경
	public int updateReadState(int messageNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new MessageDAO().updateReadState(conn, messageNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
		
	}
	
	//받은 메시지 테이블 읽음으로 변경 
	public int updateReadState2(int messageNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new MessageDAO().updateReadState2(conn, messageNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
		
	}
	
	
	public int deleteMessages(String msgNo, String table) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new MessageDAO().deleteMessages(conn, msgNo, table);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	
	
	
	
	
	
//	public int deleteMessages(String msgNo) {
//		Connection conn = null;
//		int result = 0;
//		try {
//			conn = factory.createConnection();
//			result = new MessageDAO().deleteMessages(conn, msgNo);
//			if(result > 0) {
//				JDBCTemplate.commit(conn);
//			} else {
//				JDBCTemplate.rollback(conn);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally {
//			JDBCTemplate.close(conn);
//		}
//		return result;
//	}

	

}
