package com.fimtrus;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.MulticastResult;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
/**
 * Device에 GCM Message를 보낸다.
 * Map 형태로 데이터를 보낸다.
 * Device에서는 데이터를 intent -> bundle 형태로 받을 수 있다.
 * @author jong-hyun.jeong
 */
public class GCMSender {
	
	/**
	 * 하나의 디바이스에 메시지를 보낼때 사용된다.
	 * @param regId : registration ID (해당 단말기의 registration ID)
	 * @param map : Data
	 */
	public static void sendMessageToDevice(String regId, HashMap<String, String> map) {
		List<Result> results;
		String apiKey = getApiKey();
		Sender sender = new Sender(apiKey);
		
		Message.Builder builder= new Message.Builder();
		Iterator<String> iterator = map.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			String value = map.get(key);
			builder.addData(key, value);
		}
		Message message = builder.build();
        Result result = null;
		try {
			result = sender.send(message, regId, 5);
			Result s = result;
		} catch (IOException e) {
			e.printStackTrace();
		}
        results = Arrays.asList(result);
	}
	/**
	 * 여러 디바이스에 같은 메시지를 보낼때 사용한다.
	 * @param regId : registration IDs (해당 단말기의 registration ID)
	 * @param map : Data
	 */
	public static void sendMessageToDevices(List<String> regIds, HashMap<String, String> map) {
		List<Result> results;
		String apiKey = getApiKey();
		Sender sender = new Sender(apiKey);
		
		Message.Builder builder= new Message.Builder();
		Iterator<String> iterator = map.keySet().iterator();
		
		while(iterator.hasNext()) {
			String key = iterator.next();
			String value = map.get(key);
			builder.addData(key, value);
		}
		Message message = builder.build();
        MulticastResult result = null;
		try {
			result = sender.send(message, regIds, 5);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
        results = result.getResults();
	}
	
	private static String getApiKey() {
		ResourceBundle resource = ResourceBundle.getBundle("key-config");
		String key = resource.getString("api_key");
		return key;
	}
	
}
