package com.distributedlock.demo.controller;

import com.distributedlock.demo.service.impl.StockServiceImpl;
import com.distributedlock.demo.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class StockController {

    @Resource
    private StockServiceImpl stockService;

    @GetMapping("/stock/reduce")
    public ResponseVO reduceStock(@RequestParam(value = "goodsId", required = false) String goodsId){
        return stockService.reduceStock(goodsId);
    }
}
