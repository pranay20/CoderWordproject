package com.example.codersword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.R.menu;
import android.R.raw;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class HighScore extends Activity {
	TextView[] t;
	int s,ps;
	String l;
	SharedPreferences sharedPref;
	Editor editor;
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			t=new TextView[4];
			setContentView(R.layout.highscore);
			l="";
			s=0;
			t[0]=(TextView) findViewById(R.id.hs_tv1);
			t[1]=(TextView) findViewById(R.id.hs_tv2);
			t[2]=(TextView) findViewById(R.id.hs_tv3);
			t[3]=(TextView) findViewById(R.id.hs_tv4);
				
			sharedPref=getSharedPreferences("MyPrefences", Context.MODE_PRIVATE);
			ps=sharedPref.getInt("cscore", 0);
			t[0].setText("C : "+ps);
			
			ps=sharedPref.getInt("cpscore", 0);
			t[1].setText("C++ : "+ps);
			
			ps=sharedPref.getInt("jscore", 0);
			t[2].setText("Java : "+ps);
			
			ps=sharedPref.getInt("chscore", 0);
			t[3].setText("C# : "+ps);
			
		}
		@Override
		public void onBackPressed() {
			// TODO Auto-generated method stub
			super.onBackPressed();
			Intent i=new Intent(HighScore.this,Menu.class);
			startActivity(i);
			finish();
		}
}
