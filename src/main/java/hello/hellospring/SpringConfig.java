package hello.hellospring;
import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
//import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
//    private final DataSource dataSource;
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    } (1)JPA에서는 이걸 지우고

    //(2)JPA는 EntityManager로 모든게 동작된다. //build.gradle로 JPA를 받았을경우 스프링부트가 자동으로 EntityManager를 생성해준다.
//    EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    //(3) 2번도 지우고
    private final MemberRepository memberRepository;

    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository); //(4)memberRepository() 에서 ()지운다.
    } //(5)이렇게하면 스프링 컨테이너에서 memberRepository를 찾는다. 근데 등록한게 없다.
      // 다만 SpringDataJpaMemberRepository인터페이스를 만들고 extend로 스프링의 JpaRepositry를 상속받으면
    
    /* (6) 위에 SpringDataJAP가 알아서 빈까지 등록해준다 했으니 주석처리
    @Bean
    public MemberRepository memberRepository() {
        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        //return new JdbcTemplateMemberRepository(dataSource);
        //return new JpaMemberRepository(em);
    }
    */


}