package yooxinz.springcloud.service.impl;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yooxinz.springcloud.service.IdService;

/**
 * Created by star on 2018/9/23.
 */
@Service
public class IdZookeeperServiceImpl implements IdService {

    private static String NODE_NAME = "idgenerator";

    @Autowired
    private CuratorFramework curatorFramework;

    @Override
    public Long generateId() {
        String backPath = this.getBackPath();

        String id = this.splitID(backPath);
        return Long.parseLong(id);
    }

    private String getBackPath() {
        String backPath = "";

        String fullPath = "/".concat(NODE_NAME);
        try {
            // 关键点：创建持久顺序节点
            backPath = curatorFramework.create().withMode(CreateMode.PERSISTENT_SEQUENTIAL).forPath(fullPath, null);
            //为防止生成的节点浪费系统资源，故生成后删除此节点
            curatorFramework.delete().forPath(backPath);
        } catch (Exception e) {
            throw new RuntimeException("Zookeeper ID生成时节点创建出错");
        }
        return backPath;
    }

    private  String splitID(String path) {
        int index = path.lastIndexOf(NODE_NAME);
        if (index >= 0) {
            index += NODE_NAME.length();
            return index <= path.length() ? path.substring(index) : "";
        }
        return path;
    }
}
