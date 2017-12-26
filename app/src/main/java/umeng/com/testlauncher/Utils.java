package umeng.com.testlauncher;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.AppTask;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by wangfei on 2017/12/8.
 */

public class Utils {
    public static void getTask(Context context){
        ActivityManager  mAm = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<AppTask> list =  mAm.getAppTasks();
        for (AppTask appTask:list){
            Log.e("Utils",context.getClass().getName()+"  "+appTask.getTaskInfo().affiliatedTaskId+"的num = "+appTask.getTaskInfo().numActivities);

        }
    }
    public static void getTaskInfo(Activity activity, TextView tv){
        ArrayList<String> result = new ArrayList<>();
        result.add("当前Taskid:"+activity.getTaskId());
        result.add("以下为当前存在Task信息:");
        ActivityManager  mAm = (ActivityManager) activity.getSystemService(Context.ACTIVITY_SERVICE);
        List<AppTask> list =  mAm.getAppTasks();
        for (AppTask appTask:list){
            result.add("Taskid = "+appTask.getTaskInfo().affiliatedTaskId);
            result.add("Task中activity的数量= "+appTask.getTaskInfo().numActivities);
            result.add("Task中desc "+appTask.getTaskInfo().taskDescription.getLabel());
            result.add("*************************************** ");
        }
        StringBuilder sb = new StringBuilder();
        for (String s:result){
            sb.append(s).append("\n");
        }
        tv.setText(sb);
    }
   public static String getCurProcessName(Context context) {
        int pid = android.os.Process.myPid();
        ActivityManager mActivityManager = (ActivityManager) context
            .getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : mActivityManager
            .getRunningAppProcesses()) {
            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
