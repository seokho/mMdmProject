package kr.ac.mju.mmdm.network;

import kr.ac.mju.mmdm.R;
import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;



public class NetworkActivity extends Activity implements OnCheckedChangeListener{
	ToggleButton wifiBtn;
	ToggleButton airBtn;
	String service ;
	WifiManager wifi;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_network);
		
		wifiBtn = (ToggleButton)findViewById(R.id.wifitoggle);
		airBtn = (ToggleButton)findViewById(R.id.airtoggle);
		
		service = Context.WIFI_SERVICE;
		wifi = (WifiManager)getSystemService(service);
		
		wifiBtn.setOnCheckedChangeListener(this);
		if(isWifiConnected()){
			wifiBtn.setChecked(false);
		}else {
			wifiBtn.setChecked(true);
		}
		
		
	}
	private boolean isWifiConnected() {
		ConnectivityManager connMgr = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
		if(connMgr != null){
			NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
			if((networkInfo != null)&&(networkInfo.isAvailable() == true)){
				if(networkInfo.getType()==ConnectivityManager.TYPE_WIFI){
					if((networkInfo.getState()==State.CONNECTED)||(networkInfo.getState()==State.CONNECTING)){
						return false;
					}
				}
			}
		}
		return true;
	}
	
	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		// TODO Auto-generated method stub
		if(buttonView.getId()==wifiBtn.getId()){
			if(isChecked){
				wifi.setWifiEnabled(true);
			}else{
				wifi.setWifiEnabled(false);
			}
			
		}else {
			if(isChecked){
				
			}else{
				
			}
		}
	}

}
