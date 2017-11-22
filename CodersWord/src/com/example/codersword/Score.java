package com.example.codersword;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;

import com.example.codersword.R.color;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends Activity {
	int score=0;
	TextView tv,tvw;
	Button b,p;
	Intent intent;
	String l,a;
	int ps;
	SharedPreferences sharedPref;
	Editor editor;
	int f=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.score);
		tv=(TextView) findViewById(R.id.sc_tv2);
		tvw=(TextView) findViewById(R.id.sc_ntvw);
		l="";
		a="";
		b=(Button) findViewById(R.id.sc_bb);
		p=(Button) findViewById(R.id.sc_bpa);
		
		  if(savedInstanceState==null){
				Bundle extras=getIntent().getExtras();
				if(extras==null){
					score=0;
					l=null;
					a=null;
				}
				else{
					score=extras.getInt("score");
					l=extras.getString("lang");
					a=extras.getString("word");
				}
			}else{
				score=(Integer) savedInstanceState.getSerializable("score");
				l=(String) savedInstanceState.getSerializable("lang");
				a=(String) savedInstanceState.getSerializable("word");
			}
		  score--;
		tv.setText(""+score);
		tvw.setText(a);
		sharedPref=getSharedPreferences("MyPrefences", Context.MODE_PRIVATE);
		

//		Toast.makeText(Score.this, ""+ps, Toast.LENGTH_SHORT).show();
	//	Toast.makeText(Score.this, ""+score, Toast.LENGTH_SHORT).show();
		if(l.equals("C")){
			f=1;
		ps=sharedPref.getInt("cscore", 0);
		}
		else if(l.equals("C++")){
			f=2;
		ps=sharedPref.getInt("cpscore", 0);
		}
		else if(l.equals("Java")){
			f=3;
		ps=sharedPref.getInt("jscore", 0);
		}
		else if(l.equals("C#")){
			f=4;
		ps=sharedPref.getInt("chscore", 0);
		}
		
		editor=sharedPref.edit();
			
		if(ps<score){
				switch(f){
					case 1:
						editor.putInt("cscore", score);
						editor.commit();
						break;
					case 2:
						editor.putInt("cpscore", score);
						editor.commit();
						break;
					case 3:	
						editor.putInt("jscore", score);
						editor.commit();
						break;
					case 4:
						editor.putInt("chscore", score);
						editor.commit();
						break;
				}				
//			ps=sharedPref.getInt("cscore", 0);
	//		Toast.makeText(Score.this, "ps="+ps, Toast.LENGTH_SHORT).show();
		}
							
		
		b.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent=new Intent(Score.this,Menu.class);
				startActivity(intent);
				finish();
			}
		});
		p.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				intent=new Intent(Score.this,NewGame.class);
				startActivity(intent);
				finish();
			}
		});
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
	}
}
