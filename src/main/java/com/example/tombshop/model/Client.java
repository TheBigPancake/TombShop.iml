package com.example.tombshop.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "clients")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(max = 70)
    private String full_name;
    @NotBlank
    @Size(max = 15)
    private String phone;
    @NotBlank
    @Size(max = 50)
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Order> orders = new ArrayList<>();
}
