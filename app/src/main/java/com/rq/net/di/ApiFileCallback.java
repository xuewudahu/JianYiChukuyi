package com.rq.net.di;

import com.rq.net.util.FileUtil;

import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit2.Call;
import retrofit2.Response;

public class ApiFileCallback implements Callback<ResponseBody>
{
    public static final String APK_NAME;
    private static final String TAG = "ApiFileCallback";
    private HttpCallback httpCallback;
    public String videoPath;
    
    static {
        final StringBuilder sb = new StringBuilder();
        sb.append(FileUtil.SDPATH);
        sb.append("CobaAI.apk");
        APK_NAME = sb.toString();
    }
    
    public ApiFileCallback(final HttpCallback httpCallback) {
        this.httpCallback = httpCallback;
    }
    
    public ApiFileCallback(final HttpCallback httpCallback, final String videoPath) {
        this.httpCallback = httpCallback;
        this.videoPath = videoPath;
    }
    
    public void onFailure(final Call<ResponseBody> call, final Throwable t) {
        final HttpCallback httpCallback = this.httpCallback;
        if (httpCallback != null) {
            httpCallback.onFailure(-1, t.getMessage());
        }
    }
    
    public void onResponse(final Call<ResponseBody> call, final Response<ResponseBody> response) {
        this.writeFile((ResponseBody)response.body());
    }
    
