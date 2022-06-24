package com.example.tombshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "masters")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int master_id;
    @NotBlank
    @Size(max = 70)
    private String full_name;
    @NotBlank
    @Size(max = 15)
    private String phone;
    @NotBlank
    @Size(max = 50)
    private String email;

    @ManyToMany(mappedBy = "masters")
    private List<Tomb> tombs;
}
