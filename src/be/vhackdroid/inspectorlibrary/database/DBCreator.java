package be.vhackdroid.inspectorlibrary.database;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DBCreator {

	public static void createDB(Context context){
		
		SQLiteDatabase db = context.openOrCreateDatabase("inspectorlibrary.db", Context.MODE_PRIVATE, null);
		
		// CREATE TABLES
		db.execSQL("CREATE TABLE IF NOT EXISTS tblBooks(" +
				"id INT, titel VARCHAR, barcode INT, hired BOOLEAN)");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS tblBooksThemes(" +
				"id INT, bookId INT, themeId INT)");
		
		db.execSQL("CREATE TABLE IF NOT EXISTS tblThemes(" +
				"id INT, naam VARCHAR)");
		
		//Create Data
		createBooks(db);
		createThemes(db);
		createBookThemes(db);
	}
	
	private static void createBooks(SQLiteDatabase db){
		
	
	}
	
	private static void createThemes(SQLiteDatabase  db){
		
	
	}
	
	private static void createBookThemes(SQLiteDatabase db){
	
		
	}
}