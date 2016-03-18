package com.easy.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;

import com.common.api.GsonCallback;
import com.common.api.RestApi;
import com.common.ui.ListViewFragment;
import com.common.ui.WebViewActivity;
import com.easy.R;
import com.easy.bo.Repo;
import com.easy.db.UserService;
import com.easy.ui.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit.Response;

/**
 * author miekoz on 2016/3/18.
 * email  meikoz@126.com
 */
public class HomeFragment extends ListViewFragment {

    private List<Repo.ResultsEntity> billList =new ArrayList<>();
    private HomeAdapter adapter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adapter = new HomeAdapter(getActivity(), billList, R.layout.item_home_list);
        getListView().setAdapter(adapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Repo.ResultsEntity item = adapter.getItem(position);
                WebViewActivity.start(getActivity(),item.getUrl(),item.getWho());
            }
        });
        onRecvData();
    }

    private void onRecvData() {
        RestApi.createService(UserService.class).getData("Android",10,1).enqueue(new GsonCallback<Repo>() {
            @Override
            protected void onSuccess(Response<Repo> response) {
                Repo body = response.body();
                if (!body.isError()){
                    List<Repo.ResultsEntity> results = body.getResults();
                    billList.addAll(results);
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            protected void onFail(Throwable t) {

            }
        });
    }

}
