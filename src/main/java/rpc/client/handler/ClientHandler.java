package rpc.client.handler;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Created by alan on 17-5-26.
 */
public class ClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    @Override
    public void channelActive(ChannelHandlerContext context){

    }

    @Override
    public void channelRead0(ChannelHandlerContext context,ByteBuf readIn){

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context,Throwable cause){

    }
}
