package danuta.degree;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Questions extends Activity {
	
	public EditText field1; //temp field 1
	public RadioGroup radiogroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.questions_layout);
        Log.v("Oo", "New window");
        radiogroup = (RadioGroup) findViewById(R.id.radioGroup1);
        /*field1 = (EditText) findViewById(R.id.editText1);
        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
        	public void onCheckedChanged(RadioGroup group, int checkedId){
        		RadioButton btn;
        		switch(checkedId){
        		case R.id.radio0:
        			btn = (RadioButton) group.getChildAt(0);
        			field1.setText("" + btn.getText());
        			break;
        		case R.id.radio1:
        			btn = (RadioButton) group.getChildAt(1);
        			field1.setText("" + btn.getText());
        			break;
        		case R.id.radio2:
        			btn = (RadioButton) group.getChildAt(2);
        			field1.setText("" + btn.getText());
        			break;
        		}
        	}
        });*/
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    public void log_off(View v){
    	//logging off from the application
    	Log.v("Oo","Questions. Logging off.");
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void skip_button(View v){
    	//skipping the answer
    	Log.v("Oo","Questions. Skipping the question.");
        Intent intent = new Intent(this, Questions.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void submit_button(View v){
    	//submitting the answer
    	Log.v("Oo","Questions. Submitting the answers.");
        Intent intent = new Intent(this, Results.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
    
    public void topic_button(View v){
    	//rereading the topic
    	Log.v("Oo","Questions. Back to topic.");
        Intent intent = new Intent(this, Topic.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    }
}
