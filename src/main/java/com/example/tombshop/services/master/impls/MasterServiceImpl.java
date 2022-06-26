package com.example.tombshop.services.master.impls;

import com.example.tombshop.DTO.MasterDTO;
import com.example.tombshop.model.Log;
import com.example.tombshop.model.Master;
import com.example.tombshop.repository.MasterRepository;
import com.example.tombshop.services.master.services.IMasterService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MasterServiceImpl implements IMasterService {
    private final MasterRepository repository;

    @Override
    public Page<MasterDTO> getAll(Integer page, Integer size) {
        Page<Master> clients = repository.findAll(PageRequest.of(page, size));
        var dtos = clients.get().map(this::convertToDTO).collect(Collectors.toList());
        return new PageImpl<>(dtos);
    }

    @Override
    public MasterDTO get(Integer id) {
        return convertToDTO(repository.getById(id));
    }

    @Override
    public MasterDTO create(MasterDTO entity) {
        return convertToDTO(repository.save(
                Master.builder()
                        .master_id(entity.getMaster_id())
                        .full_name(entity.getFull_name())
                        .phone(entity.getPhone())
                        .email(entity.getEmail())
                        .build()
        ));
    }

    @Override
    public MasterDTO update(MasterDTO entity) {
        return convertToDTO(repository.save(
                Master.builder()
                        .master_id(entity.getMaster_id())
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
    public MasterDTO convertToDTO(Master entity) {
        return MasterDTO.builder()
                .master_id(entity.getMaster_id())
                .full_name(entity.getFull_name())
                .phone(entity.getPhone())
                .email(entity.getEmail())
                .build();
    }
}
