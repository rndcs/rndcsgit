package com.rndcs.artificialintelligence;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
public class ResultActivity extends Activity {
    ImageButton nextbtn;
    float values[]={1,1};
    int flag=0;
    int score;

    LinearLayout linear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        LinearLayout linear=(LinearLayout) findViewById(R.id.linear);
        ImageButton nextbtn=(ImageButton) findViewById(R.id.nextbtn);

        TextView worng=(TextView)findViewById(R.id.wornglbl);
        TextView right=(TextView)findViewById(R.id.rightlbl);
        //get score
        Bundle b = getIntent().getExtras();
        score= b.getInt("score");
        //display score
        //bar.setRating(score);
        worng.setText("Worng - "+(100-score) );
        right.setText("Right - "+score );
        values[0]=score;
        values[1]=100-score;
        values=calculateData(values);
        if  ( flag == 0 )
            linear.addView(new MyGraphview(this,values));

        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, thankyou.class);
                Bundle b = new Bundle();
                b.putInt("score", score); //Your score
                intent.putExtras(b); //Put your score to your next Intent
                startActivity(intent);
                finish();


            }
        });


    }



    private float[] calculateData(float[] data) {
        // TODO Auto-generated method stub
        float total=0;
        for(int i=0;i<data.length;i++)
        {
            total+=data[i];
        }
        for(int i=0;i<data.length;i++)
        {
            data[i]=360*(data[i]/total);
        }
        return data;

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_result, menu);
        return true;
    }
}
