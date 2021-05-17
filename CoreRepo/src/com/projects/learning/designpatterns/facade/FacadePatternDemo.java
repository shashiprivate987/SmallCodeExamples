package com.projects.learning.designpatterns.facade;

public class FacadePatternDemo {
    public static void main(String[] args) {
        ShapeMaker shapeMaker = new ShapeMaker();
        shapeMaker.getCircle();
        shapeMaker.getRectangle();
        shapeMaker.getSquare();

    }
}
