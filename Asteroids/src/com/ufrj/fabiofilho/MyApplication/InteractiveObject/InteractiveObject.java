package com.ufrj.fabiofilho.MyApplication.InteractiveObject;

import com.ufrj.fabiofilho.lib.Tela;

import java.util.Set;

/**
 * Created by fabiofilho on 6/2/16.
 */
public interface InteractiveObject {

    void update(Set<String> mKeys, double mDeltaTime);

    void draw(Tela mSurface);

}


