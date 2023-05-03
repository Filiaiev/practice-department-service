package com.practice.filiaiev.resource;

import com.practice.filiaiev.model.DepartmentEntity;
import com.practice.filiaiev.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentResourceMapper departmentMapper;

    @GetMapping("/{id}")
    public DepartmentRO getDepartment(@PathVariable Integer id) {
        return departmentMapper.mapDepartmentToDepartmentRO(departmentService.getDepartment(id));
    }

    @GetMapping
    public List<DepartmentRO> getDepartments(@RequestParam List<Integer> ids) {
        return departmentMapper.mapDepartmentsToDepartmentROs(departmentService.getDepartments(ids));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDepartment(@RequestBody DepartmentRO departmentRO) {
        DepartmentEntity departmentCreate = departmentMapper.mapDepartmentROToDepartment(departmentRO);
        departmentService.createDepartment(departmentCreate);
    }
}
