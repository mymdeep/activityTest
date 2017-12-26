package umeng.com.testlauncher;

import android.app.Application;
import android.util.Log;

/**
 * Created by wangfei on 2017/12/23.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        StaticParam.a ="init";
        Log.e("xxxxxx","application:"+Utils.getCurProcessName(this)+ "    "+StaticParam.a.getClass().toString());
    }
}
