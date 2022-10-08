package com.rq.net.util;


import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.BinaryDecoder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.BinaryEncoder;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException;
import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.EncoderException;

import java.io.UnsupportedEncodingException;

public class Base64 implements BinaryEncoder, BinaryDecoder {
    static final int BASELENGTH = 255;
    static final byte[] CHUNK_SEPARATOR = "\r\n".getBytes();
    static final int CHUNK_SIZE = 76;
    static final int EIGHTBIT = 8;
    static final int FOURBYTE = 4;
    static final int LOOKUPLENGTH = 64;
    static final byte PAD = 61;
    static final int SIGN = -128;
    static final int SIXTEENBIT = 16;
    static final int TWENTYFOURBITGROUP = 24;
    private static byte[] base64Alphabet = new byte[255];
    private static byte[] lookUpBase64Alphabet = new byte[64];

    static {
        byte var4 = 0;

        int var0;
        for (var0 = 0; var0 < 255; ++var0) {
            base64Alphabet[var0] = -1;
        }

        for (var0 = 90; var0 >= 65; --var0) {
            base64Alphabet[var0] = (byte) (var0 - 65);
        }

        var0 = 122;
        label:
        while (true) {
            int var1 = 26;
            if (var0 < 97) {
                var0 = 57;

                while (true) {
                    byte var5 = 52;
                    if (var0 < 48) {
                        byte[] var6 = base64Alphabet;
                        var6[43] = 62;
                        var6[47] = 63;

                        for (var0 = 0; var0 <= 25; ++var0) {
                            lookUpBase64Alphabet[var0] = (byte) (var0 + 65);
                        }

                        var0 = 0;

                        while (true) {
                            int var2 = var4;
                            int var3 = var5;
                            if (var1 > 51) {
                                while (var3 <= 61) {
                                    lookUpBase64Alphabet[var3] = (byte) (var2 + 48);
                                    ++var3;
                                    ++var2;
                                }

                                var6 = lookUpBase64Alphabet;
                                var6[62] = 43;
                                var6[63] = 47;
                                break label;
                            }

                            lookUpBase64Alphabet[var1] = (byte) (var0 + 97);
                            ++var1;
                            ++var0;
                        }
                    }

                    base64Alphabet[var0] = (byte) (var0 - 48 + 52);
                    --var0;
                }
            }

            base64Alphabet[var0] = (byte) (var0 - 97 + 26);
            --var0;
        }

    }

    public Base64() {
    }

    public static byte[] decodeBase64(byte[] var0) {
        var0 = discardNonBase64(var0);
        int var1 = var0.length;
        byte var3 = 0;
        if (var1 == 0) {
            return new byte[0];
        } else {
            int var4 = var0.length / 4;
            var1 = var0.length;

            int var2;
            while (var0[var1 - 1] == 61) {
                var2 = var1 - 1;
                var1 = var2;
                if (var2 == 0) {
                    return new byte[0];
                }
            }

            byte[] var8 = new byte[var1 - var4];
            var2 = 0;

            for (var1 = var3; var1 < var4; ++var1) {
                int var5 = var1 * 4;
                byte var7 = var0[var5 + 2];
                byte var6 = var0[var5 + 3];
                byte[] var9 = base64Alphabet;
                byte var10 = var9[var0[var5]];
                byte var11 = var9[var0[var5 + 1]];
                if (var7 != 61 && var6 != 61) {
                    var7 = var9[var7];
                    var6 = var9[var6];
                    var8[var2] = (byte) (var10 << 2 | var11 >> 4);
                    var8[var2 + 1] = (byte) ((var11 & 15) << 4 | var7 >> 2 & 15);
                    var8[var2 + 2] = (byte) (var7 << 6 | var6);
                } else if (var7 == 61) {
                    var8[var2] = (byte) (var11 >> 4 | var10 << 2);
                } else if (var6 == 61) {
                    var6 = base64Alphabet[var7];
                    var8[var2] = (byte) (var10 << 2 | var11 >> 4);
                    var8[var2 + 1] = (byte) ((var11 & 15) << 4 | var6 >> 2 & 15);
                }

                var2 += 3;
            }

            return var8;
        }
    }

    public static byte[] decodeBase64String(String var0) {
        try {
            byte[] var2 = decodeBase64(var0.getBytes("utf-8"));
            return var2;
        } catch (UnsupportedEncodingException var1) {
            throw new RuntimeException(var1.getMessage(), var1);
        }
    }

    static byte[] discardNonBase64(byte[] var0) {
        byte[] var4 = new byte[var0.length];
        int var1 = 0;

        int var2;
        int var3;
        for (var2 = 0; var1 < var0.length; var2 = var3) {
            var3 = var2;
            if (isBase64(var0[var1])) {
                var4[var2] = var0[var1];
                var3 = var2 + 1;
            }

            ++var1;
        }

        var0 = new byte[var2];
        System.arraycopy(var4, 0, var0, 0, var2);
        return var0;
    }

    static byte[] discardWhitespace(byte[] var0) {
        byte[] var5 = new byte[var0.length];
        int var1 = 0;

        int var2;
        int var3;
        for (var2 = 0; var1 < var0.length; var2 = var3) {
            byte var4 = var0[var1];
            var3 = var2;
            if (var4 != 9) {
                var3 = var2;
                if (var4 != 10) {
                    var3 = var2;
                    if (var4 != 13) {
                        var3 = var2;
                        if (var4 != 32) {
                            var5[var2] = var0[var1];
                            var3 = var2 + 1;
                        }
                    }
                }
            }

            ++var1;
        }

        var0 = new byte[var2];
        System.arraycopy(var5, 0, var0, 0, var2);
        return var0;
    }

