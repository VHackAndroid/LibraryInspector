package be.vhackdroid.inspectorlibrary.views;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import be.vhackdroid.inspectorlibrary.database.DBCreator;
import be.vhackdroid.inspectorlibrary.models.Book;

public class LibraryInspectorStart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);

	}

	protected void onResume(){
		super.onResume();
		test();
	}
	
	public void test(){
		
		DBCreator dbh = LibraryInspectorSplash.dbh;
		Book book = dbh.getBookByBarcode("0408B1193E2581");
		Toast.makeText(LibraryInspectorStart.this, book.getTitel(), Toast.LENGTH_SHORT).show();
	}
}
