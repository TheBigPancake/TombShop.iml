package com.example.tombshop.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity(name = "logs")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer log_id;
    @Enumerated(EnumType.STRING)
    private LogTypes type;
    @NotBlank
    @Size(max = 255)
    private String message;
    private LocalDateTime date;

}
