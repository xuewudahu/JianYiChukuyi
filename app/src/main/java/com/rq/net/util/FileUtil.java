package com.rq.net.util;

import android.text.*;
import android.net.*;
import android.database.*;
import java.util.*;
import androidx.appcompat.app.*;
import android.os.*;
import android.content.*;
import android.provider.*;
import android.os.storage.*;
import java.lang.reflect.*;
import java.util.zip.*;
import java.io.*;

public final class FileUtil
{
    public static final String FILE_EXTENSION_SEPARATOR = ".";
    public static final String SDPATH;
    public static final String SEP;
    private static final String TAG = "FileUtil";
    
    static {
        SEP = File.separator;
        final StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append(File.separator);
        SDPATH = sb.toString();
    }
    
    public static boolean copyFile(final String s, final String s2) throws IOException {
        return writeFile(s2, new FileInputStream(s));
    }
    
    public static boolean createFile(final File file) {
        if (file != null) {
            if (!makeDirs(getFolderName(file.getAbsolutePath()))) {
                return false;
            }
            if (!file.exists()) {
                try {
                    return file.createNewFile();
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }
    
    public static boolean createFile(final String s) {
        return !TextUtils.isEmpty((CharSequence)s) && createFile(new File(s));
    }
    
    public static void delete(final String s, final FilenameFilter filenameFilter) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return;
        }
        final File file = new File(s);
        if (!file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
        }
        if (!file.isDirectory()) {
            return;
        }
        File[] array;
        if (filenameFilter != null) {
            array = file.listFiles(filenameFilter);
        }
        else {
            array = file.listFiles();
        }
        if (array == null) {
            return;
        }
        for (int length = array.length, i = 0; i < length; ++i) {
            final File file2 = array[i];
            if (file2.isFile()) {
                file2.delete();
            }
        }
    }
    
    public static boolean deleteAllFile(final File file) {
        return file != null && file.delete();
    }
    
    public static boolean deleteAllFile(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return true;
        }
        final File file = new File(s);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        final boolean directory = file.isDirectory();
        int i = 0;
        if (!directory) {
            return false;
        }
        for (File[] listFiles = file.listFiles(); i < listFiles.length; ++i) {
            final File file2 = listFiles[i];
            if (file2.isFile()) {
                file2.delete();
            }
            else if (file2.isDirectory()) {
                deleteAllFile(file2.getAbsolutePath());
            }
        }
        return file.delete();
    }
    
    public static void deleteEmpty(final String s) {
        final File file = new File(s);
        if (file.isDirectory() && file.listFiles().length < 1) {
            file.delete();
        }
    }
    
    public static boolean deleteFile(final File file) {
        return file != null && file.delete();
    }
    
