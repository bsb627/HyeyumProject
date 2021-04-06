package question.model.vo;

import board.model.vo.Board;

public class Question extends Board { // 1:1 문의
	
	private String qnaPassword; // 비밀번호
	private String category; // 분류
	
	public Question() {
		// TODO Auto-generated constructor stub
	}
}
