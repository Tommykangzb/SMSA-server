package netty;

import com.google.protobuf.ByteString;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.HttpRequest;
import lombok.extern.slf4j.Slf4j;
import tutorial.MessageBase;

import javax.annotation.PostConstruct;
import java.net.InetSocketAddress;

/**
 * @author 康智波
 * 2022,05,24
 */
@Slf4j
@ChannelHandler.Sharable
public class WebSocketServerHandler extends SimpleChannelInboundHandler<MessageBase.Message>{

    public static final byte PING_MSG = 1;
    public static final byte PONG_MSG = 2;
    public static final byte CUSTOM_MSG = 3;
    private int heartbeatCount = 0;



    /**
     * 这里可以引入自己业务类来处理进行的客户端连接
     */
    //@Autowired
    //private MessageService messageService;

    private static WebSocketServerHandler webSocketServerHandler;

    public static WebSocketServerHandler getInstance(){
        if (webSocketServerHandler == null){
            synchronized (WebSocketServerHandler.class){
                if (webSocketServerHandler == null){
                    webSocketServerHandler = new WebSocketServerHandler();
                }
            }
        }
        return webSocketServerHandler;
    }
    /**
     * 解决启动加载不到自己业务类
     */
    @PostConstruct
    public void init() {
        webSocketServerHandler = this;
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        int port =  ((InetSocketAddress)ctx.channel().remoteAddress()).getPort();
        System.out.println("local: " + channel.localAddress() + "  客户端 " + channel.remoteAddress() + "上线, port：" + port);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInActive");
        super.channelInactive(ctx);
    }



    /**
     * 出现异常时
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
        //移除channel
        //webSocketServerHandler.messageService.removeConnection((NioSocketChannel) ctx.channel());
        ctx.close();
        //log.info("【" + ctx.channel().remoteAddress() + "】已关闭（服务器端）");
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageBase.Message message) throws Exception {
        System.out.println("server receive msg: " + message.getData().toStringUtf8());
        Long remoteId = Long.parseLong(message.getSenderId());
        ChannelManager.getInstance().addChannel(remoteId,channelHandlerContext.channel());
        handlerWebSocketFrame(channelHandlerContext,message);
    }

    private void handlerHttpRequest(ChannelHandlerContext ctx, HttpRequest request) {

    }


    private void handlerWebSocketFrame(ChannelHandlerContext ctx, MessageBase.Message msg) throws InterruptedException {
//        System.out.println("server receive msg: " + msg.getData().toString());
//        String str = msg.getData().toStringUtf8();
//        MessageBase.Message.Builder builder = MessageBase.Message.newBuilder();
//        builder.setSenderId("1234")
//                .setReceiverId("1234")
//                .setTimeStamp(String.valueOf(System.currentTimeMillis()))
//                .setAckMsgId("123")
//                .setMsgId("123")
//                .setType(2)
//                .setSource(1);
//        if (str.equals("你好")){
//            Thread.sleep(1500);
//            builder.setData(ByteString.copyFrom("你好呀！".getBytes()));
//        } else if (str.equals("可以少点吗")){
//            Thread.sleep(3500);
//            builder.setData(ByteString.copyFrom("可以啊！你出多少？".getBytes()));
//        } else if (str.equals("你最近有空出来吃个饭吗") ||str.equals("最近有空吗")){
//            Thread.sleep(3000);
//            builder.setData(ByteString.copyFrom("有空啊，什么时候！".getBytes()));
//        } else if(str.equals("在吗")) {
//            Thread.sleep(1500);
//            builder.setData(ByteString.copyFrom("嗯嗯".getBytes()));
//        }
//        ctx.writeAndFlush(builder.build());
        ChannelManager.getInstance().forwardMsg(msg);
    }
}
