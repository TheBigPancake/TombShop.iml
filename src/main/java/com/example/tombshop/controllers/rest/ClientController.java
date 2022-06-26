package com.example.tombshop.controllers.rest;

import com.example.tombshop.DTO.ClientDTO;
import com.example.tombshop.services.client.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<List<ClientDTO>> getAll(@RequestParam Integer page, @RequestParam Integer size) {
        return ResponseEntity.ok(clientService.getAll(page, size).getContent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientDTO> get(@PathVariable Integer id) {
        return ResponseEntity.ok(clientService.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @RequestBody ClientDTO entity) {
        entity.setId(id);
        return ResponseEntity.ok(clientService.update(entity));
    }

    @PostMapping
    public ResponseEntity<ClientDTO> create(@RequestBody ClientDTO entity) {
        return ResponseEntity.ok(clientService.create(entity));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        clientService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
