package com.ufrj.fabiofilho.MyApplication;

import com.ufrj.fabiofilho.MyApplication.InteractiveObject.Asteroid.Asteroid;
import com.ufrj.fabiofilho.MyApplication.InteractiveObject.Player.Nave;
import com.ufrj.fabiofilho.lib.Jogo;
import com.ufrj.fabiofilho.lib.Tela;

import java.util.List;
import java.util.Set;

/**
 * Created by fabiofilho on 6/1/16.
 */
public class Game implements Jogo {

    /* Game attributes */
    private static final String GAME_NAME = "Asteroids";
    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 480;
    /* End of Game attributes */


    /* Interactive objects */
    private final int InitialAsteroidAmount = 6;
    private List<Asteroid> mAsteroids;
    private Nave mNave;



    public Game(){

        //Generate some random asteroids.
        mAsteroids = Asteroid.generate(InitialAsteroidAmount);

        //Instance nave object.
        mNave = new Nave();
    }

    public static int[] getScreenCenter(){

        return new int[]{
            SCREEN_WIDTH/2,
            SCREEN_HEIGHT/2
        };
    }


    @Override
    public String getTitulo() {
        return GAME_NAME;
    }

    @Override
    public int getLargura() {
        return SCREEN_WIDTH;
    }

    @Override
    public int getAltura() {
        return SCREEN_HEIGHT;
    }

    @Override
    public void tique(Set<String> mKeys, double mDeltaTime) {

        //Update position of each Asteroid's instance.
        for(int mIndex = 0; mIndex < mAsteroids.size(); mIndex++) {
            mAsteroids.get(mIndex).update(mKeys, mDeltaTime);
        }


        mNave.update(mKeys, mDeltaTime);
    }

    @Override
    public void desenhar(Tela mSurface) {

        //Draw asteroids.
        for(Asteroid mAsteroid: mAsteroids)
            mAsteroid.draw(mSurface);

        //Draw nave.
        mNave.draw(mSurface);
    }

    @Override
    public void tecla(String mKey) {

    }
}
