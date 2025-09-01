package org.softfisticado.domain.model;

import lombok.*;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherSchedule {
    private Long id;
    private Integer subjectTeacherId;
    private Integer sectionId;
    private Time startTime;
    private Time endTime;
}
