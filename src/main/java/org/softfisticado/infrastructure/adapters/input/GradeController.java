package org.softfisticado.infrastructure.adapters.input;

import io.smallrye.common.annotation.NonBlocking;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.softfisticado.application.usecases.grade.CreateGradeUseCase;
import org.softfisticado.domain.model.Grade;

@Path("/grade")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@NonBlocking
public class GradeController {
    @Inject
    CreateGradeUseCase createGradeUseCase;

    @POST
    public Uni<Response> createGrade(Grade grade) {
        return createGradeUseCase.save(grade)
                .onItem().transform(saved -> Response.status(Response.Status.CREATED).entity(saved).build());
    }

}
