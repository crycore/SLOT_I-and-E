package slot.win;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends Activity {

	Button[] button_table = new Button[2];
	private ListView listview;
	private TextView textview;
	private SQLiteDatabase db;
	private ListSQL listsql;
	int type_total;
	int day_total = 0;
	int Name_length;
	int IE_length;
	int Total_length;
	Cursor c;

	DBHelper dbhelper;
	int count;
	String day;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list);

		button_table[0] = (Button) this.findViewById(R.id.back_list);
		button_table[1] = (Button) this.findViewById(R.id.add_list);

		OnClickListener listener = new back_list_Clicklistener();
		OnClickListener listener1 = new add_list_Clicklistener();

		button_table[0].setOnClickListener(listener);
		button_table[1].setOnClickListener(listener1);

		listview = (ListView) findViewById(R.id.listview);
		textview = (TextView) findViewById(R.id.day_total);
		List<String> list_type = new ArrayList<String>();
		List<Integer> list_IE = new ArrayList<Integer>();
		List<String> list_view = new ArrayList<String>();

		Intent in = getIntent();
		String date = in.getStringExtra("date");
		day = date;

		dbhelper = new DBHelper(this);
		db = dbhelper.getWritableDatabase();
		listsql = new ListSQL(db, day);

		//SQLの中身をカーソルに登録
		c = listsql.SelectDB();

		if (c == null) {
			count = 0;
		} else {
			count = c.getCount();
		}

		//カーソルの中身を配列に入れる
		if (count != 0) {
			c.moveToFirst();
			for (int i = 0; i < count; i++) {
				int Name_length = (c.getString(0).length() * 3);
				int IE_length = String.valueOf(Integer.parseInt(c.getString(2)) - Integer.parseInt(c.getString(1))).length();
				int Total_length = (40 - (Name_length + IE_length));
				list_type.add(c.getString(0));
				type_total = Integer.parseInt(c.getString(2)) - Integer.parseInt(c.getString(1));
				list_IE.add(type_total);
				list_view.add(c.getString(0)+set_SPACE(Total_length)+ String.valueOf(type_total));
				c.moveToNext();
			}

			//リストビューに登録
			ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_view);
			listview.setAdapter(adapter);

			for (int i : list_IE) {
				day_total = day_total + i;
			}
		}

		//１日のトータル収支を計算とセット
		textview.setText("本日の収支 " + day_total);
		textview.setTextSize(35);
		if (day_total >= 0) {
			textview.setBackgroundColor(Color.BLUE);
		} else {
			textview.setBackgroundColor(Color.RED);
		}

	}

	//戻るボタン
	class back_list_Clicklistener implements OnClickListener {

		public void onClick(View v) {
			finish();
		}

	}

	//登録画面に移動
	class add_list_Clicklistener implements OnClickListener {

		public void onClick(View v) {
			Intent intent = new Intent(ListActivity.this, RegistActivity.class);
			intent.putExtra("date", day);
			startActivity(intent);
		}

	}

	//挿入する空白を計算するメソッド
	String set_SPACE(int length){
		String SPACE = "";
		for(int i = 0; i < length; i++){
			SPACE = SPACE + " ";
		}
		return SPACE;
	}
}
