package org.example.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@Builder
@Table(name = "players")
//@ToString(exclude = {"listOfMatchesFor1Player","listOfMatchesFor2Player","listOfMatchesWinner"})
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false,name = "player_name",length = 20)
    private String name;

    @OneToMany(mappedBy = "player1", fetch = FetchType.LAZY)
    List<Match> listOfMatchesFor1Player;
    @OneToMany(mappedBy = "player2", fetch = FetchType.LAZY)
    List<Match> listOfMatchesFor2Player;
    @OneToMany(mappedBy = "winner", fetch = FetchType.LAZY)
    List<Match> listOfMatchesWinner;
}
