package org.softfisticado.domain.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "student_id",unique = true)
    private Integer studentId;
    @Column(name = "code",unique = true, nullable = false)
    private String code;
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @Column(name = "registration_date")
    private LocalDate registrationDate;
    private String gender;
    private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;
    private String address;
    private String status;
    @Column(name = "date_created")
    private LocalDate dateCreated;
    @Column(name = "date_modified")
    private LocalDate dateModified;
}
