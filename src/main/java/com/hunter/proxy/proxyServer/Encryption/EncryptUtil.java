package com.hunter.proxy.proxyServer.Encryption;

public class EncryptUtil {

	private static byte[] keys = {57, 22, -91, 82, -76, -126, -107, -28, 74, -96, 30, -51, 121, -92, -39, 45, -128, -10, 122, 86, -112, 105, -73, -87, 95, 5, 90,
								 87, -36, -67, -118, -44, -69, 72, 51, 78, 16, -83, -56, -35, -71, -85, 7, -121, 113, -123, 49, 116, 19, 18, 110, 75, -57, 55, -30,
								 85, -109, 70, -23, -120, 50, -119, -89, -99, 39, -12, -32, -115, -38, 59, 79, -17, 115, 0, 114, -43, 33, -9, 17, -106, -53, -65,
								 -75, 65, -81, -66, 29, 60, -16, 63, -90, 107, -34, 112, -2, 126, -127, -54, 14, -41, 125, -47, 104, 69, 34, 31, -62, 97, 73, 124,
								 -113, 10, 36, 98, 84, 2, 93, -55, 9, -45, -105, 13, 123, -48, 1, -5, -86, 44, -15, -74, 111, 108, 64, -13, 58, 118, 66, -18, 56,
								 25, 127, -124, 41, -78, 53, -111, 38, 21, 6, 40, 120, -68, 76, -116, 12, -79, -31, -14, -24, -49, -104, -95, 81, -125, -114, -27,
								 -64, 92, 91, -11, 77, -108, 43, -98, 37, 119, -77, 8, -40, -94, 62, 3, 47, 61, -58, -61, 68, -29, -46, 96, -101, 102, -82, 80, 42,
								 -103, -117, -20, -7, -21, 24, 89, 83, -122, -70, -8, 26, 20, 100, 15, 27, -19, 101, 99, 28, -110, 11, -42, 54, -50, 35, -4, 106,
								 46, -60, -88, 103, -97, -80, -37, -52, -84, 94, 52, -6, 4, -93, 109, 71, 117, -59, -72, -102, 48, -25, -22, 88, 32, -63, -100, 23,
								 -1, -3, -33, -26, 67};
	
	private static final boolean flag = false;
	
	public static byte[] encrypt(byte[] resource){
		if(flag)return resource;
		if(resource == null)return null;
		
		for(int i = 0; i < resource.length; i=i+10){
			int index = resource[i] + 128;
			resource[i] = keys[index];
		}
		return resource;
	}
	
	public static byte[] decrypt(byte[] resource){
		if(flag)return resource;
		if(resource == null)return null;
		
		for(int i = 0; i < resource.length; i=i+10){
			int value = resource[i];
			for(int j = 0; j < keys.length; ++j){
				if(keys[j] == value){
					resource[i] = (byte)(j - 128);
					break;
				}
			}
			
		}
		return resource;
	}
	
	public static String[] getTypeAndHostAndPort(String headStr){
		String host="";
	    String port="80";
		String type = headStr.substring(0, headStr.indexOf(" "));
		String[] ary = headStr.split("\r\n");
		for(String item : ary){      			
			if(item.startsWith("Host: ")){
				String[] hostAndPort = item.substring(6).split(":");
				host = hostAndPort[0];
				if (hostAndPort.length > 1) {
	                port = hostAndPort[1];
	            }
				break;
			}
		}
		if("CONNECT".equalsIgnoreCase(type)){
			port = "443";
		}
		return new String[]{type,host,port};
	}
	
	public static void main(String[] s){
		byte[] resource = {1,6,4,9,32,125,13,-32,1,-45,-124,-102,-53,35};
		resource = EncryptUtil.encrypt(resource);
		resource = EncryptUtil.decrypt(resource);
	}
}
