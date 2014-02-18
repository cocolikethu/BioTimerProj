package com.timer.biologyexperimenttimer;

import com.example.biologyexperimenttimer.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddProtocalTimer extends FragmentActivity{

	private Button save_protocol_button;
	private Button add_step_button;
	private Button search_protocol_button;


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_timer);

		FragmentManager fragManager = getSupportFragmentManager();
		Fragment theFragment = fragManager.findFragmentById(R.id.prococal_setup_row_container);

		if(theFragment == null){
			theFragment = new Protocol_step_list_fragment();
			fragManager.beginTransaction()
			.add(R.id.prococal_setup_row_container, theFragment)
			.commit();

		}

		add_step_button = (Button) findViewById(R.id.add_step_button);
		add_step_button.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View view) {
				Protocol_step_list_fragment steplistFragment = (Protocol_step_list_fragment) getSupportFragmentManager().findFragmentById(R.id.prococal_setup_row_container);
				steplistFragment.add_a_step();
			}
		});

	}

}
