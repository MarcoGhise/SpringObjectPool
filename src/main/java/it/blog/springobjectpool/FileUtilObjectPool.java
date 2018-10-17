package it.blog.springobjectpool;

import java.util.ArrayList;
import java.util.List;
import org.springframework.aop.target.CommonsPool2TargetSource;

public class FileUtilObjectPool extends CommonsPool2TargetSource {

	private String rootFolder;
	
	public void initializeObjects() throws Exception {
		/*
		 * Initialize the object
		 */
		List<FileUtil> pool = new ArrayList<FileUtil>();

        for(int i = 0; i < this.getMinIdle(); i++) {
        	pool.add((FileUtil)this.getTarget());
        }        
        for(FileUtil instance : pool) {
        	/*
			 * Initialize Object
			 */
        	instance.initialize(rootFolder);
			
            this.releaseTarget(instance);
        }
        pool.clear();
	}
	public String getRootFolder() {
		return rootFolder;
	}
	public void setRootFolder(String rootFolder) {
		this.rootFolder = rootFolder;
	}
}
