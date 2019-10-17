package yooxinz.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import yooxinz.springcloud.rpc.ConfigRpc;
import yooxinz.springcloud.service.UserService;
import lombok.extern.slf4j.Slf4j;


import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * Created by star on 2018/8/17.
 */
@RestController
@Slf4j
public class ConfigController{

    @Autowired
    private UserService userSerivce;
    @Resource
    private ConfigRpc configRpc;

    @Value("${spring.datasource.driver-class-name}")
    private  String from;

    @RequestMapping("/")
    @ResponseBody
    public String index(){
        log.info("add");
        return userSerivce.getUserNameById((long)1).toString();
    }

    @RequestMapping(value = "/hi")
    public String hi(){
        return from;
    }

    @RequestMapping("/lambda")
    public void addNum(){

        String[] atp = {"Rafael Nadal",
                "Novak Djokovic",
                "Stanislas Wawrinka",
                "David Ferrer", "Roger Federer",
                "Andy Murray","Tomas Berdych",
                "Juan Martin Del Potro"};
        List<String> players =  Arrays.asList(atp);
        // 以前的循环方式
        for (String player : players) {
            System.out.print(player + "; ");
        }
        // 使用 lambda 表达式以及函数操作(functional operation)
        players.forEach((player) -> System.out.print(player + "; "));
        // 在 Java 8 中使用方法引用
        players.forEach(System.out::println);

    }

    @RequestMapping("/thread")
    public void thread(){
        for (int i=0; i<20; i++){
            userSerivce.executeAsyncTask(i);
        }
    }

    @RequestMapping("/fegin")
    public String fegin(){
        log.info("fegin");
        return configRpc.hi();
    }
}
