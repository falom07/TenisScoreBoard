package org.example.Service;

import org.example.DTO.MatchPlayer;
import org.example.DTO.MatchScore;

public class MatchScoreCalculateService {
    private MatchScoreCalculateService() {}
    public static void calculateScore(MatchScore matchScore, String playersPoint) {
        int plNum = takePlayerNumber(playersPoint);
        MatchPlayer matchPlayerWinPoint = matchScore.getPlayers().get(plNum);
        MatchPlayer matchPlayerLosePoint;

        if(plNum == 1){
            matchPlayerLosePoint = matchScore.getPlayers().get(0);
        }else{
            matchPlayerLosePoint = matchScore.getPlayers().get(1);
        }


        if(matchPlayerWinPoint.getGames().equals("6") && matchPlayerLosePoint.getGames().equals("6")){
            calculatePointsTiebreaker(matchPlayerWinPoint,matchPlayerLosePoint,matchScore);
        }else {
            calculatePoints(matchPlayerWinPoint, matchPlayerLosePoint,matchScore);
        }
    }

    private static void calculatePointsTiebreaker(MatchPlayer matchPlayerWinPoint, MatchPlayer matchPlayerLosePoint,MatchScore matchScore) {
        switch (matchPlayerWinPoint.getPoints()) {
            case "0" -> matchPlayerWinPoint.setPoints("1");
            case "1" -> matchPlayerWinPoint.setPoints("2");
            case "2" -> matchPlayerWinPoint.setPoints("3");
            case "3" -> matchPlayerWinPoint.setPoints("4");
            case "4" -> matchPlayerWinPoint.setPoints("5");
            case "5" -> matchPlayerWinPoint.setPoints("6");
            case "6" -> {
                String losePoints = matchPlayerLosePoint.getPoints();
                if(losePoints.equals("6") || losePoints.equals("7")){
                    matchPlayerWinPoint.setPoints("7");
                }else {
                    matchPlayerWinPoint.setGames("0");
                    matchPlayerLosePoint.setGames("0");
                    matchPlayerWinPoint.setPoints("0");
                    matchPlayerLosePoint.setPoints("0");
                    getCalculateGameSets(matchPlayerWinPoint,matchScore);
                }
            }default -> {
                int playerWinScore = Integer.parseInt(matchPlayerWinPoint.getPoints());
                int playerLoseScore = Integer.parseInt(matchPlayerLosePoint.getPoints());
                if((playerWinScore - 1) !=  playerLoseScore){
                    matchPlayerWinPoint.setPoints(String.valueOf(playerWinScore + 1));
                }else{
                    matchPlayerWinPoint.setGames("0");
                    matchPlayerLosePoint.setGames("0");
                    matchPlayerWinPoint.setPoints("0");
                    matchPlayerLosePoint.setPoints("0");
                    getCalculateGameSets(matchPlayerWinPoint,matchScore);
                }
            }
        }
    }

    private static void calculatePoints(MatchPlayer matchPlayerWinPoint, MatchPlayer matchPlayerLosePoint,MatchScore matchScore) {
        switch (matchPlayerWinPoint.getPoints()) {
            case "0" -> matchPlayerWinPoint.setPoints("15");
            case "15" -> matchPlayerWinPoint.setPoints("30");
            case "30" -> matchPlayerWinPoint.setPoints("40");
            case "40" -> {
                if (matchPlayerLosePoint.getPoints().equals("40")) {
                    matchPlayerWinPoint.setPoints("AD");
                    matchPlayerLosePoint.setPoints("40");
                } else if(matchPlayerLosePoint.getPoints().equals("AD")) {
                    matchPlayerWinPoint.setPoints("40");
                    matchPlayerLosePoint.setPoints("40");
                }else{
                    matchPlayerWinPoint.setPoints("0");
                    matchPlayerLosePoint.setPoints("0");
                    calculateGames(matchPlayerWinPoint, matchPlayerLosePoint,matchScore);
                }
            }
            case "AD" -> {
                matchPlayerWinPoint.setPoints("0");
                matchPlayerLosePoint.setPoints("0");
                calculateGames(matchPlayerWinPoint, matchPlayerLosePoint,matchScore);
            }
        }
    }

    private static void calculateGames(MatchPlayer matchPlayerWinPoint, MatchPlayer matchPlayerLosePoint,MatchScore matchScore) {
        switch (matchPlayerWinPoint.getGames()){
            case "0" -> matchPlayerWinPoint.setGames("1");
            case "1" -> matchPlayerWinPoint.setGames("2");
            case "2" -> matchPlayerWinPoint.setGames("3");
            case "3" -> matchPlayerWinPoint.setGames("4");
            case "4" -> matchPlayerWinPoint.setGames("5");
            case "5" -> {
                String playerLose = matchPlayerLosePoint.getGames();

                if (playerLose.equals("5") || playerLose.equals("6")){
                    matchPlayerWinPoint.setGames("6");
                }else{
                    matchPlayerWinPoint.setGames("0");
                    matchPlayerLosePoint.setGames("0");
                    getCalculateGameSets(matchPlayerWinPoint,matchScore);
                }
            }
            case "6" -> {
                matchPlayerWinPoint.setGames("0");
                matchPlayerLosePoint.setGames("0");
                getCalculateGameSets(matchPlayerWinPoint,matchScore);
            }
        }

    }

    private static void getCalculateGameSets(MatchPlayer matchPlayerWinPoint,MatchScore matchScore) {

        switch (matchPlayerWinPoint.getSets()){
            case "0" -> matchPlayerWinPoint.setSets("1");
            case "1" -> {
                matchScore.setWinner(matchPlayerWinPoint.getPlayerName());
                matchScore.setWinnerId(matchPlayerWinPoint.getId());
            }
        }
    }


    private static byte takePlayerNumber(String playersPoint) {
        if(playersPoint.equals("player1")) {
            return 0;
        }else{
            return 1;
        }
    }
}
