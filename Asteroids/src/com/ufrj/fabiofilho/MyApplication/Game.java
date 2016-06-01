package com.ufrj.fabiofilho.MyApplication;

import com.ufrj.fabiofilho.MyApplication.Asteroid.Asteroid;
import com.ufrj.fabiofilho.lib.Jogo;
import com.ufrj.fabiofilho.lib.Tela;

import java.util.List;
import java.util.Set;

/**
 * Created by fabiofilho on 6/1/16.
 */
public class Game implements Jogo {


    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 480;

    private final int InitialAsteroidAmount = 6;
    private List<Asteroid> mAsteroids;



    public Game(){

        mAsteroids = Asteroid.generate(InitialAsteroidAmount);
    }

    @Override
    public String getTitulo() {
        return "Asteroide";
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
            mAsteroids.get(mIndex).update(mDeltaTime);
        }


    }

    @Override
    public void desenhar(Tela mSurface) {


        //Update position of each Asteroid's instance.
        for(Asteroid mAsteroid: mAsteroids)
            mSurface.circulo(
                    mAsteroid.getX(),
                    mAsteroid.getY(),
                    mAsteroid.getSize(),
                    mAsteroid.getColor()
            );


        //Utilities.sleep(500);

    }

    @Override
    public void tecla(String mKey) {

    }
}
