package com.easy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;

import com.common.ui.ListViewFragment;
import com.common.ui.WebViewActivity;
import com.easy.R;
import com.easy.api.MainService;
import com.easy.api.ServiceFactory;
import com.easy.pojo.Goods;
import com.easy.pojo.GoodsRepo;
import com.easy.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

/**
 * author miekoz on 2016/3/18.
 * email  meikoz@126.com
 */
public class HomeFragment extends ListViewFragment {

    private List<Goods> billList =new ArrayList<>();

    private HomeAdapter adapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new HomeAdapter(getActivity(), billList, R.layout.item_home_list);
        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Goods item = adapter.getItem(position);
                WebViewActivity.start(getActivity(),item.url,item.who);
            }
        });
        onRecvData();
    }

    private void onRecvData() {
        ServiceFactory.getIns()
                .getBenefitsGoods(ServiceFactory.LOAD_LIMIT, 1)
                .enqueue(new Callback<GoodsRepo>() {
                    @Override
                    public void onResponse(Response<GoodsRepo> response, Retrofit retrofit) {
                      if (!response.body().error){
                          List<Goods> result = response.body().getResults();
                          billList.addAll(result);
                          adapter.notifyDataSetChanged();
                      }
                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
    }

}
