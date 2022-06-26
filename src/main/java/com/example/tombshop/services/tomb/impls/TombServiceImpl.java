package com.example.tombshop.services.tomb.impls;

import com.example.tombshop.DTO.MasterDTO;
import com.example.tombshop.DTO.TagDTO;
import com.example.tombshop.DTO.tomb.req.TombModify;
import com.example.tombshop.DTO.tomb.resp.TombDTO;
import com.example.tombshop.model.Master;
import com.example.tombshop.model.Tag;
import com.example.tombshop.model.Tomb;
import com.example.tombshop.repository.MasterRepository;
import com.example.tombshop.repository.TagRepository;
import com.example.tombshop.repository.TombRepository;
import com.example.tombshop.services.master.services.IMasterService;
import com.example.tombshop.services.tag.services.ITagService;
import com.example.tombshop.services.tomb.services.ITombService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TombServiceImpl implements ITombService {
    private final TombRepository repository;
    private final MasterRepository repository_m;
    private final TagRepository repository_t;
    private final IMasterService masterService;
    private final ITagService tagService;

    @Override
    public Page<TombDTO> getAll(Integer page, Integer size) {
        Page<Tomb> tombs = repository.findAll(PageRequest.of(page, size));
        var dtos = tombs.get().map(this::convertToDTO).collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    @Override
    public TombDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public TombDTO create(TombModify entity) {
        return convertToDTO(repository.save(
                Tomb.builder()
                        .tomb_id(entity.getTomb_id())
                        .name(entity.getName())
                        .price(entity.getPrice())
                        .tags(repository_t.getTombTags(entity.getTomb_id()))
                        .masters(repository_m.getTombMasters(entity.getTomb_id()))
                        .build()
        ));
    }

    @Override
    public TombDTO update(TombModify entity) {
        return convertToDTO(repository.save(
                Tomb.builder()
                        .tomb_id(entity.getTomb_id())
                        .name(entity.getName())
                        .price(entity.getPrice())
                        .tags(repository_t.getTombTags(entity.getTomb_id()))
                        .masters(repository_m.getTombMasters(entity.getTomb_id()))
                        .build()
        ));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public TombDTO convertToDTO(Tomb entity) {
        List<TagDTO> tags = new ArrayList<>();
        for (Tag t:entity.getTags()) {
            tags.add(tagService.convertToDTO(t));
        }
        List<MasterDTO> masters = new ArrayList<>();
        for (Master t:entity.getMasters()) {
            masters.add(masterService.convertToDTO(t));
        }
        return TombDTO.builder()
                .tomb_id(entity.getTomb_id())
                .name(entity.getName())
                .price(entity.getPrice())
                .tags(tags)
                .masters(masters)
                .build();
    }
}
