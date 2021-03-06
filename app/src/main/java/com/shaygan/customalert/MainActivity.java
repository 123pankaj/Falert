package com.shaygan.customalert;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.waspar.falert.Falert;
import com.waspar.falert.FalertButtonType;
import com.waspar.falert.SingleButtonListener;
import com.waspar.falert.DoubleButtonListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButton();
    }

    private void initButton() {
        findViewById(R.id.button).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                singleAction();
                break;
            case R.id.button2:
                doubleAction();
                break;
        }
    }

    private Falert falert;
    private void doubleAction() {
        LayoutInflater inflaterr = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflaterr.inflate(R.layout.custom_view, null, false);
        View loaderView = inflaterr.inflate(R.layout.loader_view, null, false);

        falert = new Falert(this)
                .setButtonType(FalertButtonType.Double_BUTTON)
                .customView(customView)
                .loaderView(loaderView)
                .setLoaderBackgroundColor(getResources().getColor(R.color.falert_red))
                .setAutoDismiss(false)
                .setPositiveText("مشاهده")
                .setNegativeText("حذف")
                .setPositiveButtonBackground(getResources().getColor(R.color.falert_white))
                .setNegativeButtonBackground(getResources().getColor(R.color.falert_white))
                .setPositiveButtonTextColor(getResources().getColor(R.color.falert_green))
                .setNegativeButtonTextColor(getResources().getColor(R.color.falert_red))
                .setstrokeButtonsSize(3)
                .setHeaderIcon(getResources().getDrawable(R.drawable.luncher))
                .setAlertRadius(40)
                .setButtonRadius(80)
                .setButtonTextSize(13)
                .setHeaderIconEnable(true)
                .setButtonEnable(true)
                .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf"))
                .setDoubleButtonListener(new DoubleButtonListener() {
                    @Override
                    public void onClickPositive() {
                        Toast.makeText(MainActivity.this, "Positive", Toast.LENGTH_SHORT).show();
                        falert.startAnimationImageClick(true);
                    }

                    @Override
                    public void onClickNegative() {
                        Toast.makeText(MainActivity.this, "Negative", Toast.LENGTH_SHORT).show();
                        falert.startAnimationImageClick(false);
                    }
                });
        falert.show(getSupportFragmentManager() , "");
    }

    private void singleAction() {
        LayoutInflater inflaterr = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflaterr.inflate(R.layout.custom_view, null, false);

        Falert falert = new Falert(this)
                .setButtonType(FalertButtonType.ONE_BUTTON)
                .customView(customView)
                .setAutoDismiss(true)
                .setSingleButtonBackground(getResources().getColor(R.color.falert_white))
                .setSingleButtonTextColor(getResources().getColor(R.color.falert_green))
                .setPositiveText("تایید")
                .setHeaderIcon(getResources().getDrawable(R.drawable.luncher))
                .setAlertRadius(40)
                .setstrokeButtonsSize(3)
                .setButtonRadius(80)
                .setButtonTextSize(13)
                .setHeaderIconEnable(true)
                .setButtonEnable(true)
                .setCancelableTouchOutside(true)
                .setTypeFace(Typeface.createFromAsset(getAssets(), "bsans.ttf"))
                .setSingleButtonListener(new SingleButtonListener() {
                    @Override
                    public void onClick() {
                        Toast.makeText(MainActivity.this, "click", Toast.LENGTH_SHORT).show();
                    }
                });
        falert.show(getSupportFragmentManager() , "");
    }
}
