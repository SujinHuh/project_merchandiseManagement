package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Member;
import jpabook.merchandiseManagement.domain.Order;
import jpabook.merchandiseManagement.item.Item;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.swing.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderRepositoryTest {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MemberRepository memberRepository;

//    @Test
//    public void memberOderTest() throws Exception {
//        //given
//        Member member = createMember();
//
//        Item item = createItem();
//
//        Long saveId = memberRepository.save(member);
//        Member findMember = memberRepository.findOne(saveId);
//
//
//        //when
//
//        //then
//
//    }
//
//    private Member createMember() {
//        Member member = new Member();
//        member.setName("SujinJPA");
//        member.setPosition("사장");
//
//        entityManager.persist(member);
//        return member;
//    }
//    private Item createItem() {
//
//        Item item = new Item();
//        item.setName("JPA_BOOk");
//        item.setPrice(9000);
//        item.setStockQuantity(5);
//
//        entityManager.persist(item);
//        return item;
//    }
}
