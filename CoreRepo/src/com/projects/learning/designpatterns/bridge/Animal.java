package com.projects.learning.designpatterns.bridge;

public abstract class Animal {

    protected FeedingAPI feedingAPI;

    protected Animal(FeedingAPI feedingAPI) {
        this.feedingAPI = feedingAPI;
    }
    public abstract void feed();
}
