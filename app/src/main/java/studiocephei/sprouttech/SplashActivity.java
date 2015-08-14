package studiocephei.sprouttech;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;
import com.parse.Parse;
import com.parse.ParseFacebookUtils;


public class SplashActivity extends Activity {

    private Typeface mTypeface;
    private TextView mTxtSlogan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_splash);
        ActionBar actionBar = getActionBar();
        actionBar.hide();
        mTypeface = Typeface.createFromAsset(getAssets(), "gothic.TTF");
        mTxtSlogan = (TextView) findViewById(R.id.txt_slogan);
        mTxtSlogan.setTypeface(mTypeface);
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "nQURh0ji1BfeZinz96yKq6jWgt44DA0sOatY2d4O", "4P7PDnNGGLW9GNzgTJrLrZp8FIAZr4pytOVCFgTs");
        ParseFacebookUtils.initialize(this);
        waitSplash();

    }

    @Override
    protected void onResume() {
        super.onResume();
        // Logs 'install' and 'app activate' App Events.
        AppEventsLogger.activateApp(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Logs 'app deactivate' App Event.
        AppEventsLogger.deactivateApp(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void waitSplash() {
       // mProgressBar = (ProgressBar) findViewById(R.id.pgb_splash);
        //mProgressBar.setVisibility(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //splash -> home
                Intent i = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(i);
                // close this activity
                finish();
            }
        }, Constants.SPLASH_TIME);
    }
}
