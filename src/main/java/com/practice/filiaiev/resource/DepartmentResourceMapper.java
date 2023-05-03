package com.practice.filiaiev.resource;

import com.practice.filiaiev.model.DepartmentEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DepartmentResourceMapper {

    DepartmentRO mapDepartmentToDepartmentRO(DepartmentEntity department);

    List<DepartmentRO> mapDepartmentsToDepartmentROs(List<DepartmentEntity> departments);

    DepartmentEntity mapDepartmentROToDepartment(DepartmentRO departmentRO);

}
