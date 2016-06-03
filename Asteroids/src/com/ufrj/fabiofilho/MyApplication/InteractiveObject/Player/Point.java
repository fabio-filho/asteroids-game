package com.ufrj.fabiofilho.MyApplication.InteractiveObject.Player;

import com.ufrj.fabiofilho.MyApplication.Game;

/**
 * Created by fabiofilho on 6/2/16.
 */
public class Point {

    private double mRotationX = 0, mRotationY = 0, mX = 0, mY = 0;


    public Point(double mRotationX, double mRotationY) {

        this.mRotationX = mRotationX;
        this.mRotationY = mRotationY;
    }

    public Point(double mRotationX, double mRotationY, double mX, double mY) {

        this.mRotationX = mRotationX;
        this.mRotationY = mRotationY;

        this.mX = mX;
        this.mY = mY;
    }


    public void rotation(double mDegrees){

        mRotationX = mRotationX * Math.cos(mDegrees) - mRotationY * Math.sin(mDegrees);
        mRotationY = mRotationY * Math.cos(mDegrees) + mRotationX * Math.sin(mDegrees);
    }

    public double getFinalX() {
        return mX - mRotationX;
    }

    public double getFinalY() {
        return mY - mRotationY;
    }


    public double getX() { return mX; }

    public double getY() {
        return mY;
    }


    public void setY(double mY) {
        this.mY = mY;
    }

    public void setX(double mX) {
        this.mX = mX;
    }


    @Override
    public String toString() {
        return "X: "+ mRotationX + " Y: "+ mRotationY;
    }


    /* Static methods */

    public Point screenCentralize(){

        return new Point(mRotationX, mRotationY, Game.getScreenCenter()[0], Game.getScreenCenter()[1]);
    }

    /* End of Static methods */
}
