package com.pdfviewer.openthemagazine;

import com.artifex.mupdf.R;
import com.artifex.mupdf.R.id;
import com.artifex.mupdf.R.layout;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
 
public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] titleValues;
 
	public ImageAdapter(Context context, String[] titleValues) {
		this.context = context;
		this.titleValues = titleValues;
	}
 
	public View getView(int position, View convertView, ViewGroup parent) {
 
		LayoutInflater inflater = (LayoutInflater) context
			.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View gridView;
 
		if (convertView == null) {
 
			gridView = new View(context);
 
			// get layout from mobile.xml
			gridView = inflater.inflate(R.layout.grid_magazines, null);
 
			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(titleValues[position].substring(titleValues[position].lastIndexOf('/')+1, titleValues[position].lastIndexOf('.')));
 
			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);
 
			String mobile = titleValues[position];
//			String pathName = "/mnt/sdcard/Download/toc-cover-winter-travel.jpg";
			String path = mobile.substring(0, mobile.lastIndexOf('.')) + ".jpg";
			Bitmap bmp = BitmapFactory.decodeFile(path);
//			Bitmap bmp = BitmapFactory.decodeFile(mobile.substring(0, mobile.lastIndexOf('.')) + ".jpg");
			imageView.setImageBitmap(bmp);
//			if (mobile.equals("Windows")) {
//				imageView.setImageBitmap(bmp);
//			} else if (mobile.equals("iOS")) {
//				//imageView.setImageResource(R.drawable.ios_logo);
//				imageView.setImageBitmap(bmp);
//			} else if (mobile.equals("Blackberry")) {
//				//imageView.setImageResource(R.drawable.blackberry_logo);
//				imageView.setImageBitmap(bmp);
//			} else {
//				//imageView.setImageResource(R.drawable.android_logo);
//				imageView.setImageBitmap(bmp);
//			}
 
		} else {
			gridView = (View) convertView;
		}
 
		return gridView;
	}
 
	@Override
	public int getCount() {
		return titleValues.length;
	}
 
	@Override
	public Object getItem(int position) {
		return null;
	}
 
	@Override
	public long getItemId(int position) {
		return 0;
	}
 
}