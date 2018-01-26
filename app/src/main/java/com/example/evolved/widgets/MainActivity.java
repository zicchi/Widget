package com.example.evolved.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextNama;
    EditText editTextTahun;
    Button bOk;
    TextView tvHasil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNama = (EditText) findViewById(R.id.editTextNama);
        editTextTahun = (EditText) findViewById(R.id.editTextTahun);
        bOk = (Button) findViewById(R.id.buttonOK);
        tvHasil = (TextView) findViewById(R.id.hasil);

        bOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcces();

            }
        });
    }

    private void doProcces() {
        if (isValue()) {
            String nama = editTextNama.getText().toString();
            int tahun = Integer.parseInt(editTextTahun.getText().toString());
            int usia = 2018 - tahun;
            tvHasil.setText(nama + " tahun ini akan berusia " + usia + " tahun");
        }
    }

    private boolean isValue() {
        boolean valid = true;

        String nama = editTextNama.getText().toString();
        String tahun = editTextTahun.getText().toString();

        if (nama.isEmpty()) {
            editTextNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            editTextNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            editTextNama.setError(null);
        }
        if (tahun.isEmpty()) {
            editTextTahun.setError("Tahun kelahiran belum diisi");
            valid = false;
        } else if (tahun.length() != 4) {
            editTextTahun.setError("Format tahun harus yyyy");
            valid = false;
        } else {
            editTextTahun.setError(null);
        }


        return valid;
    }
}
