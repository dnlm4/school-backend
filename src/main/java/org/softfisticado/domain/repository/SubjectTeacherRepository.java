package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.SubjectTeacher;

import java.util.List;

public interface SubjectTeacherRepository {
    Uni<SubjectTeacher> save(SubjectTeacher subjectTeacher);
    Uni<SubjectTeacher> update(SubjectTeacher subjectTeacher);
    Uni<List<SubjectTeacher>> findAllByTeacherId(Long teacherId);
    Uni<List<SubjectTeacher>> findAll();

}
