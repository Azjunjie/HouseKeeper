package com.xiumei.housekeeper;


import android.support.v4.hardware.fingerprint.FingerprintManagerCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.xiumei.housekeeper.base.BaseEntity;
import com.xiumei.housekeeper.base.BaseMvpActivity;
import com.xiumei.housekeeper.base.BasePresenter;
import com.xiumei.housekeeper.config.GlideApp;
import com.xiumei.housekeeper.retrofit.RetrofitClient;
import com.xiumei.housekeeper.util.GlideUtils;
import com.xiumei.housekeeper.util.LogUtils;
import com.xiumei.housekeeper.util.ToastUtils;

import butterknife.BindView;
import io.reactivex.Flowable;
import io.reactivex.Observer;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 闪屏页面
 * Created by zjj on 2018/3/20 17:05.
 */
public class SplashActivity extends BaseMvpActivity {
    @BindView(R.id.iv)
    ImageView mIv;

    @Override
    protected BasePresenter createPresenter() {
        return new BasePresenter() {
            @Override
            public void subscribe() {
                RetrofitClient.getApiService()
                        .getInfo()
                        .enqueue(new Callback<BaseEntity>() {
                            @Override
                            public void onResponse(Call<BaseEntity> call, Response<BaseEntity> response) {
                                ToastUtils.showToast(SplashActivity.this, "请求成功");
                            }

                            @Override
                            public void onFailure(Call<BaseEntity> call, Throwable t) {
                                ToastUtils.showToast(SplashActivity.this, "请求失败");
                            }
                        });
            }

            CompositeDisposable disposables = new CompositeDisposable();

            @Override
            public void unSubscribe() {
                Disposable disposable = Flowable.just("")
                        .subscribe();
                disposables.add(disposable);

                RetrofitClient.getApiService()
                        .getInfos()
                        .subscribe(new Observer<BaseEntity>() {

                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(BaseEntity baseEntity) {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
            }
        };
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {
        GlideUtils.load(this,
                "http://f9.topitme.com/9/37/30/11224703137bb30379o.jpg",
                mIv);

        FingerprintManagerCompat fingerprintManagerCompat = FingerprintManagerCompat.from(this);

        boolean hardwareDetected = fingerprintManagerCompat.isHardwareDetected();
        LogUtils.e(TAG, "hardwareDetected==" + hardwareDetected);
        boolean hasEnrolledFingerprints = fingerprintManagerCompat.hasEnrolledFingerprints();
        LogUtils.e(TAG, "hasEnrolledFingerprints==" + hasEnrolledFingerprints);
        int a = 2;
        a = a << 2;
        LogUtils.e(TAG, "2<<2==" + a);
    }

    @Override
    public void showLoadView() {

    }

    @Override
    public void hideLoadView() {

    }

    @Override
    public void showLoadErr(String err) {
        GlideApp.with(this)
                .asBitmap()
                .centerCrop();
    }

    public void onClickCustomer(View view) {
        Toast toast = new Toast(this);
        View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_toast_item, null);
        toast.setView(inflate);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.show();
    }

    public void onClickSystem(View view) {
        ToastUtils.showToast(getApplicationContext(), "弹窗吐司。。。。");
    }

    public void onClickDefault(View view) {
        ToastUtils.showToast(getApplicationContext(), "弹窗吐司22。。。。");
    }

}
