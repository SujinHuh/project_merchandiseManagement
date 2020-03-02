package jpabook.merchandiseManagement.repository;

import jpabook.merchandiseManagement.domain.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StockRepository {

    private final EntityManager entityManager;

    /**
     * save, findAll, findOne
     */

    //save - id가 있으면 신규 persist , id가 없으면 merge 를 실행
    public void save(Stock stock) {
        if (stock.getId() == null) {
            entityManager.persist(stock);
        } else {
            entityManager.merge(stock);
        }
    }

    // findAll
    public List<Stock> findAll() {
        return entityManager.createQuery("select s from Stock s", Stock.class)
                .getResultList();
    }

    // findOne
    public Stock findOne(Long stockId) {
        return entityManager.find(Stock.class, stockId);
    }
}
