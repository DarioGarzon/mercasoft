package edu.uan.mercasoft;

import edu.uan.mercasoft.controllers.AppController;
import edu.uan.mercasoft.domain.User;

public class Session {
    private User actualUser;
    private AppController selectedController;

    public AppController getSelectedController() {
        return selectedController;
    }

    public void setSelectedController(AppController selectedController) {
        this.selectedController = selectedController;
    }

    public User getActualUser() {
        return actualUser;
    }

    public void setActualUser(User actualUser) {
        this.actualUser = actualUser;
    }

    private static Session ourInstance = new Session();

    public static Session getInstance() {
        return ourInstance;
    }

    private Session() {
    }
}
