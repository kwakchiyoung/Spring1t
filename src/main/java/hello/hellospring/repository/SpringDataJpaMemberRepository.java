package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//(1)인터페이스가 인터페이스를 받을때는 extends를 쓴다. 인터페이스는 다중상속이 가능하다.
//(2) extends JpaRepository를 해놓으면 SpringDataJPA가 인터페이스에대한 구현체를 지가 알아서 구현한다. 그리고 스프링빈에 등록한다.
public interface SpringDataJpaMemberRepository extends JpaRepository <Member,Long> , MemberRepository {
    @Override
    Optional<Member> findByName(String name);
}
