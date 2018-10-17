package it.blog.springobjectpool;

import java.util.ArrayList;
import java.util.List;

public class ObjectPool extends org.springframework.aop.target.CommonsPool2TargetSource {

	public <T> void initializeObjects() throws Exception {
		/*
		 * Initialize the object
		 */
		List<T> pool = new ArrayList<T>();

        for(int i = 0; i < this.getMinIdle(); i++) {
        	pool.add((T)this.getTarget());
        }
        
        for(T instance : pool) {
            this.releaseTarget(instance);
        }

        pool.clear();

	}

}
