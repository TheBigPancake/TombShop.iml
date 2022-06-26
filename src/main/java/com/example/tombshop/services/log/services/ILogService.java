package com.example.tombshop.services.log.services;

import com.example.tombshop.DTO.LogDTO;
import org.springframework.data.domain.Page;

public interface ILogService {
    Page<LogDTO> getAll(Integer page, Integer size);

    LogDTO get(Integer id);

    LogDTO create(LogDTO entity);
}
