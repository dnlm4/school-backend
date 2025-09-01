package org.softfisticado.application.usecases.grade;

import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Grade;
import org.softfisticado.domain.repository.GradeRepository;

public class CreateGradeUseCase {
    @Inject
    GradeRepository gradeRepository;

    public Uni<Grade> save(Grade grade) {
        return gradeRepository.save(grade);
    }

}
