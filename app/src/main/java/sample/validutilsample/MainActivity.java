package sample.validutilsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import thebat.lib.validutil.ValidUtils;

public class MainActivity extends AppCompatActivity {

    EditText name,email, mobile;
    Button progress, submit;
    ValidUtils validUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        mobile = (EditText) findViewById(R.id.mobile);
        progress = (Button) findViewById(R.id.progress);
        submit = (Button) findViewById(R.id.submit);

        validUtils = new ValidUtils();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check for internet
                if (validUtils.isNetworkAvailable(MainActivity.this)){
                    if(!validUtils.validateEditTexts(name,mobile,email)){
                        validUtils.showToast(MainActivity.this, "All fields are requierd");
                    }
                    else if(!validUtils.validateEmail(email)){
                        validUtils.showToast(MainActivity.this,"Invalid Email");
                    }
                    else if(!validUtils.validateMobileNumber(mobile)){
                        validUtils.showToast(MainActivity.this,"Invalid Mobile Number");
                    }
                    else{
                        validUtils.showProgressDialog(MainActivity.this,MainActivity.this);
                    }
                }

                else{
                    validUtils.showToast(MainActivity.this, "No Internet connection");
                }
            }
        });

        progress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validUtils.showProgressDialog(MainActivity.this,MainActivity.this);
            }
        });
    }
}
