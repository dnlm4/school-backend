package org.softfisticado.infrastructure.adapters.output.repository;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Row;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.City;
import org.softfisticado.domain.repository.CityRepository;
import org.softfisticado.infrastructure.shared.QuerySql;

@ApplicationScoped
public class CityRepositoryImpl extends QuerySql<City> implements CityRepository {
    @Inject
    PgPool pgPool;

    public Uni<City> save(City city) {
        String sqlQuery = this.buildQuery(city);
        return pgPool.preparedQuery(sqlQuery)
                .execute(this.getAttributeValues())
                .onItem().transform(pgRow-> {
                    Row row = pgRow.iterator().next();
                    city.setId(row.getLong("id"));
                    return city;
                });
    }
}
