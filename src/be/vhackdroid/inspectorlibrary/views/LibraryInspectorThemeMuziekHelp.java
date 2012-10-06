package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LibraryInspectorThemeMuziekHelp extends Activity {
	
	private int currentImage = -1;
	private Bitmap[] images = new Bitmap[4];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thememuziekhelp);
		
		// Init Images
		images[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.muziek01);
		images[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.muziek02);
		images[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.muziek03);
		images[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.muziek04);
		
		ImageView arrow = (ImageView) findViewById(R.id.introComicArrow);
		arrow.setOnClickListener(new ArrowClicker());

		setNextImage();
	}
	
	private void setNextImage() {
		currentImage++;
		if (currentImage < images.length) {
			ImageView imageView = (ImageView) findViewById(R.id.muziekHelpComic);
			imageView.setImageBitmap(images[currentImage]);
		} else {
			finish();
			startActivity(new Intent(this, LibraryInspectorThemeMuziek.class));
		}
	}

	private class ArrowClicker implements OnClickListener {
		@Override
		public void onClick(View v) {
			setNextImage();
		}
	}
}