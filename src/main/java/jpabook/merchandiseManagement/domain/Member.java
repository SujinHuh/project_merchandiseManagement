package jpabook.merchandiseManagement.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
//@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userId;

    @Column(nullable = false, unique = true)
    private String name;

    private String password;

    @Column(nullable = false, unique = true)//@Valid
    private String position;

    public Member(String userId, String name, String password, String position) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.position = position;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //    @OneToMany(mappedBy = "member")
//    private List<Order> orders = new ArrayList<>();

}
