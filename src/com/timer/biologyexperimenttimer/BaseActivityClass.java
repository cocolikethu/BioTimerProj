package com.timer.biologyexperimenttimer;

import com.example.biologyexperimenttimer.R;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

public abstract class BaseActivityClass extends FragmentActivity{

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.dashboard, menu);

		return true;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.favorite_menu:
			Intent favintent = new Intent(this, FavoriteAndRecent.class);
			startActivity(favintent);
			break;
		case R.id.action_add:
			Intent addintent = new Intent(this, AddProtocalTimer.class);
			startActivity(addintent);
			break;	
		default:
		}
		return super.onOptionsItemSelected(item);
	}
}
