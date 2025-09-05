package org.softfisticado.application.usecases.student;

import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.softfisticado.domain.model.Student;
import org.softfisticado.domain.repository.StudentRepository;

@ApplicationScoped
public class CreateStudentUseCase {
    @Inject
    StudentRepository studentRepository;

    public Uni<Student> save(Student student) {
        return studentRepository.save(student);
    }
}
