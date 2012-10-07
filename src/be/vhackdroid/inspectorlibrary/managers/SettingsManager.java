package be.vhackdroid.inspectorlibrary.managers;

import android.content.SharedPreferences;

public class SettingsManager {

	public static final String PREF_FILE = "INSPECTOR_LIBRARY_PREFERENCES";

	public static boolean isFirstRun(SharedPreferences pref) {
		return pref.getBoolean("firstRun", true);
	}

	public void saveFirstRun(SharedPreferences pref, boolean firstRun) {
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("firstRun", firstRun);
		editor.commit();
	}
	
	public static void initGame(SharedPreferences pref){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("StatusKey1", false);
		editor.putBoolean("StatusKey2", false);
		editor.putBoolean("StatusKey3", false);
		editor.putBoolean("StatusKey4", false);
		editor.putBoolean("StatusKey5", false);
		editor.putBoolean("StatusKey6", false);
		editor.commit();
	}
	
	public static Boolean getStatusKey(SharedPreferences pref, int keyNumber){
		return pref.getBoolean("StatusKey" + keyNumber, false);	
	}
	
	public static void setStatusKey(SharedPreferences pref, int keyNumber, boolean status){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("StatusKey" + keyNumber, status);
		editor.commit();
	}
	
	public static Boolean isFirstBootSport(SharedPreferences pref){
		return pref.getBoolean("FirstBootSport", true);	
	}
	
	public static void setFirstBootSport(SharedPreferences pref, boolean status){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("FirstBootSport", status);
		editor.commit();
	}
}