package com.example.tombshop.DTO;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ClientDTO {
    private Integer id;
    private String full_name;
    private String phone;
    private String email;
}
