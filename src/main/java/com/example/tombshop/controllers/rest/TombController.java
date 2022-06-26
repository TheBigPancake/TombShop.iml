package com.example.tombshop.controllers.rest;

import com.example.tombshop.DTO.tomb.req.TombModify;
import com.example.tombshop.DTO.tomb.resp.TombDTO;
import com.example.tombshop.services.tomb.services.ITombService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tombs")
@RequiredArgsConstructor
public class TombController {
    private final ITombService clientService;

    @GetMapping
    public ResponseEntity<List<TombDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(clientService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TombDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TombDTO> update(@PathVariable Integer id, @RequestBody TombModify entity) {
        entity.setTomb_id(id);
        return ResponseEntity.ok(clientService.update(entity));
    }

    @PostMapping
    public ResponseEntity<TombDTO> create(@RequestBody TombModify entity) {
        return ResponseEntity.ok(clientService.create(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
