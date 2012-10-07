package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LibraryInspectorEinde extends LibraryInspectorNfcDummy {

	private int currentImage = -1;
	private Bitmap[] images = new Bitmap[4];

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.einde);

		// Init Images
		images[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.einde01);
		images[1] = BitmapFactory.decodeResource(getResources(),
				R.drawable.einde02);
		images[2] = BitmapFactory.decodeResource(getResources(),
				R.drawable.einde03);
		images[3] = BitmapFactory.decodeResource(getResources(),
				R.drawable.einde04);

		ImageView arrow = (ImageView) findViewById(R.id.EindeArrow);
		arrow.setOnClickListener(new ArrowClicker());

		setNextImage();

		MediaPlayer mp = MediaPlayer.create(this, R.raw.tada);
		mp.start();
	}

	private void setNextImage() {
		currentImage++;
		if (currentImage < images.length) {
			ImageView imageView = (ImageView) findViewById(R.id.eindeComic);
			imageView.setImageBitmap(images[currentImage]);
		} else {
			finish();
			startActivity(new Intent(this, LibraryInspectorThemes.class));
		}
	}

	private class ArrowClicker implements OnClickListener {
		@Override
		public void onClick(View v) {
			setNextImage();
		}
	}
}
