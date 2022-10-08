package com.rq.net.util;

import static okhttp3.internal.Util.UTF_8;

//import kotlin.jvm.internal.*;
import android.util.*;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException;

import javax.crypto.*;
import java.io.*;
//import kotlin.text.*;
import java.security.*;
import java.security.spec.*;
//import kotlin.*;
import java.nio.charset.*;

public final class RSACrypt
{
    private static final int DECRYPT_MAX_SIZE = 256;
    private static final int ENCRYPT_MAX_SIZE = 117;
    public static final RSACrypt INSTANCE;
    private static final String transformation = "RSA/ECB/PKCS1Padding";
    
    static {
        INSTANCE = new RSACrypt();
    }
    
    private RSACrypt() {
    }
    
    public final String decryptByPrivateKey(final String s, final PrivateKey privateKey) {
        final byte[] bytes = s.getBytes(UTF_8);
        int length = 0;
        final byte[] decode = new Base64().decode(bytes);
        Cipher instance = null;
        try {
            instance = Cipher.getInstance(RSACrypt.transformation);
            instance.init(2, privateKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        final byte[] array = null;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (decode.length - length > 0) {
            final int length2 = decode.length;
            final int decrypt_MAX_SIZE = RSACrypt.DECRYPT_MAX_SIZE;
            byte[] array2 = null;
            if (length2 - length >= decrypt_MAX_SIZE) {
                try {
                    array2 = instance.doFinal(decode, length, decrypt_MAX_SIZE);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length += RSACrypt.DECRYPT_MAX_SIZE;
            }
            else {
                try {
                    array2 = instance.doFinal(decode, length, decode.length - length);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length = decode.length;
            }
            try {
                byteArrayOutputStream.write(array2);
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        return new String(byteArray, UTF_8);
    }
    
    public final String decryptByPublicKey(final String s, final PublicKey publicKey) {
        int length = 0;
        byte[] decode = null;
        try {
            decode = (byte[]) new Base64().decode(s);
        } catch (DecoderException e) {
            e.printStackTrace();
        }
        Cipher instance = null;
        try {
            instance = Cipher.getInstance(RSACrypt.transformation);
            instance.init(2, publicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }

        byte[] array = null;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (decode.length - length > 0) {
            final int length2 = decode.length;
            final int decrypt_MAX_SIZE = RSACrypt.DECRYPT_MAX_SIZE;
            byte[] array2 = null;
            if (length2 - length >= decrypt_MAX_SIZE) {
                try {
                    array2 = instance.doFinal(decode, length, decrypt_MAX_SIZE);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length += RSACrypt.DECRYPT_MAX_SIZE;
            }
            else {
                try {
                    array2 = instance.doFinal(decode, length, decode.length - length);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length = decode.length;
            }
            try {
                byteArrayOutputStream.write(array2);
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final byte[] byteArray = byteArrayOutputStream.toByteArray();
        ////Intrinsics.checkExpressionValueIsNotNull(byteArray, "outputStream.toByteArray()");
        return new String(byteArray, UTF_8);
    }
    
    public final String encryptByPrivateKey(final String s, final PrivateKey privateKey) {
        final byte[] bytes = s.getBytes(UTF_8);
        Cipher instance = null;
        try {
            instance = Cipher.getInstance(RSACrypt.transformation);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
        try {
            instance.init(1, privateKey);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        final byte[] array = null;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = 0;
        while (bytes.length - length > 0) {
            final int length2 = bytes.length;
            final int encrypt_MAX_SIZE = RSACrypt.ENCRYPT_MAX_SIZE;
            byte[] array2 = null;
            if (length2 - length >= encrypt_MAX_SIZE) {
                try {
                    array2 = instance.doFinal(bytes, length, encrypt_MAX_SIZE);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length += RSACrypt.ENCRYPT_MAX_SIZE;
            }
            else {
                try {
                    array2 = instance.doFinal(bytes, length, bytes.length - length);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length = bytes.length;
            }
            try {
                byteArrayOutputStream.write(array2);

                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final byte[] decode = new Base64().decode(byteArrayOutputStream.toByteArray());
        return new String(decode, UTF_8);
    }
    
    public final String encryptByPublicKey(final String s, final PublicKey publicKey) {
        final byte[] bytes = s.getBytes(UTF_8);
        Cipher instance = null;
        try {
            instance = Cipher.getInstance(RSACrypt.transformation);

            instance.init(1, publicKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        final byte[] array = null;
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int length = 0;
        while (bytes.length - length > 0) {
            final int length2 = bytes.length;
            final int encrypt_MAX_SIZE = RSACrypt.ENCRYPT_MAX_SIZE;
            byte[] array2 = null;
            if (length2 - length >= encrypt_MAX_SIZE) {
                try {
                    array2 = instance.doFinal(bytes, length, encrypt_MAX_SIZE);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length += RSACrypt.ENCRYPT_MAX_SIZE;
            }
            else {
                try {
                    array2 = instance.doFinal(bytes, length, bytes.length - length);
                } catch (BadPaddingException e) {
                    e.printStackTrace();
                } catch (IllegalBlockSizeException e) {
                    e.printStackTrace();
                }
                length = bytes.length;
            }
            try {
                byteArrayOutputStream.write(array2);

                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        final byte[] decode = new Base64().decode(byteArrayOutputStream.toByteArray());
        return new String(decode, UTF_8);
    }
    
    public final int getDECRYPT_MAX_SIZE() {
        return RSACrypt.DECRYPT_MAX_SIZE;
    }
    
    public final int getENCRYPT_MAX_SIZE() {
        return RSACrypt.ENCRYPT_MAX_SIZE;
    }
    
    public final PrivateKey getRSAPrivateKey(String o) {
        final byte[] bytes = ((String)o).getBytes(UTF_8);

        o = o.replace("-----BEGIN PRIVATE KEY-----", "");//StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(new String(bytes, Charsets.UTF_8), "-----BEGIN PRIVATE KEY-----", "", false, 4, (Object)null), "-----END PRIVATE KEY-----", "", false, 4, (Object)null), "\n", "", false, 4, (Object)null);
        final Charset utf_8 = UTF_8;
        if (o != null) {
            final byte[] bytes2 = ((String)o).getBytes(utf_8);
            o = Base64Util.getBaseString(bytes2);
            final Charset utf_9 = UTF_8;
            if (o != null) {
                final byte[] bytes3 = ((String)o).getBytes(utf_9);
                final PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(bytes3);
                o = null;
                try {
                    return KeyFactory.getInstance("RSA").generatePrivate(pkcs8EncodedKeySpec);
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                    return null;
                }
            }
        }
        return null;
    }
    
    public final String getTransformation() {
        return RSACrypt.transformation;
    }
}
