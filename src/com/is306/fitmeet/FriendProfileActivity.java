package com.is306.fitmeet;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
//import android.support.v4.app.NavUtils;
import android.widget.TextView;

public class FriendProfileActivity extends Activity {
	
	TextView name, gender, age, hobbies;
	ArrayList<String> hobbiesList = new ArrayList<String>();
	User user;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_friend_profile);
		// Show the Up button in the action bar.
		setupActionBar();
		user = UsersDAO.friendChosen;
		setTitle(user.getUsername()+"'s Profile");
		name = (TextView)this.findViewById(R.id.activity_friend_profile_name);
		name.setText(user.getName());
		gender =(TextView) this.findViewById(R.id.activity_friend_profile_gender);
		gender.setText(user.getGender());
		age = (TextView)this.findViewById(R.id.activity_friend_profile_age);
		age.setText(""+user.getAge());
		hobbies=(TextView)this.findViewById(R.id.activity_friend_profile_hobbies);
		hobbies.setText(user.getHobbiesAsString());
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.friend_profile, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void createEventFromFriend(View view){
		Intent intent = new Intent(this, CreateEventActivity.class);
		startActivity(intent);
	}

}
