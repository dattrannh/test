package com.example.asynctask_listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	myasynctask my;
	Button but;
	EditText txt;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		my=new myasynctask(this);
		but=(Button)findViewById(R.id.button1);
		txt=(EditText)findViewById(R.id.editText1);
		but.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {	
				start();
			}
		});
	}

	public void start(){
		int so=Integer.parseInt(txt.getText().toString());
		my.execute(so);
	}

}
