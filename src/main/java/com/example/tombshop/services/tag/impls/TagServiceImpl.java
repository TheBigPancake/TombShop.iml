package com.example.tombshop.services.tag.impls;

import com.example.tombshop.DTO.TagDTO;
import com.example.tombshop.model.Tag;
import com.example.tombshop.repository.TagRepository;
import com.example.tombshop.services.tag.services.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements ITagService {
    private final TagRepository repository;

    @Override
    public Page<TagDTO> getAll(Integer page, Integer size) {
        Page<Tag> clients = repository.findAll(PageRequest.of(page, size));
        var dtos = clients.get().map(this::convertToDTO).collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    @Override
    public TagDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public TagDTO create(TagDTO entity) {
        return convertToDTO(repository.save(
                Tag.builder()
                        .tag_id(entity.getTag_id())
                        .name(entity.getName())
                        .build()
        ));
    }

    @Override
    public TagDTO update(TagDTO entity) {
        return convertToDTO(repository.save(
                Tag.builder()
                        .tag_id(entity.getTag_id())
                        .name(entity.getName())
                        .build()
        ));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public TagDTO convertToDTO(Tag entity) {
        return TagDTO.builder()
                .tag_id(entity.getTag_id())
                .name(entity.getName())
                .build();
    }
}
