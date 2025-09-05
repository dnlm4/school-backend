package org.softfisticado.infrastructure.adapters.input.rest.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequest {
    private Integer studentId;
    private String code;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private String gender;
    private String email;
    private Long cityId;
    private String address;
    private String status;
}
