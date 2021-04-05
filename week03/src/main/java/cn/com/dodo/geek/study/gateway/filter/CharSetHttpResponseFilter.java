package cn.com.dodo.geek.study.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;

public class CharSetHttpResponseFilter implements HttpResponseFilter {

	private String charset = "utf-8";

	public CharSetHttpResponseFilter() {
		super();
	}

	public CharSetHttpResponseFilter(String charset) {
		super();
		this.charset = charset;
	}

	@Override
	public void filter(FullHttpResponse fullResponse, ChannelHandlerContext ctx) {
		fullResponse.headers().set("charset", this.charset);
	}

}
