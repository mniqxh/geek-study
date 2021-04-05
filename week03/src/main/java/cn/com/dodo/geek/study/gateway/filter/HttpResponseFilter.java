package cn.com.dodo.geek.study.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpResponse;

public interface HttpResponseFilter {
	void filter(FullHttpResponse fullResponse, ChannelHandlerContext ctx);
}
