package np.pro.degendra.citestingproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by bajra on 6/30/15.
 */
public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
       new Handler().postDelayed(new Runnable() {
           @Override
           public void run() {
               startMainActivity();
           }
       }, 500);
    }

    private void startMainActivity() {
        finish();
        startActivity(new Intent(this, NavigationActivity.class));
    }
}
