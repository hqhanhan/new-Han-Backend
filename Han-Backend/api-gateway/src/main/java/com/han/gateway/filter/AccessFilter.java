package com.han.gateway.filter;


import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description：认证用户信息过滤器
 * Created by hqhan on 2017/6/13 0013.
 */

@Component
@DependsOn("restTemplate")
public class AccessFilter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

    @Autowired
    private RestTemplate restTemplate ;


    /**
     * 具体参数：
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时，发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }


    /**
     * 越小，优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }


    /**
     * 是否被执行，控制过滤器的控制范围
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }


    /**
     * 具体的业务逻辑
     * @return
     */
    @Override
    public Object run() {

        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer ")) {
            ctx.set("","");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("请先登录！");
            return null;
        }
        String token = authorizationHeader.substring("Bearer".length()).trim();
        /**
         * 验证token是否合法，调用han-auth模块，进行非法验证,请求路径
         */
//        ResponseEntity<Boolean> forEntity = restTemplate.getForEntity("", boolean.class);
//        Boolean isAuth = forEntity.getBody();
        Boolean isAuth = false;

        if(!isAuth){
//            ctx.setSendZuulResponse(false);
//            ctx.setResponseStatusCode(401);
//            ctx.setResponseBody("请先登录！");
            return null;
        }

        return null;
    }
}
