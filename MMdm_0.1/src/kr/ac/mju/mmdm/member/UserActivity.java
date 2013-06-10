package kr.ac.mju.mmdm.member;

import kr.ac.mju.mmdm.LockerActivity;
import kr.ac.mju.mmdm.R;
import kr.ac.mju.mmdm.appdel.AppDeleteActivity;
import kr.ac.mju.mmdm.appinstall.AppInstallActivity;
import kr.ac.mju.mmdm.backup.BackupActivity;
import kr.ac.mju.mmdm.deviceinfo.DeviceInfoActivity;
import kr.ac.mju.mmdm.leave.LeaveActivity;
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

public class UserActivity extends Activity{
	
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
					Intent intent = new Intent(UserActivity.this, TaskManagerActivity.class);
					startActivity(intent);
//				}else if(position == 1){
//					Intent intent = new Intent(UserActivity.this, ResetActivity.class);
//					startActivity(intent);
//				}else if(position == 2){
//					Intent intent = new Intent(UserActivity.this, AppInstallActivity.class);
//					startActivity(intent);
//				}else if(position == 3){
//					Intent intent = new Intent(UserActivity.this, AppDeleteActivity.class);
//					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(UserActivity.this, LockerActivity.class);
					startActivity(intent);
				}else if(position == 2){
					Intent intent = new Intent(UserActivity.this, DeviceInfoActivity.class);
					startActivity(intent);
				}else if(position == 3){
					Intent intent = new Intent(UserActivity.this, NetworkActivity.class);
					startActivity(intent);
//				}else if(position == 7){
//					Intent intent = new Intent(UserActivity.this, LeaveActivity.class);
//					startActivity(intent);
//				}else if(position == 8){
//					Intent intent = new Intent(UserActivity.this, BackupActivity.class);
//					startActivity(intent);
				}
				
			}
			
		});
		
	}

}
