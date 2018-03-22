package com.xiumei.housekeeper.retrofit;

import com.xiumei.housekeeper.base.BaseEntity;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @des 加载网络请求接口
 * Created by zjj on 2018/3/22 13:48.
 */

public interface ApiService {
    @GET("p/ab337390be34")
    Call<BaseEntity> getInfo();

    Observable<BaseEntity> getInfos();
}
