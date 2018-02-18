package com.example.treyn.compliplenty;

import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.WatchViewStub;
import android.widget.TextView;

public class Contacts {
    private final int name;

    public Contacts(int name){
        this.name = name;
    }

    public int getName() { return name;}
}