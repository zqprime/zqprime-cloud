package club.zqprime.app.Interceptor;


import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;


/**
 * mybatis 乐观锁发生并发修改错误时拦截
 *
 */
@Intercepts({@Signature(
		  type= Executor.class,
		  method = "update",
		  args = {MappedStatement.class,Object.class})})
public class VersionInterceptor implements Interceptor{

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] objs = invocation.getArgs();
		for (Object obj : objs) {
			if(obj instanceof MappedStatement){
				MappedStatement ms = (MappedStatement)obj;
				if(ms.getId().endsWith("updateById")){
					Object res = invocation.proceed();
					if(Integer.parseInt(res.toString())==0){
						throw new RuntimeException("并发错误，你的数据已经被修改");
					}
					return res;
				}
			}
		}
		return invocation.proceed();
	}

}
