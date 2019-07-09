package app.demo.net;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    EditText etUrl;
    Button btnGo;
    String url="https://www.google.com";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult=findViewById(R.id.tv_result);
        etUrl=findViewById(R.id.et_url);
        btnGo=findViewById(R.id.btn_go);



        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                url=etUrl.getText().toString();
                if(!url.isEmpty()){
                    doHttpCall();
                }else{
                    url="https://www.google.com" ;
                    doHttpCall();
                }
            }
        });
    }

    public void doHttpCall(){
     new HttpTask(url).execute();
    }
    class HttpTask extends AsyncTask {
        String url;
        HttpTask(String url){
            this.url=url;
        }
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvResult.setText("LOADING");
        }

        @Override
        protected Object doInBackground(Object[] objects) {
            String line="";
            try{
            URL url= new URL(this.url);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            line = bufferedReader.readLine();
            }catch (Exception e){
                e.printStackTrace();
                line="ERROR OCCURED";
            }
            return line;
       }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvResult.setText((String)o);
        }
    }
}
