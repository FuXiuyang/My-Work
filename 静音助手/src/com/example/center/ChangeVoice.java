package com.example.center;

import android.content.Context;
import android.media.AudioManager;

public class ChangeVoice {
	private AudioManager am;
	public ChangeVoice(Context context) {
		//��ȡ��Ƶ�������
		am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
	}
	public void setSilence(){		//��������
		if(am.getRingerMode()!=AudioManager.RINGER_MODE_SILENT){
			//ִ�о���
			am.setRingerMode(AudioManager.RINGER_MODE_SILENT);
			System.out.println("����ִ����");
		}

	}
	public void setNormal(){		//ȡ����������
		if(am.getRingerMode()!=AudioManager.RINGER_MODE_NORMAL){
			//ȡ������
			am.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
			int ringerVolume = am.getStreamVolume(AudioManager.RINGER_MODE_NORMAL);
			am.setStreamVolume(AudioManager.RINGER_MODE_NORMAL, ringerVolume, 0);
			System.out.println("����ûִ��");
		}
	}
}
