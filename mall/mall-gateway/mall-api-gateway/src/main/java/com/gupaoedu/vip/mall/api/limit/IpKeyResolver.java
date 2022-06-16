package com.gupaoedu.vip.mall.api.limit;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * @ClassName: IpKeyResolver
 * @Description:
 * @Author: Du
 * @Date: 2022/5/29
 */
public class IpKeyResolver implements KeyResolver {

    /**
     * 将IP作为限流标识
     * @param exchange
     * @return
     */
    @Override
    public Mono<String> resolve(ServerWebExchange exchange) {
        //获取客户端IP
        return Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
