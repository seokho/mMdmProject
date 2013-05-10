package kr.ac.mju.mmdm.taskmanager;

import java.util.List;

import kr.ac.mju.mmdm.R;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class TaskManagerActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		
		Button btn1 = (Button)findViewById(R.id.killbtn);
		
		btn1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
				PackageManager pkManager = getPackageManager();
				List<RunningAppProcessInfo> runningAppList = manager.getRunningAppProcesses();

				for (RunningAppProcessInfo info : runningAppList) {
				    // info.processName
					String process = info.processName;
					manager.killBackgroundProcesses(process);
				}
				
				Toast.makeText(getBaseContext(), "Killed", 0).show();
			}
			
		});
	}
	
}