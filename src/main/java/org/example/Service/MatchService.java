package org.example.Service;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.DAO.MatchDAO;
import org.example.DAO.PlayerDAO;
import org.example.DTO.MatchPlayer;
import org.example.DTO.MatchScore;
import org.example.Entity.Match;
import org.example.Entity.Player;
import org.example.Util.HibernateUtil;
import org.example.Util.MapMatches;
import org.hibernate.Session;

import java.util.UUID;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatchService {
    private final MatchDAO matchDAO = MatchDAO.getInstance();

    private static final PlayerDAO playerDAO = PlayerDAO.getInstance();
    private static volatile MatchService instance;

    public static MatchService getInstance() {
        if (instance == null) {
            synchronized (MatchService.class) {
                if (instance == null) {
                    instance = new MatchService();
                }
            }
        }
        return instance;
    }

    public UUID createNewMatch(MatchScore matchScore) {

            Player player1 = playerDAO.add(Player.builder().name(matchScore.getPlayers().get(0).getPlayerName()).build());
            Player player2 = playerDAO.add(Player.builder().name(matchScore.getPlayers().get(1).getPlayerName()).build());
            Match match = Match.builder()
                    .player1(player1)
                    .player2(player2)
                    .build();

            matchDAO.add(match);
            matchScore.setIdMatch(match.getId());
            matchScore.getPlayers().get(0).setId(player1.getId());
            matchScore.getPlayers().get(1).setId(player2.getId());

            UUID uuid = UUID.randomUUID();
            MapMatches.matchMap.put(uuid, matchScore);
            return uuid;

    }

    public void updateMatch(UUID uuid) {
        MatchScore matchScore = MapMatches.matchMap.get(uuid);
        MatchPlayer matchPlayer1 = matchScore.getPlayers().get(0);
        MatchPlayer matchPlayer2 = matchScore.getPlayers().get(1);

        Player winner = Player.builder().id(matchScore.getWinnerId()).build();
        Player player1 = Player.builder()
                .id(matchPlayer1.getId())
                .build();
        Player player2 = Player.builder()
                .id(matchPlayer2.getId())
                .build();

        Match match = Match.builder()
                .id(matchScore.getIdMatch())
                .player1(player1)
                .player2(player2)
                .winner(winner)
                .build();

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            matchDAO.update(match);
        }


        MapMatches.matchMap.remove(uuid);
    }
}

