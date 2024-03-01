package in.nari.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import in.nari.binding.User;

@Configuration
public class RedisConfig {
	
	@Bean
	public JedisConnectionFactory getJedisConnection() {
		JedisConnectionFactory factory = new JedisConnectionFactory();
		// factory.setHostName(hostName);
		// factory.setPassword(password);
		// factory.setPort(port);
		//This is for local server
		return factory;
	}
	
	@Bean
	@Primary
	public RedisTemplate<String, User> getRedisTemplate(JedisConnectionFactory factory){
		RedisTemplate<String, User> rt =new RedisTemplate<>();
		rt.setConnectionFactory(factory);
		return rt;
	}

}