    public void writeFile(final ResponseBody responseBody) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                // 
                // This method could not be decompiled.
                // 
                // Original Bytecode:
                // 
                //     1: getfield        com/yunpan/common/net/ApiFileCallback$1.val$body:Lokhttp3/ResponseBody;
                //     4: ifnonnull       8
                //     7: return         
                //     8: sipush          4096
                //    11: newarray        B
                //    13: astore          9
                //    15: aload_0        
                //    16: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //    19: getfield        com/yunpan/common/net/ApiFileCallback.videoPath:Ljava/lang/String;
                //    22: invokestatic    com/yunpan/common/utils/StringUtil.isNotEmpty:(Ljava/lang/String;)Z
                //    25: ifeq            47
                //    28: new             Ljava/io/File;
                //    31: dup            
                //    32: aload_0        
                //    33: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //    36: getfield        com/yunpan/common/net/ApiFileCallback.videoPath:Ljava/lang/String;
                //    39: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
                //    42: astore          8
                //    44: goto            59
                //    47: new             Ljava/io/File;
                //    50: dup            
                //    51: getstatic       com/yunpan/common/net/ApiFileCallback.APK_NAME:Ljava/lang/String;
                //    54: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
                //    57: astore          8
                //    59: aload           8
                //    61: invokevirtual   java/io/File.exists:()Z
                //    64: ifne            73
                //    67: aload           8
                //    69: invokevirtual   java/io/File.mkdirs:()Z
                //    72: pop            
                //    73: aload           8
                //    75: invokestatic    com/yunpan/common/utils/FileUtil.deleteFile:(Ljava/io/File;)Z
                //    78: pop            
                //    79: aload_0        
                //    80: getfield        com/yunpan/common/net/ApiFileCallback$1.val$body:Lokhttp3/ResponseBody;
                //    83: invokevirtual   okhttp3/ResponseBody.contentLength:()J
                //    86: lstore          6
                //    88: aload_0        
                //    89: getfield        com/yunpan/common/net/ApiFileCallback$1.val$body:Lokhttp3/ResponseBody;
                //    92: invokevirtual   okhttp3/ResponseBody.byteStream:()Ljava/io/InputStream;
                //    95: astore          10
                //    97: new             Ljava/io/FileOutputStream;
                //   100: dup            
                //   101: aload           8
                //   103: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
                //   106: astore          11
                //   108: aload_0        
                //   109: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   112: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   115: invokeinterface com/yunpan/common/net/ApiFileCallback$HttpCallback.onStart:()V
                //   120: new             Ljava/lang/StringBuilder;
                //   123: dup            
                //   124: invokespecial   java/lang/StringBuilder.<init>:()V
                //   127: astore          12
                //   129: aload           12
                //   131: ldc             "file download: ======================="
                //   133: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   136: pop            
                //   137: aload           12
                //   139: lload           6
                //   141: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
                //   144: pop            
                //   145: ldc             "ApiFileCallback"
                //   147: aload           12
                //   149: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                //   152: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
                //   155: pop            
                //   156: lconst_0       
                //   157: lstore          4
                //   159: aload           10
                //   161: aload           9
                //   163: invokevirtual   java/io/InputStream.read:([B)I
                //   166: istore_3       
                //   167: iload_3        
                //   168: iconst_m1      
                //   169: if_icmpne       231
                //   172: aload           11
                //   174: invokevirtual   java/io/OutputStream.flush:()V
                //   177: aload           10
                //   179: ifnull          190
                //   182: aload           10
                //   184: invokevirtual   java/io/InputStream.close:()V
                //   187: goto            190
                //   190: aload           11
                //   192: invokevirtual   java/io/OutputStream.close:()V
                //   195: goto            203
                //   198: aload           9
                //   200: invokevirtual   java/io/IOException.printStackTrace:()V
                //   203: aload_0        
                //   204: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   207: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   210: ifnull          230
                //   213: aload_0        
                //   214: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   217: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   220: aload           8
                //   222: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
                //   225: invokeinterface com/yunpan/common/net/ApiFileCallback$HttpCallback.onSuccess:(Ljava/lang/String;)V
                //   230: return         
                //   231: aload           11
                //   233: aload           9
                //   235: iconst_0       
                //   236: iload_3        
                //   237: invokevirtual   java/io/OutputStream.write:([BII)V
                //   240: lload           4
                //   242: iload_3        
                //   243: i2l            
                //   244: ladd           
                //   245: lstore          4
                //   247: aload_0        
                //   248: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   251: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   254: astore          12
                //   256: lload           4
                //   258: l2f            
                //   259: fconst_1       
                //   260: fmul           
                //   261: fstore_1       
                //   262: lload           6
                //   264: l2f            
                //   265: fconst_1       
                //   266: fmul           
                //   267: fstore_2       
                //   268: aload           12
                //   270: fload_1        
                //   271: fload_2        
                //   272: fdiv           
                //   273: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
                //   276: invokeinterface com/yunpan/common/net/ApiFileCallback$HttpCallback.onProgress:(Ljava/lang/Float;)V
                //   281: new             Ljava/lang/StringBuilder;
                //   284: dup            
                //   285: invokespecial   java/lang/StringBuilder.<init>:()V
                //   288: astore          12
                //   290: aload           12
                //   292: ldc             "file download: "
                //   294: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   297: pop            
                //   298: aload           12
                //   300: fload_1        
                //   301: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
                //   304: pop            
                //   305: aload           12
                //   307: ldc             " of "
                //   309: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   312: pop            
                //   313: aload           12
                //   315: fload_2        
                //   316: invokevirtual   java/lang/StringBuilder.append:(F)Ljava/lang/StringBuilder;
                //   319: pop            
                //   320: ldc             "ApiFileCallback"
                //   322: aload           12
                //   324: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                //   327: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
                //   330: pop            
                //   331: goto            159
                //   334: astore          9
                //   336: aload           10
                //   338: astore          12
                //   340: aload           11
                //   342: astore          10
                //   344: goto            388
                //   347: astore          9
                //   349: aconst_null    
                //   350: astore          11
                //   352: aload           10
                //   354: astore          12
                //   356: aload           11
                //   358: astore          10
                //   360: goto            388
                //   363: aconst_null    
                //   364: astore          9
                //   366: goto            458
                //   369: astore          9
                //   371: goto            382
                //   374: goto            452
                //   377: astore          9
                //   379: aconst_null    
                //   380: astore          8
                //   382: aconst_null    
                //   383: astore          12
                //   385: aconst_null    
                //   386: astore          10
                //   388: aload           12
                //   390: ifnull          401
                //   393: aload           12
                //   395: invokevirtual   java/io/InputStream.close:()V
                //   398: goto            401
                //   401: aload           10
                //   403: ifnull          419
                //   406: aload           10
                //   408: invokevirtual   java/io/OutputStream.close:()V
                //   411: goto            419
                //   414: aload           10
                //   416: invokevirtual   java/io/IOException.printStackTrace:()V
                //   419: aload_0        
                //   420: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   423: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   426: ifnull          446
                //   429: aload_0        
                //   430: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   433: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   436: aload           8
                //   438: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
                //   441: invokeinterface com/yunpan/common/net/ApiFileCallback$HttpCallback.onSuccess:(Ljava/lang/String;)V
                //   446: aload           9
                //   448: athrow         
                //   449: aconst_null    
                //   450: astore          8
                //   452: aconst_null    
                //   453: astore          10
                //   455: aconst_null    
                //   456: astore          9
                //   458: aload           10
                //   460: ifnull          471
                //   463: aload           10
                //   465: invokevirtual   java/io/InputStream.close:()V
                //   468: goto            471
                //   471: aload           9
                //   473: ifnull          489
                //   476: aload           9
                //   478: invokevirtual   java/io/OutputStream.close:()V
                //   481: goto            489
                //   484: aload           9
                //   486: invokevirtual   java/io/IOException.printStackTrace:()V
                //   489: aload_0        
                //   490: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   493: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   496: ifnull          516
                //   499: aload_0        
                //   500: getfield        com/yunpan/common/net/ApiFileCallback$1.this$0:Lcom/yunpan/common/net/ApiFileCallback;
                //   503: invokestatic    com/yunpan/common/net/ApiFileCallback.access$000:(Lcom/yunpan/common/net/ApiFileCallback;)Lcom/yunpan/common/net/ApiFileCallback$HttpCallback;
                //   506: aload           8
                //   508: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
                //   511: invokeinterface com/yunpan/common/net/ApiFileCallback$HttpCallback.onSuccess:(Ljava/lang/String;)V
                //   516: return         
                //   517: astore          8
                //   519: goto            449
                //   522: astore          9
                //   524: goto            374
                //   527: astore          9
                //   529: goto            363
                //   532: astore          9
                //   534: aload           11
                //   536: astore          9
                //   538: goto            458
                //   541: astore          9
                //   543: goto            198
                //   546: astore          10
                //   548: goto            414
                //   551: astore          9
                //   553: goto            484
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  8      44     517    452    Ljava/io/IOException;
                //  8      44     377    382    Any
                //  47     59     517    452    Ljava/io/IOException;
                //  47     59     377    382    Any
                //  59     73     522    377    Ljava/io/IOException;
                //  59     73     369    374    Any
                //  73     97     522    377    Ljava/io/IOException;
                //  73     97     369    374    Any
                //  97     108    527    369    Ljava/io/IOException;
                //  97     108    347    363    Any
                //  108    156    532    541    Ljava/io/IOException;
                //  108    156    334    347    Any
                //  159    167    532    541    Ljava/io/IOException;
                //  159    167    334    347    Any
                //  172    177    532    541    Ljava/io/IOException;
                //  172    177    334    347    Any
                //  182    187    541    203    Ljava/io/IOException;
                //  190    195    541    203    Ljava/io/IOException;
                //  231    240    532    541    Ljava/io/IOException;
                //  231    240    334    347    Any
                //  247    256    532    541    Ljava/io/IOException;
                //  247    256    334    347    Any
                //  268    331    532    541    Ljava/io/IOException;
                //  268    331    334    347    Any
                //  393    398    546    419    Ljava/io/IOException;
                //  406    411    546    419    Ljava/io/IOException;
                //  463    468    551    489    Ljava/io/IOException;
                //  476    481    551    489    Ljava/io/IOException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index: 252, Size: 252
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
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformCall(AstMethodBodyBuilder.java:1164)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:1009)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformByteCode(AstMethodBodyBuilder.java:554)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformExpression(AstMethodBodyBuilder.java:540)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformNode(AstMethodBodyBuilder.java:392)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.transformBlock(AstMethodBodyBuilder.java:333)
                //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:294)
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
        }).start();
    }
    
    public interface HttpCallback
    {
        void onFailure(final int p0, final String p1);
        
        void onProgress(final Float p0);
        
        void onStart();
        
        void onSuccess(final String p0);
    }
}
