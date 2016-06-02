package com.ufrj.fabiofilho.MyApplication.Player;

import com.ufrj.fabiofilho.MyApplication.Game;

/**
 * Created by filhofilha on 02/06/16.
 */
public class Nave {


    private double  mX = 0,  mY = 0,
            mSpeedX = 0, mSpeedY = 0,
            mRotation = 0;


    public Nave(){
        mX = Game.getScreenCenter()[0];
        mY = Game.getScreenCenter()[1];
    }


    /* Proprieties */

    public void setX(int mX){ this.mX = mX; }

    public double getX(){ return mX; }


    public double getY(){ return mY; }

    public void setY(int mY){ this.mY = mY; }

    /* End of Proprieties */





}
