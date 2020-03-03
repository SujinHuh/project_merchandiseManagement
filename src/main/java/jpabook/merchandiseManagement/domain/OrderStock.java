package jpabook.merchandiseManagement.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Setter
@Getter
public class OrderStock {

    @Id
    @GeneratedValue
    @Column(name = "order_stock_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "stock_id")
    private Stock stock;

    private int orderPrice;

    private int count;// 주문 수량

    //생성 메서드
    public static OrderStock createOrderStock(Stock stock, int orderPrice, int count) {

        OrderStock orderStock = new OrderStock();
        orderStock.setStock(stock);
        orderStock.setOrderPrice(orderPrice);
        orderStock.setCount(count);

        stock.decreaseStockQuantity(count);
        return orderStock;
    }

    public void cancel() {
        getStock().increaseStockQuantity(count);
    }

    public int getTotalPrice() {
        return getOrderPrice() * getCount();
    }

}
