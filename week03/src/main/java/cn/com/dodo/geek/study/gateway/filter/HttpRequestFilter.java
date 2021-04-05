package cn.com.dodo.geek.study.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public interface HttpRequestFilter {
	void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx);
}
