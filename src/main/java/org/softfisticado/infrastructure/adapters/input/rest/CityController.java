package org.softfisticado.infrastructure.adapters.input.rest;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.softfisticado.application.usecases.city.CreateCityUseCase;
import org.softfisticado.domain.model.City;

@Path("/city")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@NonBlocking
public class CityController {

    @Inject
    CreateCityUseCase createCityUseCase;

    @POST
    public Uni<Response> save(City city) {
        return createCityUseCase.save(city)
                .onItem()
                .transform(saved->Response
                        .status(Response.Status.CREATED)
                        .entity(saved)
                        .build());
    }

}
