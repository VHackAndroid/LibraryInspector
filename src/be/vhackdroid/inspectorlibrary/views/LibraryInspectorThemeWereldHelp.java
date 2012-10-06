package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;

public class LibraryInspectorThemeWereldHelp extends LibraryInspectorNfcDummy {
	@Override
	public void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		super.onChildTitleChanged(childActivity, title);
		setContentView(R.layout.themewereldhelp);
	}
}