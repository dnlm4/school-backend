package org.softfisticado.application.usecases.section;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Section;
import org.softfisticado.domain.repository.SectionRepository;

@ApplicationScoped
public class CreateSectionUseCase {
    @Inject
    SectionRepository sectionRepository;

    public Uni<Section> save(Section section) {
        return sectionRepository.save(section);
    }
}
