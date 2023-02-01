package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {
    //서비스단을 다 작성 후 CNT+SHIFT+T 하면 서비스단을 테스트할 수 있다.
    private final MemberRepository memberRepository;
    //private final MemberRepository memberRepository=new MemberRepository; 이걸지우고 위로 바꾸고 밑에꺼처음 생성자생성
    //(마지막)

    //이것이 핵심이다!! 이것이 DI(디팬져시인젝션) //서비스 기준 외부에서넣어주므로
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원 가입
     */
    public long join(Member member){
        //같은 이름의 회원이 있으면 안된다.
        /*
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {                                   //ifPresent는 Optional함수로 값이 있으면 안에값을 실행해준다.
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
        위 코드를 아래처럼 보기쉽게 다시 정리한다면*/
        /*
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("");
        });
         */
        //위코드를 아래처럼 줄여서 정리한다. //리펙토링 단축키는 con+shif+art+T
        validation(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId(); //아이디값만 반환한다.
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMember() {
        return memberRepository.findAll();
    }
     /* 1명 회원 조회 */
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }


    private void validation(Member member) {
        memberRepository.findByName(member.getName())     .
                ifPresent(m -> {                                   //ifPresent는 Optional함수로 값이 있으면 안에값을 실행해준다.
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
}
