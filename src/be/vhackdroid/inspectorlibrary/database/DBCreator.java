package be.vhackdroid.inspectorlibrary.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBCreator {

	public static void CreateDB(Context context){
		
		SQLiteDatabase db = context.openOrCreateDatabase("inspectorlibrary.db", Context.MODE_PRIVATE, null);
		
		
		db.execSQL("CREATE TABLE IF NOT EXISTS tblBooks(" + "bookId INT, "
				+ "barcode INT)");
	}
}