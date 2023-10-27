package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)   // 조회시 최적화 위함
public class MemberService {
//  @Autowired    // field injection
  private final MemberRepository memberRepository;

//  @Autowired    // constructor injection -> Auto
  public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  /**
   * 회원 가입
   * @param member
   * @return member id
   */
  @Transactional
  public Long join(Member member) {
    validateDuplicatedMember(member);   // 중복 회원 검증
    memberRepository.save(member);
    return member.getId();
  }

  private void validateDuplicatedMember(Member member) {
    List<Member> findMembers = memberRepository.findByName(member.getName());
    if (!findMembers.isEmpty()) {
      throw new IllegalStateException("이미 존재하는 회원입니다");
    }
  }

  // 회원 전체 조회
  public List<Member> findMembers() {
    return memberRepository.findAll();
  }

  public Member findOne(Long memberId) {
    return memberRepository.findOne(memberId);
  }
}
