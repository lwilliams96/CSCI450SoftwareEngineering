package com.example.treyn.compliplenty;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;
import android.app.Application;

public class MyApp extends Application {

    private Boolean loggedIn = false;

    public Boolean getLoggedIn()
    {
        return loggedIn;
    }

    public void setLoggedIn(Boolean bool)
    {
        loggedIn = bool;
    }

}