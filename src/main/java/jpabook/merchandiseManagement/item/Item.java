package jpabook.merchandiseManagement.item;

import jpabook.merchandiseManagement.exection.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Item {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    private int price;

    private int stockQuantity;



    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    public void removeStock(int quantity) {

        int restStock = this.stockQuantity - quantity;

        if (restStock < 0) {
            throw new NotEnoughStockException("재고가 부족합니다.!!");
        }

        this.stockQuantity = restStock;
    }

    private void change(String name, int price, int stockQuantity) {

        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;

    }

}
