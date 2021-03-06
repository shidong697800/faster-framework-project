package cn.org.faster.framework.redis.spring.boot.autoconfigure;

import cn.org.faster.framework.redis.processor.RedisListenerProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @author zhangbowen
 * @since 2018/10/10
 */
@Configuration
@Import(RedisCacheAutoConfiguration.class)
@ConditionalOnProperty(prefix = "faster.redis", name = "enabled", havingValue = "true", matchIfMissing = true)
public class RedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    public static RedisListenerProcessor redisListenerProcessor() {
        return new RedisListenerProcessor();
    }

    @Bean
    @ConditionalOnMissingBean
    public RedisMessageListenerContainer redisContainer(RedisConnectionFactory redisConnectionFactory, ApplicationContext applicationContext) {
        RedisMessageListenerContainer container
                = new RedisMessageListenerContainer();
        container.setConnectionFactory(redisConnectionFactory);
        return container;
    }
}
