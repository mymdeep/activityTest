package umeng.com.testlauncher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

/**
 * Created by wangfei on 2017/12/8.
 */

public class FourthActivity extends AppCompatActivity {
    TextView tv1,tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = (TextView)findViewById(R.id.text1);
        tv1.setText("FourthActivity");
        tv2 = (TextView)findViewById(R.id.text2);
        findViewById(R.id.btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FourthActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        Log.e("xxxxxx",this.getClass().getSimpleName()+"  onCreate");


    }
    @Override
    protected void onResume() {
        super.onResume();
        if (tv2!=null){
            Utils.getTaskInfo(this,tv2);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("xxxxxx",this.getClass().getSimpleName()+"  onNewIntent");
    }
}