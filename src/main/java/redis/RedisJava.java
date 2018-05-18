package redis;

import redis.clients.jedis.Jedis;

/**
 *  Created by ly on 2018/3/16.
 */
public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("67.218.129.213",6379);

        System.out.println("连接成功!");

        jedis.auth("admin");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
    }
}
