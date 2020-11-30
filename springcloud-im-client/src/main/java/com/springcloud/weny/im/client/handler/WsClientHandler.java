package com.springcloud.weny.im.client.handler;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Weny
 * @Date:2020/10/13
 */
@Slf4j
public class WsClientHandler  extends SimpleChannelInboundHandler<Object> {
//    private MsgHandleService msgHandleService;

    private final WebSocketClientHandshaker webSocketClientHandshaker;

    public WsClientHandler(WebSocketClientHandshaker webSocketClientHandshaker) {
        this.webSocketClientHandshaker = webSocketClientHandshaker;
        //        this.msgHandleService = SpringContextHolder.getBean(MsgHandleService.class);
    }

    /**
     * 当客户端主动链接服务端的链接后，调用此方法
     *
     * @param channelHandlerContext ChannelHandlerContext
     */
    @Override
    public void channelActive(ChannelHandlerContext channelHandlerContext) {
        log.info("\n\t⌜⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓\n" +
                "\t├ [websocke 建立连接]\n" +
                "\t⌞⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓");

        Channel channel = channelHandlerContext.channel();
        // 握手
        webSocketClientHandshaker.handshake(channel);
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.info("\n\t⌜⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓\n" +
                "\t├ [exception]: {}\n" +
                "\t⌞⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓⎓", cause.getMessage());
        ctx.close();
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        System.out.println("与服务器端断开连接");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object data) throws Exception {
        log.info("接收到服务端的消息:{}", data);
        if(data instanceof TextWebSocketFrame){
            System.out.println("收到消息："+((TextWebSocketFrame)data).text());
        }else if(data instanceof BinaryWebSocketFrame){
            System.out.println("收到二进制消息："+((BinaryWebSocketFrame)data).content().readableBytes());
            BinaryWebSocketFrame binaryWebSocketFrame=new BinaryWebSocketFrame(Unpooled.buffer().writeBytes("xxx".getBytes()));
            ctx.channel().writeAndFlush(binaryWebSocketFrame);
        }
        //自定义处理消息
    }
}
