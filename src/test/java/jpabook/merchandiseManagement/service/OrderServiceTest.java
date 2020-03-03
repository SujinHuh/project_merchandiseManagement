package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.*;
import jpabook.merchandiseManagement.exception.NotEnoughStockException;
import jpabook.merchandiseManagement.repository.OrderRepository;
import jpabook.merchandiseManagement.repository.StockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.StoreType;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class OrderServiceTest {

    @Autowired
    EntityManager entityManager;
    @Autowired
    OrderService orderService;

    @Autowired
    OrderRepository orderRepository;


    /**
     * 1. 물품 주문 -> 성공
     * 2. 주문 취소 -> 성공
     * 3. 물 수량 초과시  오류 발생
     */

    @Test
    public void stockOrder() throws Exception {

        //given
        Member member = new Member();
        member.setEmail("sujin@name");
        member.setName("수진");
        member.setPosition("사");
        entityManager.persist(member);

        Stock stock = createStock("수진 JPA", 10000, 10);

        int count = 2;
        //when
        Long orderId = orderService.order(member.getId(), stock.getId(), count);

        Order getOrder = orderRepository.findOne(orderId);

        //then
        assertEquals("물품 주문시 ORDER", OrderStatus.ORDER, getOrder.getOrderStatus());
        assertEquals("주문 수량이 같아야 한다.", 1, getOrder.getOrderStocks().size());
        assertEquals("값 곱 수량 정확해야 한다.", 10000 * count, getOrder.getTotalPrice());
        assertEquals("주문시 수량이 감소 ", 8, stock.getStockQuantity());

    }

    private Stock createStock(String name, int price, int stockQuantity) {
        Stock stock = new Stock();
        stock.setName(name);
        stock.setPrice(price);
        stock.setStockQuantity(stockQuantity);

        entityManager.persist(stock);
        return stock;
    }

    @Test
    public void 주문취소() throws Exception {

        //given
        Member member = new Member();
        member.setEmail("sujin@name");
        member.setName("수진");
        member.setPosition("사장");
        entityManager.persist(member);

        Stock stock = createStock("springDataJPA", 5000, 5);
        //when
        Long stockId = orderService.order(member.getId(), stock.getId(), 3);
        orderService.cancelOrder(stockId);

        //then
        Order getOrder = orderRepository.findOne(stockId);

        assertEquals("주문 취소 상태는 취소상태", OrderStatus.CANCEL, getOrder.getOrderStatus());
        assertEquals("재고 복귀", stock.getStockQuantity(), 5);
    }

    //상품 수량 초과 test
    @Test(expected = NotEnoughStockException.class)
    public void 상품초과() throws Exception {
        //given
        Member member = new Member();
        member.setEmail("sujin@name");
        member.setName("수진");
        member.setPosition("사장");
        entityManager.persist(member);
        Stock stock = createStock("springDataJPA", 5000, 5);
        //when
        Long stockId = orderService.order(member.getId(), stock.getId(), 6);
        //then
        fail("제고 수량 부족 예외가 발생해야 한다.");
    }
}