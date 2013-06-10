package kr.ac.mju.mmdm.taskmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;



public class TaskManagerActivity extends Activity {
	static ActivityManager manager;
	static List<RunningAppProcessInfo> runningAppList;
	List<HashMap<String, String>> aList;
	PackageManager pkManager;
	ListView lv;
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_task);
		
		Button btn1 = (Button)findViewById(R.id.killbtn);
		lv = (ListView)findViewById(R.id.processlist);
		
		manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		pkManager = getPackageManager();
		//listview 에 쑤셔넣기
		goList();
		
		btn1.setOnClickListener(new OnClickListener() { //버튼 클릭해서 모든 프로세스 삭제
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				

				for (RunningAppProcessInfo info : runningAppList) {
				    // info.processName
					String process = info.processName;
					manager.killBackgroundProcesses(process);
				}
				
				goList();
				
				Toast.makeText(getBaseContext(), "Killed", 0).show();
			}
			
		});
	}
	
	public void goList() {
		aList = new ArrayList<HashMap<String, String>>();

		runningAppList = manager.getRunningAppProcesses();
		
		for (RunningAppProcessInfo info : runningAppList) {
		    // info.processName
			HashMap<String, String> item = new HashMap<String, String>();
			item.put("name", info.processName);
			aList.add(item);
		}
		SimpleAdapter adapter = new SimpleAdapter(this, aList, R.layout.list_process,
				new String[] {"name"},
				new int[]{R.id.processname});
		lv.setAdapter(adapter);
	}
	
	public static String receiveString(String s) {
		runningAppList = manager.getRunningAppProcesses();
		for(RunningAppProcessInfo info : runningAppList) {
			s = info.processName + ",";
		}
		return s;
		
	}
	
}