package org.softfisticado.infrastructure.adapters.output.repository;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.Tuple;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Student;
import org.softfisticado.domain.repository.StudentRepository;
import org.softfisticado.infrastructure.shared.QuerySql;

@ApplicationScoped
public class StudentRepositoryImpl extends QuerySql<Student> implements StudentRepository {
    @Inject
    PgPool pgPool;

    public Uni<Student> save(Student student) {
        String querySql=this.buildQuery(student);
        System.out.println(querySql);
        return pgPool.preparedQuery(querySql)
                .execute(this.getAttributeValues())
                .onItem().transform(pgRow -> {
                    Row row = pgRow.iterator().next();
                    student.setId(row.getLong("id"));
                    return student;
                });
    }
}
