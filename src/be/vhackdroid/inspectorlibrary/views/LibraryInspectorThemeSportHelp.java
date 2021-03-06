package be.vhackdroid.inspectorlibrary.views;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LibraryInspectorThemeSportHelp extends LibraryInspectorNfcDummy {
	
	private int currentImage = -1;
	private Bitmap[] images = new Bitmap[4];
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.themesporthelp);
		
		// Init Images
		images[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.sport01);
		images[1] = BitmapFactory.decodeResource(getResources(),
				R.drawable.sport02);
		images[2] = BitmapFactory.decodeResource(getResources(),
				R.drawable.sport03);
		images[3] = BitmapFactory.decodeResource(getResources(),
				R.drawable.sport04);

		ImageView arrow = (ImageView) findViewById(R.id.sportHelpArrow);
		arrow.setOnClickListener(new ArrowClicker());

		setNextImage();
	}
	
	private void setNextImage() {
		currentImage++;
		if (currentImage < images.length) {
			ImageView imageView = (ImageView) findViewById(R.id.sportHelpComic);
			imageView.setImageBitmap(images[currentImage]);
		} else {
			finish();
			startActivity(new Intent(this, LibraryInspectorThemeSport.class));
		}
	}

	private class ArrowClicker implements OnClickListener {
		@Override
		public void onClick(View v) {
			setNextImage();
		}
	}
}
