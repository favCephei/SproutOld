package studiocephei.sprouttech;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.parse.ParseUser;


public class LoginActivity extends Activity {

    ParseUser mCurrentUser = ParseUser.getCurrentUser();
    private Button mBtnSignIn;
    private Button mBtnRegister;
    private TextView mTxtSlogan;
    private Typeface mTypeface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        mTypeface = Typeface.createFromAsset(getAssets(), "gothic.TTF");
        mTxtSlogan = (TextView) findViewById(R.id.txt_slogan);
        mBtnSignIn = (Button)findViewById(R.id.btn_signin);
        mBtnRegister = (Button)findViewById(R.id.btn_register);
        mBtnRegister.setTypeface(mTypeface);
        mBtnSignIn.setTypeface(mTypeface);
        mTxtSlogan.setTypeface(mTypeface);
        //if user is already logged in go to homeActivity
        if (mCurrentUser != null) openOverview();
        setListeners();
    }


    private void openOverview(){
        Intent i = new Intent(this, HomeActivity.class);
        startActivity(i);
    }

    private void openSignIn(){
        Intent i = new Intent(this, SigninActivity.class);
        startActivity(i);
    }

    private void openRegister(){
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);
    }

    private void setListeners(){
        mBtnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignIn();
            }
        });

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRegister();
            }
        });

    }

}
