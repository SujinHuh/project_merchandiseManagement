package jpabook.merchandiseManagement.domain;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static lombok.AccessLevel.PROTECTED;

@Entity
@Setter @Getter
@ToString
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String email;

    private String name;

    private String position;

    private String password;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public void setPassword(String password) {
        this.password = password;
    }
}
