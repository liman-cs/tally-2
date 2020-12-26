package com.example.tally.frag_record;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.tally.R;
import com.example.tally.db.TypeBean;
import java.util.List;

public class TypeBaseAdapter extends BaseAdapter {
    Context context;
    List<TypeBean>mDatas;
    int selectPos=0;//选中位置

    public TypeBaseAdapter(Context context, List<TypeBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
//    此适配器不考虑复用，因为所有item都显示在界面上，不回因为滑动而消失,所以北邮剩余的convertView，所以不用复写
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item_recordfrag_gv,parent,false);
        //查找布局当中的控件
        ImageView iv = convertView.findViewById(R.id.item_recordfrag_iv);
        TextView tv = convertView.findViewById(R.id.item_recordfrag_tv);
        //获取指定未知的数据源
        TypeBean typeBean = mDatas.get(position);
        tv.setText(typeBean.getTypename());
//        判断当前位置是否是选中位置，如果是，就设置为带颜色的图片，否则为灰色图片
        if (selectPos == position) {
            iv.setImageResource(typeBean.getsImageId());
        }else{
            iv.setImageResource(typeBean.getImageId());
        }

        return null;
    }
}