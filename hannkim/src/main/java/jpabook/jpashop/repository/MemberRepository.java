package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MemberRepository {
  // spring이 entity manager 만들어서 주입
  @PersistenceContext
  private EntityManager em;

//  public Long save(Member member) {
//    em.persist(member);
//    return member.getId();
//  }

  public Member find(Long id) {
    return em.find(Member.class, id);
  }

  public void save(Member member) {
    em.persist(member);
  }

  public Member findOne(Long id) {
    return em.find(Member.class, id);
  }

  public List<Member> findAll() {
    // qlString != SQL
    // sql 은 table 대상, qlString(JQL)은 entity 대상
    return em.createQuery("select m from Member m", Member.class)
        .getResultList();
  }

  public List<Member> findByName(String name) {
    return em.createQuery("select m from Member m where m.name = :name", Member.class)
        .setParameter("name", name)
        .getResultList();
  }
}
