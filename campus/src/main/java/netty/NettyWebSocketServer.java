package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tutorial.MessageBase;

import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

/**
 * @author 康智波
 * 2022,05,24
 */
@Slf4j
@Component
public class NettyWebSocketServer implements DisposableBean {
    /**
     * EventLoop接口
     * NioEventLoop中维护了一个线程和任务队列,支持异步提交任务,线程启动时会调用NioEventLoop的run方法,执行I/O任务和非I/O任务
     * I/O任务即selectionKey中的ready的事件,如accept,connect,read,write等,由processSelectedKeys方法触发
     * 非I/O任务添加到taskQueue中的任务,如register0,bind0等任务,由runAllTasks方法触发
     * 两种任务的执行时间比由变量ioRatio控制,默认为50,则表示允许非IO任务执行的事件与IO任务的执行时间相等
     */
    private final EventLoopGroup boosGroup = new NioEventLoopGroup();

    private final EventLoopGroup workGroup = new NioEventLoopGroup();

    private ServerBootstrap serverBootstrap; // 服务端启动

    /**
     * Channel
     * Channel类似Socket,它代表一个实体(如一个硬件设备,一个网络套接字) 的开放连接,如读写操作.通俗的讲,Channel字面意思就是通道,
     * 每一个客户端与服务端之间进行通信的一个双向通道.
     * Channel主要工作:
     * 1.当前网络连接的通道的状态(例如是否打开?是否已连接?)
     * 2.网络连接的配置参数(例如接收缓冲区的大小)
     * 3.提供异步的网络I/O操作(如建立连接,读写,绑定端口),异步调用意味着任何I/O调用都将立即返回,并且不保证在调用结束时锁清秋的I/O操作已完成.
     * 调用立即放回一个ChannelFuture实例,通过注册监听器到ChannelFuture上,可以I/O操作成功,失败或取消时回调通知调用方.
     * 4.支持关联I/O操作与对应的处理程序.
     * 不同协议,不同的阻塞类型的连接都有不同的Channel类型与之对应,下面是一些常用的Channel类型
     * NioSocketChannel,异步的客户端 TCP Socket连接
     * NioServerSocketChannel,异步的服务端 TCP Socket 连接
     * NioDatagramChannel,异步的UDP连接
     * NioSctpChannel,异步的客户端Sctp连接
     * NioSctoServerChannel,异步的Sctp服务端连接
     * 这些通道涵盖了UDP 和TCP网络IO以及文件IO
     */
    private Channel channel;

    @Value("${netty.port}")
    private Integer port;


    /**
     * 启动服务
     *
     * @param port
     */
    public void start(int port) {

        /**
         * Future
         * Future提供了另外一种在操作完成时通知应用程序的方式,这个对象可以看做一个异步操作的结果占位符.
         * 通俗的讲,它相当于一位指挥官,发送了一个请求建立完连接,通信完毕了,你通知一声它回来关闭各种IO通道,整个过程,它是不阻塞的,异步的.
         * 在Netty中所有的IO操作都是异步的,不能理科的值消息是否被正确处理,但是可以过一会儿等他执行完成或者直接注册一个监听,具体的实现就是通过Future和ChannelFutures.
         * 他们可以注册一个监听,当操作执行成功成功或者失败时监听会自动触发注册的监听事件
         */
        try {
            /**
             * Bootstrap
             * Bootstrap是引导的意思,一个Netty应用通常由一个Bootstrap开始
             * 主要作用是配置整个Netty程序,串联各个组件
             * Netty中Bootstrap类是服务端启动引导类
             */
            serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(boosGroup, workGroup)
                    //非阻塞异步服务端TCP Socket 连接
                    .channel(NioServerSocketChannel.class)
                    //指定的端口设置套接字地址
                    //.localAddress(new InetSocketAddress(port))
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    //设置为前端WebSocket可以连接
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline()
                                    .addLast(new ProtobufVarint32FrameDecoder())
                                    .addLast(new ProtobufDecoder(MessageBase.Message.getDefaultInstance()))
                                    .addLast(new ProtobufVarint32LengthFieldPrepender())
                                    .addLast(new ProtobufEncoder())
                                    .addLast(new IdleStateHandler(60,
                                            30, 60, TimeUnit.SECONDS))
                                    //配置通道处理 来进行业务处理
                                    .addLast( WebSocketServerHandler.getInstance());
                        }
                    });
            System.out.println("port: " + port);
            ChannelFuture future = serverBootstrap.bind(port).sync();

            if (!future.isSuccess()){
                System.out.println("netty server failed!");
            } else {
                System.out.println("netty server succeed!");
                channel = future.channel();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void destroy() throws InterruptedException {
        //log.info("=================Netty服务关闭==================");
        if (channel != null) {
            channel.close();
        }
        boosGroup.shutdownGracefully().sync();
        workGroup.shutdownGracefully().sync();
    }

}
