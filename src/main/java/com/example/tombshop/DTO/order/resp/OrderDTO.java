package com.example.tombshop.DTO.order.resp;

import com.example.tombshop.DTO.ClientDTO;
import com.example.tombshop.DTO.tomb.resp.TombDTO;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderDTO {
    private Integer order_id;
    private ClientDTO client;
    private BigDecimal t_price;
    private String address;
    private LocalDateTime date;
    private List<TombDTO> tombs;
}
