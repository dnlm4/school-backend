package org.softfisticado.domain.model;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Student {
    private Long id;
    private String studentId;
    private String name;
    private String lastname;
    private LocalDate birthday;
    private String gender;
    private String email;
    private String address;
    private String status;
    private LocalDate dateCreated;
    private LocalDate dateModified;
}
