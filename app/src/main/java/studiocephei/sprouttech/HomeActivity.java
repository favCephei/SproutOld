package studiocephei.sprouttech;


import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.widget.ListView;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.parse.ParseUser;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * This is the main activity of my app, the bulk of my fragment methods are done from here*
 */

public class HomeActivity extends FragmentActivity
{
    private int mContainerRes;

    //gets current user
    ParseUser mCurrentUser = ParseUser.getCurrentUser();


    /**
     * Temporary override of the back button so the user can't go back to the login screen and stuff with how the loginButton queries
     */

    @Override
    public void onBackPressed()
    {
        //No going back to login screen without logging out
    }


    /**
     * Sets up the drawer fragment and runs a 'setupDrawerConfiguration'
     * Default open view to user's profile
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        setActionBarTitle("Account Overview");
        FragmentOverview overview = new FragmentOverview();
        mContainerRes = R.id.fragment_container;
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(mContainerRes, overview).commit();


        if (mCurrentUser != null){
            fillProfile();
        }
    }




    /**
     * Retrieves up to date profile information from facebook and stores it to ParseUser through a 'meRequest' that returns
     * a JSONObject from facebook that is the current user's facebook information.
     */

    public void fillProfile(){
        Log.d(Constants.SPROUT_TAG, "Getting facebook data....");
        GraphRequest request = GraphRequest.newMeRequest(AccessToken.getCurrentAccessToken(), new GraphRequest.GraphJSONObjectCallback() {

            @Override
            public void onCompleted(JSONObject jsonObject, GraphResponse graphResponse) {
                if (jsonObject != null) {
                    Log.d(Constants.SPROUT_TAG, "Facebook data found!");

                    //information collected from facebook
                    JSONObject profile = new JSONObject();
                    try {
                        profile.put("profile_picture_url", profilePictureString(jsonObject.getString("id")));
                        profile.put("facebookId", jsonObject.getString("id"));
                        profile.put("name", jsonObject.getString("name"));
                        mCurrentUser.put("fb_name", jsonObject.getString("name"));
                        mCurrentUser.put("picture_url", profilePictureString(jsonObject.getString("id")));
                        Log.i(Constants.SPROUT_TAG, profilePictureString(jsonObject.getString("id")));
                        if (jsonObject.getString("gender") != null)
                            profile.put("gender", jsonObject.getString("gender"));
                        if (jsonObject.getString("email") != null) {
                            profile.put("email", jsonObject.getString("email"));
                            mCurrentUser.put("fb_email", jsonObject.getString("email"));
                        }
                        mCurrentUser.put("profile", profile);
                        mCurrentUser.saveInBackground();
                    } catch (JSONException e) {
                        Log.i(Constants.SPROUT_TAG, e.toString());
                    }
                }
            }
        });
        request.executeAsync();
    }

    /**
     * Returns profile picture string from a facebook Id
     */

    private String profilePictureString(String facebookId) {
        return "https://graph.facebook.com/" + facebookId + "/picture?type=large";
    }

    public void switchToWizard(){
        FragmentSuperFind fragmentSuperFind = new FragmentSuperFind();
        FragmentManager fragmentManager = getSupportFragmentManager();
        setActionBarTitle("Find My Super");
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentSuperFind).commit();
    }

    public void switchToSuper(){
        FragmentSupers fragmentSupers = new FragmentSupers();
        FragmentManager fragmentManager = getSupportFragmentManager();
        setActionBarTitle("Found Supers");
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentSupers).commit();
    }

    public void switchToPlant(){
        FragmentPlant fragmentPlant = new FragmentPlant();
        FragmentManager fragmentManager = getSupportFragmentManager();
        setActionBarTitle("Your Sprout");
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentPlant).commit();
    }

    public void switchToAge(){
        FragmentAge fragmentAge = new FragmentAge();
        FragmentManager fragmentManager = getSupportFragmentManager();
        setActionBarTitle("Invest");
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentAge).commit();
    }

    public void switchToGrowth(){
        FragmentGlobalGrowth fragmentGlobalGrowth = new FragmentGlobalGrowth();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentGlobalGrowth).commit();
    }

    public void switchToSalary(){
        FragmentSalary fragmentSalary = new FragmentSalary();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentSalary).commit();
    }

    public void switchToImportance(){
        FragmentImportance fragmentImportance = new FragmentImportance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentImportance).commit();
    }

    public void switchToStock(){
        FragmentStock fragmentStock = new FragmentStock();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentStock).commit();
    }

    public void switchToOverview(){
        FragmentOverview fragmentOverview = new FragmentOverview();
        FragmentManager fragmentManager = getSupportFragmentManager();
        setActionBarTitle("Account Overview");
        fragmentManager.beginTransaction().replace(mContainerRes, fragmentOverview).commit();
    }



    public void setActionBarTitle(String title){
        setTitle(title);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }




}