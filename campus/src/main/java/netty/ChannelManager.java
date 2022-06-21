package netty;

import io.netty.channel.Channel;
import tutorial.MessageBase;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 康智波
 * 2022,06,09
 */
public class ChannelManager {
    private static ChannelManager manager;
    private Map<Long, Channel> channelMap = new ConcurrentHashMap<>();

    public static ChannelManager getInstance() {
        if (manager == null) {
            synchronized (ChannelManager.class) {
                if (manager == null) {
                    manager = new ChannelManager();
                }
            }
        }
        return manager;
    }

    public void addChannel(Long id, Channel channel) {
        if (channelMap.containsKey(id)) {
            return;
        }
        System.out.println("ChannelManager, add an user ! " + id);
        channelMap.put(id, channel);
    }

    public void removeChannel(Long id) {
        if (!channelMap.containsKey(id)) {
            return;
        }
        Channel channel = channelMap.get(id);
        if (channel.isOpen()) {
            channel.close();
        }
        channelMap.remove(id);
    }

    public void forwardMsg(MessageBase.Message message) {
        Long remoteId = Long.parseLong(message.getReceiverId());
        if (!channelMap.containsKey(remoteId)) {
            System.out.println("ChannelManager, remote user is unConnected ! " + remoteId);
            return;
        }
        Channel remoteChannel = channelMap.get(remoteId);
        if (!remoteChannel.isOpen()) {
            System.out.println("ChannelManager address: ! " + remoteChannel.remoteAddress());
            System.out.println("ChannelManager, remote user is closed ! " + remoteId);
            return;
        }
        remoteChannel.writeAndFlush(message);
    }
}
