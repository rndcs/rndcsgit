package com.rndcs.artificialintelligence;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;


public class MainActivity extends Activity {

    boolean m_bSplashActive;
    boolean m_bPaused;

    long m_dwSplashTime = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

/////////////////////////////////
//timer code starts

        m_bPaused = false;
        m_bSplashActive = true;

//Very simple timer thread
        Thread splashTimer = new Thread()
        {
            public void run()
            {
                try
                {
//Wait loop
                    long ms = 0;
                    while(m_bSplashActive && ms < m_dwSplashTime)
                    {
                        sleep(100);
//Only advance the timer if we're running.
                        if(!m_bPaused)
                            ms += 100;
                    }
//Advance to the next screen.
                    startActivity(new Intent("com.rndcs.artificialintelligence.QUIZACTIVITY"));
                    finish();
                }
                catch(Exception e)
                {
//Thread exception
                    System.out.println(e.toString());
                }
            }
        };
        splashTimer.start();





/////////////////////////////////





        setContentView(R.layout.splash);
    }



}

