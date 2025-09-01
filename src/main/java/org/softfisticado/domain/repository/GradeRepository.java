package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.Grade;

import java.util.List;

public interface GradeRepository {
    Uni<Grade> save(Grade grade);
    //Uni<List<Grade>> findAll();
}
