package com.idouble.money;

import android.graphics.Color;
import android.os.TestLooperManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ShouyeFragment shouyeFragment;
    private MoneyFragment   moneyFragment;
    private NewsFragment    newsFragment;
    private AviFragment    aviFragment;
    private MyFragment  myFragment;
    private View shouLayout;
    private View moneyLayout;
    private View newsLayout;
    private View aviLayout;
    private View myLayout;
    private ImageView shouImage;
    private ImageView   moneyImage;
    private ImageView   newsImage;
    private ImageView   aviImage;
    private ImageView   myImage;
    private TextView    shouText;
    private TextView    moneyText;
    private TextView    newsText;
    private TextView    aviText;
    private TextView    myText;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView (R.layout.activity_main);
        shouImage = (ImageView)findViewById (R.id.shouye_image);
        moneyImage = (ImageView)findViewById (R.id.money_image);
        newsImage = (ImageView)findViewById (R.id.news_image);
        aviImage = (ImageView)findViewById (R.id.avi_image);
        myImage = (ImageView)findViewById (R.id.my_image);
        shouText = (TextView)findViewById (R.id.shouye_text);
        moneyText = (TextView)findViewById (R.id.money_text);
        newsText = (TextView)findViewById (R.id.news_text);
        aviText = (TextView)findViewById (R.id.avi_text);
        myText = (TextView)findViewById (R.id.my_text);
        shouLayout = findViewById (R.id.shouye_layout);
        moneyLayout = findViewById (R.id.money_layout);
        newsLayout = findViewById (R.id.news_layout);
        aviLayout = findViewById (R.id.avi_layout);
        myLayout = findViewById (R.id.my_layout);
        shouLayout.setOnClickListener (this);
        moneyLayout.setOnClickListener (this);
        newsLayout.setOnClickListener (this);
        aviLayout.setOnClickListener (this);
        myLayout.setOnClickListener (this);
        fragmentManager = getSupportFragmentManager ();
        setTabSelection(0);
    }

    private void setTabSelection(int index) {
        ClearSelection();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction ();
        hideFragment(fragmentTransaction);
        switch (index){
            case 0:
                shouImage.setImageResource (R.drawable.down);
                shouText.setTextColor (Color.RED);
                if(shouyeFragment == null){
                    shouyeFragment = new ShouyeFragment ();
                    fragmentTransaction.replace (R.id.content,shouyeFragment);
                }else {
                    fragmentTransaction.show (shouyeFragment);
                }
                break;
            case 1:
                moneyImage.setImageResource (R.drawable.right);
                moneyText.setTextColor (Color.RED);
                if(moneyFragment == null){
                    moneyFragment = new MoneyFragment ();
                    fragmentTransaction.add (R.id.content,moneyFragment);
                }else {
                    fragmentTransaction.show (moneyFragment);
                }

                break;
            case 2:
                newsImage.setImageResource (R.drawable.left);
                newsText.setTextColor (Color.RED);
                if(newsFragment == null){
                    newsFragment = new NewsFragment ();
                    fragmentTransaction.add (R.id.content,newsFragment);
                }else {
                    fragmentTransaction.show (newsFragment);
                }

                break;
            case 3:
                aviImage.setImageResource (R.drawable.top);
                aviText.setTextColor (Color.RED);
                if(aviFragment == null){
                    aviFragment = new AviFragment ();
                    fragmentTransaction.add (R.id.content,aviFragment);
                }else {
                    fragmentTransaction.show (aviFragment);
                }

                break;
            case 4:
                myImage.setImageResource (R.drawable.down);
                myText.setTextColor (Color.RED);
                if(myFragment == null){
                    myFragment = new MyFragment ();
                    fragmentTransaction.add (R.id.content,myFragment);
                }else {
                    fragmentTransaction.show (myFragment);
                }

                break;
        }
        fragmentTransaction.commit ();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {



        if (shouyeFragment != null){
            fragmentTransaction.hide (shouyeFragment);
        }
        if (moneyFragment != null){
            fragmentTransaction.hide (moneyFragment);
        }
        if (newsFragment != null){
            fragmentTransaction.hide (newsFragment);
        }
        if (aviFragment != null){
            fragmentTransaction.hide (aviFragment);
        }
        if (myFragment != null){
            fragmentTransaction.hide (myFragment);
        }
    }

    private void ClearSelection() {
        shouImage.setImageResource (R.drawable.top);
        shouText.setTextColor (Color.BLACK);
        moneyImage.setImageResource (R.drawable.left);
        moneyText.setTextColor (Color.BLACK);
        newsImage.setImageResource (R.drawable.right);
        newsText.setTextColor (Color.BLACK);
        aviImage.setImageResource (R.drawable.right);
        aviText.setTextColor (Color.BLACK);
        myImage.setImageResource (R.drawable.down);
        myText.setTextColor (Color.BLACK);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId ()){
            case R.id.shouye_layout:
                setTabSelection(0);
                break;
            case R.id.money_layout:
                setTabSelection(1);
                break;
            case R.id.news_layout:
                setTabSelection(2);
                break;
            case R.id.avi_layout:
                setTabSelection(3);
                break;
            case R.id.my_layout:
                setTabSelection(4);
                break;
        }
    }
}
