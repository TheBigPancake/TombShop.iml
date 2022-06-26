package com.example.tombshop.controllers.rest;

import com.example.tombshop.DTO.order.req.OrderModify;
import com.example.tombshop.DTO.order.resp.OrderDTO;
import com.example.tombshop.services.order.services.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(orderService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(orderService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderDTO> update(@PathVariable Integer id, @RequestBody OrderModify entity) {
        entity.setOrder_id(id);
        return ResponseEntity.ok(orderService.update(entity));
    }

    @PostMapping
    public ResponseEntity<OrderDTO> create(@RequestBody OrderModify entity) {
        return ResponseEntity.ok(orderService.create(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        orderService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
