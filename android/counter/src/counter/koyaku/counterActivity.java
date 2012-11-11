package counter.koyaku;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
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
	private TextView modea;
	private TextView modeb;
	private TextView modec;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		LayoutInflater factory = LayoutInflater.from(this);
		final View inputView = factory.inflate(R.layout.dialog, null);
		final AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("回転数")
				.setView(inputView)
				.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				

					public void onClick(DialogInterface dialog, int yesButton) {
						
						
					}
				})
				.setNegativeButton("Close",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int noButton) {

							}
						});
		final AlertDialog alert = builder.create();

		OnClickListener viewkaiten_listener = new Button.OnClickListener() {
			public void onClick(View view) {

				alert.show();
			}
		};

		Button modea = (Button) findViewById(R.id.buttonModeA);
		Button modeb = (Button) findViewById(R.id.buttonModeB);
		Button modec = (Button) findViewById(R.id.buttonModeC);
		modea.setOnClickListener(modea_listener);
		modeb.setOnClickListener(modeb_listener);
		modec.setOnClickListener(modec_listener);
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
		viewkaiten.setOnClickListener(viewkaiten_listener);
		Button b100 = (Button) findViewById(R.id.button100);
		Button b10 = (Button) findViewById(R.id.button10);
		Button b1 = (Button) findViewById(R.id.button1);
		mainus.setOnClickListener(mainus_listener);
		b100.setOnClickListener(b100_listener);
		b10.setOnClickListener(b10_listener);
		b1.setOnClickListener(b1_listener);
		EditText imak = (EditText) findViewById(R.id.imak);
		EditText kakok = (EditText) findViewById(R.id.kakok);
	


	}

	int kaiten;
	int kaitenb;
	int kaitenc;
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
	int Akab;
	int Midorib;
	int Kib;
	int Aob;
	int Sirob;
	float Akakb;
	float Midorikb;
	float Kikb;
	float Aokb;
	float Sirokb;
	int Akac;
	int Midoric;
	int Kic;
	int Aoc;
	int Siroc;
	float Akakc;
	float Midorikc;
	float Kikc;
	float Aokc;
	float Sirokc;
	int mode = 0;
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
		if (Aka == 0) {
			pAka.setText("1/0.0");
		}
		if (Midori == 0) {
			pMidori.setText("1/0.0");
		}
		if (Ki == 0) {
			pKi.setText("1/0.0");
		}
		if (Ao == 0) {
			pAo.setText("1/0.0");
		}
		if (Siro == 0) {
			pSiro.setText("1/0.0");
		}
		cAka.setText(String.valueOf(Aka));
		cMidori.setText(String.valueOf(Midori));
		cKi.setText(String.valueOf(Ki));
		cAo.setText(String.valueOf(Ao));
		cSiro.setText(String.valueOf(Siro));
		viewkaiten.setText(String.valueOf(kaiten));
	}

	public void runb() {
		if (Akab > 0) {
			Akakb = kaitenb / Akab;
		}
		if (Midorib > 0) {
			Midorikb = kaitenb / Midorib;
		}
		if (Kib > 0) {
			Kikb = kaitenb / Kib;
		}
		if (Aob > 0) {
			Aokb = kaitenb / Aob;
		}
		if (Sirob > 0) {
			Sirokb = kaitenb / Sirob;
		}
		pAka.setText("1/" + Akakb);
		pMidori.setText("1/" + Midorikb);
		pKi.setText("1/" + Kikb);
		pAo.setText("1/" + Aokb);
		pSiro.setText("1/" + Sirokb);
		if (Akab == 0) {
			pAka.setText("1/0.0");
		}
		if (Midorib == 0) {
			pMidori.setText("1/0.0");
		}
		if (Kib == 0) {
			pKi.setText("1/0.0");
		}
		if (Aob == 0) {
			pAo.setText("1/0.0");
		}
		if (Sirob == 0) {
			pSiro.setText("1/0.0");
		}
		cAka.setText(String.valueOf(Akab));
		cMidori.setText(String.valueOf(Midorib));
		cKi.setText(String.valueOf(Kib));
		cAo.setText(String.valueOf(Aob));
		cSiro.setText(String.valueOf(Sirob));
		viewkaiten.setText(String.valueOf(kaitenb));
	}

	public void runc() {
		if (Akac > 0) {
			Akakc = kaitenc / Akac;
		}
		if (Midoric > 0) {
			Midorikc = kaitenc / Midoric;
		}
		if (Kic > 0) {
			Kikc = kaitenc / Kic;
		}
		if (Aoc > 0) {
			Aokc = kaitenc / Aoc;
		}
		if (Siroc > 0) {
			Sirokc = kaitenc / Siroc;
		}
		pAka.setText("1/" + Akakc);
		pMidori.setText("1/" + Midorikc);
		pKi.setText("1/" + Kikc);
		pAo.setText("1/" + Aokc);
		pSiro.setText("1/" + Sirokc);
		if (Akac == 0) {
			pAka.setText("1/0.0");
		}
		if (Midoric == 0) {
			pMidori.setText("1/0.0");
		}
		if (Kic == 0) {
			pKi.setText("1/0.0");
		}
		if (Aoc == 0) {
			pAo.setText("1/0.0");
		}
		if (Siroc == 0) {
			pSiro.setText("1/0.0");
		}
		cAka.setText(String.valueOf(Akac));
		cMidori.setText(String.valueOf(Midoric));
		cKi.setText(String.valueOf(Kic));
		cAo.setText(String.valueOf(Aoc));
		cSiro.setText(String.valueOf(Siroc));
		viewkaiten.setText(String.valueOf(kaitenc));
	}

	public void modeiro() {

		if (mode == 0) {
			modea.setBackgroundColor(Color.RED);
			modeb.setBackgroundColor(Color.GRAY);
			modec.setBackgroundColor(Color.GRAY);
		}
		if (mode == 1) {
			modea.setBackgroundColor(Color.GRAY);
			modeb.setBackgroundColor(Color.RED);
			modec.setBackgroundColor(Color.GRAY);
		}
		if (mode == 2) {
			modec.setBackgroundColor(Color.RED);
		}
	}

	OnClickListener modea_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			mode = 0;
			run();
		}
	};

	OnClickListener modeb_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			mode = 1;
			runb();
		}
	};

	OnClickListener modec_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			mode = 2;
			runc();
		}
	};

	OnClickListener cKaiten_listener = new Button.OnClickListener() {
		public void onClick(View view) {

		}
	};

	OnClickListener bAka_listener = new View.OnClickListener() {
		public void onClick(View v) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (Aka > 0) {
						Aka--;
						run();

					}
				} else {
					Aka++;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (Akab > 0) {
						Akab--;
						runb();

					}
				} else {
					Akab++;
					runb();
				}
				break;
			case 2:
				if (change == 1) {
					if (Akac > 0) {
						Akac--;
						runc();

					}
				} else {
					Akac++;
					runc();
				}
				break;

			}

		}
	};

	OnClickListener bMidori_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (Midori > 0) {
						Midori--;
						run();
					}
				} else {
					Midori++;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (Midorib > 0) {
						Midorib--;
						run();
					}
				} else {
					Midorib++;
					run();
				}
				break;
			case 2:
				if (change == 1) {
					if (Midoric > 0) {
						Midoric--;
						run();
					}
				} else {
					Midoric++;
					run();
				}
				break;
			}
		}
	};
	OnClickListener bKi_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (Ki > 0) {
						Ki--;
						run();
					}
				} else {
					Ki++;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (Kib > 0) {
						Kib--;
						runb();
					}
				} else {
					Kib++;
					runb();
				}
				break;
			case 2:
				if (change == 1) {
					if (Kic > 0) {
						Kic--;
						runc();
					}
				} else {
					Kic++;
					runc();
				}
				break;
			}
		}
	};

	OnClickListener bAo_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (Ao > 0) {
						Ao--;
						run();
					}
				} else {
					Ao++;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (Aob > 0) {
						Aob--;
						runb();
					}
				} else {
					Aob++;
					runb();
				}
				break;
			case 2:
				if (change == 1) {
					if (Aoc > 0) {
						Aoc--;
						runc();
					}
				} else {
					Aoc++;
					runc();
				}
				break;
			}
		}
	};

	OnClickListener bSiro_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (Siro > 0) {
						Siro--;
						run();
					}
				} else {
					Siro++;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (Sirob > 0) {
						Sirob--;
						runb();
					}
				} else {
					Sirob++;
					runb();
				}
				break;
			case 2:
				if (change == 1) {
					if (Siroc > 0) {
						Siroc--;
						runc();
					}
				} else {
					Siroc++;
					runc();
				}
				break;
			}
		}
	};

	OnClickListener b100_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (kaiten >= 100) {
						kaiten = kaiten - 100;
						run();
					}
				} else {
					kaiten = kaiten + 100;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (kaitenb >= 100) {
						kaitenb = kaitenb - 100;
						runb();
					}
				} else {
					kaitenb = kaitenb + 100;
					runb();
				}
				break;
			case 2:
				if (change == 1) {
					if (kaitenc >= 100) {
						kaitenc = kaitenc - 100;
						runc();
					}
				} else {
					kaitenc = kaitenc + 100;
					runc();
				}
				break;
			}
		}
	};

	OnClickListener b10_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (kaiten >= 10) {
						kaiten = kaiten - 10;
						run();
					}
				} else {
					kaiten = kaiten + 10;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (kaitenb >= 10) {
						kaitenb = kaitenb - 10;
						runb();
					}
				} else {
					kaitenb = kaitenb + 10;
					runb();
				}
				break;
			case 2:
				if (change == 1) {
					if (kaitenc >= 10) {
						kaitenc = kaitenc - 10;
						runc();
					}
				} else {
					kaitenc = kaitenc + 10;
					runc();
				}
				break;
			}
		}
	};

	OnClickListener b1_listener = new Button.OnClickListener() {

		public void onClick(View view) {
			switch (mode) {
			case 0:
				if (change == 1) {
					if (kaiten >= 1) {
						kaiten = kaiten - 1;
						run();
					}
				} else {
					kaiten = kaiten + 1;
					run();
				}
				break;
			case 1:
				if (change == 1) {
					if (kaitenb >= 1) {
						kaitenb = kaitenb - 1;
						runb();
					}
				} else {
					kaitenb = kaitenb + 1;
					runb();
				}
				break;
			case 2:
				if (change == 1) {
					if (kaitenc >= 1) {
						kaitenc = kaitenc - 1;
						runc();
					}
				} else {
					kaitenc = kaitenc + 1;
					runc();
				}
				break;
			}
		}
	};

	OnClickListener mainus_listener = new Button.OnClickListener() {
		public void onClick(View view) {
			if (change == 0) {
				change = 1;
			} else {
				change = 0;
			}
		}
	};

}