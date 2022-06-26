package com.example.tombshop.controllers.rest;

import com.example.tombshop.DTO.MasterDTO;
import com.example.tombshop.services.master.services.IMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/masters")
@RequiredArgsConstructor
public class MasterController {
    private final IMasterService masterService;

    @GetMapping
    public ResponseEntity<List<MasterDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(masterService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MasterDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(masterService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MasterDTO> update(@PathVariable Integer id, @RequestBody MasterDTO entity) {
        entity.setMaster_id(id);
        return ResponseEntity.ok(masterService.update(entity));
    }

    @PostMapping
    public ResponseEntity<MasterDTO> create(@RequestBody MasterDTO entity) {
        return ResponseEntity.ok(masterService.create(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        masterService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
