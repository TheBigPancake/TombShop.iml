package com.example.tombshop.DTO.order.req;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderModify {
    private Integer order_id;
    private Integer client_id;
    private BigDecimal t_price;
    private String address;
    private LocalDateTime date;
    private List<Integer> tombs_id;
}
