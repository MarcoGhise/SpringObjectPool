package it.blog.springobjectpool;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class FileUtil {
	
	final static Logger log = Logger.getLogger("GTWLOGGER");

	private List<String> files;
	
	public FileUtil(){		
		log.info("Object Created:" + this.hashCode());		
	}
	
	public void listFilesForFolder(final File folder) {
	    for (File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	files.add(fileEntry.getName());
	        }
	    }
	}

	public void initialize(String rootFolder)
	{			
		files = new ArrayList<String>();
		
		File folder = new File(rootFolder);
		listFilesForFolder(folder);
	}
	
	public List<String> getFileByName(String fileName)
	{
		List<String> result = new ArrayList<String>();		
		for(String file : files)
		{
			if (file.contains(fileName))
				result.add(file);
		}		
		return result;
	}
}
