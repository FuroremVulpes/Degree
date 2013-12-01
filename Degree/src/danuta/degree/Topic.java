package danuta.degree;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;


public class Topic extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    public void log_off(View v){
    	//logging off the application
    	Log.v("Oo","Topic. Logging off.");
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void back_button(View v){
    	Log.v("Oo","Topic. Back to the Content.");
        //Intent intent = new Intent(this, Content.class);
        //startActivity(intent);
    	this.finish();
        //intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void test_button(View v){
    	//starting the test
    	Log.v("Oo","Topic. To the questions.");
        Intent intent = new Intent(this, Questions.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
}