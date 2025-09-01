package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.Teacher;

import java.util.List;

public interface TeacherRepository {
    Uni<Teacher> findById(Long teacherId);
    Uni<List<Teacher>> findAllByName(String name);
    Uni<List<Teacher>> findAll();
    Uni<Teacher> save(Teacher teacher);
    Uni<Teacher> update(Teacher teacher);

}
