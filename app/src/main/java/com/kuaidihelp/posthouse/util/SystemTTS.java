package com.kuaidihelp.posthouse.util;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.util.HashMap;
import java.util.Locale;

public class SystemTTS extends UtteranceProgressListener implements TTS, TextToSpeech.OnUtteranceCompletedListener {
    private Context mContext;
    private static SystemTTS singleton;
    private TextToSpeech textToSpeech; // 系统语音播报类
    private boolean isSuccess = true;

    public static SystemTTS getInstance(Context context) {
        if (singleton == null) {
            synchronized (SystemTTS.class) {
                if (singleton == null) {
                    singleton = new SystemTTS(context);
                }
            }
        }
        return singleton;
    }

    private SystemTTS(Context context) {
        this.mContext = context.getApplicationContext();
        textToSpeech = new TextToSpeech(mContext, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                //系统语音初始化成功
                if (i == TextToSpeech.SUCCESS) {
                    int result = textToSpeech.setLanguage(Locale.CHINA);
                    textToSpeech.setPitch(1.0f);// 设置音调，值越大声音越尖（女生），值越小则变成男声,1.0是常规
                    textToSpeech.setSpeechRate(1.2f);

                    textToSpeech.setOnUtteranceProgressListener(SystemTTS.this);
                    textToSpeech.setOnUtteranceCompletedListener(SystemTTS.this);
                    if (result == TextToSpeech.LANG_MISSING_DATA
                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                        //系统不支持中文播报
                        isSuccess = false;
                    }
                }

            }
        });
    }

    public void playText(String playText) {
        if (!isSuccess) {
            Toast.makeText(mContext, "系统不支持中文播报", Toast.LENGTH_SHORT).show();
            return;
        }
        if (textToSpeech != null) {
            textToSpeech.speak(playText,
                    TextToSpeech.QUEUE_ADD, null, null);

//            File sdCardDir = new File(mContext.getExternalCacheDir() + "/TTStoMP3");
//            if (!sdCardDir.exists())   sdCardDir.mkdir();    //保存在储存TTStoMP3目录下
//
//            HashMap<String, String> myHashRender = new HashMap<String, String>();
//            myHashRender.put(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "出库成功");
//            int r = textToSpeech.synthesizeToFile("出库成功", myHashRender, sdCardDir+"/" + "出库成功" + ".wav");
//            if (r == TextToSpeech.SUCCESS) {
//                //保存成功
//                Log.d("wxw","----success");
//            }else {
//                //保存失败
//                Log.d("wxw","----fail");
//            }
        }
    }

    public void stopSpeak() {
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }

//    public boolean isSpeaking() {
//        if (textToSpeech.isSpeaking()) {
//            return true;
//        }
//        return false;
//    }


    //播报完成回调
    @Override
    public void onUtteranceCompleted(String utteranceId) {

    }

    @Override
    public void onStart(String utteranceId) {

    }

    @Override
    public void onDone(String utteranceId) {
    }

    @Override
    public void onError(String utteranceId) {

    }
}

