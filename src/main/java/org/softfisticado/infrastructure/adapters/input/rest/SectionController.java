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
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.softfisticado.application.usecases.section.CreateSectionUseCase;
import org.softfisticado.domain.model.Section;

@Path("/section")
@Tag(name = "Section")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@NonBlocking
public class SectionController {
    @Inject
    CreateSectionUseCase createSectionUseCase;

    @POST
    public Uni<Response> createSection(Section section) {
        return createSectionUseCase.save(section)
                //.onItem().transform(saved -> Response.status(Response.Status.CREATED).entity(saved).build());
                .onItem()
                .transform(saved -> Response
                        .status(Response.Status.CREATED)
                        .entity(saved)
                        .build());
    }
}
