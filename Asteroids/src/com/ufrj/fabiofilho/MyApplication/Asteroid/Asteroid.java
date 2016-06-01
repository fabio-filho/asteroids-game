package com.ufrj.fabiofilho.MyApplication.Asteroid;

import com.ufrj.fabiofilho.MyApplication.Game;
import com.ufrj.fabiofilho.Objects.Utilities;
import com.ufrj.fabiofilho.lib.Cor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by fabiofilho on 6/1/16.
 */
public class Asteroid {

    public final static int SMALL = 1, MEDIUM = 2, BIG = 3, GIANT = 4;


    private static final int BASE_SIZE = 10;

    private int mSize;
    private double  mX = 0, mY = 0, mSpeedX = 0, mSpeedY = 0;

    private static Cor[] Colors = new Cor[]{
            Cor.AMARELO,
            Cor.AZUL,
            Cor.VERDE,
            Cor.VERMELHO,
            Cor.BRANCO
    };
    private Cor mColor;

    public Asteroid(int mSize, Cor mColor){
        this.mSize = mSize;
        this.mColor = mColor;

        setInitialRandomVelocity();
    }

    public Asteroid(int mSize, Cor mColor, int mX, int mY){
        this.mSize = mSize;
        this.mColor = mColor;
        this.mX = mX;
        this.mY = mY;

        setInitialRandomVelocity();
    }

    public int getSize() throws IllegalArgumentException {

        switch (mSize){
            case SMALL:
                return SMALL * BASE_SIZE;
            case MEDIUM:
                return MEDIUM * BASE_SIZE;
            case BIG:
                return BIG * BASE_SIZE;
            case GIANT:
                return GIANT * BASE_SIZE;
            default:
                throw new IllegalArgumentException("Invalid asteroid's size");
        }
    }


    public Cor getColor(){ return mColor; }


    public void setX(int mX){ this.mX = mX; }

    public double getX(){ return mX; }


    public double getY(){ return mY; }

    public void setY(int mY){ this.mY = mY; }


    public double getSpeedX(){ return mSpeedX; }

    public double getSpeedY(){ return mSpeedY; }

    public double[] getCenter() throws IllegalArgumentException {

        return new double[]{
                getX() + getSize()/2,
                getY() + getSize()/2
        };
    }


    private void setInitialRandomVelocity(){

        while (mSpeedX == 0 || mSpeedY == 0) {
            mSpeedX = new Random().nextInt(GIANT * 2 - mSize) * BASE_SIZE;
            mSpeedY = new Random().nextInt(GIANT * 2 - mSize) * BASE_SIZE;
        }

    }


    public void update(double mDeltaTime){

        //Utilities.log("dt: "+mDeltaTime+ " - x:"+mX+ " - y:"+mY+ " - speedX:"+mSpeedX+ " - speedY:"+mSpeedY);
        mX += mSpeedX * mDeltaTime;
        mY += mSpeedY * mDeltaTime;

        //Checking if the coordinates are valid.
        if(mX > Game.SCREEN_WIDTH)
            mX = -getSize()/2;

        if(mY > Game.SCREEN_HEIGHT)
            mY = -getSize()/2;

    }



    /* Static methods */

    public static List<Asteroid> generate( int mLength ){

        List<Asteroid> mList = new ArrayList<>();

        if(mLength <= 0)
            throw new IllegalArgumentException("Invalid length.");

        try {
            for(int mIndex = 0; mIndex < mLength; mIndex++){

                Asteroid mAsteroid = new Asteroid(
                        //Random size.
                        new Random().nextInt(GIANT - SMALL) + SMALL ,
                        //Random color.
                        Colors[new Random().nextInt(Colors.length)]
                );

                //Random initial position.
                mAsteroid.setX(new Random().nextInt(Game.SCREEN_WIDTH - mAsteroid.getSize()) + mAsteroid.getSize()/2);
                mAsteroid.setY(new Random().nextInt(Game.SCREEN_WIDTH - mAsteroid.getSize()) + mAsteroid.getSize()/2);

                mList.add(mAsteroid);
            }

        }catch (IllegalArgumentException mException){
            Utilities.log(mException.toString());
            mException.printStackTrace();
        }

        return mList;
    }

    /* End Static methods */

}
