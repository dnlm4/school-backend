package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.Student;

import java.util.List;

public interface StudentRepository {
    Uni<Student> save(Student student);
    /*Uni<Student> findByStudentId(Long studentId);
    Uni<List<Student>> findAll();
    Uni<Student> update(Student student);*/

}
