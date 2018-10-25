package com.nyalain.user.tugasbuyuni;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Main2Activity extends AppCompatActivity implements Animation.AnimationListener{
    private final String judul_menu[] = {
            "Tambah-tambahan",
            "Kurang-kurangan",
            "Perkalian",
            "Pembagian",
    };

    private final int image_menu[] = {
            R.drawable.plus,
            R.drawable.min,
            R.drawable.kali,
            R.drawable.division,
    };

    private final String deskripsi_menu[] = {
            "Tambah-tambahan adalah tambah-tambahan",
            "Kurang-kurangan adalah kurangan",
            "Perkalian adalah perkalian",
            "Pembagian adalah pembagian",
    };

    @BindView(R.id.recycle_menu)
    RecyclerView recyclerMenu;
    @BindView(R.id.text_tap)
    TextView textTap;
    @BindView(R.id.main_layout)
    View mainLayout;

    private Animation animBlink;
    private Animation animFadeOut;

    private String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        /*setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setPadding(0, getToolBarHeight(), 0, 0);*/

        animFadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        animFadeOut.setAnimationListener(this);

        animBlink = AnimationUtils.loadAnimation(this, R.anim.blink);
        textTap.startAnimation(animBlink);

        tapToContinue();

        makeList();

    }

    private void tapToContinue() {
        mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainLayout.startAnimation(animFadeOut);
            }
        });
    }
    private void makeList(){
        recyclerMenu.setHasFixedSize(true);
        //recyclerMenu.addItemDecoration(new DividerItem(this, LinearLayoutManager.VERTICAL,14));
        recyclerMenu.setLayoutManager(new LinearLayoutManager(this));
        ArrayList data = prepareData();
        Log.d(TAG, "makeList: " + data);
        RecycleMenuAdapter recycleMenuAdapter = new RecycleMenuAdapter(data);
        recyclerMenu.setAdapter(recycleMenuAdapter);
    }

    private ArrayList prepareData() {
        ArrayList list = new ArrayList<>();
        for (int i = 0; i < judul_menu.length ; i++) {
            MenuModel model = new MenuModel();
            model.setJudul_menu(judul_menu[i]);
            model.setImage_menu(image_menu[i]);
            model.setDeskripsi_menu(deskripsi_menu[i]);
            list.add(model);
        }

        return list;
    }
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animFadeOut){
            mainLayout.clearAnimation();
            mainLayout.setVisibility(View.GONE);

        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    private int getToolBarHeight() {
        int height;

        Resources myResources = getResources();
        int idStatusBarHeight = myResources.getIdentifier(
                "status_bar_height", "dimen", "android");
        if (idStatusBarHeight > 0) {
            height = getResources().getDimensionPixelSize(idStatusBarHeight);
            //Toast.makeText(getActivity(), "Status Bar Height = " + height, Toast.LENGTH_LONG).show();
        }else{
            height = 0;
            //Toast.makeText(getActivity(), "Resources NOT found", Toast.LENGTH_LONG).show();
        }

        return height;
    }
}
