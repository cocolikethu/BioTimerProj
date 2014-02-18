package com.timer.biologyexperimenttimer;

import com.example.biologyexperimenttimer.R;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Protocol_step_list_fragment extends Fragment{

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		 View theView = inflater.inflate(R.layout.step_detail_fragment, container, false);
		return theView;
	}
	
	public void add_a_step()
	{
		Context activity_context = getActivity();
		/* Find Tablelayout defined in main.xml */
		TableLayout tl = (TableLayout) getActivity().findViewById(R.id.TableLayout1);
		TableRow tr_step = new TableRow(activity_context);
		tr_step.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		TableRow tr_time = new TableRow(activity_context);
		tr_time.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
	   
		EditText step_name_text = new EditText(activity_context);
		step_name_text.setHint(R.string.step_name);
		step_name_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
		
		step_name_text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		tr_step.setPadding(0, 10, 0, 0);
		tr_step.addView(step_name_text);
		
		TextView step_time_text = new TextView(activity_context); 
		step_time_text.setHint(R.string.time_zero);
		step_time_text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
		step_time_text.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
		tr_time.setPadding(20, 0, 0, 0);
		tr_time.setClickable(true);
		
		tr_time.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DialogFragment timePickerFragmentDialogue = new TimePickerFragmentDialogue();
				timePickerFragmentDialogue.show(getActivity().getSupportFragmentManager()
						.beginTransaction(), "yes");
				
			}
			
		});//add OnClickListener Here
		tr_time.addView(step_time_text);
		
		tl.addView(tr_step, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
		tl.addView(tr_time, new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
	}

}
