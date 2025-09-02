package org.softfisticado.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "subject_grade_section_id")
    private SubjectGradeSection subjectGradeSection;
    private Time startTime;
    private Time endTime;
}
