package org.softfisticado.infrastructure.adapters.output.repository;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Subject;
import org.softfisticado.domain.repository.SubjectRepository;
import org.softfisticado.infrastructure.shared.QuerySql;

@ApplicationScoped
public class SubjectRepositoryImpl extends QuerySql<Subject> implements SubjectRepository {

    @Inject
    PgPool pgPool;

    @Override
    public Uni<Subject> save(Subject subject){
        String attributeData=this.buildQuery(subject);
        /*Object paramData = attributeData.get(1);


        if (!(paramData instanceof List<?> rawValues)) {
            throw new IllegalStateException("Los parameters no son una list: " + paramData);
        }

        Tuple valuesTuple = Tuple.tuple();
        for (Object val : rawValues) {
            valuesTuple.addValue(val);
        }
        List<Object> listValuesObject = (List<Object>) attributeData.get(1);
        Tuple testTuple = Tuple.tuple();
        for (Object val : listValuesObject) {
            testTuple.addValue(val);
        }
        */
        return pgPool.preparedQuery(attributeData)
                .execute(this.getAttributeValues())
                .onItem().transform(pgRow->{
                    Row row = pgRow.iterator().next();
                    subject.setId(row.getLong("id"));
                    return subject;
                });
    }
}