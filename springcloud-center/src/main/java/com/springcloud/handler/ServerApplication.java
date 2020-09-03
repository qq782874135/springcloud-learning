package com.springcloud.handler;

import com.springcloud.handler.server.ChatServer;
import io.netty.channel.ChannelFuture;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.net.InetSocketAddress;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})public class ServerApplication {
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
			final ChatServer endpoint = new ChatServer();
			ChannelFuture future = endpoint.start(
					new InetSocketAddress(18888));
			Runtime.getRuntime().addShutdownHook(new Thread() {
				@Override
				public void run() {
					endpoint.destroy();
				}
			});
			future.channel().closeFuture().syncUninterruptibly();
	}

}
