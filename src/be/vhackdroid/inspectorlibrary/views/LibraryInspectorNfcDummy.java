/*
 * Authors:
 * 
 */
package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import be.vhackdroid.inspectorlibrary.database.DBCreator;
import be.vhackdroid.inspectorlibrary.managers.NfcManager;
import be.vhackdroid.inspectorlibrary.models.Book;
import be.vhackdroid.inspectorlibrary.models.Theme;

public class LibraryInspectorNfcDummy extends Activity {
	// The NFC Adapter.
	// private NfcAdapter mAdapter;
	private NfcManager nfcReader = null;
	// Read mode.
	boolean bReadMode = false;
	//############################################
	//VERY IMPORTANT!!!!!
	private DBCreator dbh = LibraryInspectorSplash.dbh;
	//############################################


	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nfcdummy);

		//Create a new instance of NfcReader.
		nfcReader = new NfcManager(this);
		
		Button btn = (Button)findViewById(R.id.button1);
		
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//restart();
			}
		});
	}

//	private void restart(){
//		Intent i = new Intent();
//		i.setClass(LibraryInspectorNfcDummy.this, LibraryInspectorNfcDummy.class);
//		startActivity(i);
//	}
	/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	*/

	public void onNewIntent(Intent intent) {
		if (nfcReader.isReadMode() == true) {
			setIntent(intent);
			nfcReader.setIntent(intent);
			nfcReader.setReadMode(false);
			if (nfcReader.process() == true) {
				processTag();
			}
		}
	}

	public void onResume() {
		super.onResume();
		nfcReader.enableReadMode();
		nfcReader.processIntent();
	}
	
	public void onPause(){
		super.onPause();
		nfcReader.disableReadMode();
	}
	
	//////////////////////////////////////////////////////////////////////////////////
	public void processTag() {
		String barcode = nfcReader.getTagId();
		
		Book book = dbh.getBookByBarcode(barcode);
		Theme theme = (Theme)dbh.getTheme(book.getThemeId());
		Intent i = null;
		if(book.getTitel().equals("Inspector")){
			popup("Proficiat, laat ons starten!");
			i = new Intent(this, LibraryInspectorIntro.class);
		} else {
			switch(theme.getId()){
			case 0:
				i = new Intent(this, LibraryInspectorThemeMuziek.class);
				break;
			case 1:
				i = new Intent(this, LibraryInspectorThemeWereld.class);
				break;
			case 2:
				i = new Intent(this, LibraryInspectorThemeDieren.class);
				break;
			case 3:
				i = new Intent(this, LibraryInspectorThemeSport.class);
				break;
			case 4:
				i = new Intent(this, LibraryInspectorThemeGeloof.class);
				break;
			}
		}
		startActivity(i);
	}
	
	public void popup(String tekst){
		Toast.makeText(LibraryInspectorNfcDummy.this, tekst, Toast.LENGTH_SHORT).show();
	}

}
