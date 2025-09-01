package org.softfisticado.domain.model;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Subject {
    private Long id;
    private String name;
    private String description;
    private String teacherId;
    private String classroomId;
}
