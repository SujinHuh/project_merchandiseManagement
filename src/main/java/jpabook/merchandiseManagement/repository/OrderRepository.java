package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    private void save(Order order) {
//        entityManager.persist(order);
//    }
//
//
}
