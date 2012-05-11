package slot.win;

import android.app.Activity;
import android.app.SearchManager.OnCancelListener;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Setting extends Activity{
	private Button button;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.setting);
		button = (Button)this.findViewById(R.id.button2);
		button.setOnClickListener(new MyClickAdapter());
	}

	class MyClickAdapter implements OnCancelListener{
		public void onClick(View v) {
			finish();
		}

		public void onCancel() {
			// TODO 自動生成されたメソッド・スタブ

		}
	}
}
