package kr.ac.mju.mmdm.notuser;

import kr.ac.mju.mmdm.R;
import kr.ac.mju.mmdm.member.UserActivity;
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
					Intent intent = new Intent(NotUserActivity.this, ~.class);
					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(NotUserActivity.this, ~.class);
					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(NotUserActivity.this, ~.class);
					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(NotUserActivity.this, ~.class);
					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(NotUserActivity.this, ~.class);
					startActivity(intent);
				}else if(position == 1){
					Intent intent = new Intent(NotUserActivity.this, ~.class);
					startActivity(intent);
				}
				
			}
			
		});
		
	}

}
