package com.example.center;

import android.content.Context;
import android.media.AudioManager;

public class ChangeVoice {
	private AudioManager am;
	public ChangeVoice(Context context) {
		//获取音频管理服务
		am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	}
	public void setSilence(){		//静音方法
		if(am.getRingerMode()!=AudioManager.RINGER_MODE_SILENT){
			//执行静音
			am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			System.out.println("静音执行了");
		}

	}
	public void setNormal(){		//取消静音方法
		if(am.getRingerMode()!=AudioManager.RINGER_MODE_NORMAL){
			//取消静音
			am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			int ringerVolume = am.getStreamVolume(AudioManager.RINGER_MODE_NORMAL);
			am.setStreamVolume(AudioManager.RINGER_MODE_NORMAL, ringerVolume, 0);
			System.out.println("静音没执行");
		}
	}
}
