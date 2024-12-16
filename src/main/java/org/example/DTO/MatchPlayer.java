package org.example.DTO;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class MatchPlayer {
    private Long id;
    private String playerName;
    private String points;
    private String games;
    private String sets;


    public MatchPlayer(String playerName) {
        this.playerName = playerName;
        points = "0";
        games = "0";
        sets = "0";
    }
}
