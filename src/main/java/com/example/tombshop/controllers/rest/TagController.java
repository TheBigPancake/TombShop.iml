package com.example.tombshop.controllers.rest;

import com.example.tombshop.DTO.TagDTO;
import com.example.tombshop.services.tag.services.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tags")
@RequiredArgsConstructor
public class TagController {
    private final ITagService clientService;

    @GetMapping
    public ResponseEntity<List<TagDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(clientService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TagDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagDTO> update(@PathVariable Integer id, @RequestBody TagDTO entity) {
        entity.setTag_id(id);
        return ResponseEntity.ok(clientService.update(entity));
    }

    @PostMapping
    public ResponseEntity<TagDTO> create(@RequestBody TagDTO entity) {
        return ResponseEntity.ok(clientService.create(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
