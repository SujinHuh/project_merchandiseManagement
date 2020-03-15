package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.*;
import jpabook.merchandiseManagement.repository.MemberRepository;
import jpabook.merchandiseManagement.repository.OrderRepository;
import jpabook.merchandiseManagement.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderService {

    private final MemberRepository memberRepository;
    private final StockRepository stockRepository;
    private final OrderRepository orderRepository;

    /**
     * 주문
     */

    @Transactional
    public Long order(Long memberId, Long stockId, int count) {

        Member member = memberRepository.findMemberOne(memberId);
        Stock stock = stockRepository.findOne(stockId);
        /**
         *  여러개 상품 주문.. 생각
         */
        // 주문 상품 생성 -
        OrderStock orderStock = OrderStock.createOrderStock(stock, stock.getPrice(), count);

        //주문 생성
        Order order = Order.createOrder(member, orderStock);
        //주문 저장
        orderRepository.save(order);

        return order.getId();
    }

    // 주문 취소

    @Transactional
    public void cancelOrder(Long stockId) {

        Order order = orderRepository.findOne(stockId);

        order.cancel();
    }


    public List<Order> findOrders(OrderSearch orderSearch) {
       return orderRepository.findAllByCriteria(orderSearch);
    }


}
