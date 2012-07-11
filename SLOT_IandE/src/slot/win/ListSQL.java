package slot.win;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class ListSQL {

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

	DBHelper dbhelper;
	private String day;
	private SQLiteDatabase db;

	public ListSQL(SQLiteDatabase db, String day) {
		this.db = db;
		this.day = day;
	}

	//日にちごとの収支をSQLからさがす
	public Cursor SelectDB() {
		Cursor c = null;

		SELECT_SQL = "SELECT " + COL_TYPE_NAME + "," + COL_INVEST + ","
				+ COL_COLLECT + " FROM " + TABLE_NAME + " WHERE " + COL_DATE
				+ " = '" + this.day + "'";
		c = db.rawQuery(SELECT_SQL, null);
		return c;
	}

}
