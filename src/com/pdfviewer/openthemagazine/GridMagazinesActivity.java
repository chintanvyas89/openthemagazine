package com.pdfviewer.openthemagazine;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.artifex.mupdf.R;

public class GridMagazinesActivity extends Footer {
	GridView gridView;

//	static final String[] PDFS = new String[] { "Android", "iOS", "Windows",
//			"Blackberry" };
	List list = new ArrayList();
//	protected File mDirectory = Environment
//			.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
	protected File mDirectory = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/com.pdfviewer.openthemagazine/files");
	protected File[] mFiles = mDirectory.listFiles(new FilenameFilter() {
		public boolean accept(File file, String name) {
			if (name.toLowerCase().endsWith(".pdf"))
				return true;
			if (name.toLowerCase().endsWith(".xps"))
				return true;
			if (name.toLowerCase().endsWith(".cbz"))
				return true;
			return false;
		}

	});
	String[] filenames;

	void getFilenames() {
		// countries = null;
		int i = 0;
		for (File f : mFiles) {
			//PDFS[i] = f.getAbsolutePath();
			list.add(f.getAbsolutePath());
			i++;
		}
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		getFilenames();
		final String[] PDFS = (String[]) list.toArray(new String[list.size()]);
		ViewGroup vg = (ViewGroup) findViewById(R.id.lldata);
        ViewGroup.inflate(GridMagazinesActivity.this, R.layout.grid_main, vg);
		//setContentView(R.layout.grid_main);
		gridView = (GridView) findViewById(R.id.grid_main);

		gridView.setAdapter(new ImageAdapter(this, PDFS));

		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
//				Toast.makeText(
//						getApplicationContext(),
//						((TextView) v.findViewById(R.id.grid_item_label))
//								.getText(), Toast.LENGTH_SHORT).show();

				// ////////////////////
				File f = new File(PDFS[position]);
//						"/mnt/sdcard/Download/Final PDF FOR WEB 26th NOV 12.pdf");
				Uri uri = Uri.parse(f.getAbsolutePath());
				Intent intent = new Intent(GridMagazinesActivity.this,
						com.artifex.mupdf.MuPDFActivity.class);
				intent.setAction(Intent.ACTION_VIEW);
				intent.setData(uri);
				startActivity(intent);
				// /////////////////////
			}
		});

	}
}
