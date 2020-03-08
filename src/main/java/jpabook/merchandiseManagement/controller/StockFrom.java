package jpabook.merchandiseManagement.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Setter
@Getter
public class StockFrom {

    private Long id;

    @NotEmpty(message = "재고명 꼭 기재 부탁드립니다.!!")
    private String name;

    private int price;

    private int stockQuantity;


}
