package book.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import book.model.dao.BookDAO;
import book.model.vo.BookInfo;
import book.model.vo.BookPageData;
import book.model.vo.BookReview;
import book.model.vo.BookShare;
import common.JDBCTemplate;
import show.model.dao.ShowDAO;


public class BookService {

	private JDBCTemplate factory;
	
	public BookService() {
		factory = JDBCTemplate.getConnection();
	}
	
	// BookInfo
	public ArrayList<BookInfo> printAllBookInfo() { // 책정보 목록
		Connection conn = null;
		ArrayList<BookInfo> list = null;
		try {
			conn = factory.createConnection();
			list = new BookDAO().selectAllBookInfo(conn); 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return list;
	}
	
	public BookInfo printOneBookInfo(int infoNo) { // 책정보 상세보기
		BookInfo info = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			info = new BookDAO().selectOneBookInfo(conn, infoNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return info;
	}
	public int modifyBookInfo(BookInfo bookInfo) { // 책정보 수정
		Connection conn = null;
		int result = 0;
		
		try {
			conn = factory.createConnection();
			result = new BookDAO().updateBookInfo(conn, bookInfo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public int registerBookInfo(BookInfo bookInfo) { //책정보 등록
		int result = 0;
		return result;
	}
	public int deleteBookInfo(int infoNo) { //책정보 삭제
		int result = 0;
		return result ;
	}

	// BookReview
	public BookPageData printAllBookReview(int currentPage) { // 책리뷰 목록 + 페이징
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
			pd.setReviewList(new BookDAO().selectAllBookReview(conn, currentPage));
			pd.setPageNavi(new BookDAO().getReviewPageNavi(conn, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	public BookReview printOneBookReview(int no) {//책리뷰 상세보기
		BookReview review = null;
		Connection conn = null;
		
		try {
			conn = factory.createConnection();
			review = new BookDAO().selectOneBookReview(conn, no);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return review;
	}
	public int registerBookReview(BookReview review) { //책리뷰 등록
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new BookDAO().insertBookReview(conn, review);
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
	public int modifyBookReview(BookReview review) { //책리뷰 수정
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().updateBookReview(conn, review);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public int deleteBookReview(int no) { //책리뷰 삭제
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().deleteBookReview(conn, no);
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
		return result ;
	}
	
	public BookPageData seachPrintAllBookReview(int currentPage, String search, String searchCategory) { // 책리뷰 검색결과
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	public int BookReviewHits(int reviewNo) {// 조회수 증가
		int result=0;
		return result;
	}
	// Review 좋아요
	public int checkLikesReview(int reviewNo, String userId) {
		int result =0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().checkLikesReview(conn, reviewNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public int plusLikesReview(String userId, int reviewNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().insertLikesReview(conn, reviewNo, userId);
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
	public int updateLikesCountReview(int reviewNo, String userId, String state) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new BookDAO().updateLikesReview(conn, reviewNo, userId, state);
			if(likes > 0) {
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
		return likes;
	}
	public int minusLikesReview(String userId, int reviewNo, String state) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new BookDAO().updateLikesReview(conn, reviewNo, userId, state);
			if(likes > 0) {
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
		return likes;
	}
	public int getLikesReview(String userId, int reviewNo) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new BookDAO().selectLikesReview(conn,userId,reviewNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return likes;
	}
	
	// BookShare
	public BookPageData printAllBookShare(int currentPage) {// 책나눔 목록 + 페이징
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
//		System.out.println("Service pd : " + pd);
		return pd;
	}
	
	public BookShare printOneBookShare(int shareNo) { // 책나눔 상세보기
		BookShare share = null;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			share = new BookDAO().selectOneBookShare(conn, shareNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return share;
	}
	public int registerBookShare(BookShare share) { // 책나눔 등록
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new BookDAO().insertBookShare(conn, share);
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
		System.out.println("Service result:" + result );
		
		return result;
	}
	
	public int modifyBookShare(BookShare share) { //책나눔 수정
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().updateBookShare(conn, share);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public int deleteBookShare(int shareNo) { // 책나눔 삭제
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().deleteBookShare(conn, shareNo);
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
		return result ;
	}
	
	public BookPageData searchPrintAllBookReview(int currentPage, String search, String searchCategory) { //책리뷰 검색결과 전체보기  
		Connection conn = null;
		BookPageData pd = new BookPageData();
		
		try {
			conn = factory.createConnection();
			pd.setReviewList(new BookDAO().selectSearchReviewList(conn, currentPage, searchCategory));
			pd.setPageNavi(new BookDAO().getSearchReviewPageNavi(conn, currentPage, search, searchCategory));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	public int addHitsCountShare(int shareNo) { // 조회수 증가
		int result = 0;
		return result;
	}
	
	// Share 좋아요
	public int checkLikesShare(int shareNo, String userId) {
		int result =0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().checkLikesShare(conn, shareNo, userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result;
	}
	public int plusLikesCountShare(int shareNo, String userId) { // 좋아요수 증가
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().insertLikesShare(conn, shareNo, userId);
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
	public int updateLikesCountShare(int shareNo, String userId, String state) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new BookDAO().updateLikesShare(conn, shareNo, userId, state);
			if(likes > 0) {
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
		return likes;
	}
	public int minusLikesCountShare(int shareNo, String userId, String state) { // 좋아요수 빼기
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new BookDAO().updateLikesShare(conn, shareNo, userId, state);
			if(likes > 0) {
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
		return likes;
	}
	public int getLikesShare(String userId, int shareNo) {
		int likes = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			likes = new BookDAO().selectLikesShare(conn,userId,shareNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return likes;
	}

	public int addHitsCount(int reviewNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new BookDAO().updateHitsReview(conn, reviewNo);
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

}
