package com.pdfviewer.openthemagazine;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class WebServiceCall {

	HttpURLConnection conn;
	OutputStreamWriter wr;
	BufferedReader rd;
	JSONObject obj;
	boolean threadSucceeded = false;
	int count = 0;

	/**
	 * Constructor of the WebServiceCall.
	 * 
	 * @param String
	 *            data The data which will be passed to the web service via POST
	 *            method
	 * @throws SocketTimeoutException 
	 */
	public WebServiceCall(String data) throws SocketTimeoutException,IllegalAccessError,IOException {
		// TODO Auto-generated constructor stub
		System.out.println("Constructor");
		WSCall(data);
	}

	/**
	 * Calls the web service
	 * 
	 * @param String
	 *            data The data which will be passed to the web service via POST
	 *            method
	 * @author Prateek
	 */
	public void WSCall(String data) throws SocketTimeoutException,IllegalAccessError,IOException {
		try {
			// String url = "http://www.bliss-dev.com/mobiibook/services/json";
			/**
			 * 
			 * 
			 * 
			 * 
			 * 
			 * ALSO CHANGE THE VIDEO URL IN THE SPLASHSCREENACTIVITY
			 */
			// String url = "http://115.242.96.79/mymobiledash/services/json";

			// String url = "http://bliss-dev.com/mymobiledash/services/json";
			// String url = "http://8.17.80.202/mymobiledash/services/json";
			// String url = "http://115.242.99.164/mymobiledash/services/json";
			// String url = "http://192.168.1.42/mymobiledash/services/json";
			// String url = "http://192.168.1.3/mymobiledash/services/json";
			System.out.println("WSCall");
			String url = "http://staging.open.codespry.com/services/json";
			String line, response;
			// HttpURLConnection is created
			URL ws_url = new URL(url);
			conn = (HttpURLConnection) ws_url.openConnection();
			try {
				conn.setDoOutput(true);
			} catch (IllegalAccessError iae) {
				// TODO: handle exception
				iae.printStackTrace();
			}
			
			// Sets the connection timeout of 8sec
			conn.setConnectTimeout(5000);
			try {
				wr = new OutputStreamWriter(conn.getOutputStream());
				OutputStream out = new BufferedOutputStream(conn.getOutputStream());

			} 
			catch (IOException io) {
				// TODO: handle exception
				System.out.println("IOexception 81");
				io.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("Exception 81");
			}
			try {
				wr.write(data);
				wr.flush();
				rd = new BufferedReader(
						new InputStreamReader(conn.getInputStream()));
			} catch (IOException ioe) {
				// TODO: handle exception
				ioe.printStackTrace();
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			response = "";
			line = "";
			// Read the response from the server
			while ((line = rd.readLine()) != null) {
				response = response + line;
			}
			wr.close();
			rd.close();
			System.out
					.println("Resposne-------------------------- " + response);
			obj = new JSONObject(response);
			// System.out.println("--" + obj.get("#error") + "---");
			if (obj.get("#error").toString().equalsIgnoreCase("false")) {
				threadSucceeded = true;
			}

			else {
//				Session.appendLog(-1, "In wscall ", "Thread staus is false ",
//						"", "", "", System.currentTimeMillis() + "", "");
				System.out.println("Thread staus is false");
			}
		} catch (JSONException e) {
			// org.json.JSONException: End of input at character 0 of
			// If the function is called again it works
//			Session.appendLog(-1, "In wscall json exception - ", e.toString(),
//					"", "", "", System.currentTimeMillis() + "", "");
			count++;
			if (count <= 1)
				WSCall(data);
		} catch (Exception e) {
			e.printStackTrace();
//			Session.appendLog(-1, "In wscall exception - ", e.toString(), "",
//					"", "", System.currentTimeMillis() + "", "");
		} finally {
			rd = null;
			wr = null;
		}
	}

	/**
	 * Returns the JSONObject of the response
	 * 
	 * @return JSONObject
	 */
	public JSONObject getExecutionResponse() {
		return obj;
	}

	/**
	 * Returns if the web service call is successful or not
	 * 
	 * @return boolean
	 */
	public boolean isThreadSucceeded() {
		return threadSucceeded;
	}

}