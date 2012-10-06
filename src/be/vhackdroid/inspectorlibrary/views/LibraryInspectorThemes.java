package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LibraryInspectorThemes extends Activity {
	
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
				startActivity(new Intent(context, LibraryInspectorThemeMuziek.class));
			}
		});
	}
}