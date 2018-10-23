package tv.xiaoka.base.util;

public class Encrypt {
    static {


        try
        {
            System.loadLibrary("xiaoka");
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
            System.out.print("load...wrong!!!");
        }
    }

    public native String get563(String paramString);
}
