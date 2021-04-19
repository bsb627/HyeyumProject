package notice.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import notice.model.dao.NoticeDAO;
import notice.model.vo.Notice;
import notice.model.vo.NoticePageData;
import qna.model.dao.QnaDAO;
import show.model.dao.ShowDAO;


public class NoticeService {
	
	private JDBCTemplate factory;
	
	public NoticeService() {
		factory = JDBCTemplate.getConnection();
	}

	// 전체 출력
	public NoticePageData printAllList(int currentPage) {
		Connection conn = null; // ?
	//	ArrayList<Notice> nList = null; // ?
	//	String pageNavi = null;
		NoticePageData pd = new NoticePageData();
		System.out.println("서비스 들어왔니?");
		
		try {
			conn = factory.createConnection();
			pd.setNoticeList(new NoticeDAO().selectAllList(conn, currentPage));
			// 전체 리스트를 다 받아와서 pd에 있는 노티스리스트에 저장
			pd.setPageNavi(new NoticeDAO().getPageNavi(conn, currentPage));
			// DAO 에서 getpageNavi 메소드에서 그 리스트 전체를 몇개씩 잘라서 보여줄지
			// 세팅해서 화면단 밑에 보여질 pageNavi를 service로 리턴해준다.
		System.out.println("서비스 pd" + pd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd; 
	
	}
	

	// 하나만 출력
	public Notice printOne(int noticeNo) {
		Connection conn = null;
		Notice notice = null;
		try {
			conn = factory.createConnection();
			notice = new NoticeDAO().selectOne(conn, noticeNo);
			System.out.println(notice.toString());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return notice;
	}

	// 조회수
	public int noticeAddHitsCount(int noticeNo) { // 조회수 증가
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new NoticeDAO().noticeHits(conn, noticeNo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	// 검색
	
	
	
	public NoticePageData printSearchNoticeList(String search, String searchCategory, int currentPage) {
		Connection conn = null;
		NoticePageData pd = new NoticePageData();
		try {
			conn = factory.createConnection();
			pd.setNoticeList(new NoticeDAO().selectSearchNoticeList(conn, search, searchCategory, currentPage));
			pd.setPageNavi(new NoticeDAO().getSearchNoticePageNavi(conn, search, searchCategory, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	

	// 관리자!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// 등록
	public int registerNotice(Notice notice) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDAO().insertNotice(conn, notice);
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

	// 삭제
	
	public int deleteNotice(int noticeNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDAO().deleteNotice(conn, noticeNo);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			}else {
				JDBCTemplate.rollback(conn);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return result; 
	}

	// 수정
	
	public int modifyNotice(Notice notice) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new NoticeDAO().updateNotice(conn, notice);
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

	// 조회
	public int updateHits(int noticeNo) {
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new NoticeDAO().updateHitsNotice(conn, noticeNo);
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


	








