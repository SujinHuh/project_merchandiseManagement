package jpabook.merchandiseManagement.domain;

import jpabook.merchandiseManagement.exception.NotEnoughStockException;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue
    @Column(name = "stock_id")
    private Long id;

    private String name;

    private int price;

    private int stockQuantity;

    // 재고 수량 증가
    public int increaseStockQuantity(int stockQuantity) {
        return this.stockQuantity += stockQuantity;
    }

    // 재고 수량 감소
    public int decreaseStockQuantity(int stockQuantity) {

        int restStock;

        restStock = this.stockQuantity - stockQuantity;

        if(restStock < 0) {
            throw  new NotEnoughStockException("재고 수량을 채워주세요");
        }
        return this.stockQuantity = restStock;
    }
    // 물품 수정
    private void changeStock (String name, int price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
}
