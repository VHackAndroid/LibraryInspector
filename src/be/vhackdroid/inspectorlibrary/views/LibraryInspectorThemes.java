package be.vhackdroid.inspectorlibrary.views;

import be.vhackdroid.inspectorlibrary.managers.SettingsManager;
import be.vhackdroid.inspectorlibrary.managers.SettingsMuziekManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class LibraryInspectorThemes extends LibraryInspectorNfcDummy {
	
	private Context context;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themepicker);
		
		context = this;
		
		
		ImageView pijlMuziek = (ImageView) findViewById(R.id.themesButton1);
		pijlMuziek.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorThemeMuziek.class));
			}
		});
		
		ImageView pijlWereld = (ImageView) findViewById(R.id.themesButton2);
		pijlWereld.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorThemeWereld.class));
			}
		});
		
		ImageView pijlDieren= (ImageView) findViewById(R.id.themesButton3);
		pijlDieren.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorThemeDieren.class));
			}
		});
		
		ImageView pijlSport = (ImageView) findViewById(R.id.themesButton4);
		pijlSport.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorThemeSport.class));
			}
		});
		
		ImageView pijlTaal = (ImageView) findViewById(R.id.themesButton5);
		pijlTaal.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorThemeTaal.class));
			}
		});
		
		ImageView pijlGeloof = (ImageView) findViewById(R.id.themesButton6);
		pijlGeloof.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorNfcDummy.class));
			}
		});
		
		checkKeys();		
	}
	
	private void checkKeys(){
		SharedPreferences prefs = this.getApplicationContext().getSharedPreferences(
				SettingsManager.PREF_FILE, MODE_PRIVATE);
		
		ImageView sleutelMuziek = (ImageView) findViewById(R.id.themesKeyMuziek);
		ImageView sleutelWereld = (ImageView) findViewById(R.id.themesKeyWereld);
		ImageView sleutelGeloof = (ImageView) findViewById(R.id.themesKeyGeloof);
		ImageView sleutelTaal = (ImageView) findViewById(R.id.themesKeyTaal);
		ImageView sleutelSport = (ImageView) findViewById(R.id.themesKeySport);
		ImageView sleutelDieren = (ImageView) findViewById(R.id.themesKeyDieren);
		
		Bitmap bmpStatus0 = BitmapFactory.decodeResource(getResources(), R.drawable.keystatus0);
		Bitmap bmpStatus1 = BitmapFactory.decodeResource(getResources(), R.drawable.keystatus1);
		
		if (SettingsMuziekManager.getStatusDrums(prefs) && SettingsMuziekManager.getStatusGitaar(prefs) &&
				SettingsMuziekManager.getStatusPiano(prefs) && SettingsMuziekManager.getStatusSax(prefs)){
			sleutelMuziek.setImageBitmap(bmpStatus1);
		}else{
			sleutelMuziek.setImageBitmap(bmpStatus0);
		}
		//andere categoriëen
		
		if (true){
			sleutelGeloof.setImageBitmap(bmpStatus1);
			sleutelDieren.setImageBitmap(bmpStatus1);
			sleutelSport.setImageBitmap(bmpStatus1);
			sleutelTaal.setImageBitmap(bmpStatus1);
			sleutelWereld.setImageBitmap(bmpStatus1);
			
			SettingsManager.setStatusKey(prefs, 2,true);
			SettingsManager.setStatusKey(prefs, 3,true);
			SettingsManager.setStatusKey(prefs, 4,true);
			SettingsManager.setStatusKey(prefs, 5,true);
			SettingsManager.setStatusKey(prefs, 6,true);
		}
		//TODO: OTHER KEYS
		

		if(SettingsManager.getStatusKey(prefs, 1) && (SettingsManager.getStatusKey(prefs, 2)) && (SettingsManager.getStatusKey(prefs, 3)) &&
			(SettingsManager.getStatusKey(prefs, 4)) && (SettingsManager.getStatusKey(prefs, 5))){
			popup("Alles is opgelost");
			Button btn = (Button) findViewById(R.id.btnFinish);
			btn.setVisibility(View.VISIBLE);
			btn.setOnClickListener(new OnClickListener() {				
				@Override
				public void onClick(View v) {
					finish();
					startActivity(new Intent(context, LibraryInspectorEinde.class));
				}
			});
		}
	}
	
	
	
	public void onResume(){
		super.onResume();
		checkKeys();
	}
}