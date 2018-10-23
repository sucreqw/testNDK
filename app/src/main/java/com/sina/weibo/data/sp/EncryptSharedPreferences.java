package com.sina.weibo.data.sp;

import android.content.Context;

public class EncryptSharedPreferences {

    private native byte[] loadSpFile(Context paramContext, String paramString);

    private native void saveSpFile(Context paramContext, String paramString, byte[] paramArrayOfByte);

}
