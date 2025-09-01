package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;

import java.util.List;

public interface ClassroomRepository {
    Uni<ClassroomRepository> save(ClassroomRepository classroomRepository);
    Uni<ClassroomRepository> update(ClassroomRepository classroomRepository);
    Uni<ClassroomRepository> findById(Long id);
    Uni<List<ClassroomRepository>> findAll();
}
