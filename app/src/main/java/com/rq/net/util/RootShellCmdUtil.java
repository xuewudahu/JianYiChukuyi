package com.rq.net.util;

import android.util.*;
import java.io.*;
import android.graphics.*;

public class RootShellCmdUtil
{
    private static final String TAG = "RootShellCmdUtil";
    private static OutputStream os;
    private static Process process;
    
    public static final void exec(final String s) {
        try {
            if (RootShellCmdUtil.process == null) {
                RootShellCmdUtil.process = Runtime.getRuntime().exec("su");
                RootShellCmdUtil.os = RootShellCmdUtil.process.getOutputStream();
            }
            RootShellCmdUtil.os.write(s.getBytes());
            RootShellCmdUtil.os.flush();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public static String execByRuntime(final String p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: aload_0        
        //     4: invokevirtual   java/lang/Runtime.exec:(Ljava/lang/String;)Ljava/lang/Process;
        //     7: astore_0       
        //     8: new             Ljava/io/InputStreamReader;
        //    11: dup            
        //    12: aload_0        
        //    13: invokevirtual   java/lang/Process.getInputStream:()Ljava/io/InputStream;
        //    16: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //    19: astore_3       
        //    20: new             Ljava/io/BufferedReader;
        //    23: dup            
        //    24: aload_3        
        //    25: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //    28: astore_2       
        //    29: aload_3        
        //    30: astore          5
        //    32: aload_2        
        //    33: astore          4
        //    35: aload_0        
        //    36: astore          6
        //    38: sipush          1024
        //    41: newarray        C
        //    43: astore          7
        //    45: aload_3        
        //    46: astore          5
        //    48: aload_2        
        //    49: astore          4
        //    51: aload_0        
        //    52: astore          6
        //    54: new             Ljava/lang/StringBuilder;
        //    57: dup            
        //    58: invokespecial   java/lang/StringBuilder.<init>:()V
        //    61: astore          8
        //    63: aload_3        
        //    64: astore          5
        //    66: aload_2        
        //    67: astore          4
        //    69: aload_0        
        //    70: astore          6
        //    72: aload_2        
        //    73: aload           7
        //    75: invokevirtual   java/io/BufferedReader.read:([C)I
        //    78: istore_1       
        //    79: iload_1        
        //    80: ifle            102
        //    83: aload_3        
        //    84: astore          5
        //    86: aload_2        
        //    87: astore          4
        //    89: aload_0        
        //    90: astore          6
        //    92: aload           8
        //    94: aload           7
        //    96: iconst_0       
        //    97: iload_1        
        //    98: invokevirtual   java/lang/StringBuilder.append:([CII)Ljava/lang/StringBuilder;
        //   101: pop            
        //   102: aload_3        
        //   103: astore          5
        //   105: aload_2        
        //   106: astore          4
        //   108: aload_0        
        //   109: astore          6
        //   111: aload           8
        //   113: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   116: astore          7
        //   118: aload_3        
        //   119: invokevirtual   java/io/InputStreamReader.close:()V
        //   122: aload_2        
        //   123: invokevirtual   java/io/BufferedReader.close:()V
        //   126: goto            129
        //   129: aload_0        
        //   130: ifnull          137
        //   133: aload_0        
        //   134: invokevirtual   java/lang/Process.destroy:()V
        //   137: aload           7
        //   139: areturn        
        //   140: astore          7
        //   142: goto            194
        //   145: astore_2       
        //   146: aconst_null    
        //   147: astore          4
        //   149: goto            247
        //   152: astore          7
        //   154: aconst_null    
        //   155: astore_2       
        //   156: goto            194
        //   159: astore_2       
        //   160: aconst_null    
        //   161: astore          4
        //   163: aload           4
        //   165: astore_3       
        //   166: goto            247
        //   169: astore          7
        //   171: goto            190
        //   174: astore_2       
        //   175: aconst_null    
        //   176: astore_3       
        //   177: aload_3        
        //   178: astore          4
        //   180: aload           4
        //   182: astore_0       
        //   183: goto            247
        //   186: astore          7
        //   188: aconst_null    
        //   189: astore_0       
        //   190: aconst_null    
        //   191: astore_3       
        //   192: aconst_null    
        //   193: astore_2       
        //   194: aload_3        
        //   195: astore          5
        //   197: aload_2        
        //   198: astore          4
        //   200: aload_0        
        //   201: astore          6
        //   203: aload           7
        //   205: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   208: aload_3        
        //   209: ifnull          219
        //   212: aload_3        
        //   213: invokevirtual   java/io/InputStreamReader.close:()V
        //   216: goto            219
        //   219: aload_2        
        //   220: ifnull          230
        //   223: aload_2        
        //   224: invokevirtual   java/io/BufferedReader.close:()V
        //   227: goto            230
        //   230: aload_0        
        //   231: ifnull          238
        //   234: aload_0        
        //   235: invokevirtual   java/lang/Process.destroy:()V
        //   238: aconst_null    
        //   239: areturn        
        //   240: astore_2       
        //   241: aload           6
        //   243: astore_0       
        //   244: aload           5
        //   246: astore_3       
        //   247: aload_3        
        //   248: ifnull          258
        //   251: aload_3        
        //   252: invokevirtual   java/io/InputStreamReader.close:()V
        //   255: goto            258
        //   258: aload           4
        //   260: ifnull          271
        //   263: aload           4
        //   265: invokevirtual   java/io/BufferedReader.close:()V
        //   268: goto            271
        //   271: aload_0        
        //   272: ifnull          279
        //   275: aload_0        
        //   276: invokevirtual   java/lang/Process.destroy:()V
        //   279: aload_2        
        //   280: athrow         
        //   281: astore_3       
        //   282: goto            122
        //   285: astore_2       
        //   286: goto            129
        //   289: astore_0       
        //   290: aload           7
        //   292: areturn        
        //   293: astore_3       
        //   294: goto            219
        //   297: astore_2       
        //   298: goto            230
        //   301: astore_0       
        //   302: aconst_null    
        //   303: areturn        
        //   304: astore_3       
        //   305: goto            258
        //   308: astore_3       
        //   309: goto            271
        //   312: astore_0       
        //   313: goto            279
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  0      8      186    190    Ljava/lang/Exception;
        //  0      8      174    186    Any
        //  8      20     169    174    Ljava/lang/Exception;
        //  8      20     159    169    Any
        //  20     29     152    159    Ljava/lang/Exception;
        //  20     29     145    152    Any
        //  38     45     140    145    Ljava/lang/Exception;
        //  38     45     240    247    Any
        //  54     63     140    145    Ljava/lang/Exception;
        //  54     63     240    247    Any
        //  72     79     140    145    Ljava/lang/Exception;
        //  72     79     240    247    Any
        //  92     102    140    145    Ljava/lang/Exception;
        //  92     102    240    247    Any
        //  111    118    140    145    Ljava/lang/Exception;
        //  111    118    240    247    Any
        //  118    122    281    285    Any
        //  122    126    285    289    Any
        //  133    137    289    293    Any
        //  203    208    240    247    Any
        //  212    216    293    297    Any
        //  223    227    297    301    Any
        //  234    238    301    304    Any
        //  251    255    304    308    Any
        //  263    268    308    312    Any
        //  275    279    312    316    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index: 176, Size: 176
        //     at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        //     at java.util.ArrayList.get(ArrayList.java:435)
        //     at com.strobel.decompiler.ast.AstBuilder.convertToAst(AstBuilder.java:3321)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:113)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveJarDecompiled(FileSaver.java:192)
        //     at us.deathmarine.luyten.FileSaver.access$300(FileSaver.java:45)
        //     at us.deathmarine.luyten.FileSaver$4.run(FileSaver.java:112)
        //     at java.lang.Thread.run(Thread.java:748)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static void setInstallApk(final String s) {
        final StringBuilder sb = new StringBuilder();
        sb.append("=============setInstallApk: ");
        sb.append(s);
        Log.e("RootShellCmdUtil", sb.toString());
        try {
            RootShellCmdUtil.process = Runtime.getRuntime().exec("su");
            final DataOutputStream dataOutputStream = new DataOutputStream(RootShellCmdUtil.process.getOutputStream());
            dataOutputStream.writeBytes(s);
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static boolean setLed(final String s) {
        try {
            RootShellCmdUtil.process = Runtime.getRuntime().exec("su");
            final DataOutputStream dataOutputStream = new DataOutputStream(RootShellCmdUtil.process.getOutputStream());
            dataOutputStream.writeBytes(s);
            dataOutputStream.flush();
            dataOutputStream.close();
            return true;
        }
        catch (IOException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public static void setMax7219(final String s) {
        try {
            RootShellCmdUtil.process = Runtime.getRuntime().exec("su");
            final DataOutputStream dataOutputStream = new DataOutputStream(RootShellCmdUtil.process.getOutputStream());
            dataOutputStream.writeBytes(s);
            dataOutputStream.flush();
            dataOutputStream.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static final void simulateClick(final Point point) {
        exec(String.format("input tap %d %d", point.x, point.y));
    }
    
    public static final void simulateKey(final int n) {
        exec(String.format("input keyevent %d", n));
    }
}
