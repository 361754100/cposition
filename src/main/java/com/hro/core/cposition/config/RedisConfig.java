package com.hro.core.cposition.config;

import com.hro.core.cposition.log.LogUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableAutoConfiguration
public class RedisConfig {

    //获取springboot配置文件的值 (get的时候获取)
    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.database}")
    private int database;


    /**
     * @Bean 和 @ConfigurationProperties
     * 该功能在官方文档是没有提到的，我们可以把@ConfigurationProperties和@Bean和在一起使用。
     * 举个例子，我们需要用@Bean配置一个Config对象，Config对象有a，b，c成员变量需要配置，
     * 那么我们只要在yml或properties中定义了a=1,b=2,c=3，
     * 然后通过@ConfigurationProperties就能把值注入进Config对象中
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    public JedisPoolConfig getRedisConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setTestOnBorrow(true);
        return config;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    public JedisConnectionFactory getConnectionFactory() {
        JedisPoolConfig config = getRedisConfig();
//
//        RedisPassword redisPassword = RedisPassword.of(this.password);
//
//        RedisStandaloneConfiguration aloneConfig = new RedisStandaloneConfiguration();
//        aloneConfig.setHostName(this.host);
//        aloneConfig.setPassword(redisPassword);
//        aloneConfig.setDatabase(this.database);
//        aloneConfig.setPort(this.port);

        JedisConnectionFactory factory = new JedisConnectionFactory(config);
        factory.setPassword(this.password);
        factory.setHostName(this.host);
        factory.setDatabase(this.database);
        factory.setPort(this.port);

//        factory.setPoolConfig(config);
        LogUtil.info("JedisConnectionFactory bean init success.");
        return factory;
    }


    @Bean
    public RedisTemplate<?, ?> getRedisTemplate() {
        JedisConnectionFactory factory = getConnectionFactory();
        LogUtil.info(this.host+","+factory.getHostName()+","+factory.getDatabase());
        LogUtil.info(this.password+","+factory.getPassword());
        LogUtil.info(factory.getPoolConfig().getMaxIdle()+"");
//        factory.setHostName(this.host);
//        factory.setPassword(this.password);
        RedisTemplate<?, ?> template = new StringRedisTemplate(getConnectionFactory());
        return template;
    }

//    @Bean
//    public CacheManager cacheManager(
//            @SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
//        return new RedisCacheManager(getRedisTemplate());
//    }
}
