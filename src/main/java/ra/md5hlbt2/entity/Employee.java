package ra.md5hlbt2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String address;
    private String phone;
    private boolean status;
    @ManyToOne(fetch = FetchType.LAZY)
    // bên nhiều nên để LAZY
    @JoinColumn(name = "department_id")  // name of the foreign key column in the employee table
    private Department department;
}
