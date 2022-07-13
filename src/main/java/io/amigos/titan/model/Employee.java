package io.amigos.titan.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "salary")
    private double salary;

    @Column(name = "doj")
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime doj;

    @Column(name = "active")
    private boolean active;

    public Employee() {}

    public Employee(String name, double salary, LocalDateTime doj, boolean active) {
        this.name = name;
        this.salary = salary;
        this.doj = doj;
        this.active = active;
    }
}
