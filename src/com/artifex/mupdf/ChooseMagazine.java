package com.artifex.mupdf;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class ChooseMagazine extends Activity {
	// Array of strings storing country names
	String[] countries = new String[] { "India", "Pakistan", "Sri Lanka",
			"China", "Bangladesh", "Nepal", "Afghanistan", "North Korea",
			"South Korea", "Japan" };

	//String[] countries = new String[]{};
	// Array of integers points to images stored in /res/drawable-ldpi/
	String[] flags = new String[] {
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg",
			"/mnt/sdcard/Download/toc-cover-winter-travel.jpg" };
	//String[] flags;

	// Array of strings to store currencies
	String[] currency = new String[] { "Indian Rupee", "Pakistani Rupee",
			"Sri Lankan Rupee", "Renminbi", "Bangladeshi Taka",
			"Nepalese Rupee", "Afghani", "North Korean Won",
			"South Korean Won", "Japanese Yen" };
	//String[] currency = new String[]{};
	protected File mDirectory = Environment
			.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
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
	//List<String> fileNames; = new ArrayList<String>();
	void getFilenames() {
		//countries = null;
		int i = 0;
		for (File f : mFiles) {
			//fileNames.add(f.getName());
			countries[i] = f.getName();
			String str = f.getAbsolutePath();
			flags[i] = str.substring(0, str.lastIndexOf('.')) + ".jpg";
			currency[i] = str.substring(0, str.lastIndexOf('.')) + ".jpg";
			i++;
		}
		//countries = fileNames.toString();
		
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.list_main);
		getFilenames();
		// Each row in the list stores country name, currency and flag
		List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
		int len = countries.length;
		for (int i = 0; i < len; i++) {
			HashMap<String, String> hm = new HashMap<String, String>();
			hm.put("title", "Country : " + countries[i]);
			hm.put("cur", currency[i]);
			hm.put("image", flags[i]);
			aList.add(hm);
		}

		// Keys used in Hashmap
		String[] from = { "image", "title", "cur" };

		// Ids of views in listview_layout
		int[] to = { R.id.image, R.id.title, R.id.cur };

		// Instantiating an adapter to store each items
		// R.layout.listview_layout defines the layout of each item
		SimpleAdapter adapter = new SimpleAdapter(getBaseContext(), aList,
				R.layout.magazines_list, from, to);

		// Getting a reference to listview of main.xml layout file
		ListView listView = (ListView) findViewById(R.id.listview);

		// Setting the adapter to the listView
		listView.setAdapter(adapter);
		// Item Click Listener for the listview
		OnItemClickListener itemClickListener = new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View container,
					int position, long id) {
				// Getting the Container Layout of the ListView
				LinearLayout linearLayoutParent = (LinearLayout) container;

				// Getting the inner Linear Layout
				LinearLayout linearLayoutChild = (LinearLayout) linearLayoutParent
						.getChildAt(1);

				// Getting the Country TextView
				//TextView tvCountry = (TextView) linearLayoutChild.getChildAt(0);

				// Toast.makeText(getBaseContext(),
				// tvCountry.getText().toString(), Toast.LENGTH_SHORT)
				// .show();
				TextView tvCurrency = (TextView) linearLayoutChild
						.getChildAt(1);
				Toast.makeText(getBaseContext(),
						tvCurrency.getText().toString(), Toast.LENGTH_SHORT)
						.show();
//				Uri uri = Uri.parse(mFiles[position].getAbsolutePath());
//				Intent intent = new Intent(com.artifex.mupdf.ChooseMagazine.this,com.artifex.mupdf.MuPDFActivity.class);
//				intent.setAction(Intent.ACTION_VIEW);
//				intent.setData(uri);
//				startActivity(intent);
			}
		};
		// Setting the item click listener for the listview
		listView.setOnItemClickListener(itemClickListener);
	}

}
