package org.example.Service;

import org.example.DAO.MatchDAO;
import org.example.DTO.MatchScore;
import org.example.Entity.Match;
import org.example.Entity.Player;
import org.example.Util.MapMatches;

import java.util.UUID;

public class ManageMatchService {
    private final MatchDAO matchDAO = MatchDAO.getInstance();
    private final MatchService matchService = MatchService.getInstance();
    private static volatile ManageMatchService instance;

    private ManageMatchService() {}

    public static ManageMatchService getInstance() {
        if (instance == null) {
            synchronized (ManageMatchService.class) {
                if (instance == null) {
                    instance = new ManageMatchService();
                }
            }
        }
        return instance;
    }


    public String calculateScore(UUID uuid,String playerWin){
            MatchScoreCalculateService.calculateScore(MapMatches.matchMap.get(uuid),playerWin);

            if(MapMatches.matchMap.get(uuid).getWinner() != null){
                String nameWinner = MapMatches.matchMap.get(uuid).getWinner();
                matchService.updateMatch(uuid);
                return nameWinner;
            }
            return "";
    }




}
