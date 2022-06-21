package netty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author 康智波
 * 2022,05,26
 */
@Slf4j
@Component
public class NettyServerBooter implements ApplicationListener<ContextRefreshedEvent> {

    @Value("${netty.port}")
    private int nettServerPort;

    @Autowired
    private NettyWebSocketServer nettyServer;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        System.out.println("netty 启动了！");
        nettyServer.start(nettServerPort);

    }
}
