package cn.com.dodo.geek.study.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class ChartSetHttpRequestFilter implements HttpRequestFilter {

	private String charset = "utf-8";

	public ChartSetHttpRequestFilter() {
		super();
	}

	public ChartSetHttpRequestFilter(String charset) {
		this.charset = charset;
	}

	@Override
	public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
		fullRequest.headers().set("charset", this.charset);
	}

}
