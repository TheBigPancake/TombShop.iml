package com.example.tombshop.services.order.services;

import com.example.tombshop.DTO.order.req.OrderModify;
import com.example.tombshop.DTO.order.resp.OrderDTO;
import org.springframework.data.domain.Page;

public interface IOrderService {
    Page<OrderDTO> getAll(Integer page, Integer size);

    OrderDTO get(Integer id);

    OrderDTO create(OrderModify entity);

    OrderDTO update(OrderModify entity);

    void delete(Integer id);
}
