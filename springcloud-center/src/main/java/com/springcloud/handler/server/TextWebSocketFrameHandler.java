package com.springcloud.handler.server;

import com.alibaba.fastjson.JSON;
import com.springcloud.handler.bo.MsgBean;
import com.springcloud.handler.config.NettyConstant;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import org.hibernate.validator.internal.util.StringHelper;
import org.json.JSONObject;

/*
处理文本消息
 */
public class TextWebSocketFrameHandler
        extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    private final ChannelGroup group;
    public TextWebSocketFrameHandler(ChannelGroup group) {
        this.group = group;
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx,
                                   Object evt) throws Exception {
        if (evt == WebSocketServerProtocolHandler
                .ServerHandshakeStateEvent.HANDSHAKE_COMPLETE) {
            ctx.pipeline().remove(HttpRequestHandler.class);
            group.writeAndFlush(new TextWebSocketFrame(
                    "Client " + ctx.channel() + " joined"));
            group.add(ctx.channel());
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }
    @Override
    public void channelRead0(ChannelHandlerContext ctx,
                             TextWebSocketFrame msg) throws Exception {
        if(StringHelper.isNullOrEmptyString(msg.text())){return;}
        MsgBean msgBean= JSON.parseObject(msg.text(),MsgBean.class);
        msgBean.setMsg(msg.text());
        msgBean.setType(NettyConstant.MSG_TEXT);
        sendToGroup(msgBean);
//        group.writeAndFlush(msg.retain());
    }

    private void sendToGroup(MsgBean msgBean){
        if(NettyConstant.MSG_TEXT==msgBean.getType()){
            group.writeAndFlush(new TextWebSocketFrame(msgBean.getMsg()));
        }
    }
    private void sendToOne(MsgBean msgBean){

        if(NettyConstant.MSG_TEXT==msgBean.getType()){
            group.writeAndFlush(new TextWebSocketFrame(msgBean.getMsg()));
        }
    }
}
