package com.pamela.zeballos.version1;
import android.app.Application;

import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseUser;
/**
 * Created by Zeballos on 11/18/15.
 */
public class StarterApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "crkoKcmoPJibL0vesZoChlncCnm3KxJ5X85BP26Y", "m0CnutU0puprEwHitWaCDzH5eroFlSTUMTm80wgN");


        // Add your initialization code here
       // Parse.initialize(this);

        ParseUser.enableAutomaticUser();
        ParseACL defaultACL = new ParseACL();
        // Optionally enable public read access.
        // defaultACL.setPublicReadAccess(true);
        ParseACL.setDefaultACL(defaultACL, true);
    }
}
