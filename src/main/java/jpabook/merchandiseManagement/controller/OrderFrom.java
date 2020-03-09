package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.domain.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class OrderFrom {

    private Long id;

    private Member member;

    private LocalDateTime orderDate;

    private OrderStatus orderStatus;

}
