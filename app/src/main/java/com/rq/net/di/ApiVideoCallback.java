package com.rq.net.di;

import com.rq.net.bean.AdVideoTableBean;

import okhttp3.ResponseBody;
import retrofit2.*;
import retrofit2.Call;
import retrofit2.Response;

public class ApiVideoCallback implements Callback<ResponseBody>
{
    private static final String TAG = "ApiVideoCallback";
    private HttpVideoCallback httpCallback;
    private AdVideoTableBean videoBean;
    
    public ApiVideoCallback(final HttpVideoCallback httpCallback, final AdVideoTableBean videoBean) {
        this.httpCallback = httpCallback;
        this.videoBean = videoBean;
    }
    
    public void onFailure(final Call<ResponseBody> call, final Throwable t) {
        final HttpVideoCallback httpCallback = this.httpCallback;
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
                //     1: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.val$body:Lokhttp3/ResponseBody;
                //     4: ifnonnull       8
                //     7: return         
                //     8: sipush          4096
                //    11: newarray        B
                //    13: astore          7
                //    15: new             Ljava/io/File;
                //    18: dup            
                //    19: aload_0        
                //    20: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //    23: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$000:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/bean/AdVideoTableBean;
                //    26: invokevirtual   com/yunpan/cobaaidlservice/bean/AdVideoTableBean.getLocalImagePath:()Ljava/lang/String;
                //    29: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
                //    32: astore          6
                //    34: aload           6
                //    36: invokevirtual   java/io/File.exists:()Z
                //    39: ifne            48
                //    42: aload           6
                //    44: invokevirtual   java/io/File.mkdirs:()Z
                //    47: pop            
                //    48: aload           6
                //    50: invokestatic    com/yunpan/common/utils/FileUtil.deleteFile:(Ljava/io/File;)Z
                //    53: pop            
                //    54: aload_0        
                //    55: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.val$body:Lokhttp3/ResponseBody;
                //    58: invokevirtual   okhttp3/ResponseBody.contentLength:()J
                //    61: lstore          4
                //    63: aload_0        
                //    64: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.val$body:Lokhttp3/ResponseBody;
                //    67: invokevirtual   okhttp3/ResponseBody.byteStream:()Ljava/io/InputStream;
                //    70: astore          8
                //    72: new             Ljava/io/FileOutputStream;
                //    75: dup            
                //    76: aload           6
                //    78: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;)V
                //    81: astore          9
                //    83: lconst_0       
                //    84: lstore_2       
                //    85: aload           8
                //    87: aload           7
                //    89: invokevirtual   java/io/InputStream.read:([B)I
                //    92: istore_1       
                //    93: iload_1        
                //    94: iconst_m1      
                //    95: if_icmpne       178
                //    98: aload           9
                //   100: invokevirtual   java/io/OutputStream.flush:()V
                //   103: aload_0        
                //   104: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   107: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$000:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/bean/AdVideoTableBean;
                //   110: ifnull          124
                //   113: aload_0        
                //   114: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   117: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$000:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/bean/AdVideoTableBean;
                //   120: invokestatic    com/yunpan/cobaaidlservice/sqlite///LitePalManager.save:(Lorg/litepal/crud/DataSupport;)Z
                //   123: pop            
                //   124: aload           8
                //   126: ifnull          137
                //   129: aload           8
                //   131: invokevirtual   java/io/InputStream.close:()V
                //   134: goto            137
                //   137: aload           9
                //   139: invokevirtual   java/io/OutputStream.close:()V
                //   142: goto            150
                //   145: aload           7
                //   147: invokevirtual   java/io/IOException.printStackTrace:()V
                //   150: aload_0        
                //   151: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   154: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$100:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback;
                //   157: ifnull          177
                //   160: aload_0        
                //   161: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   164: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$100:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback;
                //   167: aload           6
                //   169: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
                //   172: invokeinterface com/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback.onSuccess:(Ljava/lang/String;)V
                //   177: return         
                //   178: aload           9
                //   180: aload           7
                //   182: iconst_0       
                //   183: iload_1        
                //   184: invokevirtual   java/io/OutputStream.write:([BII)V
                //   187: lload_2        
                //   188: iload_1        
                //   189: i2l            
                //   190: ladd           
                //   191: lstore_2       
                //   192: new             Ljava/lang/StringBuilder;
                //   195: dup            
                //   196: invokespecial   java/lang/StringBuilder.<init>:()V
                //   199: astore          10
                //   201: aload           10
                //   203: ldc             "file download: "
                //   205: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   208: pop            
                //   209: aload           10
                //   211: lload_2        
                //   212: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
                //   215: pop            
                //   216: aload           10
                //   218: ldc             " of "
                //   220: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
                //   223: pop            
                //   224: aload           10
                //   226: lload           4
                //   228: invokevirtual   java/lang/StringBuilder.append:(J)Ljava/lang/StringBuilder;
                //   231: pop            
                //   232: ldc             "ApiVideoCallback"
                //   234: aload           10
                //   236: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
                //   239: invokestatic    android/util/Log.d:(Ljava/lang/String;Ljava/lang/String;)I
                //   242: pop            
                //   243: goto            85
                //   246: astore          7
                //   248: aload           8
                //   250: astore          10
                //   252: aload           9
                //   254: astore          8
                //   256: goto            300
                //   259: astore          7
                //   261: aconst_null    
                //   262: astore          9
                //   264: aload           8
                //   266: astore          10
                //   268: aload           9
                //   270: astore          8
                //   272: goto            300
                //   275: aconst_null    
                //   276: astore          7
                //   278: goto            370
                //   281: astore          7
                //   283: goto            294
                //   286: goto            364
                //   289: astore          7
                //   291: aconst_null    
                //   292: astore          6
                //   294: aconst_null    
                //   295: astore          10
                //   297: aconst_null    
                //   298: astore          8
                //   300: aload           10
                //   302: ifnull          313
                //   305: aload           10
                //   307: invokevirtual   java/io/InputStream.close:()V
                //   310: goto            313
                //   313: aload           8
                //   315: ifnull          331
                //   318: aload           8
                //   320: invokevirtual   java/io/OutputStream.close:()V
                //   323: goto            331
                //   326: aload           8
                //   328: invokevirtual   java/io/IOException.printStackTrace:()V
                //   331: aload_0        
                //   332: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   335: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$100:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback;
                //   338: ifnull          358
                //   341: aload_0        
                //   342: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   345: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$100:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback;
                //   348: aload           6
                //   350: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
                //   353: invokeinterface com/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback.onSuccess:(Ljava/lang/String;)V
                //   358: aload           7
                //   360: athrow         
                //   361: aconst_null    
                //   362: astore          6
                //   364: aconst_null    
                //   365: astore          8
                //   367: aconst_null    
                //   368: astore          7
                //   370: aload           8
                //   372: ifnull          383
                //   375: aload           8
                //   377: invokevirtual   java/io/InputStream.close:()V
                //   380: goto            383
                //   383: aload           7
                //   385: ifnull          401
                //   388: aload           7
                //   390: invokevirtual   java/io/OutputStream.close:()V
                //   393: goto            401
                //   396: aload           7
                //   398: invokevirtual   java/io/IOException.printStackTrace:()V
                //   401: aload_0        
                //   402: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   405: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$100:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback;
                //   408: ifnull          428
                //   411: aload_0        
                //   412: getfield        com/yunpan/cobaaidlservice/net/ApiVideoCallback$1.this$0:Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;
                //   415: invokestatic    com/yunpan/cobaaidlservice/net/ApiVideoCallback.access$100:(Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback;)Lcom/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback;
                //   418: aload           6
                //   420: invokevirtual   java/io/File.getAbsolutePath:()Ljava/lang/String;
                //   423: invokeinterface com/yunpan/cobaaidlservice/net/ApiVideoCallback$HttpVideoCallback.onSuccess:(Ljava/lang/String;)V
                //   428: return         
                //   429: astore          6
                //   431: goto            361
                //   434: astore          7
                //   436: goto            286
                //   439: astore          7
                //   441: goto            275
                //   444: astore          7
                //   446: aload           9
                //   448: astore          7
                //   450: goto            370
                //   453: astore          7
                //   455: goto            145
                //   458: astore          8
                //   460: goto            326
                //   463: astore          7
                //   465: goto            396
                //    Exceptions:
                //  Try           Handler
                //  Start  End    Start  End    Type                 
                //  -----  -----  -----  -----  ---------------------
                //  8      34     429    364    Ljava/lang/Exception;
                //  8      34     289    294    Any
                //  34     48     434    289    Ljava/lang/Exception;
                //  34     48     281    286    Any
                //  48     72     434    289    Ljava/lang/Exception;
                //  48     72     281    286    Any
                //  72     83     439    281    Ljava/lang/Exception;
                //  72     83     259    275    Any
                //  85     93     444    453    Ljava/lang/Exception;
                //  85     93     246    259    Any
                //  98     124    444    453    Ljava/lang/Exception;
                //  98     124    246    259    Any
                //  129    134    453    150    Ljava/io/IOException;
                //  137    142    453    150    Ljava/io/IOException;
                //  178    187    444    453    Ljava/lang/Exception;
                //  178    187    246    259    Any
                //  192    243    444    453    Ljava/lang/Exception;
                //  192    243    246    259    Any
                //  305    310    458    331    Ljava/io/IOException;
                //  318    323    458    331    Ljava/io/IOException;
                //  375    380    463    401    Ljava/io/IOException;
                //  388    393    463    401    Ljava/io/IOException;
                // 
                // The error that occurred was:
                // 
                // java.lang.IndexOutOfBoundsException: Index: 210, Size: 210
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
    
    public interface HttpVideoCallback
    {
        void onFailure(final int p0, final String p1);
        
        void onSuccess(final String p0);
    }
}
