package cn.com.dodo.geek.study.gateway.inbound;

import java.util.List;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class HttpInboundInitializer extends ChannelInitializer<SocketChannel> {

	private List<String> proxyServers;

	public HttpInboundInitializer(List<String> proxyServers) {
		this.proxyServers = proxyServers;
	}

	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline cp = ch.pipeline();
		cp.addLast(new HttpServerCodec(), new HttpObjectAggregator(1024*1024), new HttpInboundHandler(this.proxyServers));
	}

}
