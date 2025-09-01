package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.Section;

import java.util.List;

public interface SectionRepository {
    Uni<Section> save(Section section);
    //Uni<List<Section>> findAll();
}
