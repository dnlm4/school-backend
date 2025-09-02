package org.softfisticado.domain.model;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "subject")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "subject_id",unique = true, nullable = false)
    private Integer subjectId;
    @Column(name = "code",unique = true, nullable = false)
    private String code;
    private String name;
    private String description;
}
