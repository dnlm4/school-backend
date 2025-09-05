package org.softfisticado.infrastructure.adapters.input.rest.student;

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
import org.softfisticado.application.usecases.student.CreateStudentUseCase;
import org.softfisticado.domain.model.Student;
import org.softfisticado.infrastructure.adapters.input.rest.student.dto.StudentRequest;
import org.softfisticado.infrastructure.mappers.StudentMapper;

@Path("/student")
@Tag(name = "Student")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@NonBlocking
public class StudentController {
    @Inject
    CreateStudentUseCase createStudentUseCase;

    @Inject
    StudentMapper studentMapper;

    @POST
    public Uni<Response> save(StudentRequest request) {

        Student student = studentMapper.toStudent(request);

        return createStudentUseCase.save(student)
                .onItem()
                .transform(saved->Response
                        .status(Response.Status.CREATED)
                        .entity(saved)
                        .build());
    }

}
