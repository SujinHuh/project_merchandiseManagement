package jpabook.merchandiseManagement.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
public class Stock {

    @Id @GeneratedValue
    @Column(name = "stock_id")
    private Long id;

    private String name;

    private Long price;

    private int stockQuantity;


}
