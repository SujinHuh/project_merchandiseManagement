package jpabook.merchandiseManagement.domain;

import jpabook.merchandiseManagement.item.Item;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sun.security.x509.OIDMap;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter @Setter
@NoArgsConstructor
public class OrderItem {

    @Id @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int orderprice;

    private int count;

    public static OrderItem createOrderItem(Item item, int orderprice, int count) {
        OrderItem orderItem = new OrderItem();
        orderItem.setItem(item);
        orderItem.setOrderprice(orderprice);
        orderItem.setCount(count);

        item.removeStock(count);
        return orderItem;
    }
    public void cancel() {
        getItem().addStock(count);
    }
    public int getTotalPrice() {
        return getOrderprice() * getCount();
    }
}
