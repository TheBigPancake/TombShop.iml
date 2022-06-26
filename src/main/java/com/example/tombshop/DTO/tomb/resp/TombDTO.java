package com.example.tombshop.DTO.tomb.resp;
import com.example.tombshop.DTO.MasterDTO;
import com.example.tombshop.DTO.TagDTO;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TombDTO {
    private Integer tomb_id;
    private String name;
    private BigDecimal price;
    private List<TagDTO> tags;
    private List<MasterDTO> masters;
}
