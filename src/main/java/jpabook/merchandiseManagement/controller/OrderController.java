package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.domain.Order;
import jpabook.merchandiseManagement.domain.OrderSearch;
import jpabook.merchandiseManagement.domain.Stock;
import jpabook.merchandiseManagement.repository.OrderRepository;
import jpabook.merchandiseManagement.service.MemberService;
import jpabook.merchandiseManagement.service.OrderService;
import jpabook.merchandiseManagement.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final StockService stockService;


    @GetMapping("/order")
    public String createOrderForm(Model model) {
        List<Member> members = memberService.memberList();
        List<Stock> stocks = stockService.findAll();

        model.addAttribute("members", members);
        model.addAttribute("stocks", stocks);

        return "order/orderFrom";
    }

    @PostMapping("/order")
    public String orders(@RequestParam("memberId") Long memberId,
                         @RequestParam("stockId") Long stockId,
                         @RequestParam("count") int count){

        orderService.order(memberId,stockId,count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {

        List<Order> orders = orderService.findOrders(orderSearch);
        model.addAttribute("orders",orders);

        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancel")
    public String cancelOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancelOrder(orderId);
        return "redirect:/orders";
    }
}
