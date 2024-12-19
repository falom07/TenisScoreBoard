package org.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(of = "id")
@ToString(exclude = {"userChats","company"})

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String username;
//    @BatchSize(size = 2)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_company")
    private Company company;
//    @OneToOne(mappedBy = "user")
//    private UserInfo userInfo;

    @OneToMany(mappedBy = "user")
//    @Fetch(FetchMode.SUBSELECT)
    private List<UserChat> userChats = new ArrayList<>();

}
