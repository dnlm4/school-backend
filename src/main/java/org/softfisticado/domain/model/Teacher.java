package org.softfisticado.domain.model;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Teacher {
    private Long id;
    private String teacherId;
    private String name;
    private String lastname;
    private LocalDate birthday;
    private String specialty;
    private String email;
    private String address;
    private Integer phone_number;
    private LocalDate admission_date;
    private String status;
    private LocalDate date_created;
    private LocalDate date_modified;
}
