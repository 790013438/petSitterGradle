package snippets.redis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class LinkTest {

    @Test
    public void testLink() {
        Jedis jedis = new Jedis("10.7.190.148", 6379);
//        jedis.auth("1qaz2wsx");
        System.out.println(jedis.get("user"));
        System.out.println(jedis.get("fucker"));
    }
}
