package com.example.codersword;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Prgcp extends Activity {
	int i;
	private int progressStatus = 100;
	Random r;
	String[] w={"virtual","seekg","seekp","static","public","void","free","flush","delete","calloc",
			"catch","enum","cout","return","endl","node","public","private","const","class","inline",
			"include","strcat","strcpy","scope","float","double","long","short","signed","pointer",
			"object"};
	Thread th1,th2;
	Intent intent;
	String a;
	int z=30;
	int p=0,p1=1;
	Boolean f=true;
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
	//	notify();
		if(requestCode==1){
			if(resultCode==Activity.RESULT_CANCELED){
				intent=new Intent(Prgcp.this,NewGame.class);
				startActivity(intent);
				finish();
			}
		if(resultCode==Activity.RESULT_OK){
			
			p=data.getIntExtra("pgstatus", 0);
			if(i==z){
				Toast.makeText(Prgcp.this, ""+i,Toast.LENGTH_LONG).show();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finish();
			}
			if(p==0){
				p1=0;
				Toast.makeText(Prgcp.this, "Game Over",Toast.LENGTH_LONG).show();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Thread th3=new Thread(new Runnable(){

					@Override
					public void run() {
						// TODO Auto-generated method stub
						Intent sc=new Intent(Prgcp.this,Score.class);
						sc.putExtra("score", i);
						sc.putExtra("lang", "C++");
						sc.putExtra("word", a);
						startActivity(sc);
						finish();
					}
					
				});
				th3.start();
				
			}
			else{
			//	Toast.makeText(Prgc.this, ""+p,Toast.LENGTH_LONG).show();
				f=true;
				
			}
		}
		
		}
			
	}
	@Override
	protected void onCreate(final Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.prgcp);
		
		r=new Random();
		

		a="";
		i=0;
		th2=new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				int j=0;
				Set<Integer> set=new LinkedHashSet<Integer>();
				while(set.size()<z){
					set.add(r.nextInt(z));
				}
				int[] n1=new int[z];
				Iterator<Integer> it=set.iterator();
				while(it.hasNext())
					n1[j++]=it.next();
					while(i<z){
						while(f==true){
							a=w[n1[i]];
							
							a=a.toUpperCase();
							switch(a.length()){
							case 4:
								intent=new Intent(Prgcp.this,T4.class);
								intent.putExtra("lang", "C++");
								intent.putExtra("pgstatus", 100);
								
								intent.putExtra("word", a);
								startActivityForResult(intent, 1);
								i++;
								f=false;
								break;
							case 5:
								intent=new Intent(Prgcp.this,T5.class);
								intent.putExtra("lang", "C++");
								intent.putExtra("pgstatus", 100);
								intent.putExtra("word", a);
								startActivityForResult(intent, 1);
								i++;
								f=false;
								break;
							case 6:
								intent=new Intent(Prgcp.this,T6.class);
								intent.putExtra("lang", "C++");
								intent.putExtra("pgstatus", 100);
								intent.putExtra("word", a);
								startActivityForResult(intent, 1);
								i++;
								f=false;
								break;
							case 7:
								intent=new Intent(Prgcp.this,T7.class);
								intent.putExtra("lang", "C++");
								intent.putExtra("pgstatus", 100);
								intent.putExtra("word", a);
								startActivityForResult(intent, 1);
								i++;
								f=false;
								break;
							}
							
						}
					if(p1==0)
						break;
					}
			}
			
		});
		th2.start();	
	
	}

	
	}
					
		
				
	