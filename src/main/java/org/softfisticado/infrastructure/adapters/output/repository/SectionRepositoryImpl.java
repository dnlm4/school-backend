package org.softfisticado.infrastructure.adapters.output.repository;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Section;
import org.softfisticado.domain.repository.SectionRepository;
import org.softfisticado.infrastructure.shared.QuerySql;

@ApplicationScoped
public class SectionRepositoryImpl extends QuerySql<Section> implements SectionRepository {
    @Inject
    PgPool pgPool;

    @Override
    public Uni<Section> save(Section section) {
        String querySql=this.buildQuery(section);
        //"INSERT INTO school.section (name) VALUES ($1) RETURNING id"
        return pgPool.preparedQuery(querySql)
                .execute(this.getAttributeValues())
                //.execute(Tuple.tuple(this.getAttributesValueInTuple(attributeData.get(1))))
                .onItem().transform(pgRow -> {
                    Row row = pgRow.iterator().next();
                    section.setId(row.getLong("id"));
                    return section;
                });
    }

}
