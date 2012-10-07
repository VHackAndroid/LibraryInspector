package be.vhackdroid.inspectorlibrary.views;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LibraryInspectorThemeMuziek extends LibraryInspectorNfcDummy {

	private Context context;
	
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
	}
}