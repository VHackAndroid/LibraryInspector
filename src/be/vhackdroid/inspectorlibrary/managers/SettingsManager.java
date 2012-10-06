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
}