package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;

public class LibraryInspectorThemeDierenHelp extends Activity {
	@Override
	protected void onChildTitleChanged(Activity childActivity,
			CharSequence title) {
		super.onChildTitleChanged(childActivity, title);
		setContentView(R.layout.themedierenhelp);
	}
}
