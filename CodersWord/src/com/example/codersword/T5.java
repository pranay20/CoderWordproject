package com.example.codersword;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import com.example.codersword.R.color;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings.Global;
import android.text.style.BackgroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class T5 extends Activity {
	TextView tv,tv2;
	Button b[];
	int n1[];
	int n=5;
	private ProgressBar progressBar;
	private int progressStatus=10;
	private Handler handler= new Handler();
	int c=0;
	int cnt=0;
	
	String l;
	String s;
	String s1;
	Bundle extras;
	Intent intent;
	void getString(String a)
	{
		s1 = ""+s1+a;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.t5);
		tv=(TextView)findViewById(R.id.t5_tv1);
		tv2=(TextView) findViewById(R.id.t5_tv2);
		Random r=new Random();
		s1="";
		l="";
		int j=0;
		s="";
		b=new Button[n];
		n1=new int[n];
		Set<Integer> set=new LinkedHashSet<Integer>();
		while(set.size()<n){
			set.add(r.nextInt(n));
			
		}
		Iterator<Integer> it=set.iterator();
		while(it.hasNext())
			n1[j++]=it.next();
		
		  if(savedInstanceState==null){
				Bundle extras=getIntent().getExtras();
				if(extras==null){
					s=null;
					l=null;
				}
				else{
					l=extras.getString("lang");
					progressStatus=extras.getInt("pgstatus");
					s=extras.getString("word");
				}
			}else{
				l=(String) savedInstanceState.getSerializable("lang");
				progressStatus=(Integer) savedInstanceState.getSerializable("pgstatus");
				s=(String) savedInstanceState.getSerializable("word");
			}
		  	tv2.setText(s1);
		 
		
			//Toast.makeText(T4.this, l,Toast.LENGTH_LONG).show();
	
			tv.setText(l+" Language ");
			b[0]=(Button) findViewById(R.id.t5_b1);
			b[1]=(Button) findViewById(R.id.t5_b2);
			b[2]=(Button) findViewById(R.id.t5_b3);
			b[3]=(Button) findViewById(R.id.t5_b4);
			b[4]=(Button) findViewById(R.id.t5_b5);
			for(int i=0;i<n;i++)
			{
				
				b[i].setText(""+s.charAt(n1[i]));
			
			}
			
			b[0].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
						b[0].setBackgroundColor(color.buttonclick);
						getString((String) b[0].getText());
							 tv2.setText(s1);
							c++;
							
							
						
				}
			});
			
b[1].setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					b[1].setBackgroundColor(color.buttonclick);
					getString((String) b[1].getText());
					tv2.setText(s1);
					c++;
					
				}
			});

b[2].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		b[2].setBackgroundColor(color.buttonclick);
		getString((String) b[2].getText());
		tv2.setText(s1);
		c++;
		
		}
});

b[3].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		b[3].setBackgroundColor(color.buttonclick);
		getString((String) b[3].getText());
		 tv2.setText(s1);
		c++;
		
		
	}
});
			

b[4].setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		b[4].setBackgroundColor(color.buttonclick);
		getString((String) b[4].getText());
		 tv2.setText(s1);
		c++;
		
		
	}
});
			
			// Code for progress bar
			progressBar = (ProgressBar) findViewById(R.id.t5_pb1);
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					while(progressStatus > 0){
						progressStatus -= 1;
					handler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							intent=new Intent(T5.this,Prgc.class);;
						
								if(l.equals("C++")){
									intent=new Intent(T5.this,Prgcp.class);
									}
								else if(l.equals("Java")){
									 intent=new Intent(T5.this,Prgj.class);
								}
								else if(l.equals("C#")){
								 intent=new Intent(T5.this,Prgch.class);
								}
							progressBar.setProgress(progressStatus);
							
							if(c==n){
								if(s.equals(s1)){
									//Toast.makeText(T4.this, s, Toast.LENGTH_LONG).show();
									for(int i=0;i<n;i++)
									{
										b[i].setBackgroundColor(color.buttonbac);
									}
									intent.putExtra("pgstatus", progressStatus);
									setResult(Activity.RESULT_OK, intent);
									finish();
												}
								else{
									c=0;
									s1="";
									tv2.setText("");
									for(int i=0;i<n;i++){
										b[i].setBackgroundColor(getResources().getColor(R.color.Button2));
									}
								}
									}
							else{								
							}
									if(progressStatus==0){
									intent.putExtra("pgstatus", progressStatus);
									setResult(Activity.RESULT_OK, intent);
									finish();
													}
							
											}
					});
				try
				{
					Thread.sleep(100);
				}
				catch(InterruptedException e)
				{
					e.printStackTrace();
				}
				}
				}
			}).start();
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		
		cnt++;
		if(cnt==1)
		Toast.makeText(T5.this, "Press again to go back", Toast.LENGTH_SHORT).show();
		if(cnt==2){
			super.onBackPressed();	
		intent.putExtra("pgstatus", progressStatus);
		setResult(Activity.RESULT_CANCELED, intent);
		finish();
		}
	}

}
