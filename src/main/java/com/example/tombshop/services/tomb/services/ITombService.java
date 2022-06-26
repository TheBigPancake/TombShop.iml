package com.example.tombshop.services.tomb.services;

import com.example.tombshop.DTO.tomb.req.TombModify;
import com.example.tombshop.DTO.tomb.resp.TombDTO;
import com.example.tombshop.model.Tomb;
import org.springframework.data.domain.Page;

public interface ITombService {
    Page<TombDTO> getAll(Integer page, Integer size);

    TombDTO get(Integer id);

    TombDTO create(TombModify entity);

    TombDTO update(TombModify entity);

    void delete(Integer id);

    TombDTO convertToDTO(Tomb entity);
}
