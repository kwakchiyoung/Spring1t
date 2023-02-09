package hello.hellospring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //(1) JPA사용하려면 @Entity어노테이션 달기 =이제부터 이것은 JPA가 관리하는 엔티티라고 표현한다.
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //(2) IDENTITY란 PK에서 시퀀스처럼 자동으로 생성되는것을 말함.
    private long id;
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
