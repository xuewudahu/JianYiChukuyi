package com.rq.net.util;


import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.HashFunction;
import com.google.firebase.crashlytics.buildtools.reloc.com.google.common.hash.Hashing;

import java.io.UnsupportedEncodingException;
import java.lang.Character.UnicodeBlock;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public final class StringUtil {
    private StringUtil() {
    }

    public static String capitalizeFirstLetter(String var0) {
        if (isBlank(var0)) {
            return var0;
        } else {
            char var1 = var0.charAt(0);
            String var2 = var0;
            if (Character.isLetter(var1)) {
                if (Character.isUpperCase(var1)) {
                    return var0;
                }

                StringBuilder var3 = new StringBuilder(var0.length());
                var3.append(Character.toUpperCase(var1));
                var3.append(var0.substring(1));
                var2 = var3.toString();
            }

            return var2;
        }
    }

    public static String chomp(String var0) {
        if (isEmpty(var0)) {
            return var0;
        } else if (var0.length() == 1) {
            char var4 = var0.charAt(0);
            return var4 != '\r' && var4 != '\n' ? var0 : "";
        } else {
            int var2 = var0.length() - 1;
            char var3 = var0.charAt(var2);
            int var1;
            if (var3 == '\n') {
                var1 = var2;
                if (var0.charAt(var2 - 1) == '\r') {
                    var1 = var2 - 1;
                }
            } else {
                var1 = var2;
                if (var3 != '\r') {
                    var1 = var2 + 1;
                }
            }

            return var0.substring(0, var1);
        }
    }

    public static String chomp(String var0, String var1) {
        String var2 = var0;
        if (!isEmpty(var0)) {
            if (var1 == null) {
                return var0;
            }

            var2 = var0;
            if (var0.endsWith(var1)) {
                var2 = var0.substring(0, var0.length() - var1.length());
            }
        }

        return var2;
    }

    public static boolean contains(String var0, char var1) {
        boolean var3 = isEmpty(var0);
        boolean var2 = false;
        if (var3) {
            return false;
        } else {
            if (var0.indexOf(var1) >= 0) {
                var2 = true;
            }

            return var2;
        }
    }

    public static boolean contains(String var0, String var1) {
        boolean var3 = false;
        boolean var2 = var3;
        if (var0 != null) {
            if (var1 == null) {
                return false;
            }

            var2 = var3;
            if (var0.indexOf(var1) >= 0) {
                var2 = true;
            }
        }

        return var2;
    }

    public static boolean containsIgnoreCase(String var0, String var1) {
        if (var0 != null) {
            if (var1 == null) {
                return false;
            }

            int var3 = var1.length();
            int var4 = var0.length();

            for(int var2 = 0; var2 <= var4 - var3; ++var2) {
                if (var0.regionMatches(true, var2, var1, 0, var3)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int countMatches(String var0, String var1) {
        boolean var4 = isEmpty(var0);
        int var3 = 0;
        if (var4) {
            return 0;
        } else if (isEmpty(var1)) {
            return 0;
        } else {
            int var2 = 0;

            while(true) {
                var3 = var0.indexOf(var1, var3);
                if (var3 == -1) {
                    return var2;
                }

                ++var2;
                var3 += var1.length();
            }
        }
    }

    public static boolean equals(String var0, String var1) {
        if (var0 == null) {
            return var1 == null;
        } else {
            return var0.equals(var1);
        }
    }

    public static boolean equalsIgnoreCase(String var0, String var1) {
        if (var0 == null) {
            return var1 == null;
        } else {
            return var0.equalsIgnoreCase(var1);
        }
    }

    public static boolean isAlpha(String var0) {
        if (var0 == null) {
            return false;
        } else {
            int var2 = var0.length();

            for(int var1 = 0; var1 < var2; ++var1) {
                if (!Character.isLetter(var0.charAt(var1))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isAlphanumeric(String var0) {
        if (var0 == null) {
            return false;
        } else {
            int var2 = var0.length();

            for(int var1 = 0; var1 < var2; ++var1) {
                if (!Character.isLetterOrDigit(var0.charAt(var1))) {
                    return false;
                }
            }

            return true;
        }
    }

    public static boolean isBlank(String var0) {
        if (var0 != null) {
            int var2 = var0.length();
            if (var2 == 0) {
                return true;
            }

            for(int var1 = 0; var1 < var2; ++var1) {
                if (!Character.isWhitespace(var0.charAt(var1))) {
                    return false;
                }
            }
        }

        return true;
    }

    public static final boolean isChinese(char var0) {
        UnicodeBlock var1 = UnicodeBlock.of(var0);
        return var1 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || var1 == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || var1 == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || var1 == UnicodeBlock.GENERAL_PUNCTUATION || var1 == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || var1 == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static final boolean isChinese(String var0) {
        if (var0 == null) {
            return false;
        } else {
            char[] var2 = var0.toCharArray();

            for(int var1 = 0; var1 < var2.length; ++var1) {
                if (isChinese(var2[var1])) {
                    return true;
                }
            }

            return false;
        }
    }

    public static boolean isEmpty(String var0) {
        return var0 == null || var0.length() == 0;
    }

    public static boolean isNotBlank(String var0) {
        return isBlank(var0) ^ true;
    }

    public static boolean isNotEmpty(String var0) {
        return isEmpty(var0) ^ true;
    }

    public static boolean isNumberDecimals(String var0) {
        return isEmpty(var0) ? false : Pattern.compile("^[0-9]*\\.?[0-9]*$").matcher(var0).matches();
    }

    public static boolean isNumeric(String var0) {
        return isEmpty(var0) ? false : Pattern.compile("[0-9]*").matcher(var0).matches();
    }

    public static boolean isNumericOrChar(String var0) {
        return isEmpty(var0) ? false : Pattern.compile("[A-Za-z0-9]*").matcher(var0).matches();
    }

    public static String leftPad(String var0, int var1) {
        return leftPad(var0, var1, ' ');
    }

    public static String leftPad(String var0, int var1, char var2) {
        if (var0 == null) {
            return null;
        } else {
            int var3 = var1 - var0.length();
            if (var3 <= 0) {
                return var0;
            } else {
                return var3 > 8192 ? leftPad(var0, var1, String.valueOf(var2)) : padding(var3, var2).concat(var0);
            }
        }
    }

    public static String leftPad(String var0, int var1, String var2) {
        String var6 = var0;
        if (var0 == null) {
            var6 = "";
        }

        var0 = var2;
        if (isEmpty(var2)) {
            var0 = " ";
        }

        int var4 = var0.length();
        int var5 = var1 - var6.length();
        if (var5 <= 0) {
            return var6;
        } else {
            byte var3 = 0;
            if (var4 == 1 && var5 <= 8192) {
                return leftPad(var6, var1, var0.charAt(0));
            } else if (var5 == var4) {
                return var0.concat(var6);
            } else if (var5 < var4) {
                return var0.substring(0, var5).concat(var6);
            } else {
                char[] var8 = new char[var5];
                char[] var7 = var0.toCharArray();

                for(var1 = var3; var1 < var5; ++var1) {
                    var8[var1] = var7[var1 % var4];
                }

                return (new String(var8)).concat(var6);
            }
        }
    }

    public static String nullToBlank(String var0) {
        String var1 = var0;
        if (var0 == null) {
            var1 = "";
        }

        return var1;
    }

    private static String padding(int var0, char var1) throws IndexOutOfBoundsException {
        if (var0 < 0) {
            StringBuilder var3 = new StringBuilder();
            var3.append("Cannot pad a negative amount: ");
            var3.append(var0);
            IndexOutOfBoundsException var4 = new IndexOutOfBoundsException(var3.toString());
            throw var4;
        } else {
            char[] var2 = new char[var0];

            for(var0 = 0; var0 < var2.length; ++var0) {
                var2[var0] = var1;
            }

            return new String(var2);
        }
    }

    public static String plusString(String var0, int var1) {
        String var4 = var0;
        if (var0 == null) {
            var4 = "";
        }

        int var3 = var4.getBytes().length;
        int var2 = 0;
        if (var3 >= var1) {
            return var4.substring(0, var1);
        } else {
            StringBuilder var5 = new StringBuilder();
            var5.append(var4);

            while(var2 < var1 - var3) {
                var5.append(" ");
                ++var2;
            }

            return var5.toString();
        }
    }

    public static String remove(String var0, String var1) {
        String var2 = var0;
        if (!isEmpty(var0)) {
            if (isEmpty(var1)) {
                return var0;
            }

            var2 = replace(var0, var1, "", -1);
        }

        return var2;
    }

    public static String replace(String var0, String var1, String var2) {
        return replace(var0, var1, var2, -1);
    }

    public static String replace(String var0, String var1, String var2, int var3) {
        if (!isEmpty(var0) && !isEmpty(var1) && var2 != null) {
            if (var3 == 0) {
                return var0;
            } else {
                byte var6 = 0;
                int var7 = var0.indexOf(var1, 0);
                if (var7 == -1) {
                    return var0;
                } else {
                    int var8 = var1.length();
                    int var5 = var2.length() - var8;
                    if (var5 < 0) {
                        var5 = 0;
                    }

                    int var4 = 64;
                    if (var3 >= 0) {
                        if (var3 <= 64) {
                            var4 = var3;
                        }
                    } else {
                        var4 = 16;
                    }

                    StringBuffer var9 = new StringBuffer(var0.length() + var5 * var4);
                    var4 = var3;
                    var5 = var7;

                    for(var3 = var6; var5 != -1; var5 = var0.indexOf(var1, var3)) {
                        var9.append(var0.substring(var3, var5));
                        var9.append(var2);
                        var3 = var5 + var8;
                        --var4;
                        if (var4 == 0) {
                            break;
                        }
                    }

                    var9.append(var0.substring(var3));
                    return var9.toString();
                }
            }
        } else {
            return var0;
        }
    }

    public static String replaceOnce(String var0, String var1, String var2) {
        return replace(var0, var1, var2, 1);
    }

    public static String reverse(String var0) {
        return isEmpty(var0) ? var0 : (new StringBuffer(var0)).reverse().toString();
    }

    public static String rightPad(String var0, int var1) {
        return rightPad(var0, var1, ' ');
    }

    public static String rightPad(String var0, int var1, char var2) {
        if (var0 == null) {
            return null;
        } else {
            int var3 = var1 - var0.length();
            if (var3 <= 0) {
                return var0;
            } else {
                return var3 > 8192 ? rightPad(var0, var1, String.valueOf(var2)) : var0.concat(padding(var3, var2));
            }
        }
    }

    public static String rightPad(String var0, int var1, String var2) {
        if (var0 == null) {
            return null;
        } else {
            String var6 = var2;
            if (isEmpty(var2)) {
                var6 = " ";
            }

            int var4 = var6.length();
            int var5 = var1 - var0.length();
            if (var5 <= 0) {
                return var0;
            } else {
                byte var3 = 0;
                if (var4 == 1 && var5 <= 8192) {
                    return rightPad(var0, var1, var6.charAt(0));
                } else if (var5 == var4) {
                    return var0.concat(var6);
                } else if (var5 < var4) {
                    return var0.concat(var6.substring(0, var5));
                } else {
                    char[] var7 = new char[var5];
                    char[] var8 = var6.toCharArray();

                    for(var1 = var3; var1 < var5; ++var1) {
                        var7[var1] = var8[var1 % var4];
                    }

                    return var0.concat(new String(var7));
                }
            }
        }
    }

    public static List<String> stringToList(String var0, String var1) {
        ArrayList var4 = new ArrayList();
        if (var1.equals("")) {
            var4.add(var0);
            return var4;
        } else {
            String[] var5 = var0.split(var1);
            int var3 = var5.length;

            for(int var2 = 0; var2 < var3; ++var2) {
                var4.add(var5[var2]);
            }

            return var4;
        }
    }

    public static String subLeft(String var0, int var1) {
        if (var0 == null) {
            return null;
        } else if (var1 < 0) {
            return "";
        } else {
            return var0.length() <= var1 ? var0 : var0.substring(0, var1);
        }
    }

    public static String subMid(String var0, int var1, int var2) {
        if (var0 == null) {
            return null;
        } else if (var2 >= 0 && var1 <= var0.length()) {
            int var3 = var1;
            if (var1 < 0) {
                var3 = 0;
            }

            var1 = var0.length();
            var2 += var3;
            return var1 <= var2 ? var0.substring(var3) : var0.substring(var3, var2);
        } else {
            return "";
        }
    }

    public static String subRight(String var0, int var1) {
        if (var0 == null) {
            return null;
        } else if (var1 < 0) {
            return "";
        } else {
            return var0.length() <= var1 ? var0 : var0.substring(var0.length() - var1);
        }
    }

    public static String trim(String var0) {
        return var0 == null ? null : var0.trim();
    }

    public static String utf8Encode(String var0) {
        if (!isEmpty(var0) && var0.getBytes().length != var0.length()) {
            try {
                var0 = URLEncoder.encode(var0, "UTF-8");
                return var0;
            } catch (UnsupportedEncodingException var1) {
                throw new RuntimeException("UnsupportedEncodingException occurred. ", var1);
            }
        } else {
            return var0;
        }
    }

    public static String getSudiyiAuth(long var1, String var3, String var4, String var5, String var6) {
        Object[] var15 = new Object[]{var1, null, null};
        var3 = var3.toUpperCase();
        var15[1] = var3;
        var15[2] = var4;
        var3 = String.format("date: %s\n%s %s HTTP/1.1", Arrays.copyOf(var15, var15.length));
        Charset var9 = Charset.defaultCharset();
        byte[] var10 = var6.getBytes(var9);
        HashFunction var11 = Hashing.hmacSha256(var10);
        Charset var14 = Charset.defaultCharset();
        if (var3 != null) {
            byte[] var8 = var3.getBytes(var14);
            var3 = Base64Util.encode(var11.hashBytes(var8).asBytes());
            Object[] var13 = new Object[]{var5, "hmac-sha256", "date request-line", var3};
            var3 = String.format("hmac key=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"", Arrays.copyOf(var13, var13.length));
            return var3;
        } else {
            return null;
        }
    }
}