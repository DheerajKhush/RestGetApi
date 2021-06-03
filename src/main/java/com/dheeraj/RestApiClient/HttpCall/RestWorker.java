package com.dheeraj.RestApiClient.HttpCall;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.dheeraj.RestApiClient.DataModel.JsonDataModel;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/*
 * Class to perform Http Requests and response
 * 
 * 
 */
public class RestWorker {
	String urlString;
	private List<JsonDataModel> lsitArrayList;

	public RestWorker(String urlString) {
		this.urlString = urlString;
	}

	public List<JsonDataModel> getListData() {
		return lsitArrayList;
	}

	public void callRestApi() {

		OkHttpClient client = new OkHttpClient();
//			 System.out.println("Calling the API..");
		Request request = new Request.Builder().url(urlString).get().build();

		try {
			Response response = client.newCall(request).execute();
			String jsonString = response.body().string();
			JSONObject jsonObject = new JSONObject(jsonString);
			JSONArray jsonArray = jsonObject.getJSONArray("list");
			lsitArrayList = new ArrayList<>();

			for (int i = 0; i < jsonArray.length(); i++) {

				JSONObject jsonObject2 = jsonArray.getJSONObject(i);
				JSONObject mainObject = jsonObject2.getJSONObject("main");
				JSONObject windObject = jsonObject2.getJSONObject("wind");

				JsonDataModel dataModel = new JsonDataModel();

				dataModel.setWeather(mainObject.get("temp").toString());
				dataModel.setPressure(mainObject.get("pressure").toString());
				dataModel.setWindSpeed(windObject.get("speed").toString());
				dataModel.setDateTimeString(jsonObject2.get("dt_txt").toString());
				lsitArrayList.add(dataModel);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
