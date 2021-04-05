package cn.com.dodo.geek.study.gateway.inbound;

import java.util.List;

import cn.com.dodo.geek.study.gateway.filter.ChartSetHttpRequestFilter;
import cn.com.dodo.geek.study.gateway.filter.HttpRequestFilter;
import cn.com.dodo.geek.study.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;

public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

	private List<String> proxyServers;
	private HttpOutboundHandler handler;
	private HttpRequestFilter filter = new ChartSetHttpRequestFilter("utf-8");

	public HttpInboundHandler(List<String> proxyServers) {
		super();
		this.proxyServers = proxyServers;
		this.handler = new HttpOutboundHandler(this.proxyServers);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		try {
			FullHttpRequest request = (FullHttpRequest) msg;
			this.filter.filter(request, ctx);
			handler.handle(request, ctx);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		ctx.flush();
	}

}
