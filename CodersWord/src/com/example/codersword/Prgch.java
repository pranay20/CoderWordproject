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

public class Prgch extends Activity {
	int i;
	private int progressStatus = 100;
	Random r;
	String[] w={"suspend","resume","start","stop","Thread","adapter","catch","foreach","goto","null",
			"switch","join","global","console","type","readkey","tobyte","tochar","toint16","toint32",
			"decimal","true","false","system","double","while","break","public","private","main","string",
			"length"};
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
				intent=new Intent(Prgch.this,NewGame.class);
				startActivity(intent);
				finish();
			}
		if(resultCode==Activity.RESULT_OK){
			
			p=data.getIntExtra("pgstatus", 0);
			if(i==z){
				Toast.makeText(Prgch.this, ""+i,Toast.LENGTH_LONG).show();
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
				Toast.makeText(Prgch.this, "Game Over",Toast.LENGTH_LONG).show();
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
						Intent sc=new Intent(Prgch.this,Score.class);
						sc.putExtra("score", i);
						sc.putExtra("lang", "C#");
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
		
		setContentView(R.layout.prgch);
		
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
								intent=new Intent(Prgch.this,T4.class);
								intent.putExtra("lang", "C#");
								intent.putExtra("pgstatus", 100);
								
								intent.putExtra("word", a);
								startActivityForResult(intent, 1);
								i++;
								f=false;
								break;
							case 5:
								intent=new Intent(Prgch.this,T5.class);
								intent.putExtra("lang", "C#");
								intent.putExtra("pgstatus", 100);
								intent.putExtra("word", a);
								startActivityForResult(intent, 1);
								i++;
								f=false;
								break;
							case 6:
								intent=new Intent(Prgch.this,T6.class);
								intent.putExtra("lang", "C#");
								intent.putExtra("pgstatus", 100);
								intent.putExtra("word", a);
								startActivityForResult(intent, 1);
								i++;
								f=false;
								break;
							case 7:
								intent=new Intent(Prgch.this,T7.class);
								intent.putExtra("lang", "C#");
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
					
		
				
	