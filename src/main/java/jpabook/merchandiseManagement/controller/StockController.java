package jpabook.merchandiseManagement.controller;

import jpabook.merchandiseManagement.domain.Stock;
import jpabook.merchandiseManagement.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class StockController {

    private final StockService stockService;

    @GetMapping("/stocks/new")
    public String createStockFrom(Model model){
        model.addAttribute("stockFrom", new StockFrom());
        return "stocks/createStockFrom";
    }

    @PostMapping("/stocks/new")
    public String create(@Valid StockFrom stockFrom, BindingResult result) {
         if(result.hasErrors()) {
             return "stocks/createStockFrom";
         }
        Stock stock = new Stock();
         stock.setName(stockFrom.getName());
         stock.setPrice(stockFrom.getPrice());
         stock.setStockQuantity(stockFrom.getStockQuantity());

         stockService.save(stock);

         return "redirect:/";
    }

    @GetMapping("/stocks")
    public String stockList(Model model) {
        List<Stock> stocks = stockService.findAll();
        model.addAttribute("stocks",stocks);
        return "stocks/stockList";
    }

    @GetMapping("/stocks/{stockId}/edit")
    public String updateStockFrom(Model model, @PathVariable("stockId") Long stockId) {

        Stock stock = stockService.findOne(stockId);

        StockFrom stockFrom = new StockFrom();
        stockFrom.setId(stock.getId());
        stockFrom.setName(stock.getName());
        stockFrom.setPrice(stock.getPrice());
        stockFrom.setStockQuantity(stock.getStockQuantity());

        model.addAttribute("form",stockFrom);
        return "stocks/updateStockFrom";
    }
    @PostMapping("/stocks/{stockId}/edit")
    public String updateStock(@PathVariable Long stockId, @ModelAttribute("form") StockFrom from) {

        stockService.updateStock(stockId,from.getName(),from.getPrice(),from.getStockQuantity());
        return "redirect:/stocks";
    }
}
