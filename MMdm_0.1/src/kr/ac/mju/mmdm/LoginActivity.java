package kr.ac.mju.mmdm;

import kr.ac.mju.mmdm.member.UserActivity;
import kr.ac.mju.mmdm.notuser.NotUserActivity;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class LoginActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		Button logInBtn = (Button)findViewById(R.id.sign_in_button);  		//로그인하면 서버에 전송 비교 ok 넘어감 ,다르면 재입력 혹은 회원가입
	//	Button notUserBtn = (Button)findViewById(R.id.nonsign_in_button);	//비회원 사용자들 
	//	Button registBtn = (Button)findViewById(R.id.regist_in_button); 	//회원가입 버튼
	//	CheckBox autoCheck = (CheckBox)findViewById(R.id.autoLogin);		//앞으로 로그인시 자동 로그인
	//	EditText idTxt = (EditText)findViewById(R.id.id);					//아이디 입력
	// pswTxt = (EditText)findViewById(R.id.password);			//비번 입력
		
//		notUserBtn.setOnClickListener(new OnClickListener() { 				//비회원 로그인 화면으로 넘김
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				Intent i = new Intent(getBaseContext(), NotUserActivity.class);
//				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//				startActivity(i);
//			}
//			
//		});
//		
//		registBtn.setOnClickListener(new OnClickListener() { 				//회원가입 화면으로 넘김
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		
		logInBtn.setOnClickListener(new OnClickListener() { 				//로그인 확인작업

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), UserActivity.class); //서버연동 전 이라 일단 기능구현 먼저
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(i);
			}
			
		});
		startService(new Intent("kr.ac.mju.mmdm.MdmService"));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
	

}
