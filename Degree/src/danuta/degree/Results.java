package danuta.degree;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;


public class Results extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    public void log_off(View v){
    	//logging off from the application
        Log.v("Oo","Resuls. Log off.");
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void again_button(View v){
    	//back to the topic
    	Log.v("Oo","Results. Topic1.");
        Intent intent = new Intent(this, Topic.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void submit_button(View v){
    	//submit the test results
    	Log.v("Oo","Results. Submit the results. Content.");
        Intent intent = new Intent(this, Content.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
}