package com.one.ExceptionHandle;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/*
- 首页
- Coding By One ON 08/27
*/
@RestController
public class IndexController {
    @RequestMapping("/index")
    public Map index() {
        Map<String, Object> map = new HashMap<>(16);
        map.put("code", 200);
        map.put("message", "success");
        if (1 == 1) {
//            throw new IllegalStateException("121");
            throw new ArrayIndexOutOfBoundsException("121");
        }
        return map;
    }
}
