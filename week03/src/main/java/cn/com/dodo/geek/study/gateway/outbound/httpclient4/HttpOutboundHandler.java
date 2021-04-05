package cn.com.dodo.geek.study.gateway.outbound.httpclient4;

import java.io.IOException;
import java.util.List;
import java.util.Random;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import cn.com.dodo.geek.study.gateway.filter.CharSetHttpResponseFilter;
import cn.com.dodo.geek.study.gateway.filter.HttpResponseFilter;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;

public class HttpOutboundHandler {

	private List<String> proxyServers;
	private CloseableHttpClient httpClient;
	private HttpResponseFilter filter = new CharSetHttpResponseFilter("utf-8");

	public HttpOutboundHandler(List<String> proxyServers) {
		this.proxyServers = proxyServers;
		this.httpClient = HttpClientBuilder.create().build();
	}

	public void handle(FullHttpRequest request, ChannelHandlerContext ctx) {

		FullHttpResponse response = null;
		try {
			String url = randomServer(this.proxyServers) + request.uri();
			System.out.println("实际访问地址：" + url);
			HttpGet httpGet = new HttpGet(url);
			response = httpClient.execute(httpGet, new ResponseHandler<FullHttpResponse>() {
				@Override
				public FullHttpResponse handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
					byte[] body = EntityUtils.toByteArray(response.getEntity());
					FullHttpResponse fullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,
							HttpResponseStatus.OK, Unpooled.wrappedBuffer(body));
					fullHttpResponse.headers().set("Content-Type", "application/json");
					fullHttpResponse.headers().setInt("Content-Length",
							Integer.parseInt(response.getFirstHeader("Content-Length").getValue()));
					filter.filter(fullHttpResponse, ctx);
					return fullHttpResponse;
				}
			});
		} catch (Exception e) {
			response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.NO_CONTENT);
			ctx.close();
		} finally {
			if (request != null) {
				if (!HttpUtil.isKeepAlive(request)) {
					ctx.write(response).addListener(ChannelFutureListener.CLOSE);
				} else {
					ctx.write(response);
				}
			}
			ctx.flush();
		}
	}

	private String randomServer(List<String> proxyServers) {
		int index = new Random().nextInt(proxyServers.size());
		return proxyServers.get(index);
	}

}
