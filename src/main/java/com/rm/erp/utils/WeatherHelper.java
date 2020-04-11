package com.rm.erp.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.alibaba.fastjson.JSONObject;

public class WeatherHelper {

	public static Map<String, Object> getWatherByCity() throws NullPointerException, IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		String country = getWeatkerInfo();
		String watherInfo = "";
		if (StringUtil.isEmpty(country)) {
			watherInfo = getWeather(Constants.CITYID);
		} else {
			watherInfo = getWeather(country);
		}
		String[] weatherInfoLiStrings = watherInfo.split("#");
		resultMap.put("temperature", weatherInfoLiStrings[4].substring(7, weatherInfoLiStrings[4].length()));
		resultMap.put("realWather", weatherInfoLiStrings[12]);
		resultMap.put("wather", weatherInfoLiStrings[13]);
		return resultMap;
	}

	public static String getWeatkerInfo() {
		try {
			String country = "";
			String ip = Tools.getCurrentUserIP();
			String address = IpAddressUtils.getAddresses("ip=" + ip, "utf-8");
			if (!StringUtil.isEmpty(address)) {
				JSONObject jsonObject = JSONObject.parseObject(address);
				if (jsonObject != null) {
					JSONObject dataJsonObject = jsonObject.getJSONObject("data");
					if (dataJsonObject != null) {
						country = dataJsonObject.getString("country");
					}
				}
			}
			return country;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 获取SOAP的请求头，并替换其中的标志符号为用户输入的城市
	 * 
	 * @param city 用户输入的城市名称
	 * @return 客户将要发送给服务器的SOAP请求
	 */
	private static String getSoapRequest(String city) {
		StringBuilder sb = new StringBuilder();
		sb.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>"
				+ "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" "
				+ "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" "
				+ "xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">"
				+ "<soap:Body>    <getWeather xmlns=\"http://WebXml.com.cn/\">" + "<theCityCode>" + city
				+ "</theCityCode>    </getWeather>" + "</soap:Body></soap:Envelope>");
		return sb.toString();
	}

	/**
	 * 用户把SOAP请求发送给服务器端，并返回服务器点返回的输入流
	 * 
	 * @param city 用户输入的城市名称
	 * @return 服务器端返回的输入流，供客户端读取
	 * @throws Exception
	 */
	private static InputStream getSoapInputStream(String city) throws Exception {
		try {
			String soap = getSoapRequest(city);
			if (soap == null) {
				return null;
			}
			URL url = new URL("http://www.webxml.com.cn/WebServices/WeatherWS.asmx");
			URLConnection conn = url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);

			conn.setRequestProperty("Content-Length", Integer.toString(soap.length()));
			conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
			conn.setRequestProperty("SOAPAction", "http://WebXml.com.cn/getWeather");

			OutputStream os = conn.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os, "utf-8");
			osw.write(soap);
			osw.flush();
			osw.close();

			InputStream is = conn.getInputStream();
			return is;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 对服务器端返回的XML进行解析
	 * 
	 * @param city 用户输入的城市名称
	 * @return 字符串 用#分割
	 */
	public static String getWeather(String city) {
		try {
			Document doc;
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);
			DocumentBuilder db = dbf.newDocumentBuilder();
			InputStream is = getSoapInputStream(city);
			doc = db.parse(is);
			NodeList nl = doc.getElementsByTagName("string");
			StringBuffer sb = new StringBuffer();
			for (int count = 0; count < nl.getLength(); count++) {
				Node n = nl.item(count);
				if (n.getFirstChild().getNodeValue().equals("查询结果为空！")) {
					sb = new StringBuffer("#");
					break;
				}
				sb.append(n.getFirstChild().getNodeValue() + "#");
			}
			is.close();
			return sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
