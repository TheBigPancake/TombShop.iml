package com.example.tombshop.DTO;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MasterDTO {
    private Integer master_id;
    private String full_name;
    private String phone;
    private String email;
}
