package com.projects.learning.designpatterns.command;

public class MenuOptions {
    private final ActionListenerCommand open;
    private final ActionListenerCommand save;

    public MenuOptions(ActionListenerCommand open, ActionListenerCommand save ){
        this.open = open;
        this.save = save;

    }


    public void clickOpen() {
        open.execute();
        
    }

    public void clickSave() {
        save.execute();
    }
}
