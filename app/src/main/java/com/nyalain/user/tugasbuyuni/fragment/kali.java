package com.nyalain.user.tugasbuyuni.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.nyalain.user.tugasbuyuni.R;

public class kali extends Fragment {
    EditText editAngka1, editAngka2;
    TextView tvHasil;
    Button kurang;

    Integer angka1, angka2;
    public kali(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.kali, container, false);
        editAngka1 = view.findViewById(R.id.angka1);
        editAngka1.setText("0");
        editAngka2 = view.findViewById(R.id.angka2);
        editAngka2.setText("0");
        tvHasil = view.findViewById(R.id.txthasil);
        kurang = view.findViewById(R.id.buttonkurang);

        return view;
    }

    private void proses() {
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hasilkali();
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        proses();
    }

    private void hasilkali() {
        angka1 = Integer.parseInt(editAngka1.getText().toString());
        angka2 = Integer.parseInt(editAngka2.getText().toString());
        if (angka1.equals("")){
            tvHasil.setText("Isi terlebih dahulu");
        }
        else if (angka2.equals("")) {
            tvHasil.setText("Isi terlebih dahulu");
        }else {
            Integer hasil = angka1 * angka2;
            tvHasil.setText(String.valueOf(hasil));
        }
    }
}
