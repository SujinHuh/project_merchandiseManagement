package jpabook.merchandiseManagement.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String position;

    // 미정
//    private String password;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();


}
