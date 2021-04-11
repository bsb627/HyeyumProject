package show.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
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
		return null;
	}
	
	public ShowReview selectOneReview(Connection conn, int showNo) { // 관람후기 상세보기
		return null;
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
		return null;
	}
	
	public int totalReviewCount(Connection conn) { // 관람후기 총 게시글 수
		return 0;
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
	
	

	
}
