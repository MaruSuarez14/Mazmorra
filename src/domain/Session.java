package domain;

import java.sql.Connection;

public class Session {
    private Connection con;
    private User user;
    private Personage personage;

    public Session(Connection con, User user, Personage personage) {
        this.con = con;
        this.user = user;
        this.personage = personage;
    }
    public Session(Connection con, User user) {
        this.con = con;
        this.user = user;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Personage getPersonage() {
        return personage;
    }


}
