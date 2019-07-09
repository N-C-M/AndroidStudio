package app.cec.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etFirst,etSec;
    Button btnAdd,btnSub,btnX,btnDiv,btnClr;
    TextView tvRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etFirst=findViewById(R.id.et_first);
        etSec=findViewById(R.id.et_sec);
        btnAdd=findViewById(R.id.btn_add);
        btnSub=findViewById(R.id.btn_sub);
        btnX=findViewById(R.id.btn_x);
        btnDiv=findViewById(R.id.btn_div);
        tvRes=findViewById(R.id.tv_res);
        btnClr=findViewById(R.id.btn_clr);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { 
                try {

                    new AddTask().execute();
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSec.getText().toString());
                    int c = add(a,b);

                    tvRes.setText(String.valueOf(c));*/
                   new AddTask().execute();
                }catch(Exception e){
                    showErrorToast();

                }

            }

        });
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSec.getText().toString());
                    int c = a - b;

                    tvRes.setText(String.valueOf(c));
                }catch(Exception e){
                    showErrorToast();
                }

            }
        });
        btnX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSec.getText().toString());
                    int c = a * b;

                    tvRes.setText(String.valueOf(c));
                }catch(Exception e){
                    showErrorToast();
                }
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int a = Integer.parseInt(etFirst.getText().toString());
                    int b = Integer.parseInt(etSec.getText().toString());
                    float c = (float)a / b;

                    tvRes.setText(String.valueOf(c));
                }catch(Exception e){
                    showErrorToast();
                }

            }
        });
        btnClr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etFirst.setText("");
                etSec.setText("");
                tvRes.setText("");
            }
        });
    }
    public void showErrorToast()
    {
        Toast.makeText(this," Enter a number",Toast.LENGTH_SHORT).show();
    }

    public int add(int a,int b){
        return a+b;
    }
    class AddTask extends AsyncTask {    
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            tvRes.setText("Please Wait");       

        }

        @Override
        protected Object doInBackground(Object[] objects) {
         try{
                 Thread.sleep(3000);}  
         catch(Exception e){

            }
         String epoch=String.valueOf(System.currentTimeMillis());                                    /*return the epoch time */
         return epoch;

        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            tvRes.setText((String)o);                             
        }
    }
}


