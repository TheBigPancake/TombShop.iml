package com.example.tombshop.services.master.services;

import com.example.tombshop.DTO.MasterDTO;
import com.example.tombshop.model.Master;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IMasterService {
    Page<MasterDTO> getAll(Integer page, Integer size);

    MasterDTO get(Integer id);

    MasterDTO create(MasterDTO entity);

    MasterDTO update(MasterDTO entity);

    void delete(Integer id);

    MasterDTO convertToDTO(Master entity);
}
