package websocketdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @ClassName: WebSocketConfig
 * @Description: TODO
 * @Author: loooody
 * @Create: 19-3-27 下午2:58
 * @Version 1.0
 **/

@Component
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
