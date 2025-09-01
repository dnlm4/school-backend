package org.softfisticado.domain.model;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classroom {
    private Long id;
    private String classroomId;
    private String name;
    private Integer gradeId;
    private Integer sectionId;
}
