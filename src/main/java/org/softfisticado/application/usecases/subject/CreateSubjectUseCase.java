package org.softfisticado.application.usecases.subject;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Subject;
import org.softfisticado.domain.repository.SubjectRepository;

@ApplicationScoped
public class CreateSubjectUseCase {
    @Inject
    SubjectRepository subjectRepository;
    public Uni<Subject> save(Subject subject) {
        return subjectRepository.save(subject);
    }
}
