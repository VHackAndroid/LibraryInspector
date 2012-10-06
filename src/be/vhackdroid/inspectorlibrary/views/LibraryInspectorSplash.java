package be.vhackdroid.inspectorlibrary.views;

import be.vhackdroid.inspectorlibrary.R;
import be.vhackdroid.inspectorlibrary.database.DBCreator;
import be.vhackdroid.inspectorlibrary.settings.SettingsManager;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

public class LibraryInspectorSplash extends Activity {

	boolean active = true;
	int splashTime = 2500;
	Context context;
	SharedPreferences prefs;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);

		context = this.getApplicationContext();
		prefs = this.getApplicationContext().getSharedPreferences(
				SettingsManager.PREF_FILE, MODE_PRIVATE);
		// thread for counting down the SplashScreen
		Thread splashTread = new Thread() {
			@Override
			public void run() {
				if (SettingsManager.isFirstRun(prefs)) {
					DBCreator.createDB(context);
				}
				try {
					int waited = 0;
					while (active && (waited < splashTime)) {
						sleep(100);
						if (active) {
							waited += 100;
						}
					}
				} catch (InterruptedException e) {
					// do nothing, don't care
				} finally {
					finish();
					// TODO: startActivity(new Intent(context,
					// Dashboard.class));
					stop();
				}
			}
		};
		splashTread.start();

	}
}