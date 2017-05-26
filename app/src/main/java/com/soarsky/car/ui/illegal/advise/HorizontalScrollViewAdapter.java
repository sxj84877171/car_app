package com.soarsky.car.ui.illegal.advise;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.soarsky.car.R;
import com.soarsky.car.uitl.ImageUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class HorizontalScrollViewAdapter {

	private Context mContext;
	private LayoutInflater mInflater;
	private List<String> mDatas;
	private RemovePictureListener listener;


	public HorizontalScrollViewAdapter(Context context, List<String> mDatas, RemovePictureListener listener)
	{
		this.mContext = context;
		mInflater = LayoutInflater.from(context);
		this.mDatas = mDatas;
		this.listener = listener;
	}

	public int getCount()
	{
		return mDatas.size();
	}

	public Object getItem(int position)
	{
		return mDatas.get(position);
	}

	public long getItemId(int position)
	{
		return position;
	}

	public View getView(final int position, View convertView, ViewGroup parent)
	{

		ViewHolder viewHolder = null;
		if (convertView == null)
		{
			viewHolder = new ViewHolder();
			convertView = mInflater.inflate(
					R.layout.activity_index_gallery_item,null);
			viewHolder.mImg = (ImageView) convertView
					.findViewById(R.id.id_index_gallery_item_image);
			/*viewHolder.mText = (TextView) convertView
					.findViewById(R.id.id_index_gallery_item_text);*/
			viewHolder.iv_delete = (ImageView) convertView
					.findViewById(R.id.iv_delete);
			convertView.setTag(viewHolder);
		} else
		{
			viewHolder = (ViewHolder) convertView.getTag();
		}

	//	Log.d("TAG","mDatas.get(position)="+position+"---"+mDatas.get(position)+"-----"+mDatas.size());


		if (mDatas.size() == 0){
			viewHolder.mImg.setVisibility(View.GONE);
		}else {
			ImageUtil.loadImg(viewHolder.mImg, mDatas.get(position).toString());
		}


		viewHolder.mImg.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

//				Intent intent = new Intent(mContext,BigPictureActivity.class);
//				intent.putStringArrayListExtra("pics", (ArrayList<String>) mDatas);
//				intent.putExtra("position",position);
//				mContext.startActivity(intent);
			}
		});

		viewHolder.iv_delete.setImageResource(R.mipmap.delete_p);
		viewHolder.iv_delete.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new AlertDialog.Builder(mContext).setTitle(R.string.delete_confirm)
						.setPositiveButton(R.string.dialog_text, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// 点击“确认”后的操作
								listener.removePicture(position);



							}
						})
						.setNegativeButton(R.string.exit_cancel, new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								// 点击“返回”后的操作,这里不设置没有任何操作
							}
						}).show();
			}
		});
		return convertView;
	}


	private class ViewHolder
	{
		ImageView mImg;
		ImageView iv_delete;
		TextView mText;
	}

/**
 * 加载本地图片
 * http://bbs.3gstdy.com
 * @param url
 * @return
 */
public static Bitmap getLoacalBitmap(String url) {
	try {
		FileInputStream fis = new FileInputStream(url);
		return BitmapFactory.decodeStream(fis);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
		return null;
	}
}

}
