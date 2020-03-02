package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.Stock;
import jpabook.merchandiseManagement.repository.StockRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class StockServiceTest {

    @Autowired
    StockRepository stockRepository;

    @Autowired
    StockService stockService;

    @Test
    public void 상품입고() throws Exception {

        //given
        Stock stock = new Stock();
        stock.setName("빵야");
        stock.setPrice(95000);
        stock.setStockQuantity(10);

        //when
        stockService.save(stock);
        //then
        assertEquals(stock, stockRepository.findOne(1l));
    }

    @Test
    public void update() throws Exception {


        //given
        Stock stock = new Stock();
        stock.setName("빵야");
        stock.setPrice(95000);
        stock.setStockQuantity(10);

        //when
        stockService.save(stock);

        stockService.updateStock("잘하자",10,90);
        stockService.save(stock);

        //then


    }
}