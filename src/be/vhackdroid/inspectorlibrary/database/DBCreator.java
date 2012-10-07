package be.vhackdroid.inspectorlibrary.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import be.vhackdroid.inspectorlibrary.models.Book;
import be.vhackdroid.inspectorlibrary.models.Theme;

public class DBCreator extends SQLiteOpenHelper {

	public DBCreator(Context context) {
		super(context, "inspectorlibrary", null, 1);

		// SQLiteDatabase db =
		// context.openOrCreateDatabase("inspectorlibrary.db",
		// Context.MODE_PRIVATE, null);
		Log.d("DATABASE AANMAKEN", "HAHAHAHAHAHAHAHA");
		// CREATE TABLES
		// db.execSQL("CREATE TABLE IF NOT EXISTS tblBooks(" +
		// "id INT, titel VARCHAR, barcode VARCHAR, hired INT)");
		//
		// db.execSQL("CREATE TABLE IF NOT EXISTS tblThemes(" +
		// "id INT, naam VARCHAR)");

		// Create Data
		// createBooks(db);
		// createThemes(db);

		// db.close();
	}

	private void createBooks(SQLiteDatabase db) {
		String[] titels = { "De woordspeler", "In the winning mood",
				"Triathlon totaal", "Sportvoeding", "Inspector","Paul McCartney: a leaf for piano", "Practical theory for guitar", "Kijk eens wat ik kan!", "Rock of Ages" };
		String[] barcodes = { "0408B1193E2581", "04085C193E2581",
				"04E937193E2580", "0409AA193E2581", "0409D3193E2581", "04E6EA193E2580", "04FA8D193E2580", "0409DE193E2581", "0405BD193E2581" };
		String[] clues = { "Konijn", "Olifant", "Leeuw", "Tijger", "Gevonden","Gitaar", "Piano", "Drums", "Saxofoon"};
		String[] voorwerpen = {"Sport","Sport","Sport","Sport","Vergrootglas","Gitaar", "Piano", "Drums", "Saxofoon"};
		int[] themeIds = {4,4,4,4,7,1,1,1,1};
		for (int i = 0; i < titels.length; i++) {
			String sql = "INSERT INTO tblBooks(id, titel, barcode, hired, clue, themeId, voorwerp) VALUES("
					+ (i+1)
					+ ", '"
					+ titels[i]
					+ "', '"
					+ barcodes[i]
					+ "',0,'"
					+ clues[i] + "', " + themeIds[i] + ", '" + voorwerpen[i] + "')";
			Log.d("sql",sql);
			db.execSQL(sql);
		}
	}

	private void createThemes(SQLiteDatabase db) {
		String[] themes = { "Muziek", "De wereld", "Dieren", "Sport", "Taal",
				"Geloof","Special" };

		for (int i = 0; i < themes.length; i++) {
			db.execSQL("INSERT INTO tblThemes(id,naam) VALUES (" + (i+1) + ", '"
					+ themes[i] + "')");
		}

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("CREATE TABLE IF NOT EXISTS tblBooks("
				+ "id INT, titel VARCHAR, barcode VARCHAR, hired INT, clue VARCHAR, themeId INT, voorwerp VARCHAR)");

		db.execSQL("CREATE TABLE IF NOT EXISTS tblThemes("
				+ "id INT, naam VARCHAR)");
		

		createBooks(db);
		createThemes(db);
		
		Log.d("DBCREATOR", "TBL AANGEMAAKT + GEVULD");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("DROP TABLE IF EXISTS tblBooks");
		db.execSQL("DROP TABLE IF EXISTS tblThemes");
		onCreate(db);

	}

	public Book getBookByBarcode(String barcode) {
		SQLiteDatabase db = this.getWritableDatabase();
		Book book = null;
		String sql = "SELECT * FROM tblBooks WHERE barcode = '" + barcode
				+ "';";
		Cursor cursor = db.rawQuery(sql, null);
		book = createBook(cursor);
		return book;
	}
	
	public String getVoorwerpFromBook(int id){
		SQLiteDatabase db = this.getWritableDatabase();
		String sql = "SELECT voorwerp FROM tblBooks WHERE id = " + id + ";";
		Cursor cursor = db.rawQuery(sql, null);		
		String voorwerp = "";
		
		if(cursor.moveToFirst()){
			voorwerp = cursor.getString(0);
		}
		cursor.close();
		return voorwerp;
	}
	
	public boolean isBookElementOfTheme(int id, String theme) {
		SQLiteDatabase db = this.getWritableDatabase();
		String sql_theme = "SELECT id FROM tblThemes WHERE naam = '" + theme + "';";
		Cursor cursor = db.rawQuery(sql_theme, null);		
		
		if(cursor.moveToFirst()){
			//Id exists.
			int themeId = cursor.getInt(0);
			
			String sql_book = "SELECT * FROM tblBooks WHERE id = " + id + " AND themeId = " + themeId + ";";
			Cursor cursor2 = db.rawQuery(sql_book, null);
			
			if(cursor2.moveToFirst()){
				//Oké
				cursor.close();
				cursor2.close();
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
		
	}
	
	public Book createBook(Cursor cursor){
		Book book = null;
		if (cursor.moveToFirst()) {
			// Only one record if everything is normal.
			book = new Book();
			book.setId(cursor.getInt(0));
			book.setTitel(cursor.getString(1));
			book.setBarcode(cursor.getString(2));

			int hired = cursor.getInt(3);
			if (hired == 0) {
				book.setHired(false);
			} else {
				book.setHired(true);
			}

			book.setClue(cursor.getString(4));
			book.setThemeId(cursor.getInt(5));
			book.setVoorwerp(cursor.getString(6));
		}
		cursor.close();
		return book;
	}

	public Theme getTheme(int themeId) {
		SQLiteDatabase db = this.getWritableDatabase();
		Theme theme = null;

		String sql = "SELECT * FROM tblThemes WHERE id = " + themeId;
		Cursor cursor = db.rawQuery(sql, null);

		if (cursor.moveToFirst()) {
			// Normally there is only one record.
			theme = new Theme();
			theme.setId(cursor.getInt(0));
			theme.setNaam(cursor.getString(1));

		}
		cursor.close();
		return theme;

	}
}