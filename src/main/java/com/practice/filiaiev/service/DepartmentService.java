package com.practice.filiaiev.service;

import com.practice.filiaiev.model.DepartmentEntity;
import com.practice.filiaiev.repository.DepartmentRepository;
import com.practice.filiaiev.resource.DepartmentRO;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    public DepartmentEntity getDepartment(Integer id) {
        return repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    public List<DepartmentEntity> getDepartments(List<Integer> ids) {
        return repository.findAllById(ids);
    }

    public void createDepartment(DepartmentEntity department) {
        repository.save(department);
    }
}
