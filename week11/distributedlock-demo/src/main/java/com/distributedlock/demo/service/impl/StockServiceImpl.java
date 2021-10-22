package com.distributedlock.demo.service.impl;

import com.distributedlock.demo.constants.Constans;
import com.distributedlock.demo.vo.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class StockServiceImpl {
    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * redis分布式锁 扣减库存
     * @param goodsId
     * @return
     */
    public ResponseVO reduceStock(String goodsId) {
        String key = "key:" + goodsId;
        String val = UUID.randomUUID().toString();
        ResponseVO response = null;
        try {
            Boolean flag = redisTemplate.opsForValue().setIfAbsent(key, val, 10, TimeUnit.SECONDS);
            if (!flag) {
                log.info("获取锁失败");
                return new ResponseVO(100, "获取锁失败", null);
            }
            //扣减库存
            Integer stock = Integer.valueOf(redisTemplate.boundValueOps(Constans.GOOD_STOCK_KEY).get());
            if (stock > 0) {
                Thread.sleep(10000);
                Long currStock = redisTemplate.boundValueOps(Constans.GOOD_STOCK_KEY).decrement();
                // 生成订单
                log.info("库存扣减成功，准备生成订单...");
                // 构建响应
                return new ResponseVO(200, "订单创建成功", null);
            } else {
                // 说明库存已经扣减完了。
                log.error("已经没有库存啦");
                return new ResponseVO(201, "无库存", null);
            }
        } catch (Exception e) {
            // 业务异常
            log.error("fail... " + e);
            return new ResponseVO(102, "网络异常", null);
        } finally {
            // 自己的锁自己解
            if (val.equalsIgnoreCase(redisTemplate.opsForValue().get(key))) {
                redisTemplate.delete(key);
                log.info("解锁成功");
            }
        }
    }
}
