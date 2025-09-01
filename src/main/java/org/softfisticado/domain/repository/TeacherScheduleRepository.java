package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.Teacher;

import java.util.List;

public interface TeacherScheduleRepository {
    Uni<Teacher> save(Teacher teacher);
    Uni<Teacher> update(Teacher teacher);
    Uni<List<Teacher>> findAllByTeacherId(Long teacherId);
    Uni<List<Teacher>> findAll();

}
