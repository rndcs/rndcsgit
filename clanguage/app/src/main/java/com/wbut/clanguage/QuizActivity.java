package com.wbut.clanguage;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
public class QuizActivity extends Activity {
    List<Question> quesList;
    int score=0;
    int qid=0;
    Question currentQ;
    TextView txtQuestion, countlbl;

    RadioButton rda, rdb, rdc,  rdd, rb;
    RadioGroup grp;
    String rid;

    WebView webview;
    ImageButton ad1btn;
    String bannerUrl;
    String clickUrl;
    String lbanerUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        ad1btn=(ImageButton) findViewById(R.id.ad1btn);
        // Ad fetching
		/*
		 Jasonparse Jp = new Jasonparse();
		    String[] out= Jp.parse(25);

		     bannerUrl=out[0];
		     clickUrl =out[1];

			  Drawable image = ImageOperations(bannerUrl,"image.jpg");

				ImageView imgView ;
				imgView = (ImageView)findViewById(R.id.image1);

				imgView.setImageDrawable(image);

				imgView.setOnClickListener(new ImageView.OnClickListener() {

					public void onClick(View v) {

						//webview = (WebView) findViewById(R.id.webview);
						//webview.getSettings().setJavaScriptEnabled(true);
						//webview.loadUrl(clickUrl);

						openBrowser1();

					      }
					}
			 );

	//Ad fetching code	*/

        DbHelper db=new DbHelper(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        countlbl=(TextView)findViewById(R.id.countlbl);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio3);
        setQuestionView();




        rda.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rb=rda;
                evaluate();


            }
        });
        rdb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rb=rdb;
                evaluate();


            }
        });
        rdc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rb=rdc;
                evaluate();


            }
        });
        rdd.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rb=rdd;
                evaluate ();


            }
        });

        ad1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openBrowser1();

            }
        });

    }

    public void evaluate()
    {
        //Toast.makeText(this,"i am in evaluate", Toast.LENGTH_SHORT).show();
        grp=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());


        //rid=grp.getCheckedRadioButtonId();
        rid=String.valueOf(answer.getTag());
        //Log.d("yourans", currentQ.getANSWER()+" "+rid);
        //Toast.makeText(this,rid, Toast.LENGTH_SHORT).show();
        if(currentQ.getANSWER().equals(rid))
        {
            score++;
            rb.setBackgroundColor(Color.GREEN);
            Log.d("score", "Your score"+score);
            //Toast.makeText(getApplicationContext(),"RIGHT", Toast.LENGTH_LONG).show();
        }
        else
        {
            rb.setBackgroundColor(Color.RED);
            //Toast.makeText(getApplicationContext(),"WORNG : Correct Answer is "+currentQ.getANSWER(), Toast.LENGTH_LONG).show();
            if(currentQ.getANSWER().equals("a"))
            {
                rda.setBackgroundColor(Color.GREEN);
            }

            if(currentQ.getANSWER().equals("b"))
            {
                rdb.setBackgroundColor(Color.GREEN);
            }

            if(currentQ.getANSWER().equals("c"))
            {
                rdc.setBackgroundColor(Color.GREEN);
            }

            if(currentQ.getANSWER().equals("d"))
            {
                rdd.setBackgroundColor(Color.GREEN);
            }



        }
        if(qid<100){
            currentQ=quesList.get(qid);
            //delay thread

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    rda.setBackgroundColor(Color.WHITE);
                    rdb.setBackgroundColor(Color.WHITE);
                    rdc.setBackgroundColor(Color.WHITE);
                    rdd.setBackgroundColor(Color.WHITE);
                    rda.setChecked(false);
                    rdb.setChecked(false);
                    rdc.setChecked(false);
                    rdd.setChecked(false);


                    setQuestionView();
                    // Do something after 5s = 5000ms
                    //buttons[inew][jnew].setBackgroundColor(Color.BLACK);
                }
            }, 1000);

            //delay ends


        }else{
            Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", score); //Your score
            intent.putExtras(b); //Put your score to your next Intent
            startActivity(intent);
            finish();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_quiz, menu);
        return true;
    }
    private void setQuestionView()
    {
        countlbl.setText((qid + 1) + "/ 100");
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTA());
        rdb.setText(currentQ.getOPTB());
        rdc.setText(currentQ.getOPTC());
        rdd.setText(currentQ.getOPTD());

        qid++;
    }

    private Drawable ImageOperations(String url, String saveFilename) {
        try {
            InputStream is = (InputStream) this.fetch(url);
            Drawable d = Drawable.createFromStream(is, "src");
            return d;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Object fetch(String address) throws MalformedURLException,IOException {
        URL url = new URL(address);
        Object content = url.getContent();
        return content;
    }


    private void openBrowser1()
    {
        //this intent is used to open other activity wich contains another webView
        Intent intent = new Intent(QuizActivity.this,SecondActivity.class);
        intent.putExtra("clickUrl", "http://mcatutorials.com/");
        startActivity(intent);
    }

}
