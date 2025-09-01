package org.softfisticado.infrastructure.adapters.output;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Section;
import org.softfisticado.domain.repository.SectionRepository;

@ApplicationScoped
public class SectionRepositoryImpl implements SectionRepository {
    @Inject
    PgPool pgPool;

    @Override
    public Uni<Section> save(Section section) {

        System.out.println("****************zzzz******************************************************");
        System.out.println(section);
        System.out.println("**********************************************************************");
        return pgPool.preparedQuery("INSERT INTO section (id,name) VALUES ($1,$2) RETURNING id")
                .execute(Tuple.of(section.getName()))
                .onItem().transform(pgRow -> {
                    Row row = pgRow.iterator().next();
                    section.setId(row.getLong("id"));
                    return section;
                });
    }

}
