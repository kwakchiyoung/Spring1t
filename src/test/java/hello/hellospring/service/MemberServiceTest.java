package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    //메인/서비스에서 만들어진 소스를 한글로 변경한다 테스트 코드라 배포하는것도 아니고 상관이 없다.(1)

    MemberService memberService; //(2)
    MemoryMemberRepository memberRepository;

    //(8)
    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    //(7)
    @AfterEach  //@Test메소드들이 메소드들이 실행이 끝날때마다 실행시켜주는 기능
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");
        //when
        long saveId=memberService.join(member);
        //than
        Member findMember = memberService.findOne(saveId).get();//(3)오른쪽 값만 입력하고 cnt+art+v를 누르면 반환타입과 변수가 자동들어감
        assertThat(member.getName()).isEqualTo(findMember.getName());//(4) Assertions에 art+enter를 쳐서 아래를 클릭하여 static import생성 그러면 바로 메소드를 사용하수있음.
    }

    @Test //(5) 테스트케이스 추가 사실상 중복체크를 해서 예외가 잘 터지는지가 더 중요하므로 그것도 테스트해줘야함.
    public void 중복회원예회(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");
        //when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        //(6)전체 주석 cnt+shif+/
       /* try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.z");
        }*/



        //than dd

    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}
//루카 피시에서 추가ㅋㅋ