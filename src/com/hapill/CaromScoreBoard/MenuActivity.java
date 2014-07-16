package com.hapill.CaromScoreBoard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		
		
		Button gameStart = (Button)findViewById(R.id.game_start);
		gameStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("", "game start");
				Intent intentSubActivity = 
						new Intent(MenuActivity.this, GameActivity.class);
				startActivity(intentSubActivity);
				overridePendingTransition(0,0); // 전환 효과 없애기.
				finish(); // 현재 액티비티 종료 시킴 아예.
			}
		});
		Button stats = (Button)findViewById(R.id.stats);
		stats.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("", "stats");
				
			}
		});
		Button playerInfo = (Button)findViewById(R.id.player_info);
		playerInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.d("", "player Info");
				
			}
		});
	}

}
