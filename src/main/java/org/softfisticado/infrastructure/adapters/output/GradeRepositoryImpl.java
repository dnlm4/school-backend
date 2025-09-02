package org.softfisticado.infrastructure.adapters.output;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Grade;
import org.softfisticado.domain.repository.GradeRepository;

@ApplicationScoped
public class GradeRepositoryImpl implements GradeRepository {
    @Inject
    PgPool pgPool;

    @Override
    public Uni<Grade> save(Grade grade){
        return pgPool.preparedQuery("")
                .execute(Tuple.of(grade.getName()))
                .onItem().transform(pgRow->{
                    Row row = pgRow.iterator().next();
                    grade.setId(row.getLong("id"));
                    return  grade;
                });
    }
}
