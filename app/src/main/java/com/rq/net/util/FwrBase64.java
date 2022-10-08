package com.rq.net.util;

//import kotlin.jvm.internal.*;
import java.nio.charset.*;
//import kotlin.*;
import java.io.*;

public final class FwrBase64
{
    public static final FwrBase64 INSTANCE;
    private static final byte[] base64DecodeChars;
    private static final char[] base64EncodeChars;
    
    static {
        INSTANCE = new FwrBase64();
        base64EncodeChars = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/' };
        base64DecodeChars = new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1 };
    }
    
    private FwrBase64() {
    }
    
    public final byte[] decode(String s) throws UnsupportedEncodingException {
        final StringBuffer sb = new StringBuffer();
        final Charset forName = Charset.forName("US-ASCII");
        final byte[] bytes = s.getBytes(forName);
        final int length = bytes.length;
        int i = 0;
    Label_0048:
        while (true) {
            while (i < length) {
                int n = i;
                int n2;
                byte b;
                while (true) {
                    final byte[] base64DecodeChars = FwrBase64.base64DecodeChars;
                    n2 = n + 1;
                    b = base64DecodeChars[bytes[n]];
                    if (n2 >= length || b != -1) {
                        break;
                    }
                    n = n2;
                }
                int n3 = n2;
                if (b == -1) {
                    break;
                }
                int n4;
                byte b2;
                while (true) {
                    final byte[] base64DecodeChars2 = FwrBase64.base64DecodeChars;
                    n4 = n3 + 1;
                    b2 = base64DecodeChars2[bytes[n3]];
                    if (n4 >= length || b2 != -1) {
                        break;
                    }
                    n3 = n4;
                }
                if (b2 == -1) {
                    break;
                }
                sb.append((char)(b << 2 | (b2 & 0x30) >>> 4));
                int n5 = n4;
                while (true) {
                    final int n6 = n5 + 1;
                    final byte b3 = bytes[n5];
                    if (b3 == 61) {
                        s = sb.toString();
                        final Charset forName2 = Charset.forName("ISO-8859-1");
                        if (s != null) {
                            final byte[] bytes2 = s.getBytes(forName2);
                            return bytes2;
                        }
                        //throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    else {
                        final byte b4 = FwrBase64.base64DecodeChars[b3];
                        if (n6 < length && b4 == -1) {
                            n5 = n6;
                        }
                        else {
                            if (b4 == -1) {
                                break Label_0048;
                            }
                            sb.append((char)((b2 & 0xF) << 4 | (b4 & 0x3C) >>> 2));
                            int n7 = n6;
                            while (true) {
                                i = n7 + 1;
                                final byte b5 = bytes[n7];
                                if (b5 == 61) {
                                    s = sb.toString();
                                    final Charset forName3 = Charset.forName("ISO-8859-1");
                                    if (s != null) {
                                        final byte[] bytes3 = s.getBytes(forName3);
                                        return bytes3;
                                    }
                                }
                                else {
                                    final byte b6 = FwrBase64.base64DecodeChars[b5];
                                    if (i < length && b6 == -1) {
                                        n7 = i;
                                    }
                                    else {
                                        if (b6 == -1) {
                                            break Label_0048;
                                        }
                                        sb.append((char)(b6 | (b4 & 0x3) << 6));
                                        continue Label_0048;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            break;
        }
        s = sb.toString();
        final Charset forName4 = Charset.forName("ISO-8859-1");
        if (s != null) {
            final byte[] bytes4 = s.getBytes(forName4);
            return bytes4;
        }
        return null;
    }
    
    public final String encode(final byte[] array) {
        final StringBuffer sb = new StringBuffer();
        int n3;
        for (int length = array.length, i = 0; i < length; i = n3 + 1) {
            final int n = i + 1;
            final int n2 = array[i] & 0xFF;
            if (n == length) {
                sb.append(FwrBase64.base64EncodeChars[n2 >>> 2]);
                sb.append(FwrBase64.base64EncodeChars[(n2 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            n3 = n + 1;
            final int n4 = array[n] & 0xFF;
            if (n3 == length) {
                sb.append(FwrBase64.base64EncodeChars[n2 >>> 2]);
                sb.append(FwrBase64.base64EncodeChars[(n2 & 0x3) << 4 | (n4 & 0xF0) >>> 4]);
                sb.append(FwrBase64.base64EncodeChars[(n4 & 0xF) << 2]);
                sb.append("=");
                break;
            }
            final int n5 = array[n3] & 0xFF;
            sb.append(FwrBase64.base64EncodeChars[n2 >>> 2]);
            sb.append(FwrBase64.base64EncodeChars[(n2 & 0x3) << 4 | (n4 & 0xF0) >>> 4]);
            sb.append(FwrBase64.base64EncodeChars[(n4 & 0xF) << 2 | (n5 & 0xC0) >>> 6]);
            sb.append(FwrBase64.base64EncodeChars[n5 & 0x3F]);
        }
        final String string = sb.toString();
        return string;
    }
}
