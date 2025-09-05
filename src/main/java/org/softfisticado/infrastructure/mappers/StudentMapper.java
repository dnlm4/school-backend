package org.softfisticado.infrastructure.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.softfisticado.domain.model.Student;
import org.softfisticado.infrastructure.adapters.input.rest.student.dto.StudentRequest;
import org.softfisticado.infrastructure.adapters.input.rest.student.dto.StudentResponse;

@Mapper(componentModel = "cdi")
public interface StudentMapper {
    @Mapping(target = "city.id", source = "cityId")
    Student toStudent(StudentRequest studentDTO);

    @Mapping(target = "city.id", source = "city.id")
    @Mapping(target = "city.name", source = "city.name")
    StudentResponse toStudentResponse(Student student);
}
