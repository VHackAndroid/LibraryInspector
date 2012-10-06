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
import android.widget.CheckBox;
import android.widget.TextView;
import be.vhackdroid.inspectorlibrary.managers.NfcManager;

public class LibraryInspectorNfcDummy extends Activity {
	// The NFC Adapter.
	// private NfcAdapter mAdapter;
	private NfcManager nfcReader = null;
	// Read mode.
	boolean bReadMode = false;


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
				restart();
			}
		});
	}

	private void restart(){
		Intent i = new Intent();
		i.setClass(LibraryInspectorNfcDummy.this, LibraryInspectorNfcDummy.class);
		startActivity(i);
	}
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
		TextView txtTest = (TextView) findViewById(R.id.textView_test);
		CheckBox box = (CheckBox) findViewById(R.id.checkBox1);
		String id = nfcReader.getTagId();
		String titel = "Geen boek gevonden";
		Boolean found = false;

		String[] aId = {"0408B1193E2581","04085C193E2581","04E937193E2580","040AD3193E2581","0409AA193E2581"};
		String[] aTitles = {"De woordspeler","In the winning mood","Triathlon totaal","Mister Michel","Sportvoeding"};
		
		for(int i=0; i<aId.length; i++){
			if(id.equals(aId[i])){
				titel = aTitles[i];
				i = aId.length;
				found=true;
			}
		}
		box.setChecked(found);
		txtTest.setText(titel);
	}

}
