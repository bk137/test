package org.shun.cloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//@Component,@Service,@Controller,@Repository注解的类，并把这些类纳入进spring容器中管理。
@Component
public class MyLB implements LoadBalancer {

    //记录次数
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    /**
     * 返回现在第几次访问
     *
     * @return
     */
    public final int getAndIncrement(){
        int current;
        int next;
        do{
            current = this.atomicInteger.get();
            next = current >= 2147483647 ? 0 :current + 1;
                                    //比较与交换CAS
        }while(!this.atomicInteger.compareAndSet(current, next));
        System.out.println("*******第几次访问，次数next:"+next);
        return next;
    }


    /**
     * 返回服务器(下标)
     * @param serviceInstances 服务器总数
     * @return
     */
    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {
        int  index = getAndIncrement() % serviceInstances.size();

        return serviceInstances.get(index);
    }
}
