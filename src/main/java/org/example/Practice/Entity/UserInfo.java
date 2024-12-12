package org.example.Practice.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = "user")
@Table(name = "user_info")
@Builder
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String address;
    @Column(name = "birthday")
    private LocalDate birthday;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_user")
    private User user;


//    public void setUser(User user) {
//        user.setUserInfo(this);
//        this.user = user;
//    }
}
