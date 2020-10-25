package com.example.musicshop.test;

import android.util.Log;

public class TestClass
{
    public void test()
    {
//        Magnitola magnitola = new Magnitola();
//        playInPlayer(magnitola);

//        playInPlayer(new Magnitola());

//        Player player = new Magnitola();
//        playInPlayer(player);

//        Player player = new Player()
//        {
//            @Override
//            public void play()
//            {
//                Log.e("TestClass", "play in anonimus");
//            }
//        };
//        playInPlayer(player);
        playInPlayer(new Player()
        {
            @Override
            public void play()
            {
                Log.e("TestClass", "play in anonimus2");
            }
        });

    }

    public void playInPlayer(Player player)
    {
        player.play();
    }


}