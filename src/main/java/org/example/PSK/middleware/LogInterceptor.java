package org.example.PSK.middleware;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;

@Interceptor
@LoggedMethod
public class LogInterceptor implements Serializable {
    @AroundInvoke
    public Object logMethod(InvocationContext context) throws  Exception {
        System.out.println("Called: " + context.getMethod().getName());
        return context.proceed();
    }
}
