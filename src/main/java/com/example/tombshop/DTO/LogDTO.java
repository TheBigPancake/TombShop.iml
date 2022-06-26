package com.example.tombshop.DTO;

import com.example.tombshop.model.LogTypes;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LogDTO {
    private Integer log_id;
    private LogTypes type;
    private String message;
    private LocalDateTime date;
}
