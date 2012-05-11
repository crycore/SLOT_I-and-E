package slot.win;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.content.Intent;
import android.graphics.Color;

public class SLOT_IandE extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    public boolean onCreateOptionnsMenu(Menu menu){
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.layout.menu, menu);
    	return true;
    }

    //メニューアイテム選択イベントの処理
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()){
			case R.id.menu_iten0:
				Intent intent = new Intent();
				intent.setClass(SLOT_IandE.this, Setting.class);
				startActivity(intent);
				return true;
			case R.id.menu_item1:
				Intent intent2 = new Intent();
				intent2.setClass(SLOT_IandE.this, Setting.class);
				startActivity(intent2);
				return true;
			case R.id.menu_item2:
				Intent intent3 = new Intent();
				intent3.setClass(SLOT_IandE.this, Setting.class);
				startActivity(intent3);
				return true;
		}
		return true;

    }
}