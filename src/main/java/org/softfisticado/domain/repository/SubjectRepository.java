package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.Subject;

import java.util.List;

public interface SubjectRepository {
    Uni<Subject> save(Subject subject);
    Uni<Subject> update(Subject subject);
    Uni<Subject> findById(Long id);
    Uni<List<Subject>> findAll();
}
