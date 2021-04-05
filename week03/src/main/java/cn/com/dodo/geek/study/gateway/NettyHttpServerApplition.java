package cn.com.dodo.geek.study.gateway;

import java.util.Arrays;
import java.util.List;

import cn.com.dodo.geek.study.gateway.inbound.NettyInboundServer;

public class NettyHttpServerApplition {

	public static void main(String[] args) {
		int port = 8888;
		List<String> proxyServers = Arrays
				.asList(new String[] { "http://localhost:8801", "http://localhost:8802", "http://localhost:8803" });
		NettyInboundServer server = new NettyInboundServer(port, proxyServers);
		try {
			server.run();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
