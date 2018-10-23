package com.sina.weibo;

import android.content.Context;

import java.io.File;

//Java_  com_sina_weibo_WeiboApplication_newCalculateS
public class WeiboApplication {

    static {

    try
    {
        System.loadLibrary("utility");
    }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
        System.out.print("load...wrong!!!");
    }
    }
    public native void init(String paramString);

    public native void initDaemon(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4);

    public native String calculateS(String paramString);
   // public native static String CalculateS(String paramString);
    public native String newCalculateS(String paramString);
    public native String generateCheckToken(String paramString1, String paramString2);

    public native String getDecryptionString(String paramString);

    public native String getIValue(String paramString);
    public native com.sina.weibo.net.e getNetInstance(Context paramContext, String paramString);

    public native com.sina.weibo.net.e getNetInstanceFromHotFix(Context paramContext, String paramString1, File paramFile, String paramString2, String paramString3, String paramString4);

}
