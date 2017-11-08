package com.zsh.blackcard.ui.zgactivity;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.zsh.blackcard.BaseActivity;
import com.zsh.blackcard.R;
import com.zsh.blackcard.ui.zgactivity.zgmyindentfragment.AfterSafeFragment;
import com.zsh.blackcard.ui.zgactivity.zgmyindentfragment.AllMyIndentFragment;
import com.zsh.blackcard.ui.zgactivity.zgmyindentfragment.EvaluateFragment;
import com.zsh.blackcard.ui.zgactivity.zgmyindentfragment.WaitPayFragment;
import com.zsh.blackcard.ui.zgactivity.zgmyindentfragment.WaitTakeFragment;


public class ZgMyIndentActivity extends BaseActivity implements View.OnClickListener {
    private ImageView dingdanback;
    private ViewPager myindentvp;
    private RadioButton all_btn;
    private RadioButton evaluate_btn;
    private RadioButton pay_btn;
    private RadioButton take_btn;
    private RadioButton aftersafe_btn;
    public FragmentManager flzmihome;
    public AllMyIndentFragment fg_all;
    public WaitPayFragment fg_pay;
    public WaitTakeFragment fg_take;
    public EvaluateFragment fg_evaluate;
    public AfterSafeFragment fg_after;


    @Override
    protected void initUI() {
        setContentView(R.layout.activity_zg_my_indent);
        mydfindID();
        dingdanOnclick();
        initData();
        //网络请求判断
        Httpclient();
        // button按钮的监听
        all_btn.setOnClickListener(this);
        pay_btn.setOnClickListener(this);
        take_btn.setOnClickListener(this);
        evaluate_btn.setOnClickListener(this);
        aftersafe_btn.setOnClickListener(this);
    }

    private void initData() {
        flzmihome = getSupportFragmentManager();
        FragmentTransaction transaction = flzmihome.beginTransaction();
        fg_all = new AllMyIndentFragment();
        fg_pay = new WaitPayFragment();
        fg_take = new WaitTakeFragment();
        fg_evaluate = new EvaluateFragment();
        fg_after = new AfterSafeFragment();
        transaction.add(R.id.myindentfl, fg_all);
        transaction.add(R.id.myindentfl, fg_pay);
        transaction.add(R.id.myindentfl, fg_take);
        transaction.add(R.id.myindentfl, fg_evaluate);
        transaction.add(R.id.myindentfl, fg_after);
        transaction.show(fg_all);
        transaction.hide(fg_pay);
        transaction.hide(fg_take);
        transaction.hide(fg_evaluate);
        transaction.hide(fg_after);
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myindent_all_btn:
                FragmentTransaction transaction1 = flzmihome.beginTransaction();
                transaction1.show(fg_all);
                transaction1.hide(fg_pay);
                transaction1.hide(fg_take);
                transaction1.hide(fg_evaluate);
                transaction1.hide(fg_after);
                transaction1.commit();
                break;
            case R.id.myindent_pay_btn:
                FragmentTransaction transaction2 = flzmihome.beginTransaction();
                transaction2.hide(fg_all);
                transaction2.show(fg_pay);
                transaction2.hide(fg_take);
                transaction2.hide(fg_evaluate);
                transaction2.hide(fg_after);
                transaction2.commit();
                break;
            case R.id.myindent_take_btn:
                FragmentTransaction transaction3 = flzmihome.beginTransaction();
                transaction3.hide(fg_all);
                transaction3.hide(fg_pay);
                transaction3.show(fg_take);
                transaction3.hide(fg_evaluate);
                transaction3.hide(fg_after);
                transaction3.commit();
                break;
            case R.id.myindent_evaluate_btn:
                FragmentTransaction transaction4 = flzmihome.beginTransaction();
                transaction4.hide(fg_all);
                transaction4.hide(fg_pay);
                transaction4.hide(fg_take);
                transaction4.show(fg_evaluate);
                transaction4.hide(fg_after);
                transaction4.commit();
                break;
            case R.id.myindent_aftersafe_btn:
                FragmentTransaction transaction5 = flzmihome.beginTransaction();
                transaction5.hide(fg_all);
                transaction5.hide(fg_pay);
                transaction5.hide(fg_take);
                transaction5.hide(fg_evaluate);
                transaction5.show(fg_after);
                transaction5.commit();
                break;
            default:
                break;
        }

    }

    private void dingdanOnclick() {
        dingdanback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void mydfindID() {
        dingdanback = (ImageView) findViewById(R.id.mydingdan_back);
        all_btn = (RadioButton) findViewById(R.id.myindent_all_btn);
        pay_btn = (RadioButton) findViewById(R.id.myindent_pay_btn);
        take_btn = (RadioButton) findViewById(R.id.myindent_take_btn);
        evaluate_btn = (RadioButton) findViewById(R.id.myindent_evaluate_btn);
        aftersafe_btn = (RadioButton) findViewById(R.id.myindent_aftersafe_btn);
    }

    private void Httpclient() {
        //获取链接管理器
        ConnectivityManager cm = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        //获取当前网络信息对象
        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        //ActiveNetworkInfo不为空
        if (netInfo != null) {
            //网络是否已经链接
            boolean available = netInfo.isAvailable();
            //网络是否链接好并可以传递数据
            boolean connected = netInfo.isConnected();
            if (available && connected) {
                int type = netInfo.getType();
                if (type == ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(this, "wifi网路可用", Toast.LENGTH_SHORT).show();
                } else if (type == ConnectivityManager.TYPE_MOBILE) {
                    Toast.makeText(this, "手机流量可用网路可用", Toast.LENGTH_SHORT).show();
                }
                // Toast.makeText(this, "网路可用", 0).show();
            } else {
                Toast.makeText(this, "网路不可用", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "网路不可用", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK
                && event.getRepeatCount() == 0) {
            //do something...'
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
