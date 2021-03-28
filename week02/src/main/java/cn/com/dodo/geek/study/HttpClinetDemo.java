package cn.com.dodo.geek.study;

import java.io.Closeable;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClinetDemo {
	public static void main(String[] args) {
		HttpClient httpClient = getClinet();
		HttpGet httpGet = new HttpGet("http://localhost:8801");
		CloseableHttpResponse response = null;
		try {
			response = (CloseableHttpResponse) httpClient.execute(httpGet);
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (httpClient != null) {
					((Closeable) httpClient).close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	private static HttpClient getClinet(){
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		return httpClient;
	}

}
