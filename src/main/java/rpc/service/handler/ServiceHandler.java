package rpc.service.handler;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelOutboundHandler;

/**
 * Created by alan on 17-5-23.
 */
@ChannelHandler.Sharable
public class ServiceHandler extends ChannelInboundHandlerAdapter{

    @Override
    public void channelRead(ChannelHandlerContext context,Object msg){

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext context){

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext context,Throwable cause){
        cause.printStackTrace();
        context.close();
    }
}
