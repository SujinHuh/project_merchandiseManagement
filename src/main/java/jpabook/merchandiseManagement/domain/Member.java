package jpabook.merchandiseManagement.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private String password;

    @Column(nullable = false, unique = true)//@Valid
    private String position;

//    @OneToMany(mappedBy = "member")
//    private List<Order> orders = new ArrayList<>();
}
