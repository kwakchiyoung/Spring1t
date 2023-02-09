package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository{

    private final EntityManager em; //(1) JPA는 EntityManager로 모든게 동작된다. //build.gradle로 JPA를 받았을경우 스프링부트가 자동으로 EntityManager를 생성해준다.

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member); //영구저장하다라는 뜻
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        //JPQL이라는 쿼리 언어이다. //객체 자체를 조회한다. Member객체의 alias m
        return em.createQuery("select m from Member m", Member.class).getResultList();

    }
}
