package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class LibraryInspectorIntro extends Activity {

	private int currentImage = -1;
	private Bitmap[] images = new Bitmap[7];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.introscreen);

		// Init Images
		images[0] = BitmapFactory.decodeResource(getResources(),
				R.drawable.intro01);
		images[1] = BitmapFactory.decodeResource(getResources(),
				R.drawable.intro02);
		images[2] = BitmapFactory.decodeResource(getResources(),
				R.drawable.intro03);
		images[3] = BitmapFactory.decodeResource(getResources(),
				R.drawable.intro04);
		images[4] = BitmapFactory.decodeResource(getResources(),
				R.drawable.intro05);
		images[5] = BitmapFactory.decodeResource(getResources(),
				R.drawable.intro06);
		images[6] = BitmapFactory.decodeResource(getResources(),
				R.drawable.intro07);

		ImageView arrow = (ImageView) findViewById(R.id.introComicArrow);
		arrow.setOnClickListener(new ArrowClicker());

		setNextImage();
	}

	private void setNextImage() {
		currentImage++;
		if (currentImage < images.length) {
			ImageView imageView = (ImageView) findViewById(R.id.introComic);
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