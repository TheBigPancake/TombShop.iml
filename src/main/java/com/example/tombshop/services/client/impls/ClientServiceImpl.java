package com.example.tombshop.services.client.impls;

import com.example.tombshop.DTO.ClientDTO;
import com.example.tombshop.model.Client;
import com.example.tombshop.model.Tag;
import com.example.tombshop.repository.ClientRepository;
import com.example.tombshop.services.client.services.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {
    private final ClientRepository repository;

    @Override
    public Page<ClientDTO> getAll(Integer page, Integer size) {
        Page<Client> clients = repository.findAll(PageRequest.of(page, size));
        var dtos = clients.get().map(this::convertToDTO).collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    @Override
    public ClientDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public ClientDTO create(ClientDTO entity) {
        return convertToDTO(repository.save(
                Client.builder()
                        .id(entity.getId())
                        .full_name(entity.getFull_name())
                        .phone(entity.getPhone())
                        .email(entity.getEmail())
                        .build()
        ));
    }

    @Override
    public ClientDTO update(ClientDTO entity) {
        return convertToDTO(repository.save(
                Client.builder()
                        .id(entity.getId())
                        .full_name(entity.getFull_name())
                        .phone(entity.getPhone())
                        .email(entity.getEmail())
                        .build()
        ));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public ClientDTO convertToDTO(Client entity) {
        return ClientDTO.builder()
                .id(entity.getId())
                .full_name(entity.getFull_name())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build();
    }
}
