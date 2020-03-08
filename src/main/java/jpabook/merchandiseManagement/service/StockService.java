package jpabook.merchandiseManagement.service;

import jpabook.merchandiseManagement.domain.Stock;
import jpabook.merchandiseManagement.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StockService {

    private final StockRepository stockRepository;

    /**
     * 1. 저장
     * 2. 전체 목록
     * 3. 물품 find
     */
    @Transactional
    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    @Transactional
    public void updateStock(Long stockId,String name, int price, int stockQuantity) {
        Stock findStock = stockRepository.findOne(stockId);

        findStock.setName(name);
        findStock.setPrice(price);
        findStock.setStockQuantity(stockQuantity);
    }

    public List<Stock> findAll() {
        return stockRepository.findAll();
    }

    public Stock findOne(Long stockId) {
        return stockRepository.findOne(stockId);
    }


}
