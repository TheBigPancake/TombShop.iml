package com.example.tombshop.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tombs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tomb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tomb_id;

    @NotBlank
    @Size(max = 20)
    private String name;
    private BigDecimal price;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tomb_tags",
            joinColumns = @JoinColumn(name = "tomb_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private List<Tag> tags = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tomb_masters",
            joinColumns = @JoinColumn(name = "tomb_id"),
            inverseJoinColumns = @JoinColumn(name = "master_id"))
    private List<Master> masters = new ArrayList<>();

    @ManyToMany(mappedBy = "tombs")
    private List<Order> orders = new ArrayList<>();
}
