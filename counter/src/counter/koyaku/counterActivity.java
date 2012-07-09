package counter.koyaku;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class counterActivity extends Activity {

	private TextView cAka;
	private TextView cMidori;
	private TextView cKi;
	private TextView cAo;
	private TextView cSiro;
	private TextView pAka;
	private TextView pMidori;
	private TextView pKi;
	private TextView pAo;
	private TextView pSiro;
	private TextView viewkaiten;
	private View mainus;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		Button bAka = (Button) findViewById(R.id.buttonAka);
		Button bMidori = (Button) findViewById(R.id.buttonMidori);
		Button bKi = (Button) findViewById(R.id.buttonKi);
		Button bAo = (Button) findViewById(R.id.buttonAo);
		Button bSiro = (Button) findViewById(R.id.buttonSiro);
		cAka = (TextView) findViewById(R.id.countAka);
		cMidori = (TextView) findViewById(R.id.countMidori);
		cKi = (TextView) findViewById(R.id.countKi);
		cAo = (TextView) findViewById(R.id.countAo);
		cSiro = (TextView) findViewById(R.id.countSiro);
		pAka = (TextView) findViewById(R.id.probabilityAka);
		pMidori = (TextView) findViewById(R.id.probabilityMidori);
		pKi = (TextView) findViewById(R.id.probabilityKi);
		pAo = (TextView) findViewById(R.id.probabilityAo);
		pSiro = (TextView) findViewById(R.id.probabilitySiro);
		bAka.setOnClickListener(bAka_listener);
		bMidori.setOnClickListener(bMidori_listener);
		bKi.setOnClickListener(bKi_listener);
		bAo.setOnClickListener(bAo_listener);
		bSiro.setOnClickListener(bSiro_listener);

		mainus = (Button) findViewById(R.id.count1);
		mainus = (View) findViewById(R.id.count1);
		viewkaiten = (TextView) findViewById(R.id.countKaiten);
		viewkaiten = (Button) findViewById(R.id.countKaiten);
		Button b100 = (Button) findViewById(R.id.button100);
		Button b10 = (Button) findViewById(R.id.button10);
		Button b1 = (Button) findViewById(R.id.button1);
		mainus.setOnClickListener(mainus_listener);
		b100.setOnClickListener(b100_listener);
		b10.setOnClickListener(b10_listener);
		b1.setOnClickListener(b1_listener);

	}

	int kaiten;
	int k;
	int Aka;
	int Midori;
	int Ki;
	int Ao;
	int Siro;
	float Akak;
	float Midorik;
	float Kik;
	float Aok;
	float Sirok;
	int change = 0;

	public void run() {
		if (Aka > 0) {
			Akak = kaiten / Aka;
		}
		if (Midori > 0) {
			Midorik = kaiten / Midori;
		}
		if (Ki > 0) {
			Kik = kaiten / Ki;
		}
		if (Ao > 0) {
			Aok = kaiten / Ao;
		}
		if (Siro > 0) {
			Sirok = kaiten / Siro;
		}
		pAka.setText("1/" + Akak);
		pMidori.setText("1/" + Midorik);
		pKi.setText("1/" + Kik);
		pAo.setText("1/" + Aok);
		pSiro.setText("1/" + Sirok);
	}

	OnClickListener cKaiten_listener = new Button.OnClickListener() {
		public void onClick(View view) {

		}
	};

	OnClickListener bAka_listener = new View.OnClickListener() {
		public void onClick(View v) {
			if (change == 1) {
				if (Aka > 0) {
					Aka--;
					cAka.setText(String.valueOf(Aka));
					run();

				}
			} else {
				Aka++;
				cAka.setText(String.valueOf(Aka));
				run();
			}

		}
	};

	OnClickListener bMidori_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			if (change == 1) {
				if (Midori > 0) {
					Midori--;
					cMidori.setText(String.valueOf(Midori));
					run();
				}
			} else {
				Midori++;
				cMidori.setText(String.valueOf(Midori));
				run();
			}

		}
	};
	OnClickListener bKi_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			if (change == 1) {
				if (Ki > 0) {
					Ki--;
					cKi.setText(String.valueOf(Ki));
					run();
				}
			} else {
				Ki++;
				cKi.setText(String.valueOf(Ki));
				run();
			}
		}
	};
	OnClickListener bAo_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			if (change == 1) {
				if (Ao >= 1) {
					Ao--;
					cAo.setText(String.valueOf(Ao));
					run();
				}
			} else {
				Ao++;
				cAo.setText(String.valueOf(Ao));
				run();
			}
		}
	};
	OnClickListener bSiro_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			if (change == 1) {
				if (Siro >= 1) {
					Siro--;
					cSiro.setText(String.valueOf(Siro));
					run();
				}
			} else {
				Siro++;
				cSiro.setText(String.valueOf(Siro));
				run();
			}
		}
	};

	OnClickListener b100_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			if (change == 1) {
				if (kaiten >= 100) {
					kaiten = kaiten - 100;
					viewkaiten.setText(String.valueOf(kaiten));
					run();
				}
			} else {
				kaiten = kaiten + 100;
				viewkaiten.setText(String.valueOf(kaiten));
				run();
			}
		}
	};

	OnClickListener b10_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			if (change == 1) {
				if (kaiten >= 10) {
					kaiten = kaiten - 10;
					viewkaiten.setText(String.valueOf(kaiten));
					run();
				}
			} else {
				kaiten = kaiten + 10;
				viewkaiten.setText(String.valueOf(kaiten));
				run();
			}
		}
	};

	OnClickListener b1_listener = new Button.OnClickListener() {

		public void onClick(View view) {
			if (change == 1) {
				if (kaiten >= 1) {
					kaiten = kaiten - 1;
					viewkaiten.setText(String.valueOf(kaiten));
					run();
				}
			} else {
				kaiten = kaiten + 1;
				viewkaiten.setText(String.valueOf(kaiten));
				run();
			}
		}
	};

	OnClickListener mainus_listener = new Button.OnClickListener() {
		

		public void onClick(View view) {
			if (change == 0) {
				change = 1;
				mainus.setBackgroundColor(drawable/aka); 
			} else {
				change = 0;
				mainus.setBackgroundColor(Color.DKGRAY); 
			}
		}
	};

}