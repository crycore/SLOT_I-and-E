package slot.win;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class RegistSQL {

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

	protected Context context;
	protected SQLiteDatabase db;

	private String day;


	public RegistSQL(SQLiteDatabase db, String day) {
		this.db = db;
		this.day = day;
	}

	public void WriteDB(Bean bean) {
		ContentValues values = new ContentValues();
		values.put(COL_DATE, day);
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
}

}
