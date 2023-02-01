package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //저장
    //null값을 반환할 수 있어 Optional에 감싸 반환한다.
    Optional<Member> findById(Long id);  //아이디찾기
    Optional<Member> findByName(String name); //이름찾기
    List<Member> findAll(); //모든회원리스트 찾기
}
