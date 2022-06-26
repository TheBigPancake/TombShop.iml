package com.example.tombshop.services.order.impls;

import com.example.tombshop.DTO.order.req.OrderModify;
import com.example.tombshop.DTO.order.resp.OrderDTO;
import com.example.tombshop.DTO.tomb.resp.TombDTO;
import com.example.tombshop.model.Client;
import com.example.tombshop.model.Order;
import com.example.tombshop.model.Tomb;
import com.example.tombshop.repository.ClientRepository;
import com.example.tombshop.repository.OrderRepository;
import com.example.tombshop.repository.TombRepository;
import com.example.tombshop.services.client.services.IClientService;
import com.example.tombshop.services.order.services.IOrderService;
import com.example.tombshop.services.tomb.services.ITombService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {
    private final OrderRepository repository;
    private final ClientRepository repository_c;
    private final TombRepository repository_t;
    private final IClientService clientService;
    private final ITombService tombService;

    @Override
    public Page<OrderDTO> getAll(Integer page, Integer size) {
        Page<Order> orders = repository.findAll(PageRequest.of(page, size));
        var dtos = orders.get().map(this::convertToDTO).collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    @Override
    public OrderDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public OrderDTO create(OrderModify entity) {
        return convertToDTO(repository.save(
                        Order.builder()
                                .order_id(entity.getOrder_id())
                                .client(repository_c.getById(entity.getClient_id()))
                                .t_price(entity.getT_price())
                                .address(entity.getAddress())
                                .date(entity.getDate())
                                .tombs(repository_t.getOrderTombs(entity.getOrder_id()))
                                .build()
                )
        );
    }

    @Override
    public OrderDTO update(OrderModify entity) {
        return convertToDTO(repository.save(
                        Order.builder()
                                .order_id(entity.getOrder_id())
                                .client(repository_c.getById(entity.getClient_id()))
                                .t_price(entity.getT_price())
                                .address(entity.getAddress())
                                .date(entity.getDate())
                                .tombs(repository_t.getOrderTombs(entity.getOrder_id()))
                                .build()
                )
        );
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public OrderDTO convertToDTO(Order entity) {
        List<TombDTO> tombs = new ArrayList<>();
        for (Tomb t:entity.getTombs()) {
            tombs.add(tombService.convertToDTO(t));
        }
        return OrderDTO.builder()
                .order_id(entity.getOrder_id())
                .client(clientService.convertToDTO(entity.getClient()))
                .t_price(entity.getT_price())
                .address(entity.getAddress())
                .date(entity.getDate())
                .tombs(tombs)
                .build();
    }
}
