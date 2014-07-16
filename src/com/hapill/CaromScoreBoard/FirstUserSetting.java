package com.hapill.CaromScoreBoard;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


public class FirstUserSetting extends Activity 
{ 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_first_user_setting);
		
		final DBContactHelper db = new DBContactHelper(this);
		
		Contact contact = db.getContact(1);
		if(contact != null)
		{
			
			{
				EditText _edit = (EditText)findViewById(R.id.user_name);
				_edit.setText(contact.getName());
			}
			{
				EditText _edit = (EditText)findViewById(R.id.three_ball_numbers);
				_edit.setText(String.valueOf(contact.getThreeBall()));
			}
			{
				EditText _edit = (EditText)findViewById(R.id.four_ball_numbers);
				_edit.setText(String.valueOf(contact.getFourBall()));
			}
		}
//		DataStorageHub.getInstance().setFileName(getFilesDir() + "user_info.txt");
		
		Button decideButton = (Button)findViewById(R.id.decide);
		decideButton.setOnClickListener(new OnClickListener() { 
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				EditText name = (EditText)findViewById(R.id.user_name);
				EditText threeball = (EditText)findViewById(R.id.three_ball_numbers);
				EditText fourball = (EditText)findViewById(R.id.four_ball_numbers);
				db.addContact(new Contact(name.getText().toString(),  Integer.parseInt(threeball.getText().toString()),
						Integer.parseInt(fourball.getText().toString())));
				
				Intent intentSubActivity = 
						new Intent(FirstUserSetting.this, MenuActivity.class);
				startActivity(intentSubActivity);
				overridePendingTransition(0,0); // 전환 효과 없애기.
				finish(); // 현재 액티비티 종료 시킴 아예.
				// 세팅이 끝난거라고 세팅하고 
				// 사용자 정보를 json 으로 저장한다.
				
			}
		});
	}

	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
