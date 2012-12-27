package com.pdfviewer.openthemagazine;

import java.io.File;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.artifex.mupdf.R;

public class ImageAdapter extends BaseAdapter {
	private Context context;
	private final String[] titleValues;

	public ImageAdapter(Context context, String[] titleValues) {
		this.context = context;
		this.titleValues = titleValues;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View gridView;

		if (convertView == null) {

			gridView = new View(context);

			// get layout from grid_magazines.xml
			gridView = inflater.inflate(R.layout.grid_magazines, null);

			// set value into textview
			TextView textView = (TextView) gridView
					.findViewById(R.id.grid_item_label);
			textView.setText(titleValues[position].substring(
					titleValues[position].lastIndexOf('/') + 1,
					titleValues[position].lastIndexOf('.')));

			// set image based on selected text
			ImageView imageView = (ImageView) gridView
					.findViewById(R.id.grid_item_image);

			String mobile = titleValues[position];
			// String pathName =
			// "/mnt/sdcard/Download/toc-cover-winter-travel.jpg";
			String path = mobile.substring(0, mobile.lastIndexOf('.')) + ".jpg";
			Bitmap bmp = BitmapFactory.decodeFile(path);
			// Bitmap bmp = BitmapFactory.decodeFile(mobile.substring(0,
			// mobile.lastIndexOf('.')) + ".jpg");
			imageView.setImageBitmap(bmp);
			// if (mobile.equals("Windows")) {
			// imageView.setImageBitmap(bmp);
			// } else if (mobile.equals("iOS")) {
			// //imageView.setImageResource(R.drawable.ios_logo);
			// imageView.setImageBitmap(bmp);
			// } else if (mobile.equals("Blackberry")) {
			// //imageView.setImageResource(R.drawable.blackberry_logo);
			// imageView.setImageBitmap(bmp);
			// } else {
			// //imageView.setImageResource(R.drawable.android_logo);
			// imageView.setImageBitmap(bmp);
			// }
			Button bPreview = (Button) gridView.findViewById(R.id.bPreview);
			Button bBuy = (Button) gridView.findViewById(R.id.bBuy);
			bPreview.setBackgroundColor(android.graphics.Color.parseColor("#CE201F"));
			bBuy.setBackgroundColor(android.graphics.Color.parseColor("#CE201F"));
			bPreview.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// Toast.makeText(context,titleValues[position].substring(titleValues[position].lastIndexOf('/')+1,
					// titleValues[position].lastIndexOf('.')),
					// Toast.LENGTH_SHORT).show();
					File f = new File(titleValues[position]);
					// "/mnt/sdcard/Download/Final PDF FOR WEB 26th NOV 12.pdf");
					Uri uri = Uri.parse(f.getAbsolutePath());
					Intent intent = new Intent(context,
							com.artifex.mupdf.MuPDFActivity.class);
					intent.setAction(Intent.ACTION_VIEW);
					intent.setData(uri);
					context.startActivity(intent);
				}
			});
			bBuy.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					// Toast.makeText(context,titleValues[position].substring(titleValues[position].lastIndexOf('/')+1,
					// titleValues[position].lastIndexOf('.')),
					// Toast.LENGTH_SHORT).show();
					
					Intent intent = new Intent(context,
							com.pdfviewer.openthemagazine.Subscription.class);
					context.startActivity(intent);
				}
			});

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