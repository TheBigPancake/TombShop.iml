package com.example.tombshop.services.log.impls;

import com.example.tombshop.DTO.LogDTO;
import com.example.tombshop.model.Client;
import com.example.tombshop.model.Log;
import com.example.tombshop.repository.LogRepository;
import com.example.tombshop.services.log.services.ILogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LogServiceImpl implements ILogService {
    private final LogRepository repository;
    @Override
    public Page<LogDTO> getAll(Integer page, Integer size) {
        Page<Log> logs = repository.findAll(PageRequest.of(page, size));
        var dtos = logs.get().map(this::convertToDTO).collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    @Override
    public LogDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public LogDTO create(LogDTO entity) {
        return convertToDTO(repository.save(
                Log.builder()
                        .log_id(entity.getLog_id())
                        .type(entity.getType())
                        .message(entity.getMessage())
                        .date(entity.getDate())
                        .build()
        ));
    }
    public LogDTO convertToDTO(Log entity) {
        return LogDTO.builder()
                .log_id(entity.getLog_id())
                .type(entity.getType())
                .message(entity.getMessage())
                .date(entity.getDate())
                .build();
    }
}
