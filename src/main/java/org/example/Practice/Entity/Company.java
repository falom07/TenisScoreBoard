package org.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;
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
//    @Fetch(FetchMode.SUBSELECT)
    private List<User> listUser= new ArrayList<>();
}
