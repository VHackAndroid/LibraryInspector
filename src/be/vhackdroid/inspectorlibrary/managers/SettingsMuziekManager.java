package be.vhackdroid.inspectorlibrary.managers;

import android.content.SharedPreferences;

public class SettingsMuziekManager {

	public static final String PREF_FILE = "INSPECTOR_LIBRARY_PREFERENCES";
	
	public static void setStatusGitaar(SharedPreferences pref, boolean status){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("MuziekGitaar", status);
		editor.commit();
	}
	
	public static boolean getStatusGitaar(SharedPreferences pref){
		return pref.getBoolean("MuziekGitaar", false);
	}
	
	public static void setStatusPiano(SharedPreferences pref, boolean status){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("MuziekPiano", status);
		editor.commit();
	}
	
	public static boolean getStatusPiano(SharedPreferences pref){
		return pref.getBoolean("MuziekPiano", false);
	}
	
	public static void setStatusDrums(SharedPreferences pref, boolean status){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("MuziekDrums", status);
		editor.commit();
	}
	
	public static boolean getStatusDrums(SharedPreferences pref){
		return pref.getBoolean("MuziekDrums", false);
	}
	
	public static void setStatusSax(SharedPreferences pref, boolean status){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("MuziekSax", status);
		editor.commit();
	}
	
	public static boolean getStatusSax(SharedPreferences pref){
		return pref.getBoolean("MuziekSax", false);
	}
	
	public static boolean isFirstMuziekBoot(SharedPreferences pref){
		return pref.getBoolean("firstBootMuziek", true);
	}
	
	public static void setFirstMuziekBoot(SharedPreferences pref, boolean status){
		SharedPreferences.Editor editor = pref.edit();
		editor.putBoolean("firstBootMuziek", status);
		editor.commit();
	}
}