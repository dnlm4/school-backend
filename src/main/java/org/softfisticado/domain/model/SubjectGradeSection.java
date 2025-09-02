package org.softfisticado.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "subject_grade_section")
public class SubjectGradeSection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @ManyToOne
    @JoinColumn(name = "subject_grade")
    private SubjectGrade subjectGrade;
    @ManyToOne
    @JoinColumn(name = "section_id")
    private Section section;
    @Column(name = "academic_year",length = 5,nullable = false)
    private String academicYear;



}
