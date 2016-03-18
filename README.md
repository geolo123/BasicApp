[EasyApp ](https://github.com/meikoz/EasyApp)
- efficient，simple develop for android
- Android 基础框架,用于优化开发体验,减少代码量

## Usage
>   EasyApp中common拷入到自己项目的根目录中
    File --> New --> Import Module 选择自己项目的common目录
    
#### EasyApp
>   EasyApp继承Application 初始化一些第三方库

```
public class EasyApp extends Application{
    public Gson gson;
    private static EasyApp ourInstance = new EasyApp();
    public static EasyApp getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        this.initGson();

        LogLevel logLevel;
        if (Config.DEBUG)logLevel =LogLevel.FULL;
        else logLevel=LogLevel.NONE;

        Logger.init().methodOffset(2).methodCount(2).logLevel(logLevel);

        //Secure, simple key-value storage for android
        Hawk.init(this)
                .setEncryptionMethod(HawkBuilder.EncryptionMethod.MEDIUM)
                .setStorage(HawkBuilder.newSqliteStorage(this))
                .build();
    }

    private void initGson() {
        this.gson = new GsonBuilder()
                .setDateFormat(Constant.GANK_DATA_FORMAT)
                .create();
    }
}
```



*设置斜体*
**设置加粗**
*+- 无序列表


`<heelo>`

hello[^hello]

---
