package in.nari.rest;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.nari.binding.User;

@RestController
public class UserRestController {
	
	private HashOperations<String, Integer, User> hashOps;
	
	
	
	public UserRestController(RedisTemplate<String, User> redisTemplate) {
		hashOps = redisTemplate.opsForHash();
	}

	@PostMapping("/user")
	public String saveUser(@RequestBody User user) {
		    hashOps.put("Persons", user.getUserId(), user);
		    return "User Insert";
	}
	
	@GetMapping("/user/{uid}")
	public User getUserById(@PathVariable Integer uid) {
		return hashOps.get("Persons", uid);	
	}
	

}
