package com.example.tombshop.services.tag.services;

import com.example.tombshop.DTO.TagDTO;
import com.example.tombshop.model.Tag;
import org.springframework.data.domain.Page;

public interface ITagService {
    Page<TagDTO> getAll(Integer page, Integer size);

    TagDTO get(Integer id);

    TagDTO create(TagDTO entity);

    TagDTO update(TagDTO entity);

    void delete(Integer id);

    TagDTO convertToDTO(Tag entity);
}
