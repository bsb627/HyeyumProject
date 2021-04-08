package qna.model.service;

import java.sql.Connection;
import java.sql.SQLException;


import common.JDBCTemplate;
import qna.model.dao.QnaDAO;
import qna.model.vo.Qna;
import qna.model.vo.QnaPageData;
import show.model.dao.ShowDAO;

public class QnaService {

	private JDBCTemplate factory;
	
	public QnaService() {
		factory = new JDBCTemplate().getConnection();
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
	public Qna printOne(int qnaNo) {

		Connection conn = null;
		Qna qna = null;
		try {
			conn = factory.createConnection();
			qna = new QnaDAO().selectOne(conn, qnaNo);
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
	
	// 글삭제
	public int deleteQna(int qnaNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = factory.createConnection();
			result = new QnaDAO().deleteQna(conn, qnaNo);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
