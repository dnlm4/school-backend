package org.softfisticado.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "teacher")
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "teacher_id",unique = true, nullable = false)
    private String teacherId;
    @Column(name = "code",unique = true, nullable = false)
    private String code;
    private String name;
    @Column(name = "last_naame")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    private String specialty;
    private String email;
    private String address;
    @Column(name = "phone_number")
    private Integer phoneNumber;
    @Column(name = "admission_date")
    private LocalDate admissionDate;
    private String status;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(name = "date_modified")
    private LocalDate dateModified;
}
