package org.example.Service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.example.DAO.MatchDAO;
import org.example.Entity.Match;
import org.example.Util.HibernateUtil;
import org.hibernate.Session;

import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MatchListService {
    private static volatile MatchListService instance;


    private static final MatchDAO matchDAO = MatchDAO.getInstance();

    public static MatchListService getInstance() {
        if (instance == null) {
            synchronized (MatchListService.class) {
                if (instance == null) {
                    instance = new MatchListService();
                }
            }
        }
        return instance;
    }

    public List<Match> getMatchList(String pageNumber,String pageSize,String nameFilter) {
        int pageNumberInt = convertStringToInt(pageNumber);
        int pageSizeInt = convertStringToInt(pageSize) == 1 ? 10 : convertStringToInt(pageSize);

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
        if(nameFilter == null){
            return  matchDAO.readAllWithSize(pageSizeInt,pageNumberInt);
        }else{
            return matchDAO.readAllByNameWithSize(nameFilter,pageSizeInt,pageNumberInt);
        }
        }

    }


    private int convertStringToInt(String convertString){
        if(convertString == null){
            return 1;
        }else{
            int res;
            try {           //check if somebody find a way send string instead of number
                res = Integer.parseInt(convertString);
            }catch (NumberFormatException e){
                return 1;
            }
         return res;
        }
    }

    public List<String> getNumPages(String pageNumber,String pageSize) {
        int countDataInTable = Math.toIntExact(matchDAO.countDataInTable());
        int pageNumberInt = convertStringToInt(pageNumber);
        int pageSizeInt = convertStringToInt(pageSize);

        if(countDataInTable < pageSizeInt){ //if user wants to see more data than there is in the db
            return List.of("","1","");
        }
        double howMuchPages = Math.ceil((double) countDataInTable / pageSizeInt);   //find max page that we can show now;

        if((int)howMuchPages > pageNumberInt){ //if we have more pages than user want
            String first = String.valueOf(pageNumberInt - 1);
            String second = String.valueOf(pageNumberInt);
            String third = String.valueOf(pageNumberInt + 1);
            return List.of(first,second,third);
        }else{
            String first = String.valueOf(pageNumberInt - 1);
            String second = String.valueOf(pageNumberInt);
            return List.of(first,second,"");
        }

    }

    public String getUsersDesirePage(String page,String currentPage,String pageSize) {
        if(page == null){
            return  "1";
        }

        int countDataInTable = Math.toIntExact(matchDAO.countDataInTable());
        int currentPageInt = convertStringToInt(currentPage);
        int pageSizeInt = convertStringToInt(pageSize);

        int howMushPageWeHave = (int) Math.ceil((double)countDataInTable / pageSizeInt);
        int previousPage = currentPageInt - 1 == 0 ? 1 : currentPageInt - 1;
        int nextPage = currentPageInt + 1 == howMushPageWeHave + 1 ? howMushPageWeHave : currentPageInt + 1;

        return switch (page) {
            case "first" -> "1";
            case "last" -> String.valueOf(howMushPageWeHave);
            case "previous" -> String.valueOf(previousPage);
            case "next" -> String.valueOf(nextPage);
            default -> page;
        };

    }
}























