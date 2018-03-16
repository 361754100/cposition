package com.hro.core.cposition.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, ?> redisTemplate;

    /**
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean set(final String key, final String value, final Long expireTime) {
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });

        if(result && expireTime != null && expireTime.longValue() != 0l) {
            this.expire(key, expireTime.longValue());
        }
        return result;
    }

    /**
     *
     * @param key
     * @param obj
     * @param expireTime
     * @return
     */
    public boolean setObj(final String key, final Object obj, final Long expireTime) {
        String value = JSON.toJSONString(obj);
        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                connection.set(serializer.serialize(key), serializer.serialize(value));
                return true;
            }
        });

        if(result && expireTime != null && expireTime.longValue() != 0l) {
            this.expire(key, expireTime.longValue());
        }
        return result;
    }

    /**
     *
     * @param key
     * @return
     */
    public String get(final String key){
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });
        return result;
    }

    /**
     *
     * @param key
     * @param clz
     * @param <T>
     * @return
     */
    public <T> Object getObj(final String key, Class<T> clz){
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] value =  connection.get(serializer.serialize(key));
                return serializer.deserialize(value);
            }
        });

        if(!StringUtils.isBlank(result)) {
            return JSON.parseObject(result, clz);
        }
        return null;
    }

    /**
     *
     * @param key
     * @param expire
     * @return
     */
    public boolean expire(final String key, long expire) {
        return redisTemplate.expire(key, expire, TimeUnit.SECONDS);
    }

    /**
     *
     * @param key
     * @param list
     * @param expireTime
     * @param <T>
     * @return
     */
    public <T> boolean setList(String key, List<T> list, final Long expireTime) {
        String value = JSONUtils.toJSONString(list);
        return set(key,value, expireTime);
    }

    /**
     *
     * @param key
     * @param clz
     * @param <T>
     * @return
     */
    public <T> List<T> getList(String key,Class<T> clz) {
        String json = get(key);
        if(json!=null){
            List<T> list = JSON.parseArray(json, clz);
            return list;
        }
        return null;
    }

    /**
     *
     * @param key
     * @param obj
     * @param expireTime
     * @return
     */
    public long lpush(final String key, Object obj, final Long expireTime) {
        final String value = JSONUtils.toJSONString(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.lPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });

        if(result > 0l && expireTime != null && expireTime.longValue() != 0l) {
            this.expire(key, expireTime.longValue());
        }
        return result;
    }

    /**
     *
     * @param key
     * @param obj
     * @param expireTime
     * @return
     */
    public long rpush(final String key, Object obj, final Long expireTime) {
        final String value = JSONUtils.toJSONString(obj);
        long result = redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                long count = connection.rPush(serializer.serialize(key), serializer.serialize(value));
                return count;
            }
        });

        if(result > 0l && expireTime != null && expireTime.longValue() != 0l) {
            this.expire(key, expireTime.longValue());
        }
        return result;
    }

    /**
     *
     * @param key
     * @return
     */
    public String lpop(final String key) {
        String result = redisTemplate.execute(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] res =  connection.lPop(serializer.serialize(key));
                return serializer.deserialize(res);
            }
        });
        return result;
    }

}
