package com.loooody.miaosha.redis;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Service
public class RedisService {

    @Autowired
    RedisPoolFactory redisPoolFactory ;


    /**
     * 获取单个对象
     * @param prefix
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        Jedis jedis = null;
        try{
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            String realKey = prefix.getPrefix() + key;
            String str = jedis.get(realKey);
            T t = stringToBean(str,clazz);
            return t;
        }finally{
            returnToPool(jedis);
        }
    }

    /**
     * 设置对象
     * @param keyPrefix
     * @param key
     * @param value
     * @param <T>
     * @return
     */
    public <T> boolean set(KeyPrefix keyPrefix, String key, T value) {
        Jedis jedis = null;
        try{
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            String realKey = keyPrefix.getPrefix() + key;
            String str = beanToString(value);
            if (str == null || str.length() <= 0) {
                return false;
            }
            int seconds = keyPrefix.expireSeconds();
            if (seconds <= 0) {
                jedis.set(realKey, str);
            }else{
                jedis.setex(realKey, seconds, str);
            }
            return true;
        }finally{
            returnToPool(jedis);
        }
    }

    /**
     * 判断值是否存在
     * @param keyPrefix
     * @param key
     * @param <T>
     * @return
     */
    public <T> boolean exists(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try{
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.exists(realKey);
        }finally{
            returnToPool(jedis);
        }
    }

    public <T> Long incr(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try{
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.incr(realKey);
        }finally{
            returnToPool(jedis);
        }
    }

    public <T> Long decr(KeyPrefix keyPrefix, String key) {
        Jedis jedis = null;
        try{
            jedis = redisPoolFactory.JedisPoolFactory().getResource();
            String realKey = keyPrefix.getPrefix() + key;
            return jedis.decr(realKey);
        }finally{
            returnToPool(jedis);
        }
    }

    private <T> String beanToString(T value) {

        if (value == null) {
            return null;
        }
        Class<?> clazz = value.getClass();
        if(clazz == int.class || clazz == Integer.class){
            return "" + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        }else{
            return JSON.toJSONString(value);
        }

    }

    private <T> T stringToBean(String str, Class<T> clazz) {
        if (str == null || str.length() <= 0 || clazz == null) {
            return null;
        }
        if(clazz == int.class || clazz == Integer.class){
            return (T) Integer.valueOf(str);
        } else if (clazz == String.class) {
            return (T)str;
        } else if (clazz == long.class || clazz == Long.class) {
            return (T) Long.valueOf(str);
        }else{
            return JSON.toJavaObject(JSON.parseObject(str), clazz);
        }
    }

    private void returnToPool(Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }

}
