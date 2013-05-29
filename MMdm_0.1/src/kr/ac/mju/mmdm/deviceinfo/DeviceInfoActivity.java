package kr.ac.mju.mmdm.deviceinfo;

import java.io.File;

import kr.ac.mju.mmdm.R;
import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.os.StatFs;
import android.view.Menu;
import android.widget.TextView;

public class DeviceInfoActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		TextView txtInterTotal = (TextView) findViewById(R.id.textView1);
		TextView txtInterAvailTotal = (TextView) findViewById(R.id.textView2);
		TextView txtExterTotal = (TextView) findViewById(R.id.textView3);
		TextView txtExterAvailTotal = (TextView) findViewById(R.id.textView4);

		txtInterTotal.setText("1.내장메모리 : "
				+ formatSize(getTotalInternalMemorySize()));
		txtInterAvailTotal.setText("2.사용가능 : "
				+ formatSize(getInternalMemorySize()));
		txtExterTotal.setText("3.외장메모리 : "
				+ formatSize(getTotalExternalMemorySize()));
		txtExterAvailTotal.setText("4.사용가능 : "
				+ formatSize(getExternalMemorySize()));
	}

	/** 전체 내장 메모리 크기를 가져온다 */
	private long getTotalInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long totalBlocks = stat.getBlockCount();

		return totalBlocks * blockSize;
	}

	/** 사용가능한 내장 메모리 크기를 가져온다 */
	private long getInternalMemorySize() {
		File path = Environment.getDataDirectory();
		StatFs stat = new StatFs(path.getPath());
		long blockSize = stat.getBlockSize();
		long availableBlocks = stat.getAvailableBlocks();

		return availableBlocks * blockSize;
	}

	/** 전체 외장 메모리 크기를 가져온다 */
	private long getTotalExternalMemorySize() {
		if (isStorage(true) == true) {
			File path = Environment.getExternalStorageDirectory();
			StatFs stat = new StatFs(path.getPath());
			long blockSize = stat.getBlockSize();
			long totalBlocks = stat.getBlockCount();

			return totalBlocks * blockSize;
		} else {
			return -1;
		}
	}

	/** 사용가능한 외장 메모리 크기를 가져온다 */
	private long getExternalMemorySize() {
		if (isStorage(true) == true) {
			File path = Environment.getExternalStorageDirectory();
			StatFs stat = new StatFs(path.getPath());
			long blockSize = stat.getBlockSize();
			long availableBlocks = stat.getAvailableBlocks();
			return availableBlocks * blockSize;
		} else {
			return -1;
		}
	}

	/** 보기 좋게 MB,KB 단위로 축소시킨다 */
	private String formatSize(long size) {
		String suffix = null;

		if (size >= 1024) {
			suffix = "KB";
			size /= 1024;
			if (size >= 1024) {
				suffix = "MB";
				size /= 1024;
			}
		}
		StringBuilder resultBuffer = new StringBuilder(Long.toString(size));

		int commaOffset = resultBuffer.length() - 3;
		while (commaOffset > 0) {
			resultBuffer.insert(commaOffset, ',');
			commaOffset -= 3;
		}

		if (suffix != null) {
			resultBuffer.append(suffix);
		}

		return resultBuffer.toString();
	}

	/** 외장메모리 sdcard 사용가능한지에 대한 여부 판단 */
	private boolean isStorage(boolean requireWriteAccess) {
		String state = Environment.getExternalStorageState();

		if (Environment.MEDIA_MOUNTED.equals(state)) {
			return true;
		} else if (!requireWriteAccess
				&& Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
}