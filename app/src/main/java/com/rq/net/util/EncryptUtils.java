package com.rq.net.util;

import android.util.*;
import java.security.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.spec.*;

public class EncryptUtils
{
    private static final char[] hexDigits;
    
    static {
        hexDigits = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
    }
    
    public static byte[] base64Decode(final byte[] array) {
        if (array != null && array.length != 0) {
            return new Base64().decode(array);
        }
        return new byte[0];
    }
    
    public static byte[] base64Encode(final byte[] array) {
        if (array != null && array.length != 0) {
            return new Base64().decode(array);
        }
        return new byte[0];
    }
    
    public static String base64Encode2String(final byte[] array) {
        if (array != null && array.length != 0) {
            return new String(new Base64().decode(array));
        }
        return "";
    }
    
    static String bytes2HexString(final byte[] array) {
        return bytes2HexString512(array);
    }
    
    public static String bytes2HexString512(final byte[] array) {
        if (array == null) {
            return "";
        }
        final int length = array.length;
        if (length <= 0) {
            return "";
        }
        final char[] array2 = new char[length << 1];
        int i = 0;
        int n = 0;
        while (i < length) {
            final int n2 = n + 1;
            final char[] hexDigits = EncryptUtils.hexDigits;
            array2[n] = hexDigits[array[i] >> 4 & 0xF];
            n = n2 + 1;
            array2[n2] = hexDigits[array[i] & 0xF];
            ++i;
        }
        return new String(array2);
    }
    
    public static byte[] decryptAES(final byte[] array, final byte[] array2, final String s, final byte[] array3) {
        return symmetricTemplate(array, array2, "AES", s, array3, false);
    }
    
    public static byte[] decryptBase64AES(final byte[] array, final byte[] array2, final String s, final byte[] array3) {
        return decryptAES(base64Decode(array), array2, s, array3);
    }
    
    public static byte[] encryptAES(final byte[] array, final byte[] array2, final String s, final byte[] array3) {
        return symmetricTemplate(array, array2, "AES", s, array3, true);
    }
    
    public static String encryptAES2Base64(final byte[] array, final byte[] array2, final String s, final byte[] array3) {
        return base64Encode2String(encryptAES(array, array2, s, array3));
    }
    
    public static byte[] encryptHmacSHA512(final byte[] array, final byte[] array2) {
        return hmacTemplate(array, array2, "HmacSHA512");
    }
    
    public static String encryptHmacSHA512ToString(final String s, final String s2) {
        if (s != null && s.length() != 0 && s2 != null && s2.length() != 0) {
            return encryptHmacSHA512ToString(s.getBytes(), s2.getBytes());
        }
        return "";
    }
    
    public static String encryptHmacSHA512ToString(final byte[] array, final byte[] array2) {
        return bytes2HexString(encryptHmacSHA512(array, array2));
    }
    
    private static byte[] hmacTemplate(byte[] doFinal, final byte[] array, final String s) {
        if (doFinal != null && doFinal.length != 0 && array != null) {
            if (array.length == 0) {
                return null;
            }
            try {
                final SecretKeySpec secretKeySpec = new SecretKeySpec(array, s);
                final Mac instance = Mac.getInstance(s);
                instance.init(secretKeySpec);
                doFinal = instance.doFinal((byte[])doFinal);
                return (byte[])doFinal;
            }
            catch (NoSuchAlgorithmException e) {}
            catch (InvalidKeyException ex) {}
        }
        return null;
    }
    
    private static byte[] symmetricTemplate(byte[] doFinal, byte[] generateSecret, String instance, String s, final byte[] array, final boolean b) {
        if (doFinal != null && doFinal.length != 0 && generateSecret != null) {
            if (generateSecret.length == 0) {
                return null;
            }
        Label_0114_Outer:
            while (true) {
                while (true) {
                    int n = 0;
                    Label_0142: {
                        while (true) {
                            Label_0136: {
                                try {
                                    if ("DES".equals(instance)) {
                                        generateSecret = (byte[])(Object)new DESKeySpec(generateSecret);
                                        generateSecret = (byte[])(Object)SecretKeyFactory.getInstance(instance).generateSecret((KeySpec)(Object)generateSecret);
                                    }
                                    else {
                                        generateSecret = (byte[])(Object)new SecretKeySpec(generateSecret, instance);
                                    }
                                    Cipher cipher = Cipher.getInstance(s);
                                    n = 1;
                                    final int n2 = 1;
                                    if (array == null || array.length == 0) {
                                        break Label_0142;
                                    }
                                    IvParameterSpec ivParameterSpec = new IvParameterSpec(array);
                                    if (b) {
                                        ((Cipher)cipher).init(n2, (Key)(Object)generateSecret, (AlgorithmParameterSpec)ivParameterSpec);
                                        doFinal = ((Cipher)cipher).doFinal((byte[])doFinal);
                                        return (byte[])doFinal;
                                    }
                                    break Label_0136;
                                    /*final int n3 = 0;
                                    ((Cipher)cipher).init(n3, (Key)(Object)generateSecret);
                                    return ((Cipher)cipher).doFinal((byte[])doFinal);*/
                                } catch (InvalidAlgorithmParameterException e) {
                                    e.printStackTrace();
                                } catch (NoSuchPaddingException e) {
                                    e.printStackTrace();
                                } catch (IllegalBlockSizeException e) {
                                    e.printStackTrace();
                                } catch (InvalidKeySpecException e) {
                                    e.printStackTrace();
                                } catch (NoSuchAlgorithmException e) {
                                    e.printStackTrace();
                                } catch (BadPaddingException e) {
                                    e.printStackTrace();
                                } catch (InvalidKeyException e) {
                                    e.printStackTrace();
                                } finally {
                                    //((Throwable)doFinal).printStackTrace();
                                }
                                break;
                            }
                            final int n2 = 2;
                            continue Label_0114_Outer;
                        }
                    }
                    if (b) {
                        final int n3 = n;
                        continue;
                    }
                    final int n3 = 2;
                    continue;
                }
            }
        }
        return null;
    }
}
