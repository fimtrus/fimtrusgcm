/**
 * test.java.java        Jul 12, 2012
 *
 * © 2012 Accenture. All Rights Reserved.
 * The trademarks used in these materials are the properties of their respective owners.
 * This work is protected by copyright law and contains valuable trade secrets and 
 * confidential information.
 */
package com.fimtrus;

import java.util.HashMap;


/**
 * 
 *
 * @author jong-hyun.jeong
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//nexus
		HashMap<String, String> map = new HashMap<String, String>();
		
		/******************************************************/
		//FROM AXA
		map.put("wisemobile", "smartivr");
		map.put("msg", "앱으로 간편하게 마일리지 정보 등록하세요!!");
//		map.put("url", "");
		map.put("url", "/AXASV?skey=axsh0010");
		map.put("mode", "aps");
		map.put("site", "1001");
		map.put("service_code", "0001");
		map.put("template_id", "11-1-82-Mobile.xml");
		/******************************************************/
		/******************************************************/
		//FROM SMARTIVR
		/******************************************************/
		//- g pro
		String deviceId = "APA91bEqTRvBIBCD1FU6J5KZ2ro5Rr_oGa_bu4PQrjCvz0jK34jJ5eFbQ8gOwmSlpP2T1k5tLWgLT-wg4-_1U4eI_H_2du_nnh9avPQr1vFz0ms5M3GskuiE01BnLJjVPJflkN0p7Bf5Dax7Oohv40p-EwmHNgVgUQ";
		
		//- nexus
//		String deviceId = "APA91bFzZyHMWcjSqFkwMHNSvkgwBYlQeZIaG2rsNol_q7KhMun7_fkgDTxNbu8Zs1-ROruCaqTECX8qos8RmVSeHeT14pmxvCDTZUBYdlh4NVv9HdsjAyhJDftep6i6dtQ26E-rou_bldxanE4gRDt3sxbftYv6YA";
		
		GCMSender.sendMessageToDevice(deviceId, map);
	}
}
