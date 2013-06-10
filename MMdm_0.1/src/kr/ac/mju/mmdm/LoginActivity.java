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
		
		Button logInBtn = (Button)findViewById(R.id.sign_in_button);  		//�α����ϸ� ������ ���� �� ok �Ѿ ,�ٸ��� ���Է� Ȥ�� ȸ������
	//	Button notUserBtn = (Button)findViewById(R.id.nonsign_in_button);	//��ȸ�� ����ڵ� 
	//	Button registBtn = (Button)findViewById(R.id.regist_in_button); 	//ȸ������ ��ư
	//	CheckBox autoCheck = (CheckBox)findViewById(R.id.autoLogin);		//������ �α��ν� �ڵ� �α���
	//	EditText idTxt = (EditText)findViewById(R.id.id);					//���̵� �Է�
	// pswTxt = (EditText)findViewById(R.id.password);			//��� �Է�
		
//		notUserBtn.setOnClickListener(new OnClickListener() { 				//��ȸ�� �α��� ȭ������ �ѱ�
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
//		registBtn.setOnClickListener(new OnClickListener() { 				//ȸ������ ȭ������ �ѱ�
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//		});
		
		logInBtn.setOnClickListener(new OnClickListener() { 				//�α��� Ȯ���۾�

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(), UserActivity.class); //�������� �� �̶� �ϴ� ��ɱ��� ����
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
