package com.projects.learning.designpatterns.facade;

public class ShapeMaker {
    private Shape circle;
    private Shape square;
    private Shape rectangle;

    public ShapeMaker() {
        this.circle = new Circle();
        this.square = new Square();
        this.rectangle = new Rectangle();
    }

    public void getCircle() {
        circle.draw();
    }

    public void getSquare() {
        square.draw();
    }

    public void getRectangle() {
        rectangle.draw();
    }
}
