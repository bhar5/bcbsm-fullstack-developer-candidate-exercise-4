@RestController
@CrossOrigin
public class UserController {

    @RequestMapping("/login")
    public boolean login(@RequestBody User user) {
        return
          user.getUserName().equals("user") && user.getPassword().equals("password");
    }
	
    @RequestMapping("/user")
    public Principal user(HttpServletRequest request) {
        String authToken = request.getHeader("Authorization")
          .substring("Basic".length()).trim();
        return () ->  new String(Base64.getDecoder()
          .decode(authToken)).split(":")[0];
    }
}