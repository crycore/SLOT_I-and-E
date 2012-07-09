package mamezou.com;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBAdapter {

	static final String DATABASE_NAME = "IandE.db";
	static final int DATABASE_VERSION = 1;
	static String SELECT_SQL;

	public static final String TABLE_NAME = "IandE";
	public static final String COL_ID = "_id";
	public static final String COL_DATE = "date";
	public static final String COL_HOOL_NAME = "holl_name";
	public static final String COL_TYPE_NAME = "type_name";
	public static final String COL_INVEST = "invest";
	public static final String COL_COLLECT = "collect";
	public static final String COL_NOTE = "note";

	public String date;

	protected final Context context;
	protected DatabaseHelper dbHelper;
	protected SQLiteDatabase db;

	public DBAdapter(Context context, String date) {
		this.context = context;
		dbHelper = new DatabaseHelper(this.context);
		this.date = date;
	}

	//
	// SQLiteOpenHelper
	//

	private static class DatabaseHelper extends SQLiteOpenHelper {

		public DatabaseHelper(Context context) {
			super(context, DATABASE_NAME, null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_DATE
					+ " TEXT NOT NULL," + COL_HOOL_NAME + " TEXT NOT NULL,"
					+ COL_TYPE_NAME + " TEXT NOT NULL, " + COL_INVEST
					+ " TEXT NOT NULL, " + COL_COLLECT + " TEXT NOT NULL,"
					+ COL_NOTE + "TEXT);");

			String a = ("CREATE TABLE " + TABLE_NAME + " (" + COL_ID
					+ " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_DATE
					+ " DATETIME NOT NULL," + COL_HOOL_NAME + " TEXT NOT NULL,"
					+ COL_TYPE_NAME + " TEXT NOT NULL, " + COL_INVEST
					+ " TEXT NOT NULL, " + COL_COLLECT + " TEXT NOT NULL,"
					+ COL_NOTE + "TEXT);");

			Log.d("tag", a);
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
			onCreate(db);
		}
	}

	//
	// Adapter Methods
	//

	public DBAdapter open() {
		db = dbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		dbHelper.close();
	}

	//
	// App Methods
	//

	public boolean deleteAllIandE() {
		return db.delete(TABLE_NAME, null, null) > 0;
	}

	public boolean deleteIandE(int id) {
		return db.delete(TABLE_NAME, COL_ID + "=" + id, null) > 0;
	}

	public Cursor select_table() {
		Cursor c = null;
		try{

		SELECT_SQL = "SELECT " + COL_TYPE_NAME + "," + COL_INVEST +"," + COL_COLLECT + " FROM " + TABLE_NAME +
		" WHERE COL_DATE = '" + date + "'";
		c = db.rawQuery(SELECT_SQL, null);


		}catch (Exception e) {
			Log.d("tag", e.toString());
		}
		return c;
	}

	public void saveIandE(Bean bean) {

		try{
		ContentValues values = new ContentValues();
		values.put(COL_DATE, date);
		values.put(COL_HOOL_NAME, bean.getHoll_name());
		values.put(COL_TYPE_NAME, bean.getType_name());
		values.put(COL_INVEST, bean.getInvest());
		if (bean.getCollect() != null) {
			values.put(COL_COLLECT, bean.getCollect());
		} else {
			values.put(COL_COLLECT, 0);
		}
		values.put(COL_NOTE, bean.getnote());

		db.insertOrThrow(TABLE_NAME, null, values);
		}catch (Exception e) {
			Log.d("tag",e.toString());
		}
	}

}
