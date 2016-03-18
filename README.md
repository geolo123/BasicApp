[EasyApp ](https://github.com/meikoz/EasyApp)
-   efficient，simple develop for android
-   Android 基础框架,用于优化开发体验,减少代码量

## Usage
-   EasyApp中common拷入到自己项目的根目录中
-   File --> New --> Import Module 选择自己项目的common目录
    
#### Class Usage
-   EasyApp继承Application 初始化一些第三方库
-   继承ReplaceActivity 调用replaceFragment(new NewFragment) 用户使用Fragment代替Activity使用
-   继承ListViewFragment 不用每一个列表页面单独写一个布局 进行统一处理刷新 加载
-   WebViewActivity 进行仿微信加载WebView显示进度条,直接调用start()方法进行跳转.
-   EasyToolBar 顶部导航栏 布局里面<include layout="@layout/view_tool_bar" /> 继承BaseActivity initTitleBar方法
-   继承CommonAdapter 实现convert(ViewHolder helper, T item) helper.setText( 设置文字为控件).
-   LocalStorage 进行本地数据缓存 Key Value形式
-   RestApi 实例化Retrofit 返回Service 实现与服务器调用

```
   public static <T> T createService(Class<T> clz){

        //okhttp
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(7676, TimeUnit.MILLISECONDS);

        //log
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        okHttpClient.interceptors().add(interceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(EasyApp.getInstance().gson))
                .client(okHttpClient)
                .build();
        return retrofit.create(clz);
    }
```
