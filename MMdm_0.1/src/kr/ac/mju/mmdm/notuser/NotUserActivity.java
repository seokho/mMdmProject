package kr.ac.mju.mmdm.notuser;

import kr.ac.mju.mmdm.R;
import kr.ac.mju.mmdm.appdel.AppDeleteActivity;
import kr.ac.mju.mmdm.appinstall.AppInstallActivity;
import kr.ac.mju.mmdm.deviceinfo.DeviceInfoActivity;
import kr.ac.mju.mmdm.locker.LockerActivity;
import kr.ac.mju.mmdm.network.NetworkActivity;
import kr.ac.mju.mmdm.reset.ResetActivity;
import kr.ac.mju.mmdm.taskmanager.TaskManagerActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class NotUserActivity extends Activity{
	
	private int[] imageIDs = new int[] {
			R.drawable.ic_launcher,
	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notuser);
		
		GridView gridViewImages = (GridView)findViewById(R.id.gridview);
		ImageGridAdapter imageGridAdapter = new ImageGridAdapter(this);
		gridViewImages.setAdapter(imageGridAdapter);
		
		gridViewImages.setOnItemClickListener(new OnItemClickListener(){

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				if (position == 0 ){
					Intent intent = new Intent(NotUserActivity.this, TaskManagerActivity.class);
					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(NotUserActivity.this, ResetActivity.class);
					startActivity(intent);
				}else if(position == 2){
					Intent intent = new Intent(NotUserActivity.this, AppInstallActivity.class);
					startActivity(intent);
				}else if(position == 3){
					Intent intent = new Intent(NotUserActivity.this, AppDeleteActivity.class);
					startActivity(intent);
				}else if(position == 4){
					Intent intent = new Intent(NotUserActivity.this, LockerActivity.class);
					startActivity(intent);
				}else if(position == 5){
					Intent intent = new Intent(NotUserActivity.this, DeviceInfoActivity.class);
					startActivity(intent);
				}else if(position == 6){
					Intent intent = new Intent(NotUserActivity.this, NetworkActivity.class);
					startActivity(intent);
				}
				
			}
			
		});
		
	}

}
