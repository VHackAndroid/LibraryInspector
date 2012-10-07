package be.vhackdroid.inspectorlibrary.views;

import be.vhackdroid.inspectorlibrary.managers.SettingsManager;
import be.vhackdroid.inspectorlibrary.managers.SettingsMuziekManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LibraryInspectorThemeSport extends LibraryInspectorNfcDummy {
	
	private Context context;
	private SharedPreferences prefs;
	private static String THEME = "Sport";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themesport);
		
		context = this;
		ImageView helpButton = (ImageView) findViewById(R.id.themesSportHelpKnop);
		helpButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorThemeSportHelp.class));
			}
		});
		
		//TODO handle intent parameter
		
		   prefs = this.getApplicationContext().getSharedPreferences(
					SettingsManager.PREF_FILE, MODE_PRIVATE);
		   
		  // checkStatusItems();
		   
		 //if first time start up muziek, then boot help
		   if(SettingsManager.isFirstBootSport(prefs)){
			   finish();
			   startActivity(new Intent(context, LibraryInspectorThemeSportHelp.class));
			   SettingsManager.setFirstBootSport(prefs, false);
		   }	
	}
}