package qna.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import common.JDBCTemplate;
import javafx.scene.control.Alert;
import qna.model.dao.QnaDAO;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;
import show.model.dao.ShowDAO;

public class QnaService {

	private JDBCTemplate factory;
	
	public QnaService() {
		factory = JDBCTemplate.getConnection();
	}
	
	// 전체출력 
	public QnaPageData printAllQna(int currentPage) {
		Connection conn = null;
		QnaPageData pd = new QnaPageData();		
		try {		
			conn = factory.createConnection();
			pd.setQnaList(new QnaDAO().selectAllList(conn, currentPage));
			pd.setPageNavi(new QnaDAO().getPageNavi(conn, currentPage));		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return pd;
	}
	
	// 하나출력
	public Qna printOne(int qnaNo, String qnaPass ) {
		Connection conn = null;
		Qna qna = null;
		try {
			conn = factory.createConnection();
			qna = new QnaDAO().selectOne(conn, qnaNo, qnaPass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qna;
	}
	
	// 질문 등록
	public int registerQuestion(Qna qna) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().insertQuestion(conn, qna);
			if(result > 0) {
				JDBCTemplate.commit(conn);
				
			} else {
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
	// 답변 등록
	public int registerAnswer(Qna qna) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().insertAnswer(conn, qna);
			if(result > 0) {
				JDBCTemplate.commit(conn);
			} else {
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
	
	// 글삭제 : 답글 있을 경우 다 삭제
	public int deleteQna(int family) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().deleteQna(conn, family);
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
	

	
	// 글수정
	public int modifyQna(Qna qna) {
		
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().updateQna(conn, qna);
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
	
	// 글검색
	public QnaPageData printSearchList(String search, String searchCategory, int currentPage) {
		Connection conn = null;
		QnaPageData pd = new QnaPageData();
		try {
			conn = factory.createConnection();
			pd.setQnaList(new QnaDAO().selectSearchList(conn, search, searchCategory, currentPage));
			pd.setPageNavi(new QnaDAO().getSearchPageNavi(conn, search, searchCategory, currentPage));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return pd;
		
	}
	
	//조회수
	public int addHitsCount(int qnaNo) { // 조회수 증가
		int result = 0;
		Connection conn = null;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().updateHitsQna(conn, qnaNo);
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

	///////////////////////////관리자///////////////////////////////////
	public ArrayList<Qna> printAllQnaAdmin() {
		Connection conn = null;
		ArrayList<Qna> qnaList = null;
		
		try {
			conn = factory.createConnection();
			qnaList = new QnaDAO().selectAllQna(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JDBCTemplate.close(conn);
		}
		
		return qnaList;
	}

	public Qna printOneAdmin(int qnaNo, int family) {
		Connection conn = null;
		Qna qna = null;
		try {
			conn = factory.createConnection();
			qna = new QnaDAO().selectOneAdmin(conn, qnaNo, family);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qna;

	}
	
	
	public int deleteQnaAdmin(String qnaNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().deleteQnaAdmin(conn, qnaNo);
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

	public int modifyQnaAdmin(Qna qna) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().updateQnaAdmin(conn, qna);
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

	public Qna printParentAdmin(int family) {
		Connection conn = null;
		Qna qna = null;
		try {
			conn = factory.createConnection();
			qna = new QnaDAO().printParentAdmin(conn, family);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(conn);
		}
		return qna;
	}
	
}
