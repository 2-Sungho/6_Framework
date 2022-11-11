package edu.kh.project.member.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.kh.project.member.model.vo.Member;

@Repository // DB 연결 객체+bean 등록
public class AjaxDAO {
	
	@Autowired // 같은 자료형이 bean으로 등록되어 있으면 자동으로 DI
	private SqlSessionTemplate sqlSession;
	// SqlSessionTemplate : 커넥션+마이바티스+스프링 TX 제어

	/** 이메일 중복 검사 DAO
	 * @param memberEmail
	 * @return 
	 */
	public int emailDupCheck(String memberEmail) {
		return sqlSession.selectOne("ajaxMapper.emailDupCheck",memberEmail);
	}

	/** 닉네임 중복 검사 DAO
	 * @param memberNickname
	 * @return
	 */
	public int nicknameDupCheck(String memberNickname) {
		return sqlSession.selectOne("ajaxMapper.nicknameDupCheck", memberNickname);
	}

	/** 이메일로 회원정보 조회 DAO
	 * @param email
	 * @return member
	 */
	public Member selctEmail(String email) {
		return sqlSession.selectOne("ajaxMapper.selectEmail", email);
	}

	/** 회원 목록 조회 DAO
	 * @return List<Member>
	 */
	public List<Member> selectMemberList() {
		// selectList() :
		// 조회결과의 각 행을 resultType 또는 resultMap에 맞는
		// VO객체를 List에 담아 반환
		return sqlSession.selectList("ajaxMapper.selectMemberList");
	}
	

}
