package org.shun.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Administrator
 */
public interface LoadBalancer {
    //服务器数量
    ServiceInstance instances(List<ServiceInstance> serviceInstances);
}
