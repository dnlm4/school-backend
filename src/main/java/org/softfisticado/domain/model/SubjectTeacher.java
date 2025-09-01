package org.softfisticado.domain.model;

import lombok.*;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectTeacher {
    private Long id;
    private String year;
    private String teacherId;
    private Integer gradeId;
    private Integer subjectId;
    private Date startDate;
    private Date endDate;
}
