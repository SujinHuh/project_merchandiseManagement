package jpabook.merchandiseManagement.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.FetchType.LAZY;

@Entity(name = "orders")
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderStock> orderStocks = new ArrayList<>();

    private LocalDateTime orderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    //연관관계 메서드 ===
    public void setMember(Member member) {
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderStock(OrderStock orderStock) {
        orderStocks.add(orderStock);
        orderStock.setOrder(this);
    }
    // 생성자
    public static Order createOrder(Member member, OrderStock... orderStocks) {

        Order order = new Order();
        order.setMember(member);

        for (OrderStock orderStock : orderStocks) {
            order.addOrderStock(orderStock);
        }

        order.setOrderStatus(OrderStatus.ORDER);
        order.setOrderDate(LocalDateTime.now());
        return order;
    }

    public void cancel() {
        this.setOrderStatus(OrderStatus.CANCEL);
        for (OrderStock orderStock : this.orderStocks) {
            orderStock.cancel();
        }
    }

    public int getTotalPrice() {

        int totalPrice = 0;

        for(OrderStock orderStock : orderStocks) {
            totalPrice += orderStock.getTotalPrice();
        }
        return totalPrice;
    }
}
