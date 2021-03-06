package com.timer.biologyexperimenttimer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.biologyexperimenttimer.R;
import com.timer.common.ClockTicking;

public class Dashboard extends BaseActivityClass {

	// private Timer potocolTimer = new ProtocolTimer();
	// private TimersObjectContainer countDownTimersContainer = new
	// TimersObjectContainer();
	private TextView countDownTimerTextView;
	private List<Button> mButtons = new ArrayList<Button>();
	private List<CountDownTimerWithActiveIndicator> mCountDownTimers = new ArrayList<CountDownTimerWithActiveIndicator>();
	private CountDownTimerWithActiveIndicator mCurrentCountDownTimer;
	public final int NUM_OF_DISPLAY_BUTTONS = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dashboard);
		countDownTimerTextView = (TextView) findViewById(R.id.timerCountDown);
		ClockTicking clockTicking = new ClockTicking(this);
		clockTicking.startClock();
		setTimer();
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
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
*/
	public Button addNewButton(final int ID) {
		Button button = new Button(this);

		final String text = "T" + Integer.toString(ID);
		button.setText(text);

		LinearLayout ll = (LinearLayout) findViewById(R.id.timersButtonContiner);
		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		ll.addView(button, lp);
		mButtons.add(button);
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mCurrentCountDownTimer.disable();
				mCurrentCountDownTimer = mCountDownTimers.get(ID - 1);
				System.out.println(ID - 1);
				mCurrentCountDownTimer.enable();
			}
		});
		return button;
	}

	class CountDownTimerWithActiveIndicator extends CountDownTimer {

		private boolean mIsActive = false;

		public CountDownTimerWithActiveIndicator(long millisInFuture,
				long countDownInterval, boolean isActive) {
			super(millisInFuture, countDownInterval);
			mIsActive = isActive;
		}

		public void enable() {
			mIsActive = true;
		}

		public void disable() {
			mIsActive = false;
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			if (mIsActive) {
				countDownTimerTextView.setText("done~");
			}
		}

		@Override
		public void onTick(long millisUntilFinished) {
			// TODO Auto-generated method stub
			if (mIsActive) {
				countDownTimerTextView.setText("seconds remaining: "
						+ millisUntilFinished / 1000);
			}
		}

	}

	public void onFinishedTimePicker(int enteredTime) {

		if (mCurrentCountDownTimer != null) {
			mCurrentCountDownTimer.disable();
		}
		mCurrentCountDownTimer = new CountDownTimerWithActiveIndicator(
				enteredTime * 1000, 1000, true);
		mCountDownTimers.add(mCurrentCountDownTimer);
		mCurrentCountDownTimer.start();
		
		addNewButton(mCountDownTimers.size());

	}

	private void setTimer() {
		TextView countDownTimer = (TextView) findViewById(R.id.timerCountDown);
		countDownTimer.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment timePickerFragmentDialogue = new TimePickerFragmentDialogue();
				timePickerFragmentDialogue.show(getSupportFragmentManager()
						.beginTransaction(), "yes");
			}
		});

	}

}
