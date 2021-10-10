package com.cdx.course.week03.inbound;

import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class HttpInboundHandler extends ChannelInboundHandlerAdapter{
    private final List<String> proxyServer;

    public HttpInboundHandler(List<String> proxyServer) {
        this.proxyServer = proxyServer;
    }
}
