package com.mjhome.example.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.mjhome.example.models.Order;

import java.util.List;
import java.util.Map;

/**
 * @author minjian
 */
@Mapper
public interface OrderMapper {

    void insertOne(Order order);
    void delete(Long id);
    void update(Order order);
    List<Map<String, Object>> query(Map<String, Object> condition);
}
