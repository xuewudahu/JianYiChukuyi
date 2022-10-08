package com.rq.net.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

public class Base64Util {
    private static final char[] encodeTable;

    private static final char last2byte = (char)Integer.parseInt("00000011", 2);

    private static final char last4byte = (char)Integer.parseInt("00001111", 2);

    private static final char last6byte = (char)Integer.parseInt("00111111", 2);

    private static final char lead2byte;

    private static final char lead4byte;

    private static final char lead6byte = (char)Integer.parseInt("11111100", 2);

    static {
        lead4byte = (char)Integer.parseInt("11110000", 2);
        lead2byte = (char)Integer.parseInt("11000000", 2);
        encodeTable = new char[] {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd',
                'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
                'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
                'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7',
                '8', '9', '+', '/' };
    }

    public static Bitmap base64StringtoBitmap(String paramString) {
        try {
            byte[] arrayOfByte;
            if ((paramString.split(",")).length > 1) {
                arrayOfByte = Base64.decode(paramString.split(",")[1], 0);
            } else {
                arrayOfByte = Base64.decode(paramString, 0);//(String)arrayOfByte
            }
            return BitmapFactory.decodeByteArray(arrayOfByte, 0, arrayOfByte.length);
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public static String encode(byte[] paramArrayOfbyte) {
        double d = paramArrayOfbyte.length;
        Double.isNaN(d);
        StringBuffer stringBuffer = new StringBuffer((int)(d * 1.34D) + 3);
        int k = 0;
        int j = 0;
        int i = 0;
        while (k < paramArrayOfbyte.length) {
            for (j %= 8; j < 8; j += 6) {
                if (j != 0) {
                    if (j != 2) {
                        char c;
                        if (j != 4) {
                            if (j != 6)
                                continue;
                            c = (char)((char)(paramArrayOfbyte[k] & last2byte) << 4);
                            int m = k + 1;
                            i = c;
                            if (m < paramArrayOfbyte.length) {
                                i = (paramArrayOfbyte[m] & lead4byte) >>> 4;
                            } else {
                                continue;
                            }
                        } else {
                            c = (char)((char)(paramArrayOfbyte[k] & last4byte) << 2);
                            int m = k + 1;
                            i = c;
                            if (m < paramArrayOfbyte.length) {
                                i = (paramArrayOfbyte[m] & lead2byte) >>> 6;
                            } else {
                                continue;
                            }
                        }
                        i = c | i;
                    } else {
                        i = paramArrayOfbyte[k] & last6byte;
                    }
                } else {
                    i = (char)(paramArrayOfbyte[k] & lead6byte) >>> 2;
                }
                i = (char)i;
                continue;
                //stringBuffer.append(encodeTable[i]);
            }
            k++;
        }
        if (stringBuffer.length() % 4 != 0)
            for (i = 4 - stringBuffer.length() % 4; i > 0; i--)
                stringBuffer.append("=");
        return stringBuffer.toString();
    }

    public static String getBaseString(byte[] paramArrayOfbyte) {
        return Base64.encodeToString(paramArrayOfbyte, 2);
    }
}