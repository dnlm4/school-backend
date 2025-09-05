package org.softfisticado.infrastructure.adapters.output.repository;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Grade;
import org.softfisticado.domain.repository.GradeRepository;
import org.softfisticado.infrastructure.shared.QuerySql;

@ApplicationScoped
public class GradeRepositoryImpl extends QuerySql<Grade> implements GradeRepository {
    @Inject
    PgPool pgPool;


    public Uni<Grade> save(Grade grade){
        String querySql=this.buildQuery(grade);
        return pgPool.preparedQuery(querySql)
                .execute(this.getAttributeValues())
//                .execute(Tuple.tuple())
                .onItem().transform(pgRow->{
                    Row row = pgRow.iterator().next();
                    grade.setId(row.getLong("id"));
                    return  grade;
                });
    }
}
