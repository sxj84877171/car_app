package com.sxj.carloan.ui;

import android.support.v7.widget.RecyclerView;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sxj.carloan.BaseActivity;
import com.sxj.carloan.R;
import com.sxj.carloan.bean.CaseStateFactroy;
import com.sxj.carloan.bean.ServerBean;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class ItemRecyclerViewAdapter extends RecyclerView.Adapter<ItemRecyclerViewAdapter.ViewHolder> {
    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    String title1;
    String title2;

    List<ServerBean.RowsBean> mValues = new ArrayList<>();
    private BaseActivity activity;

    public ItemRecyclerViewAdapter(List<ServerBean.RowsBean> items, BaseActivity activity) {
        if (items != null) {
            mValues = items;
        }
        this.activity = activity;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.fragment_item, null);
//        TextView view = new TextView(parent.getContext());
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        if (position == 0) {
            if (title1 != null) {
                holder.textView.setText(title1);
            } else {
                holder.textView.setText("状态");
            }
            if (title2 != null) {
                holder.fview.setText(title2);
            } else {
                holder.fview.setText("申请人");
            }
            TextPaint paint = holder.textView.getPaint();
            paint.setFakeBoldText(true);
            paint = holder.fview.getPaint();
            paint.setFakeBoldText(true);
        } else {
            holder.fview.setText(mValues.get(position - 1).getCust_name_tmp());
            holder.textView.setText(CaseStateFactroy.getInstance().getCaseState(mValues.get(position - 1).getCase_state_id()));
        }
        ((View) holder.textView.getParent()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (position > 0) {
                    if(onItemClickListener != null){
                        onItemClickListener.onItemClick(v,mValues.get(position-1),position);
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mValues != null) {
            return mValues.size() + 1;
        }
        return 1;
    }

    public void setValues(List<ServerBean.RowsBean> mValues) {
        this.mValues = mValues;
        notifyDataSetChanged();
    }

    public void addValues(List<ServerBean.RowsBean> mValues) {
        if (this.mValues == null) {
            this.mValues = new ArrayList<>();
        }
        this.mValues.addAll(mValues);
        notifyDataSetChanged();
    }

    public void cleanValues() {
        if (this.mValues == null) {
            this.mValues = new ArrayList<>();
        }
        this.mValues.clear();
        notifyDataSetChanged();
    }

    public interface OnItemClickListener{
        void onItemClick(View view , ServerBean.RowsBean rowsBean, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {


        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.id);
            fview = (TextView) itemView.findViewById(R.id.content);
        }

        TextView textView;
        TextView fview;
    }



}
