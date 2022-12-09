package dao;
import domain.Personage;

import java.util.List;

public interface PersonageDao {

    Personage findByID(int characterID);
    Personage findByName(String name);
    List<Personage> findByUserID(int userID);

//    Personage venderObjeto();
//    Personage comprarObjeto();
//    Personage descansar();
//    Personage luchar();

    boolean createPersonage(int classID, String username, int userID);
    boolean removePersonage(int characterID);
}
