package com.loooody.miaosha.redis;

public class OrderPrefix extends BasePrefix {
    public OrderPrefix(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }
}
