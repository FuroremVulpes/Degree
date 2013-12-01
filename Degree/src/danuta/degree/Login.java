package danuta.degree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import danuta.degree.R.id;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity {

	public TextView state; 
	public EditText login; 
	public EditText password; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        login = (EditText) findViewById(R.id.editText3);
    	password = (EditText) findViewById(R.id.editText5);
    	state = (TextView) findViewById(id.textView1);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.login, menu);
        return true;
    }
    
    public void sign_in_sql(View v){
    	//sign in operation
    	
    	Log.v("Oo", "Start.Sign in. BEGIN.");
    	Intent intent = new Intent(this, Content.class);
        startActivity(intent);
        //intent.putExtra(NAME,VALUE); give another windows values
    	/*String login_str = login.getText().toString();
    	String password_str = password.getText().toString();
    	
    	if (right_input(login_str, password_str) == 1){
    		Log.v("Oo", "Start. Moving to the content window.");
    		Intent intent = new Intent(this, Content.class);
    		startActivity(intent);
    		/*ArrayList login_info = new ArrayList();
    		login_info.add(login);
    		login_info.add(password);
    		intent.putExtra("login_info",login_info); //give another windows values//
    	} else {
    		if (right_input(login_str, password_str) == 2){
    			Log.v("Oo", "Start. User doesn't exist.");
    			state.setText("User isn't registered.");
    		}else{
    			Log.v("Oo", "Start. Login failed.");
    			state.setText("Login failed.");
    		}
    	}*/
    	Log.v("Oo", "Start.Sign in. END.");
    }
    
    public void register_sql(View v){
    	//registration check
    	Log.v("Oo", "Registration. BEGIN.");
    	String login_str = login.getText().toString();
    	String password_str = password.getText().toString();
    	
    	if (right_input(login_str, password_str) == 1){
    		Log.v("Oo", "Registration. Moving to the content window.");
    		state.setText("Login already exists.");
    	} else {
    		if (right_input(login_str, password_str) == 2){
    			Log.v("Oo", "Registration. New user.");
    			//+++++
    			//state.setText("NEW"+login_str+" "+password_str);
    			//+++++
    			Intent intent = new Intent(this, Questions.class);
        		startActivity(intent);
        		//intent.putExtra(NAME,VALUE); give another windows values
    		}else{
    			Log.v("Oo", "Registration. Login already exists.");
    			state.setText("Login already exists.");
    		}
    	}
    	Log.v("Oo", "Start.Sign in. END.");
    }
    
    public int right_input(String login_str, String password_str){
    	//checks whether the login and password are from the DB
    	Log.v("BD", "In right_input");
    	
    	String login_db = ""; //login in DB
    	String password_db = ""; //password in DB
    	int result = 0; //login and password are NOT valid
    	
    	Log.v("BD", "In right_input: try");
    	
    	/*try {
    		String urlParameters = "log=user1&pass=user1";
    		URL url = new URL("http://10.200.5.114:8080/Degree/login");
    		//URLConnection conn = url.openConnection();
    		HttpURLConnection httpconnection = (HttpURLConnection)url.openConnection();
    		httpconnection.setRequestMethod("POST");
    		httpconnection.setDoOutput(true);
    		httpconnection.setDoInput(true);
    		httpconnection.connect();
    		Log.v("BD", "In right_input: connection");

    		OutputStreamWriter writer = new OutputStreamWriter(httpconnection.getOutputStream());

    		writer.write(urlParameters);
    		writer.flush();
    		Log.v("BD", "In right_input: writer");

    		String line, res = "";
    		BufferedReader reader = new BufferedReader(new InputStreamReader(httpconnection.getInputStream()));
    		Log.v("BD", "In right_input: reader");

    		while ((line = reader.readLine()) != null) {
    			res += line;
    		}
    		Toast out = Toast.makeText(getApplicationContext(), res.toString(), Toast.LENGTH_SHORT);
			out.show();
			Log.v("BD", "In right_input: result");
    		writer.close();
    		reader.close();*/
    	
    	// Create a new HttpClient and Post Header
        HttpClient httpclient = new DefaultHttpClient();
        //PostMethod post = new PostMethod("http://10.200.5.114:8080/Degree/login");
        try {
        	URI url = new URI("http://10.200.5.114:8080/Degree/login");
        	HttpPost httppost = new HttpPost(url);
        
        	Log.v("BD", "In right_input: try");
            // Add your data
        	//JSONObject data = new JSONObject();
        	//data.put("log", "user1");
        	//data.put("pass", "user1");
        	
            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
            nameValuePairs.add(new BasicNameValuePair("log", "user1"));
            nameValuePairs.add(new BasicNameValuePair("pass", "user1"));
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
            Log.v("BD", "In right_input: execute");
            
            // Execute HTTP Post Request
            HttpResponse response = httpclient.execute(httppost);
            Log.v("BD", "In right_input: request sent");
            //Response parsing
            /*BufferedReader rd = new BufferedReader(
                    new InputStreamReader(response.getEntity().getContent()));

            StringBuffer results = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				results.append(line);
			}
			Log.v("BD", "In right_input: result");
			//+++++++++++++++++
			Toast out = Toast.makeText(getApplicationContext(), results.toString(), Toast.LENGTH_SHORT);
			out.show();
			//++++++++++++++++
			
			//System.out.println(results.toString());
            */
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
        	Log.v("BD", "In right_input: ClientProtocolException");
        } catch (IOException e) {
            // TODO Auto-generated catch block
        	Log.v("BD", "In right_input: IOException " + e.toString());
        } catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    	/*//+++++++
    	login_db += "danuta";
    	password_db += "q1w2e3r4";
    	//+++++++
    	if (login_str.equals(login_db)){
    		if (password_str.equals(password_db)){
    			result = 1; //login and password are valid
    		}
    	}else{
    		result = 2; //login doesn't exist
    	}*/
    	return result;
    }
    
}
