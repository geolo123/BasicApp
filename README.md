[EasyApp ](https://github.com/meikoz/EasyApp)
- efficient，simple develop for android
- Android 基础框架,用于优化开发体验,减少代码量

## Usage
- EasyApp中common拷入到自己项目的根目录中
- File --> New --> Import Module 选择自己项目的common目录
    
##### EasyApp
>   EasyApp继承Application 初始化一些第三方库

##### ReplaceActivity
>   用于Fragment替换Activity使用 只要继承ReplaceActivity replaceFragment(new 使用Fragment())

```
public class MainActivity extends ReplaceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initTitleBar("replaceFragment");
        replaceFragment(new HomeFragment());
    }
}
```

##### ListViewFragment
>   只要继承ListViewFragment 不用没页面单独写布局

```
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
```

---
