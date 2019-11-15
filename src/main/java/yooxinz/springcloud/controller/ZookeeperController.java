package yooxinz.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import yooxinz.springcloud.service.IdService;

/**
 * Created by star on 2018/8/17.
 */
@RestController
@Slf4j
@RequestMapping("/zookeeper")
public class ZookeeperController {

    @Autowired
    private IdService idService;

    @RequestMapping("/generate/id")
    @ResponseBody
    public Long generateId(){
        return idService.generateId();
    }
}
