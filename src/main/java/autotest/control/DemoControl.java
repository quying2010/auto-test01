package autotest.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/demo")
public class DemoControl {
    private List<HashMap<String,String>> list=new LinkedList<HashMap<String,String>>();
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginGet(String username, String password) {
        String result= "username"+username+",password"+password;
       return result;
    }
    @RequestMapping(value = "/loginMem", method = RequestMethod.GET)
    public String loginMem(String username, String password) {
        String result= "username"+username+",password"+password;
        for(int i=0;i<100000;i++) {
            HashMap<String, String> map = new HashMap<String, String>();
            map.put(username,password);
            list.add(map);
        }
        return result;
    }
}
