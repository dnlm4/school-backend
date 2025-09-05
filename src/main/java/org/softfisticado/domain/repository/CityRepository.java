package org.softfisticado.domain.repository;

import io.smallrye.mutiny.Uni;
import org.softfisticado.domain.model.City;


public interface CityRepository {
    Uni<City> save(City city);
}
