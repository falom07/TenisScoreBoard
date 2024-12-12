package org.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@NoArgsConstructor
@Builder
@Entity
@AllArgsConstructor
@Table(name = "company")
@ToString(exclude = "listUser")

public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "age")
    private Integer age;
    @Column(name ="name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "salary")
    private int salary;
    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE,orphanRemoval = true)
    private Set<User> listUser;
}
