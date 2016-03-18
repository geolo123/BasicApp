>   efficient，simple develop for android

[EasyApp ](https://github.com/meikoz/EasyApp)

-   业务时间写的Android基础框架,方便开发
-   避免重复代码过多问题
-   站在巨人的肩膀上前进，不要重复造轮子

## Usage
-   EasyApp中common拷入到自己项目的根目录中
-   File --> New --> Import Module 选择自己项目的common目录
-   写了一些公共基础类可以继承减少代码的实现,和业务逻辑的编写
-   正在摸索阶段,可能还不是很规范
    
## code规范
由于最近在进行公司代码重构和代码规范的整理，发现项目中有好多重复页面,重复代码可以利用。
[EasyApp ](https://github.com/meikoz/EasyApp)
在这个项目进行了一些Ui公共基础的封装

## NetWork层
Retrofit 
>   Retrofit是square组织推出的一个类型安全用于java以及Android的网络请求库，我之所以喜爱它的最重要的原因之一是优美的RestApi风格的代码。
如果后端使用的也是Restful风格的接口，那么Retrofit是你最好的选择。

[官方网站 ](http://square.github.io/retrofit/)
[详细使用教程 ](http://inthecheesefactory.com/blog/retrofit-2.0/en)

接口层封装了网络底层的API,Retrofit网络请求库
①.RestApi,网络请求的配置封装

    public static <T> T createService(Class<T> clz){
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(7676, TimeUnit.MILLISECONDS);

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
    
②.MainService,UserService,根据业务定义接口类,定义所有接口方法
```
  @GET("data/{type}/{size}/{page}")
    Call<Repo> getData(
            @Path("type") String type,
            @Path("size") int size,
            @Path("page") int page
    );
```
③.Repo,响应类,封装HTTP请求返回的数据结构
```
public class RepnBo<T> {
    public int errcode;
    public String errmsg;
    public T data;

    public boolean isSuccess() {
        return errcode == 0;
    }
}
{  "errcode":0, "errmsg":"用于提示用户请求结果""data":[{ }] }
```

##  Ui层
-   BaseActivity 用于管理每一个Activity 写一些公共方法 showLoading(),showToast()
-   EasyApp继承Application 初始化一些第三方库
-   继承ReplaceActivity 调用replaceFragment(new NewFragment) 用户使用Fragment代替Activity使用
-   继承ListViewFragment 不用每一个列表页面单独写一个布局 进行统一处理刷新 加载
-   WebViewActivity 进行仿微信加载WebView显示进度条,直接调用start()方法进行跳转.
-   EasyToolBar 顶部导航栏 布局里面<include layout="@layout/view_tool_bar" /> 继承BaseActivity initTitleBar方法
-   继承CommonAdapter 实现convert(ViewHolder helper, T item) helper.setText( 设置文字为控件).
-   LocalStorage 进行本地数据缓存 Key Value形式

##  Code规范
①.缩进    
很多人都习惯用Tab缩进，不管是规范4个空格还是2个空格，统一设置好Tab缩进的size就好了

②.命名
资源id命名结构为:控件_范围_功能,列如: edit_login_password,登录密码输入框












