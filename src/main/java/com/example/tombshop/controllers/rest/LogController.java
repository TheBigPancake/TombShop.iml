package com.example.tombshop.controllers.rest;

import com.example.tombshop.DTO.LogDTO;
import com.example.tombshop.services.log.services.ILogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/logs")
@RequiredArgsConstructor
public class LogController {
    private final ILogService logService;

    @GetMapping
    public ResponseEntity<List<LogDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(logService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LogDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(logService.get(id));
    }

    @PostMapping
    public ResponseEntity<LogDTO> create(@RequestBody LogDTO entity) {
        return ResponseEntity.ok(logService.create(entity));
    }
}
