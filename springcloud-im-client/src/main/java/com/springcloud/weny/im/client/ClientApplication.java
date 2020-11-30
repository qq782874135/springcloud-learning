package com.springcloud.weny.im.client;

import com.springcloud.weny.im.client.handler.WsClientHandler;
import com.springcloud.weny.im.client.handler.WsClientInitializer;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.http.DefaultHttpHeaders;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshakerFactory;
import io.netty.handler.codec.http.websocketx.WebSocketVersion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class ClientApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		try {
			URI uri = new URI("ws://127.0.0.1:18888/ws");
			Bootstrap bootstrap = new Bootstrap();
			WsClientHandler webSocketClientHandler = new WsClientHandler(
					WebSocketClientHandshakerFactory.newHandshaker(uri
							, WebSocketVersion.V13
							, null
							, false
							, new DefaultHttpHeaders()));
			bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class).
					handler(new WsClientInitializer(webSocketClientHandler));
			Channel channel = bootstrap.connect(uri.getHost(), uri.getPort()).channel();
			channel.closeFuture().sync();
		} catch (InterruptedException | URISyntaxException e) {
			e.printStackTrace();
		} finally {
			eventLoopGroup.shutdownGracefully();
		}
	}
}
