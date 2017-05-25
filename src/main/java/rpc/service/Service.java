package rpc.service;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import rpc.service.handler.ServiceHandler;

import java.net.InetSocketAddress;

/**
 * Created by alan on 17-5-23.
 */
public class Service {

    private int port;

    Service(int port){
        this.port = port;
    }

    public void start() throws InterruptedException {

        ServerBootstrap bootstrap =  new ServerBootstrap();
        bootstrap.group(new NioEventLoopGroup(),new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel socketChannel){
                        socketChannel.pipeline().addLast(new ServiceHandler());
                    }
                });

        final ChannelFuture future = bootstrap.bind(new InetSocketAddress(8080));
        future.addListener(new ChannelFutureListener() {
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                if(channelFuture.isSuccess()){
                    System.out.println("service start...");
                }else {
                    System.out.println("service start fail");
                    channelFuture.cause().printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {

    }
}