    public static boolean deleteFile(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return true;
        }
        final File file = new File(s);
        if (!file.exists()) {
            return true;
        }
        if (file.isFile()) {
            return file.delete();
        }
        final boolean directory = file.isDirectory();
        int i = 0;
        if (!directory) {
            return false;
        }
        for (File[] listFiles = file.listFiles(); i < listFiles.length; ++i) {
            final File file2 = listFiles[i];
            if (file2.isFile()) {
                file2.delete();
            }
            else if (file2.isDirectory()) {
                deleteFile(file2.getAbsolutePath());
            }
        }
        return file.delete();
    }
    
    public static String getDataColumn(Context query, final Uri uri, final String s, final String[] array) {
        Cursor cursor = null;
        Label_0080: {
            try {
                query = (Context)query.getContentResolver().query(uri, new String[] { "_data" }, s, array, (String)null);
                if (query != null) {
                    try {
                        if (((Cursor)query).moveToFirst()) {
                            final String string = ((Cursor)query).getString(((Cursor)query).getColumnIndexOrThrow("_data"));
                            if (query != null) {
                                ((Cursor)query).close();
                            }
                            return string;
                        }
                    }
                    finally {
                        break Label_0080;
                    }
                }
                if (query != null) {
                    ((Cursor)query).close();
                }
                return null;
            }
            finally {
                cursor = null;
            }
        }
        if (cursor != null) {
            cursor.close();
        }
        return  null;
    }
    
    public static List<String> getDirNameList(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return Collections.emptyList();
        }
        final File[] listFiles = new File(s).listFiles();
        if (listFiles == null) {
            return Collections.emptyList();
        }
        final ArrayList<String> list = new ArrayList<String>();
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            final File file = listFiles[i];
            if (file.isDirectory()) {
                list.add(file.getName());
            }
        }
        return list;
    }
    
    public static List<String> getExtSDCardPath() {
        final ArrayList<String> list = new ArrayList<String>();
        try {
            final InputStreamReader inputStreamReader = new InputStreamReader(Runtime.getRuntime().exec("mount").getInputStream());
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                final String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (!line.contains("extSdCard")) {
                    continue;
                }
                final String s = line.split(" ")[1];
                if (!new File(s).isDirectory()) {
                    continue;
                }
                list.add(s);
            }
            inputStreamReader.close();
            return list;
        }
        catch (Exception ex) {
            return list;
        }
    }
    
    public static File getFile(final File file) {
        try {
            if (file.exists()) {
                return file;
            }
            final File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            return file;
        }
        catch (IOException ex) {
            return null;
        }
    }
    
    public static File getFile(final String s) {
        return getFile(new File(s));
    }
    
    public static File getFile(final String s, final String s2) {
        if (!new File(s).exists()) {
            final File file = new File(FileUtil.SDPATH);
            if (!file.exists()) {
                file.mkdirs();
            }
            final String[] split = s.split("/");
            final int length = split.length;
            int i = 0;
            String s3 = "";
            while (i < length) {
                final String s4 = split[i];
                String s5 = s3;
                if (!s4.equals("")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append(s3);
                    sb.append("/");
                    sb.append(s4);
                    final String string = sb.toString();
                    final File file2 = new File(string);
                    s5 = string;
                    if (!file2.exists()) {
                        file2.mkdirs();
                        s5 = string;
                    }
                }
                ++i;
                s3 = s5;
            }
        }
        final StringBuilder sb2 = new StringBuilder();
        sb2.append(s);
        sb2.append("/");
        sb2.append(s2);
        return new File(sb2.toString());
    }
    
    public static byte[] getFileByByte(String byteArray) {
        final byte[] array = new byte[0];
        final File file = new File(byteArray);
        if (!file.exists()) {
            return array;
        }
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream((int)file.length());
        BufferedInputStream bufferedInputStream = null;
        byteArray = null;
        Throwable t;
        try {
            try {
                final BufferedInputStream bufferedInputStream2 = new BufferedInputStream(new FileInputStream(file));
                try {
                    byteArray = (String)(Object)new byte[1024];
                    while (true) {
                        final int read = bufferedInputStream2.read((byte[])(Object)byteArray, 0, 1024);
                        if (-1 == read) {
                            break;
                        }
                        byteArrayOutputStream.write((byte[])(Object)byteArray, 0, read);
                    }
                    byteArray = (String)(Object)byteArrayOutputStream.toByteArray();
                    try {
                        bufferedInputStream2.close();
                    }
                    catch (IOException bufferedInputStream1) {
                        bufferedInputStream1.printStackTrace();
                    }
                    try {
                        byteArrayOutputStream.close();
                        return (byte[])(Object)byteArray;
                    }
                    catch (IOException bufferedInputStream3) {
                        ((IOException)bufferedInputStream3).printStackTrace();
                        return (byte[])(Object)byteArray;
                    }
                }
                catch (IOException bufferedInputStream4) {}
                finally {
                    //byteArray = (String)bufferedInputStream4;
                }
            }
            finally {}
        }
        catch (IOException ex) {
            ex.printStackTrace();
            //t = (Throwable)bufferedInputStream;
            //bufferedInputStream = (BufferedInputStream)ex;
        }
        //((Throwable)bufferedInputStream).printStackTrace();
        /*try {
            ((BufferedInputStream)t).close();
        }
        catch (IOException ex2) {
            ex2.printStackTrace();
        }*/
        try {
            byteArrayOutputStream.close();
            return array;
        }
        catch (IOException ex3) {
            ex3.printStackTrace();
            return array;
        }
        /*try {
            ((BufferedInputStream)byteArray).close();
        }
        catch (IOException ex4) {
            ex4.printStackTrace();
        }
        try {
            byteArrayOutputStream.close();
        }
        catch (IOException ex5) {
            ex5.printStackTrace();
        }*/
        //throw t;
    }
    
    public static String getFileExtension(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        final int lastIndex = s.lastIndexOf(".");
        final int lastIndex2 = s.lastIndexOf(File.separator);
        if (lastIndex == -1) {
            return "";
        }
        if (lastIndex2 >= lastIndex) {
            return "";
        }
        return s.substring(lastIndex + 1);
    }
    
    public static String getFileName(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        final int lastIndex = s.lastIndexOf(File.separator);
        if (lastIndex == -1) {
            return s;
        }
        return s.substring(lastIndex + 1);
    }
    
    public static List<String> getFileNameList(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return Collections.emptyList();
        }
        final File[] listFiles = new File(s).listFiles();
        if (listFiles == null) {
            return Collections.emptyList();
        }
        final ArrayList<String> list = new ArrayList<String>();
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            final File file = listFiles[i];
            if (file.isFile()) {
                list.add(file.getName());
            }
        }
        return list;
    }
    
    public static List<String> getFileNameList(final String s, final FilenameFilter filenameFilter) {
        if (filenameFilter == null) {
            return getFileNameList(s);
        }
        if (TextUtils.isEmpty((CharSequence)s)) {
            return Collections.emptyList();
        }
        final File[] listFiles = new File(s).listFiles(filenameFilter);
        final ArrayList<String> list = new ArrayList<String>();
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            final File file = listFiles[i];
            if (file.isFile()) {
                list.add(file.getName());
            }
        }
        return list;
    }
    
    public static List<String> getFileNameList(final String s, final String s2) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return Collections.emptyList();
        }
        final File[] listFiles = new File(s).listFiles(new FilenameFilter() {
            @Override
            public boolean accept(final File file, final String s) {
                final StringBuilder sb = new StringBuilder();
                sb.append(".");
                sb.append(s2);
                return s.indexOf(sb.toString()) > 0;
            }
        });
        if (listFiles == null) {
            return Collections.emptyList();
        }
        final ArrayList<String> list = new ArrayList<String>();
        for (int length = listFiles.length, i = 0; i < length; ++i) {
            final File file = listFiles[i];
            if (file.isFile()) {
                list.add(file.getName());
            }
        }
        return list;
    }
    
    public static String getFileNameWithoutExtension(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        final int lastIndex = s.lastIndexOf(".");
        final int lastIndex2 = s.lastIndexOf(File.separator);
        if (lastIndex2 == -1) {
            if (lastIndex == -1) {
                return s;
            }
            return s.substring(0, lastIndex);
        }
        else {
            if (lastIndex == -1) {
                return s.substring(lastIndex2 + 1);
            }
            if (lastIndex2 < lastIndex) {
                return s.substring(lastIndex2 + 1, lastIndex);
            }
            return s.substring(lastIndex2 + 1);
        }
    }
    
    public static long getFileSize(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        final long n = -1L;
        if (empty) {
            return -1L;
        }
        final File file = new File(s);
        long length = n;
        if (file.exists()) {
            length = n;
            if (file.isFile()) {
                length = file.length();
            }
        }
        return length;
    }
    
    public static String getFolderName(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return s;
        }
        final int lastIndex = s.lastIndexOf(File.separator);
        if (lastIndex == -1) {
            return "";
        }
        return s.substring(0, lastIndex);
    }
    
    public static String getImageAbsolutePath(final AppCompatActivity appCompatActivity, Uri uri) {
        final Uri uri2 = null;
        if (appCompatActivity != null) {
            if (uri == null) {
                return null;
            }
            if (Build.VERSION.SDK_INT >= 19 && DocumentsContract.isDocumentUri((Context)appCompatActivity, uri)) {
                if (isExternalStorageDocument(uri)) {
                    final String[] split = DocumentsContract.getDocumentId(uri).split(":");
                    if ("primary".equalsIgnoreCase(split[0])) {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(Environment.getExternalStorageDirectory());
                        sb.append("/");
                        sb.append(split[1]);
                        return sb.toString();
                    }
                }
                else {
                    if (isDownloadsDocument(uri)) {
                        return getDataColumn((Context)appCompatActivity, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), (long)Long.valueOf(DocumentsContract.getDocumentId(uri))), null, null);
                    }
                    if (isMediaDocument(uri)) {
                        final String[] split2 = DocumentsContract.getDocumentId(uri).split(":");
                        final String s = split2[0];
                        if ("image".equals(s)) {
                            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        }
                        else if ("video".equals(s)) {
                            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                        }
                        else {
                            uri = uri2;
                            if ("audio".equals(s)) {
                                uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                            }
                        }
                        return getDataColumn((Context)appCompatActivity, uri, "_id=?", new String[] { split2[1] });
                    }
                }
            }
            else if ("content".equalsIgnoreCase(uri.getScheme())) {
                if (isGooglePhotosUri(uri)) {
                    return uri.getLastPathSegment();
                }
                return getDataColumn((Context)appCompatActivity, uri, null, null);
            }
            else if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }
    
    public static String getStoragePath(final Context context, final boolean b) {
        final StorageManager storageManager = (StorageManager)context.getSystemService(Context.STORAGE_SERVICE);
        try {
            final Class<?> forName = Class.forName("android.os.storage.StorageVolume");
            final Method method = storageManager.getClass().getMethod("getVolumeList", (Class<?>[])new Class[0]);
            final Method method2 = forName.getMethod("getPath", (Class<?>[])new Class[0]);
            final Method method3 = forName.getMethod("isRemovable", (Class<?>[])new Class[0]);
            final Object invoke = method.invoke(storageManager, new Object[0]);
            for (int length = Array.getLength(invoke), i = 0; i < length; ++i) {
                final Object value = Array.get(invoke, i);
                final String s = (String)method2.invoke(value, new Object[0]);
                if (b == (boolean)method3.invoke(value, new Object[0])) {
                    return s;
                }
            }
            return null;
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        catch (NoSuchMethodException ex2) {
            ex2.printStackTrace();
        }
        catch (InvocationTargetException ex3) {
            ex3.printStackTrace();
        }
        catch (ClassNotFoundException ex4) {
            ex4.printStackTrace();
        }
        return null;
    }
    
    public static boolean hasSdcard() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
    
    public static boolean isDownloadsDocument(final Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }
    
    public static boolean isExternalStorage(final Context context) {
        return getStoragePath(context, true) != null;
    }
    
    public static boolean isExternalStorageDocument(final Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }
    
    public static boolean isFileExist(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        final boolean b = false;
        if (empty) {
            return false;
        }
        final File file = new File(s);
        boolean b2 = b;
        if (file.exists()) {
            b2 = b;
            if (file.isFile()) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public static boolean isFolderExist(final String s) {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        final boolean b = false;
        if (empty) {
            return false;
        }
        final File file = new File(s);
        boolean b2 = b;
        if (file.exists()) {
            b2 = b;
            if (file.isDirectory()) {
                b2 = true;
            }
        }
        return b2;
    }
    
    public static boolean isGooglePhotosUri(final Uri uri) {
        return "com.google.android.apps.photos.content".equals(uri.getAuthority());
    }
    
    public static boolean isMediaDocument(final Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }
    
    public static boolean makeDirs(final File file) {
        return file != null && ((file.exists() && file.isDirectory()) || file.mkdirs());
    }
    
    public static boolean makeDirs(final String s) {
        if (TextUtils.isEmpty((CharSequence)s)) {
            return false;
        }
        final File file = new File(s);
        return (file.exists() && file.isDirectory()) || file.mkdirs();
    }
    
    public static String readFile(final String s) throws IOException {
        return readFile(s, "utf-8");
    }
    
    public static String readFile(String string, final String s) throws IOException {
        if (TextUtils.isEmpty((CharSequence)string)) {
            return null;
        }
        String s2 = s;
        if (TextUtils.isEmpty((CharSequence)s)) {
            s2 = "utf-8";
        }
        final File file = new File(string);
        final StringBuilder sb = new StringBuilder("");
        if (!file.isFile()) {
            return null;
        }
        BufferedReader bufferedReader2;
        try {
            final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), s2));
            try {
                while (true) {
                    final String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (!sb.toString().equals("")) {
                        sb.append("\r\n");
                    }
                    sb.append(line);
                }
                string = sb.toString();
                try {
                    bufferedReader.close();
                    return string;
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                    return string;
                }
            }
            finally {}
        }
        finally {
            bufferedReader2 = null;
        }
        /*if (bufferedReader2 != null) {
            try {
                bufferedReader2.close();
            }
            catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }*/
        //throw string;
    }
    
    public static List<String> readFileToList(final String s) throws IOException {
        return readFileToList(s, "utf-8");
    }
    
    public static List<String> readFileToList(String s, final String s2) throws IOException {
        final boolean empty = TextUtils.isEmpty((CharSequence)s);
        final BufferedReader bufferedReader = null;
        if (empty) {
            return null;
        }
        String s3 = s2;
        List<String> ss = new ArrayList();
        if (TextUtils.isEmpty((CharSequence)s2)) {
            s3 = "utf-8";
        }
        final File file = new File(s);
        //s = (String)new ArrayList();
        if (!file.isFile()) {
            return null;
        }
        BufferedReader bufferedReader3;
        try {
            final BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file), s3));
            try {
                while (true) {
                    final String line = bufferedReader2.readLine();
                    if (line == null) {
                        break;
                    }
                    ((List<String>)ss).add(line);
                }
                try {
                    bufferedReader2.close();
                    return (List<String>)ss;
                }
                catch (IOException ex) {
                    ex.printStackTrace();
                    return (List<String>)ss;
                }
            }
            finally {}
        }catch (Exception e){}
        /*finally {
            bufferedReader3 = bufferedReader;
        }
        if (bufferedReader3 != null) {
            try {
                bufferedReader3.close();
            }
            catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }*/
        return ss;
    }
    
    public static boolean writeFile(final File file, final InputStream inputStream) throws IOException {
        return writeFile(file, inputStream, false);
    }
    
    public static boolean writeFile(File ex, final InputStream inputStream, final boolean b) throws IOException {
        Object o = null;
        try {
            createFile(((File)ex).getAbsolutePath());
            FileOutputStream exs = new FileOutputStream((File)ex, b);
            try {
                o = new byte[2048];
                while (true) {
                    final int read = inputStream.read((byte[])o);
                    if (read == -1) {
                        break;
                    }
                    ((OutputStream)exs).write((byte[])o, 0, read);
                }
                ((OutputStream)exs).flush();
                try {
                    ((OutputStream)exs).close();
                    inputStream.close();
                    return true;
                }
                catch (IOException ioException) {
                    ioException.printStackTrace();
                    return true;
                }
            }
            finally {
                o = ex;
            }
        }
        finally {}
        /*if (o != null) {
            try {
                ((OutputStream)o).close();
                inputStream.close();
            }
            catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }*/
    }
    
    public static boolean writeFile(final String s, final InputStream inputStream) throws IOException {
        return writeFile(s, inputStream, false);
    }
    
    public static boolean writeFile(final String s, final InputStream inputStream, final boolean b) throws IOException {
        File file;
        if (s != null) {
            file = new File(s);
        }
        else {
            file = null;
        }
        return writeFile(file, inputStream, b);
    }
    
    public static boolean writeFile(String ex, final String s, final boolean b) throws IOException {
        if (TextUtils.isEmpty((CharSequence)ex)) {
            return false;
        }
        if (TextUtils.isEmpty((CharSequence)s)) {
            return false;
        }
        final OutputStreamWriter outputStreamWriter = null;
        OutputStreamWriter outputStreamWriter2;
        try {
            createFile((String)ex);
            FileWriter exw = new FileWriter((String)ex, b);
            try {
                ((Writer)exw).write(s);
                ((OutputStreamWriter)exw).flush();
                try {
                    ((OutputStreamWriter)exw).close();
                    return true;
                }
                catch (IOException e) {
                    e.printStackTrace();
                    return true;
                }
            }
            finally {}
        }catch (Exception e){}
        /*finally {
            outputStreamWriter2 = outputStreamWriter;
        }
        if (outputStreamWriter2 != null) {
            try {
                outputStreamWriter2.close();
            }
            catch (IOException ex2) {
                ex2.printStackTrace();
            }
        }*/
        return false;
    }
    
    public static boolean zipFile(final String s, final String s2) throws IOException {
        if (!isFileExist(s)) {
            return false;
        }
        final File file = new File(s2);
        if (file.exists()) {
            file.delete();
        }
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream4;
        FileInputStream fileInputStream3;
        try {
            final File file2 = new File(s);
            final FileInputStream fileInputStream = new FileInputStream(file2);
            try {
                final FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    final ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);
                    try {
                        final ZipEntry zipEntry = new ZipEntry(file2.getName());
                        zipEntry.setSize(file2.length());
                        zipEntry.setTime(file2.lastModified());
                        zipOutputStream.putNextEntry(zipEntry);
                        final byte[] array = new byte[1024];
                        while (true) {
                            final int read = fileInputStream.read(array);
                            if (read == -1) {
                                break;
                            }
                            zipOutputStream.write(array, 0, read);
                        }
                        zipOutputStream.flush();
                        zipOutputStream.close();
                        fileOutputStream.close();
                        fileInputStream.close();
                        return true;
                    }
                    finally {}
                }
                finally {}
            }
            finally {}
        }
        finally {
            fileInputStream2 = null;
            fileInputStream3 = (fileInputStream4 = fileInputStream2);
        }
        /*if (fileInputStream2 != null) {
            ((ZipOutputStream)fileInputStream2).close();
        }
        if (fileInputStream3 != null) {
            ((FileOutputStream)fileInputStream3).close();
        }
        if (fileInputStream4 != null) {
            fileInputStream4.close();
        }
        throw;*/
    }
}
