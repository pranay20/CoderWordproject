package com.example.codersword;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;


public class StartigPoint extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_startig_point);
        Thread timer = new Thread()
        {
        	public void run()
        	{
        		try {
        				Thread.sleep(2000);
        				startActivity(new Intent("android.intent.action.MENU"));
        				finish();
        	} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        	}
        	}
    };
    timer.start();
    
   }


}
