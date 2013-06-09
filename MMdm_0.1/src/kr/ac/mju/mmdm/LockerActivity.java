package kr.ac.mju.mmdm;

import kr.ac.mju.mmdm.R;
import kr.ac.mju.mmdm.R.layout;
import android.app.admin.DeviceAdminReceiver;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.Preference.OnPreferenceClickListener;
import android.preference.PreferenceActivity;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import android.widget.Toast;

public class LockerActivity extends PreferenceActivity implements
		OnPreferenceClickListener {
	public DevicePolicyManager devicePolicyManager;
	public ComponentName adminComponent;
	public boolean is_pass ;
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.layout.activity_locker);

		Preference authorityOn = (Preference) findPreference("authority_on");
		Preference authorityOff = (Preference) findPreference("authority_off");
		Preference lockOn = (Preference) findPreference("lock_on");
		Preference pwOn = (Preference) findPreference("pw_on");
		Preference lockOk = (Preference) findPreference("lock_ok");

		authorityOn.setOnPreferenceClickListener(this);
		authorityOff.setOnPreferenceClickListener(this);
		lockOn.setOnPreferenceClickListener(this);
		pwOn.setOnPreferenceClickListener(this);
		lockOk.setOnPreferenceClickListener(this);
		
		adminComponent = new ComponentName(this,DpmClass.class);
		devicePolicyManager = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
		
	}

	@Override
	public boolean onPreferenceClick(Preference preference) {
		// TODO Auto-generated method stub
		adminComponent = new ComponentName(this,DpmClass.class);
		devicePolicyManager = (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);

		if (preference.getKey().equals("authority_on")) { // 권한 획득
			Log.i("prefer1","ok");
			if (!devicePolicyManager.isAdminActive(adminComponent)) {
				Intent intent = new Intent(
						DevicePolicyManager.ACTION_ADD_DEVICE_ADMIN);
				intent.putExtra(DevicePolicyManager.EXTRA_DEVICE_ADMIN,
						adminComponent);
				intent.putExtra(DevicePolicyManager.EXTRA_ADD_EXPLANATION,
						"Additional text explaining why this needs to be added.");
				startActivityForResult(intent, 1);
				Log.i("prefer1","ok2");
			}
		} else if (preference.getKey().equals("authority_off")) { // 권한 해제
			if (devicePolicyManager.isAdminActive(adminComponent)) {
				devicePolicyManager.removeActiveAdmin(adminComponent);
			}
		} else if (preference.getKey().equals("lock_on")) { // 화면 잠금
			if (devicePolicyManager.isAdminActive(adminComponent))
				devicePolicyManager.lockNow();
		} else if (preference.getKey().equals("pw_on")) { //비밀번호 설정
			Intent intent = new Intent(
					DevicePolicyManager.ACTION_SET_NEW_PASSWORD);
			startActivity(intent);
		} else if (preference.getKey().equals("lock_ok")) { //확인
			String PASSWORD_TYPE_KEY = "lockscreen.password_type";
			try {
				final boolean isPattern = 1 == android.provider.Settings.System
						.getLong(
								getContentResolver(),
								android.provider.Settings.System.LOCK_PATTERN_ENABLED);

				long mode = android.provider.Settings.Secure.getLong(
						getContentResolver(), PASSWORD_TYPE_KEY);
				final boolean isPassword = DevicePolicyManager.PASSWORD_QUALITY_NUMERIC == mode
						|| DevicePolicyManager.PASSWORD_QUALITY_ALPHABETIC == mode
						|| DevicePolicyManager.PASSWORD_QUALITY_ALPHANUMERIC == mode;

				is_pass = isPassword || isPattern;
			} catch (SettingNotFoundException e) {
				e.printStackTrace();

			}
		}

	

		return false;
	}
	
	public static class DpmClass extends DeviceAdminReceiver {
		static SharedPreferences getSamplePreferences(Context context) {
			return context.getSharedPreferences(
					DeviceAdminReceiver.class.getName(), 0);
		};

		void showToast(Context context, CharSequence msg) {
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}

		@Override
		public void onEnabled(Context context, Intent intent) {
			// 기기권한이 설정되었을 경우
			showToast(context, "Device Admin enabled");
		}

		@Override
		public CharSequence onDisableRequested(Context context, Intent intent) {
			return "This is an optional message to warn the user about disabling.";
		}

		@Override
		public void onDisabled(Context context, Intent intent) {
			// 기기 권한이 해제 됬을 경우
			showToast(context, "Device Admin Disabled");
		}

		@Override
		public void onPasswordChanged(Context context, Intent intent) {
			// 패스워드 상태가 변경되었을 경우
			showToast(context, "Password Change");
		}

		@Override
		public void onPasswordFailed(Context context, Intent intent) {
			// 패스워드 입력이 실패했을 겨우
			showToast(context, "PasswordFailed");
		}

		@Override
		public void onPasswordSucceeded(Context context, Intent intent) {
			// 패스워드를 정상적으로 입력했을 경우
			showToast(context, "PasswordSucceeded");
		}

	}

}
