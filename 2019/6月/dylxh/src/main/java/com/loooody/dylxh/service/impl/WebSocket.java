package com.loooody.dylxh.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @ClassName: WebSocket
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-27 下午3:00
 * @Version 1.0
 **/

@Component
@Slf4j
@ServerEndpoint("/webSocket")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSockets = new CopyOnWriteArraySet<>();

    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSockets.add(this);

        log.info("【webSocket消息】有新的连接，总数:{}", webSockets.size());
    }

    @OnClose
    public void onClose(){
        webSockets.remove(this);

        log.info("【webSocket消息】连接断开，总数:{}", webSockets.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【webSocket消息】收到消息，总数:{}", message);
    }

    public void sendMessage(String message) {
        for (WebSocket webSocket : webSockets) {
            log.info("【webSocket消息】发送消息，总数:{}", message);

            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    @OnError
    public void onError(Session session, Throwable error){
        log.info("error");
    }

}
