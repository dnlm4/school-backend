package org.softfisticado.infrastructure.adapters.input.rest.student.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentResponse {
    private Long id;
    private Integer studentId;
    private String code;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registrationDate;
    private String gender;
    private String email;
    private CityDTO city;
    private String address;
    private String status;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CityDTO {
        private Long id;
        private String name;
    }
}
