package com.example.evolved.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import static com.example.evolved.widgets.R.id.buttonOK;

public class Main2Activity extends AppCompatActivity {

    RadioGroup rgStatus;
    RadioButton rbBM, rbM, rbD, rbJ;
    TextView tvHasil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        rbBM = (RadioButton) findViewById(R.id.radioButtonBM);
        rbM = (RadioButton) findViewById(R.id.radioButtonM);
        rbD = (RadioButton) findViewById(R.id.radioButtonD);
        rbJ = (RadioButton) findViewById(R.id.radioButtonJ);
        rgStatus = (RadioGroup) findViewById(R.id.radioGroupStatus);
        tvHasil = (TextView) findViewById(R.id.textViewHasil);

        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.radioButtonBM) {
                    findViewById(R.id.etAnak).setVisibility(View.GONE);
                } else {
                    findViewById(R.id.etAnak).setVisibility(View.VISIBLE);
                }
            }
        });

        findViewById(buttonOK).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doClick();
            }

            private void doClick() {

                String hasil = null;

                if (rgStatus.getCheckedRadioButtonId() != -1) {
                    RadioButton rb = (RadioButton)
                            findViewById(rgStatus.getCheckedRadioButtonId());
                    hasil = rb.getText().toString();

                    if (rgStatus.getCheckedRadioButtonId() != R.id.radioButtonBM) {
                        EditText etJAnak = (EditText) findViewById(R.id.etAnak);
                        hasil += "\nJumlah Anak : " + etJAnak.getText();
                    }
                }

                /*if (rbBM.isChecked()){
                    hasil = rbBM.getText().toString();
                }else if (rbM.isChecked()){
                    hasil = rbM.getText().toString();
                }else if (rbD.isChecked()){
                    hasil = rbD.getText().toString();
                }else if (rbJ.isChecked()){
                    hasil = rbJ.getText().toString();
                }*/
                if (hasil == null) {
                    tvHasil.setText("Belum memilih status");
                } else {
                    tvHasil.setText("Status Anda : " + hasil);
                }

            }

        });
    }
}
