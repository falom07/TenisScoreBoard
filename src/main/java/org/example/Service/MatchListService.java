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
            return  matchDAO.readAllWithSize(pageSizeInt,pageNumberInt,session);
        }else{
            return matchDAO.readAllByNameWithSize(nameFilter,pageSizeInt,pageNumberInt,session);
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
}
