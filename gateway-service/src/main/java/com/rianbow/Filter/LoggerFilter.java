package com.rianbow.Filter;

import com.netflix.zuul.ZuulFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.stereotype.Component;

/**
 * Created by lailai on 2018/1/11.
 * 创建过滤器，在链路数据中添加自定义数据
 */
@Component
public class LoggerFilter extends ZuulFilter{

    @Autowired
    private Tracer tracer;

    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 900;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        //通过Tracer在链路数据中添加自定义数据-操作人
        tracer.addTag("operator","lai");
        System.out.println(tracer.getCurrentSpan().traceIdString());
        return null;
    }
}
