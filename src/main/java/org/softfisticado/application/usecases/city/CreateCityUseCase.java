package org.softfisticado.application.usecases.city;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.City;
import org.softfisticado.domain.repository.CityRepository;

@ApplicationScoped
public class CreateCityUseCase {
    @Inject
    CityRepository  cityRepository;

    public Uni<City> save(City city) {
        return cityRepository.save(city);
    }

}
