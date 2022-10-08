package com.kuaidihelp.posthouse;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.kuaidihelp.posthouse.util.MulitPointTouchListener;
import com.kuaidihelp.posthouse.util.ZoomView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PhotoSearchActivity extends AppCompatActivity {
    private TextView textViewPic;
    private TextView textViewDec;
    private TextView textViewTime;
    private ImageView imageView;
    private LinearLayout linearLayout;
    private EditText editText;
//    private List<ImageView> imageViewList;
//    private List<LinearLayout> linearViewList;
    private List<String> selectedList;
    private Button button_select_all;
    private Button button_select_not;
    private Button button_delet;
    private Button button_query;
    private Boolean editMode = false;
    /**
     * 显示图片的GridView
     */
    private GridView gvPhoto;
    /**
     * 文件夹下所有图片的地址名称
     */
    private List<String> listpathStr;
    /**
     * 文件夹下图片的真实路径
     */
    private List<String> searchDesignOrderList;
    private String scanpath;
    /**
     * 显示图片的适配器
     */
    private Photodaapter adapter;
    /**
     * 所有图片的名字
     */
    public File[] allFiles;
    /**
     * 想要查找的文件夹
     */
    private File folder;
    String serch;
    public  RelativeLayout queryCardView;
    public  ImageView imageClose;
    public  ImageView queryimageButton;
    private long lastonclickTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_search);
