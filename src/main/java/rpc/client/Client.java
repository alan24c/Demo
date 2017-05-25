package rpc.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import rpc.client.handler.ClientHandler;

import java.net.InetSocketAddress;

/**
 * Created by alan on 17-5-23.
 */
public class Client {



    public void start(int port){
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    public void initChannel(SocketChannel socketChannel){
                        socketChannel.pipeline().addLast(new ClientHandler());
                    }
                });


    }

    public boolean sendMessage(Object messasgeBody, InetSocketAddress address){
        // TODO: 17-5-26 远程连接 

        return false;
    }
}
