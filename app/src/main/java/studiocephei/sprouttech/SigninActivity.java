package studiocephei.sprouttech;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.facebook.login.widget.LoginButton;


public class SigninActivity extends Activity {

    private LoginButton mLoginButton;
    private Button mSkipBtn;
    private EditText mEmailEt;
    private EditText mPasswordEt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        mLoginButton = (LoginButton) findViewById(R.id.login_button);
        //dev command
        mSkipBtn = (Button) findViewById(R.id.btn_dev_skip);
        mEmailEt = (EditText) findViewById(R.id.et_email);
        mPasswordEt = (EditText) findViewById(R.id.et_password);
        mEmailEt.setHint("Email");
        mPasswordEt.setHint("Password");

        attachBtn();
    }

    private void attachBtn(){
        mSkipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openHomeActivity();
            }
        });

    }

    private void openHomeActivity(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

}
