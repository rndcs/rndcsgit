package com.rndcs.artificialintelligence;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class thankyou extends Activity {
    ImageButton sharebtn,  gettutbtn;

    int flag=0;
    int score;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thankyou);

        ImageButton sharebtn=(ImageButton) findViewById(R.id.sharebtn);

        ImageButton gettutbtn=(ImageButton) findViewById(R.id.gettutbtn);


        Bundle b = getIntent().getExtras();
        score= b.getInt("score");

        sharebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);


                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I just scored " + score +" / 100 " + " in databasemanagementsystem.");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I just scored " + score +" / 100 " + " in databasemanagementsystem. Thanks to http://mcatutorials.com");
                sharingIntent.putExtra(Intent.EXTRA_TITLE, "My brilliant Performance in Data Structure");
                //startActivityForResult(Intent.createChooser(sharingIntent, "Share via"),1000);
/**
 * Get the result when we share any data to another activity
 * */
                //sharingIntent.putExtra(Intent.EXTRA_TEXT, "#I just scored " + score +" / 5 " + " in Data Structure.");
                startActivity(Intent.createChooser(sharingIntent, "Share Your Test Results"));

            }
        });

        gettutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openBrowser1();

            }
        });



    }

    private void openBrowser1()
    {
        //this intent is used to open other activity wich contains another webView
        Intent intent = new Intent(thankyou.this,SecondActivity.class);
        intent.putExtra("clickUrl", "http://mcatutorials.com/mca-tutorials-database-management-system.php");
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}