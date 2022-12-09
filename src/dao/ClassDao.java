package dao;
import domain.Class;

import java.util.List;

public interface ClassDao {

    Class findByName(String name);
    Class findByID(int id);
    List<Class> findAllClasses();


}