    public static byte[] encodeBase64(byte[] var0) {
        return encodeBase64(var0, false);
    }

    public static byte[] encodeBase64(byte[] var0, boolean var1) {
        int var2 = var0.length * 8;
        int var9 = var2 % 24;
        int var10 = var2 / 24;
        if (var9 != 0) {
            var2 = (var10 + 1) * 4;
        } else {
            var2 = var10 * 4;
        }

        int var3;
        int var4;
        if (var1) {
            if (CHUNK_SEPARATOR.length == 0) {
                var3 = 0;
            } else {
                var3 = (int) Math.ceil((double) ((float) var2 / 76.0F));
            }

            var4 = var2 + CHUNK_SEPARATOR.length * var3;
        } else {
            var3 = 0;
            var4 = var2;
        }

        byte[] var16 = new byte[var4];
        int var6 = 0;
        int var5 = 0;
        var2 = 0;

        int var8;
        byte var22;
        for (int var7 = 76; var6 < var10; var7 = var8) {
            var8 = var6 * 3;
            byte var14 = var0[var8];
            byte var15 = var0[var8 + 1];
            byte var11 = var0[var8 + 2];
            byte var12 = (byte) (var15 & 15);
            byte var13 = (byte) (var14 & 3);
            var8 = var14 >> 2;
            if ((var14 & -128) != 0) {
                var8 ^= 192;
            }

            var14 = (byte) var8;
            var8 = var15 >> 4;
            if ((var15 & -128) != 0) {
                var8 ^= 240;
            }

            var15 = (byte) var8;
            var8 = var11 >> 6;
            if ((var11 & -128) != 0) {
                var8 ^= 252;
            }

            var22 = (byte) var8;
            byte[] var17 = lookUpBase64Alphabet;
            var16[var5] = var17[var14];
            var16[var5 + 1] = var17[var13 << 4 | var15];
            var16[var5 + 2] = var17[var12 << 2 | var22];
            var16[var5 + 3] = var17[var11 & 63];
            var5 += 4;
            if (var1 && var5 == var7) {
                var17 = CHUNK_SEPARATOR;
                System.arraycopy(var17, 0, var16, var5, var17.length);
                var7 = var2 + 1;
                var17 = CHUNK_SEPARATOR;
                var8 = var17.length;
                var2 = var5 + var17.length;
                var8 = (var7 + 1) * 76 + var8 * var7;
            } else {
                var8 = var7;
                var7 = var2;
                var2 = var5;
            }

            ++var6;
            var5 = var2;
            var2 = var7;
        }

        var6 *= 3;
        byte var18;
        byte var19;
        if (var9 == 8) {
            var22 = var0[var6];
            var19 = (byte) (var22 & 3);
            var6 = var22 >> 2;
            if ((var22 & -128) != 0) {
                var6 ^= 192;
            }

            var18 = (byte) var6;
            var0 = lookUpBase64Alphabet;
            var16[var5] = var0[var18];
            var16[var5 + 1] = var0[var19 << 4];
            var16[var5 + 2] = 61;
            var16[var5 + 3] = 61;
        } else if (var9 == 16) {
            byte var21 = var0[var6];
            byte var20 = var0[var6 + 1];
            var19 = (byte) (var20 & 15);
            var22 = (byte) (var21 & 3);
            var6 = var21 >> 2;
            if ((var21 & -128) != 0) {
                var6 ^= 192;
            }

            var21 = (byte) var6;
            var6 = var20 >> 4;
            if ((var20 & -128) != 0) {
                var6 ^= 240;
            }

            var18 = (byte) var6;
            var0 = lookUpBase64Alphabet;
            var16[var5] = var0[var21];
            var16[var5 + 1] = var0[var18 | var22 << 4];
            var16[var5 + 2] = var0[var19 << 2];
            var16[var5 + 3] = 61;
        }

        if (var1 && var2 < var3) {
            var0 = CHUNK_SEPARATOR;
            System.arraycopy(var0, 0, var16, var4 - var0.length, var0.length);
        }

        return var16;
    }

    public static byte[] encodeBase64Chunked(byte[] var0) {
        return encodeBase64(var0, true);
    }

    public static String encodeBase64String(byte[] var0) {
        try {
            String var2 = new String(encodeBase64(var0), "utf-8");
            return var2;
        } catch (UnsupportedEncodingException var1) {
            throw new RuntimeException(var1.getMessage(), var1);
        }
    }

    public static boolean isArrayByteBase64(byte[] var0) {
        var0 = discardWhitespace(var0);
        int var2 = var0.length;
        if (var2 == 0) {
            return true;
        } else {
            for (int var1 = 0; var1 < var2; ++var1) {
                if (!isBase64(var0[var1])) {
                    return false;
                }
            }

            return true;
        }
    }

    private static boolean isBase64(byte var0) {
        if (var0 == 61) {
            return true;
        } else {
            return base64Alphabet[var0] != -1;
        }
    }

    public Object decode(Object var1) throws DecoderException {
        if (var1 instanceof byte[]) {
            return this.decode((byte[]) ((byte[]) var1));
        } else {
            throw new DecoderException("Parameter supplied to Base64 decode is not a byte[]");
        }
    }

    public byte[] decode(byte[] var1) {
        return decodeBase64(var1);
    }

    public Object encode(Object var1) throws EncoderException {
        if (var1 instanceof byte[]) {
            return this.encode((byte[]) ((byte[]) var1));
        } else {
            throw new EncoderException("Parameter supplied to Base64 encode is not a byte[]");
        }
    }

    public byte[] encode(byte[] var1) {
        return encodeBase64(var1, false);
    }
}