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
import android.widget.ImageView;

public class LibraryInspectorThemeMuziek extends LibraryInspectorNfcDummy {

	private Context context;
	private SharedPreferences prefs;
	private static String THEME = "Muziek";
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thememuziek);
		context = this;
		ImageView helpButton = (ImageView) findViewById(R.id.themesMuziekHelpKnop);
		helpButton.setOnClickListener(new OnClickListener() {			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(context, LibraryInspectorThemeMuziekHelp.class));
			}
		});
		
		//TODO handle intent parameter
		
	   prefs = this.getApplicationContext().getSharedPreferences(
				SettingsManager.PREF_FILE, MODE_PRIVATE);
	   
	   checkStatusItems();
	   
	   //if first time start up muziek, then boot help
	   if(SettingsMuziekManager.isFirstMuziekBoot(prefs)){
		   finish();
		   startActivity(new Intent(context, LibraryInspectorThemeMuziekHelp.class));
		   SettingsMuziekManager.setFirstMuziekBoot(prefs, false);
	   }		
	}
	
	@Override
	public void processTag(){
		super.processTag();
		   if(dbh.isBookElementOfTheme(huidigeId, THEME)){
			   popup("Prima, doe zo verder!");
			   String voorwerp = dbh.getVoorwerpFromBook(huidigeId);
			   if(voorwerp.equals("Gitaar")){
				   SettingsMuziekManager.setStatusGitaar(prefs, true);
			   } else if(voorwerp.equals("Drums")){
				   SettingsMuziekManager.setStatusDrums(prefs, true);
			   } else if(voorwerp.equals("Saxofoon")){
				   SettingsMuziekManager.setStatusSax(prefs, true);
			   } else if(voorwerp.equals("Piano")){
				   SettingsMuziekManager.setStatusPiano(prefs, true);
			   }
		   }
		   
		   checkStatusItems();
	}
	
	private void checkStatusItems(){
		ImageView imgGuitar = (ImageView) findViewById(R.id.themesMuziekGuitar);
		ImageView imgDrums = (ImageView) findViewById(R.id.themesMuziekDrums);
		ImageView imgSax = (ImageView) findViewById(R.id.themesMuziekSax);
		ImageView imgPiano = (ImageView) findViewById(R.id.themesMuziekPiano);
		ImageView imgSleutel = (ImageView) findViewById(R.id.ThemeMuziekSleutel);
		
		if(SettingsMuziekManager.getStatusGitaar(prefs)){			
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.guitarstatus1);
			imgGuitar.setImageBitmap(bmp);
		}else{
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.guitarstatus0);
			imgGuitar.setImageBitmap(bmp);
		}
		if(SettingsMuziekManager.getStatusDrums(prefs)){			
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.drumsstatus1);
			imgDrums.setImageBitmap(bmp);
		}else{
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.drumsstatus0);
			imgDrums.setImageBitmap(bmp);
		}
		if(SettingsMuziekManager.getStatusPiano(prefs)){			
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.pianostatus1);
			imgPiano.setImageBitmap(bmp);
		}else{
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.pianostatus0);
			imgPiano.setImageBitmap(bmp);
		}
		if(SettingsMuziekManager.getStatusSax(prefs)){			
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.saxstatus1);
			imgSax.setImageBitmap(bmp);
		}else{
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.saxstatus0);
			imgSax.setImageBitmap(bmp);
		}
		
		if (SettingsMuziekManager.getStatusGitaar(prefs) && SettingsMuziekManager.getStatusDrums(prefs) &&
				SettingsMuziekManager.getStatusPiano(prefs) && SettingsMuziekManager.getStatusSax(prefs)){
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.keystatus1);
			imgSleutel.setImageBitmap(bmp);
			SettingsManager.setStatusKey(prefs, 1,true);
		}else{
			Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.keystatus0);
			imgSleutel.setImageBitmap(bmp);
		}	
	}
}