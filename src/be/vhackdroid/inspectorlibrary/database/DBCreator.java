package be.vhackdroid.inspectorlibrary.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBCreator {

	public static void createDB(Context context){
		
		SQLiteDatabase db = context.openOrCreateDatabase("inspectorlibrary.db", Context.MODE_PRIVATE, null);
		
		// CREATE TABLES
		db.execSQL("CREATE TABLE IF NOT EXISTS tblBooks(" +
				"id INT, titel VARCHAR, barcode VARCHAR, hired INT)");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS tblBooksThemes(" +
				"id INT, bookId INT, themeId INT)");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS tblThemes(" +
				"id INT, naam VARCHAR)");
		
		//Create Data
		createBooks(db);
		createThemes(db);
		createBookThemes(db);
		
		db.close();
	}
	
	private static void createBooks(SQLiteDatabase db){
		db.execSQL("INSERT INTO tblBooks(id, titel, barcode, hired) VALUES(" +
				"1, 'Boek1', '01030063020', 0)");
	}
	
	private static void createThemes(SQLiteDatabase  db){
		
	
	}
	
	private static void createBookThemes(SQLiteDatabase db){
	
		
	}
}