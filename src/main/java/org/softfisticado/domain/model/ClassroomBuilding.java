package org.softfisticado.domain.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "classroom_building")
public class ClassroomBuilding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "classroom_id",unique = true,nullable = false)
    private String classroomId;
    @Column(name="code",unique = true,nullable = false)
    private String code;
    private String name;


}
