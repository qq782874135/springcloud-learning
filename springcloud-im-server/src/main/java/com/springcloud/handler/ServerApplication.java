package com.springcloud.handler;

import com.springcloud.handler.config.NettyConstant;
import com.springcloud.handler.server.ChatServer;
import io.netty.channel.ChannelFuture;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.net.InetSocketAddress;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})

public class ServerApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		final ChatServer endpoint = new ChatServer();
		ChannelFuture future = endpoint.start(
				new InetSocketAddress(NettyConstant.WS_PORT));
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				endpoint.destroy();
			}
		});
		future.channel().closeFuture().syncUninterruptibly();
	}
}
