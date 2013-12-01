package danuta.degree;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;


public class Content extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    public void log_off(View v){
    	Log.v("Oo", "Content. Logging off.");
		Intent intent = new Intent(this, Login.class);
		startActivity(intent);
		//intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void topic1_next(View v){
    	Log.v("Oo","Content. Topic1.");
    	Intent intent = new Intent(this, Topic.class);
    	startActivity(intent);
    	//intent.putExtra(NAME,VALUE); give another windows values
    }
}