//        imageViewList = new ArrayList<ImageView>();
//        linearViewList = new ArrayList<LinearLayout>();
        selectedList = new ArrayList<String>();
        listpathStr = new ArrayList<>();
        initView();
    }

    @Override
    protected void onResume() {
        Log.e("wxw_界面","--进入查看图片界面--onResume");
        button_delet.setVisibility(View.INVISIBLE);
        button_select_all.setVisibility(View.INVISIBLE);
        button_select_not.setVisibility(View.INVISIBLE);
        try {
            initData();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onResume();
    }

    private void initView() {
        gvPhoto = (GridView) findViewById(R.id.gv_photo);
        editText = findViewById(R.id.et_query_barcode);
        button_select_all = findViewById(R.id.btn_quanselect);
        button_select_not = findViewById(R.id.btn_notselect);
        button_delet = findViewById(R.id.btn_delect);
        button_query = findViewById(R.id.btn_query);
        queryimageButton = findViewById(R.id.query_imageView);
        imageClose = findViewById(R.id.query_close);
        queryCardView = findViewById(R.id.query_cardView);
        RelativeLayout  btn_back = findViewById(R.id.rl_back_photosearch);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Long time = SystemClock.uptimeMillis();
                if (time - lastonclickTime >= 2000) {
/*                    Intent intent_back = new Intent(PhotoSearchActivity.this, SettingActivity.class);
                    startActivity(intent_back);*/
                    finish();
                    lastonclickTime = time;
                }
            }
        });
        button_delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editMode = false;
                for (String i : selectedList) {
                    String delectStr = folder.getPath() + "/" + adapter.mlist.get(Integer.parseInt(i));
                    deleteSingleFile(delectStr);
                    Log.d("wxwTTTTTTTTT", "----" + delectStr);
                }
                button_delet.setVisibility(View.INVISIBLE);
                button_select_all.setVisibility(View.INVISIBLE);
                button_select_not.setVisibility(View.INVISIBLE);
                selectedList.clear();
                try {
                    initData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serch = editText.getText().toString();
                findDesignOrder(serch);
            }
        });
        button_select_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedList.clear();
                for (int i = 0; i < adapter.mlist.size(); i++) {
                    selectedList.add(i + "");
                }
                serch = editText.getText().toString();
                findDesignOrder(serch);
            }
        });
        button_select_not.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedList.clear();
                serch = editText.getText().toString();
                findDesignOrder(serch);
            }
        });
        button_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                serch = editText.getText().toString();
                findDesignOrder(serch);
            }
        });
        imageClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                queryCardView.setVisibility(View.GONE);
            }
        });
    }
    public Uri getImageContentUri(File imageFile) {
        String filePath = imageFile.getAbsolutePath();
        Cursor cursor = getContentResolver().query(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                new String[]{MediaStore.Images.Media._ID},
                MediaStore.Images.Media.DATA + "=? ",
                new String[]{filePath}, null);

        if (cursor != null && cursor.moveToFirst()) {
            @SuppressLint("Range") int id = cursor.getInt(cursor
                    .getColumnIndex(MediaStore.MediaColumns._ID));
            Uri baseUri = Uri.parse("content://media/external/images/media");
            return Uri.withAppendedPath(baseUri, "" + id);
        } else {
            if (imageFile.exists()) {
                ContentValues values = new ContentValues();
                values.put(MediaStore.Images.Media.DATA, filePath);
                return getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
            } else {
                return null;
            }
        }
    }
    public static Bitmap openImage(String path){
        Bitmap bitmap = null;
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(path));
            bitmap = BitmapFactory.decodeStream(bis);
            bis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }
    private void initData() throws IOException {
        searchDesignOrderList = new ArrayList<String>();
        /**将文件夹下所有文件名存入数组*/
        String dir2 = PhotoSearchActivity.this.getExternalFilesDir(null).getPath();

        folder = new File(dir2);
        if (!folder.exists())
        {
            folder.mkdirs();
        }
        allFiles = folder.listFiles();
        /**遍历数组*/
        listpathStr.clear();
        for (int i = 0; i < allFiles.length; i++) {
            scanpath = allFiles[i].getName();

            if (scanpath.substring(scanpath.lastIndexOf(".") + 1).equals("jpg")) {
                listpathStr.add(scanpath);
            }
        }
        Collections.sort(listpathStr,new Comparator<String >(){

            @Override
            public int compare(String o1, String o2) {
                File file1 = new File(dir2+"/"+o1);
                File file2 = new File(dir2+"/"+o2);
                long modifieTime1 = file1.lastModified();
                long modifieTime2 = file2.lastModified();
                if (modifieTime1 > modifieTime2) {
                    return -1;
                }else if(modifieTime1 < modifieTime2) {
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        /** 图片写入适配器*/
        adapter = new Photodaapter(listpathStr, this);
        Log.d("wxwCC", "listpathStr---" + listpathStr.size());
        gvPhoto.setAdapter(adapter);
        gvPhoto.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View view, int position,
                                    long id) {
                switch (position) {
                    default:
                        ImageView imageView = view.findViewById(R.id.image_select);
                        if (imageView.getVisibility() == View.VISIBLE) {
                            if (selectedList.contains(position + "")) {
                                imageView.setImageResource(R.drawable.noselect);
                                selectedList.remove(position + "");
                                view.findViewById(R.id.linear).setBackgroundColor(Color.argb(100, 255, 255, 255));
                            } else {
                                imageView.setImageResource(R.drawable.dui);
                                selectedList.add(position + "");
                                view.findViewById(R.id.linear).setBackgroundColor(Color.argb(100, 200, 200, 200));
                            }
                        } else {
//                            Log.e("wxwTT", "----------" + position);
//                            Intent photoInten = new Intent();
//                            File file = new File(folder.getPath() + "/" + adapter.mlist.get(position));
//                            Log.e("wxwTT", "----------" + file.getPath()+"--"+getPackageName());
//                            Uri uri;
//                            photoInten.setAction(Intent.ACTION_VIEW);
//                            uri = FileProvider.getUriForFile(getApplicationContext(), getPackageName() + ".fileprovider", file);
//                            photoInten.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                            photoInten.setDataAndType(uri, "image/*");
//                            startActivity(photoInten);

//                            File file = new File(folder.getPath() + "/" + adapter.mlist.get(position));
//                            Log.e("wxww","--"+file.getPath());
//                            //这里的file是获取你指定的一张图片的路径
//                            Intent intent = new Intent();
//                            intent.setAction(android.content.Intent.ACTION_VIEW);
//                            intent.setDataAndType(getImageContentUri(file), "image/*");
//                            startActivity(intent);
                            Bitmap bitmap = null;
                            bitmap = openImage(folder.getPath() + "/" + adapter.mlist.get(position));
                            Log.e("ttttt","-------重新new----"+queryimageButton.getParent());
                            queryCardView.removeView(queryimageButton);
                            Log.e("ttttt","-------重新new----");
                            queryimageButton =new ZoomView(PhotoSearchActivity.this);
                            queryimageButton.setBackgroundResource(R.color.gray);
                            queryCardView.addView(queryimageButton);

                            queryimageButton.setOnTouchListener(new MulitPointTouchListener());
                            queryimageButton.setImageBitmap((Bitmap) bitmap);
                            queryCardView.setVisibility(View.VISIBLE);
                            break;
                        }
                }
            }
        });
        gvPhoto.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("wxwTT", "-position---" + position);
                editMode = true;
                view.findViewById(R.id.linear).setBackgroundColor(Color.argb(100, 200, 200, 200));
                ImageView imageView = view.findViewById(R.id.image_select);
                imageView.setImageResource(R.drawable.dui);
                selectedList.add(position + "");
                button_delet.setVisibility(View.VISIBLE);
                button_select_all.setVisibility(View.VISIBLE);
                button_select_not.setVisibility(View.VISIBLE);
                serch = editText.getText().toString();
                findDesignOrder(serch);
                return true;
            }
        });
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                serch = editText.getText().toString();
                findDesignOrder(serch);
            }
        });
    }

    private void findDesignOrder(String searchString) {
        if (searchDesignOrderList.size() != 0) {
            searchDesignOrderList.clear();
        }
        if (searchString != null ) {
            int length = listpathStr.size();
            for (int i = 0; i < length; i++) {
                String orderCode = listpathStr.get(i);
                if (orderCode.contains(searchString)) {
                    searchDesignOrderList.add(orderCode);
                }
            }
        }
        adapter.mlist = searchDesignOrderList;
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (editMode) {
            editMode = false;
            button_delet.setVisibility(View.INVISIBLE);
            button_select_all.setVisibility(View.INVISIBLE);
            button_select_not.setVisibility(View.INVISIBLE);
            serch = editText.getText().toString();
            findDesignOrder(serch);
            selectedList.clear();
            adapter.notifyDataSetChanged();
            return;
        }
        super.onBackPressed();
    }

    public  boolean deleteSingleFile(String filePath$Name) {
        File file = new File(filePath$Name);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                Log.e("--Method--", "Copy_Delete.deleteSingleFile: 删除单个文件" + filePath$Name + "成功！");
                PhotoSearchActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new
                        File(PhotoSearchActivity.this.getExternalFilesDir(null).getPath()))));
                return true;
            } else {
                Log.e("wxw", "删除单个文件" + filePath$Name + "失败！");
                return false;
            }
        } else {
            Log.e("wxw", "删除单个文件失败：" + filePath$Name + "不存在！");
            return false;
        }
    }

    public class Photodaapter extends BaseAdapter {
        private List<String> mlist;
        private Context mcontext;

        public List<String> getMlist() {
            return mlist;
        }

        private LayoutInflater minflater;

        public Photodaapter(List<String> list, Context context) {
            super();
            this.mlist = list;
            this.mcontext = context;
            this.minflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, final ViewGroup parent) {
            convertView = minflater.inflate(R.layout.lv_iv_item, null);
            textViewPic = convertView.findViewById(R.id.picshow);
            textViewDec = convertView.findViewById(R.id.picdecode);
            textViewTime = convertView.findViewById(R.id.pictime);
            imageView = convertView.findViewById(R.id.image_select);
            linearLayout = convertView.findViewById(R.id.linear);

            if (editMode) {
                imageView.setVisibility(View.VISIBLE);
                if (selectedList.contains(position + "")) {
                    imageView.setImageResource(R.drawable.dui);
                    linearLayout.setBackgroundColor(Color.argb(100, 200, 200, 200));
                } else {
                    imageView.setImageResource(R.drawable.noselect);
                    linearLayout.setBackgroundColor(Color.argb(100, 255, 255, 255));
                }

            }
            textViewPic.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
            textViewDec.setText(mlist.get(position).substring(0, mlist.get(position).lastIndexOf(".")));
            File file2 = new File(folder.getPath() + "/" + mlist.get(position));
            long modifieTime = file2.lastModified();
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(
                    new java.util.Date(modifieTime));
            textViewTime.setText(date);
            return convertView;
        }
    }
}