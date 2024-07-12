package java.Bug.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "bugs")
public class Bug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "bugName", nullable = false)
    private String bugName;

    @Column(name = "priority", nullable = false, unique = true)
    private String priority;

    @Column(name = "bugDate", nullable = false)
    private String bugDate;

    @Column(name = "projectName", nullable = false)
    private String projectName;

    @Column(name = "bugType", nullable = false)
    private String bugType;

    @Column(name = "bugLevel", nullable = false)
    private String bugLevel;

    @Column(name = "assignToDeveloper", nullable = false)
    private String assignToDeveloper;

    @Column(name = "status", nullable = false)
    private String status;
}
