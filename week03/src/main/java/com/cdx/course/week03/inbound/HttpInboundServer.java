package com.cdx.course.week03.inbound;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.EpollChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
@Slf4j
public class HttpInboundServer {

    private int port;

    private List<String> proxyServers;

    public HttpInboundServer(int port, List<String> proxyServers) {
        this.port = port;
        this.proxyServers = proxyServers;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(8);

        ServerBootstrap sb = new ServerBootstrap();
        sb.childOption(ChannelOption.TCP_NODELAY, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.SO_REUSEADDR, true)
                .childOption(ChannelOption.SO_RCVBUF, 32 * 1024)
                .childOption(ChannelOption.SO_SNDBUF, 32 * 1024)
                .childOption(EpollChannelOption.SO_REUSEPORT, true)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT);

        sb.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.DEBUG))
                .childHandler(new HttpInboundInitializer(this.proxyServers));

        Channel ch = sb.bind(port).sync().channel();
        log.debug("开启netty http服务器，监听地址和端口为 http://127.0.0.1:" + port + '/');
        ch.closeFuture().sync();


    }
}
