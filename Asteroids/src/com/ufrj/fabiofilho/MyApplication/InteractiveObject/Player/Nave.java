package com.ufrj.fabiofilho.MyApplication.InteractiveObject.Player;

import com.ufrj.fabiofilho.MyApplication.Game;
import com.ufrj.fabiofilho.MyApplication.InteractiveObject.InteractiveObject;
import com.ufrj.fabiofilho.MyApplication.InteractiveObject.Keyboard;
import com.ufrj.fabiofilho.lib.Cor;
import com.ufrj.fabiofilho.lib.Tela;

import java.util.Set;

/**
 * Created by filhofilha on 02/06/16.
 */
public class Nave implements InteractiveObject{


    private final double MAX_SPEED = 500, SIZE = 8, ACCELERATION = 1;

    private double  mRotation = Math.PI, mSpeed = 0;

    private Point[] mPositionVector;

    private Cor mColor;


    public Nave(){

        mColor = Cor.BRANCO;

        mPositionVector = new Point[]{
                new Point(5, 0).screenCentralize(),
                new Point(-3, -4).screenCentralize(),
                new Point(-3, 4).screenCentralize()
        };

    }


    private void correctPosition(){

        if (mPositionVector[0].getX() > Game.SCREEN_WIDTH) {
            mPositionVector[0].setX(SIZE / 2);
            mPositionVector[1].setX(SIZE / 2);
            mPositionVector[2].setX(SIZE / 2);
        }

        if (mPositionVector[0].getY() > Game.SCREEN_HEIGHT) {
            mPositionVector[0].setY(SIZE / 2);
            mPositionVector[1].setY(SIZE / 2);
            mPositionVector[2].setY(SIZE / 2);
        }

        if (mPositionVector[0].getX() < 0) {
            mPositionVector[0].setX(Game.SCREEN_WIDTH - SIZE / 2);
            mPositionVector[1].setX(Game.SCREEN_WIDTH - SIZE / 2);
            mPositionVector[2].setX(Game.SCREEN_WIDTH - SIZE / 2);
        }

        if (mPositionVector[0].getY() < 0) {
            mPositionVector[0].setY(Game.SCREEN_HEIGHT - SIZE / 2);
            mPositionVector[1].setY(Game.SCREEN_HEIGHT - SIZE / 2);
            mPositionVector[2].setY(Game.SCREEN_HEIGHT - SIZE / 2);
        }
    }


    @Override
    public void update(Set<String> mKeys, double mDeltaTime) {

        int mDirection = 0;

        // Checking pressed keys.
        if(mKeys.contains(Keyboard.UP)) {
            if (mSpeed < MAX_SPEED)
                mSpeed += ACCELERATION;
        }else
            if(mSpeed > 0)
                mSpeed -= ACCELERATION;

        if(mKeys.contains(Keyboard.LEFT))
            mDirection = -1;

        if(mKeys.contains(Keyboard.RIGHT))
            mDirection = 1;

        //Updating rotation.
        if(mDirection != 0) {

            //Calculating the rotation degree.
            double mTempRotation = mDirection * Math.PI * mDeltaTime;
            //mRotation = (mRotation + mTempRotation) % Math.PI*2;

            mRotation += mTempRotation;
            if(mRotation < 0)
                mRotation = Math.PI*2;
            if(mRotation >= Math.PI*2)
                mRotation = 0;

            //Applying the rotation.
            for (int mIndex = 0; mIndex < mPositionVector.length; mIndex++)
                mPositionVector[mIndex].rotation(mTempRotation);
        }

        //Updating position.
        if(mSpeed != 0) {

            double mSpeedX, mSpeedY;

            mSpeedX = mSpeed * mDeltaTime + Math.cos(mRotation);
            mSpeedY = mSpeed * mDeltaTime + Math.sin(mRotation);

            //Speed x
            if (mRotation > Math.PI && mRotation < 3 * Math.PI / 2)
                mSpeedX *= -1;

            if (mRotation == Math.PI / 2 || mRotation == 3 * Math.PI / 2)
                mSpeedX = 0;

            //Speed y
            if (mRotation < Math.PI && mRotation > 0)
                mSpeedY *= -1;

            if (mRotation == Math.PI || mRotation == 0 || mRotation == Math.PI * 2)
                mSpeedY = 0;

            for (int mIndex = 0; mIndex < mPositionVector.length; mIndex++) {
                mPositionVector[mIndex].setX(mPositionVector[mIndex].getX() + mSpeedX);
                mPositionVector[mIndex].setY(mPositionVector[mIndex].getY() + mSpeedY);
            }

            //Correcting the coordinates.
            correctPosition();
        }

    }

    @Override
    public void draw(Tela mSurface) {

        mSurface.triangulo(
                mPositionVector[0].getFinalX(), mPositionVector[0].getFinalY(),
                mPositionVector[1].getFinalX(), mPositionVector[1].getFinalY(),
                mPositionVector[2].getFinalX(), mPositionVector[2].getFinalY(),
                mColor
        );
    }



}
