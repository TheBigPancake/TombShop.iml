package com.example.tombshop.services.client.services;

import com.example.tombshop.DTO.*;
import com.example.tombshop.model.Client;
import org.springframework.data.domain.Page;

public interface IClientService {
    Page<ClientDTO> getAll(Integer page, Integer size);

    ClientDTO get(Integer id);

    ClientDTO create(ClientDTO entity);

    ClientDTO update(ClientDTO entity);

    void delete(Integer id);

    ClientDTO convertToDTO(Client entity);
}
