package slot.win;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper{

	static final String DATABASE_NAME = "IandE.db";
	static final int DATABASE_VERSION = 1;

	public static final String TABLE_NAME = "IandE";
	public static final String COL_ID = "_id";
	public static final String COL_DATE = "date";
	public static final String COL_HOOL_NAME = "holl_name";
	public static final String COL_TYPE_NAME = "type_name";
	public static final String COL_INVEST = "invest";
	public static final String COL_COLLECT = "collect";
	public static final String COL_NOTE = "note";

	protected Context context;
	protected SQLiteDatabase db;

	public DBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {

		String sq = "CREATE TABLE " + TABLE_NAME + " (" + COL_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_DATE
				+ " TEXT NOT NULL," + COL_HOOL_NAME + " TEXT NOT NULL,"
				+ COL_TYPE_NAME + " TEXT NOT NULL, " + COL_INVEST
				+ " TEXT NOT NULL, " + COL_COLLECT + " TEXT NOT NULL,"
				+ COL_NOTE + "TEXT);";
		try{
		db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_ID
				+ " INTEGER PRIMARY KEY AUTOINCREMENT," + COL_DATE
				+ " TEXT NOT NULL," + COL_HOOL_NAME + " TEXT NOT NULL,"
				+ COL_TYPE_NAME + " TEXT NOT NULL, " + COL_INVEST
				+ " TEXT NOT NULL, " + COL_COLLECT + " TEXT NOT NULL,"
				+ COL_NOTE + " TEXT)");
		}catch (Exception e) {
			Log.e(DATABASE_NAME, COL_COLLECT);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
		onCreate(db);
	}
}
