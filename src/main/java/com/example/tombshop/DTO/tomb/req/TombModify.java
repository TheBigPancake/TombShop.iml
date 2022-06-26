package com.example.tombshop.DTO.tomb.req;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TombModify {
    private Integer tomb_id;
    private String name;
    private BigDecimal price;
    private List<Integer> tags;
    private List<Integer> masters;
}
