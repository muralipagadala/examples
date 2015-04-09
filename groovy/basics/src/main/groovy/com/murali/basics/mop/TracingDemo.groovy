import org.codehaus.groovy.runtime.StringBufferWriter

class Whatevers{
	int outer(){
		return inner()
	}
	int inner(){
		return 1
	}
}

def log = new StringBuffer("\n")
def tracer = new TracingInterceptor()
def proxy = ProxyMetaClass.getInstance(Whatevers.class);
proxy.interceptor = tracer
proxy.use {
	assert 1 == new Whatevers().outer()
}

println log