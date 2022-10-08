package com.kuaidihelp.posthouse;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.rq.net.MyApplication;
import com.rq.net.util.ExpressStationEnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExpressAdapter extends RecyclerView.Adapter<ExpressAdapter.ViewHolder> {
    private List<Express> mExpressList;
    private int selectedPosition = MyApplication.getStationEnum().getCode();
    private List<Integer> selectedPosition_multi;
    public Boolean isSingle = true;
    SharedPreferences preferDataList;
    SharedPreferences sharedPreferences;
    public ExpressAdapter(List<Express> expressList, Context context) {
        Log.e("wxww_生命周期","--ExpressAdapter--ExpressAdapter()");
        mExpressList = expressList;
        preferDataList = context.getSharedPreferences("expressMulti", Activity.MODE_PRIVATE);
        sharedPreferences = context.getSharedPreferences("state", Activity.MODE_PRIVATE);
        int environNums = preferDataList.getInt("DATA", 1);
        selectedPosition_multi = new ArrayList<>();
        for (int i = 0; i < environNums; i++) {
            int environItem = preferDataList.getInt("item_" + i, 0);
            selectedPosition_multi.add(environItem);
        }
        isSingle=sharedPreferences.getBoolean("isSingle", true);
    }
    @NonNull
    @Override
    public ExpressAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.express_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExpressAdapter.ViewHolder holder, int position) {
        Express express = mExpressList.get(position);
        holder.expressImage.setImageResource(express.getImageView());
        holder.expressName.setText(express.getTextView());
        holder.expressSwitch.setOnCheckedChangeListener(null);
        if (isSingle) {

            if (holder.getAdapterPosition() == selectedPosition) {
                holder.expressSwitch.setChecked(true);
            } else {

                holder.expressSwitch.setChecked(false);
            }
            holder.expressSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    if (isChecked) {
                        int position = holder.getAdapterPosition();
                        Express express = mExpressList.get(position);
                        setExpressStation(express.getTextView());
                        selectedPosition =position;
                        notifyDataSetChanged();
                        Log.e("wxww_调试","--selectPosition-"+ selectedPosition);
                    }
                }
            });
        }else{
            for (Integer integer : selectedPosition_multi) {
                
            }
            if (selectedPosition_multi.contains(holder.getAdapterPosition())) {
                holder.expressSwitch.setChecked(true);
            } else {
                holder.expressSwitch.setChecked(false);
            }


            holder.expressSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    int position = holder.getAdapterPosition();
                    SharedPreferences.Editor editor = preferDataList.edit();

                    if (isChecked) {
                        selectedPosition_multi.add(position);
                    } else {
                        Log.e("wxw_","-position--"+position);
/*                        for (int i = 0; i <selectedPosition_multi.size() ; i++) {
                            if (selectedPosition_multi.get(i) == position) {
                                selectedPosition_multi.remove(i);
                            }
                        }*/
                        selectedPosition_multi.remove((Integer) position);
                    }


                    Collections.sort(selectedPosition_multi, new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            if (o1 > o2) {
                                return -1;
                            } else {
                                return 1;
                            }

                        }
                    });
                    editor.clear();
                    editor.putInt("DATA",selectedPosition_multi.size());
                    for (int i = 0; i < selectedPosition_multi.size(); i++) {
                            editor.putInt("item_" + i, selectedPosition_multi.get(i));
                    }
                    editor.commit();
                }
            });

        }


    }

    @Override
    public int getItemCount() {
        return mExpressList.size();
    }

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView expressImage;
        TextView expressName;
        Switch expressSwitch;

        public ViewHolder(View view) {
            super(view);
            expressImage = (ImageView) view.findViewById(R.id.express_img);
            expressName = (TextView) view.findViewById(R.id.express_text);
            expressSwitch = (Switch) view.findViewById(R.id.express_switch);
        }

    }

    private ExpressStationEnum setExpressStation(String s) {
        switch (s) {
            case "多多驿站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.DUODUOYIZHAN);

                return ExpressStationEnum.DUODUOYIZHAN;
            case "快宝驿站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.KUAIBAO);
                return ExpressStationEnum.KUAIBAO;
            case "韵达快递":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.YUNDAKDCS);
                 return ExpressStationEnum.YUNDAKDCS;
            case "驿站助手":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.STATIONHELPER);
                 return ExpressStationEnum.STATIONHELPER;
            case "百世邻里":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.LAIQU);
                 return ExpressStationEnum.LAIQU;
            case "兔喜快递超市":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.KUAIDICAOSHI);
                 return ExpressStationEnum.KUAIDICAOSHI;
            case "驿收发":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.YSHOUFA);
                 return ExpressStationEnum.YSHOUFA;
            case "极兔":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.JITU);
                 return ExpressStationEnum.JITU;
            case "快递员小扁担":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.COURIERSMALLPOLE);
                 return ExpressStationEnum.COURIERSMALLPOLE;
            case "驿站小扁担":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.STAGESMALLPOLE);
                 return ExpressStationEnum.STAGESMALLPOLE;
            case "熊猫快收":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.PANDAHARVEST);
                 return ExpressStationEnum.PANDAHARVEST;
            case "摩西管家":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.MOXIGUANJIA);
                 return ExpressStationEnum.MOXIGUANJIA;
            case "中邮自提":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.ZYZT);
                 return ExpressStationEnum.ZYZT;
            case "中邮驿站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.ZHONGYOUSTATION);
                 return ExpressStationEnum.ZHONGYOUSTATION;
            case "妈妈驿站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.MAMASTATION);
                 return ExpressStationEnum.MAMASTATION;
            case "蓝店":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.BLUESHOP);
                 return ExpressStationEnum.BLUESHOP;
            case "丰巢服务站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.FENGCHAOSERVICE);
                 return ExpressStationEnum.FENGCHAOSERVICE;
            case "粉丝生活":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.FENSHISHENGHUO);
                 return ExpressStationEnum.FENSHISHENGHUO;
            case "果果驿站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.GUOGUOYIZHAN);
                 return ExpressStationEnum.GUOGUOYIZHAN;
            case "近邻宝高拍仪":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOGAOPAIYI);
                 return ExpressStationEnum.JINLINBAOGAOPAIYI;
            case "近邻宝快递取件":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOKUAIDIQUJIAN);
                 return ExpressStationEnum.JINLINBAOKUAIDIQUJIAN;
            case "近邻宝OCR接驳":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOOCRJIEBO);
                 return ExpressStationEnum.JINLINBAOOCRJIEBO;
            case "近邻宝取件签收":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.JINLINBAOQIANSHOU);
                 return ExpressStationEnum.JINLINBAOQIANSHOU;
            case "速递易共配":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.SUDIYIGONGPEI);
                 return ExpressStationEnum.SUDIYIGONGPEI;
            case "聚水潭":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.JUSHUITAN);
                 return ExpressStationEnum.JUSHUITAN;
            case "星火":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.XINGHUO);
                 return ExpressStationEnum.XINGHUO;
            case "溪鸟高拍仪":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.XINIAOGAOPAIYI);
                 return ExpressStationEnum.XINIAOGAOPAIYI;
            case "小兵驿站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.XIAOBINGSTATION);
                 return ExpressStationEnum.XIAOBINGSTATION;
            case "吉客云":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.NETMANAGER);
                 return ExpressStationEnum.NETMANAGER;
            case "喵站":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.MIAOZHAN);
                 return ExpressStationEnum.MIAOZHAN;
            case "众邮称重":
                if (isSingle)
                    MyApplication.setStationEnum(ExpressStationEnum.ZHONGYOUCHENGZHONG);
                 return ExpressStationEnum.ZHONGYOUCHENGZHONG;
        }
        return ExpressStationEnum.DUODUOYIZHAN;
    }

}
