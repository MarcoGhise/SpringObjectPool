package it.blog.springobjectpool;

import java.util.List;

import it.blog.springobjectpool.response.ResultRest;

import org.apache.log4j.Logger;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

	final static Logger log = Logger.getLogger("GTWLOGGER");

	@Autowired
	@Qualifier("poolTargetSourceResultRest")
	CommonsPool2TargetSource poolTargetSourceResultRest;
	
	@Autowired
	@Qualifier("poolTargetSourceFileUtil")
	CommonsPool2TargetSource poolTargetSourceFileUtil;
	
	@RequestMapping(value = "/pool", method = { RequestMethod.GET, RequestMethod.POST })
	public ResultRest pool(@RequestParam("code") int code) {

		try {
			
			/*
			 * Return Object from Object Pool
			 */
			ResultRest simpleBean = (ResultRest)poolTargetSourceResultRest.getTarget();
			
			Thread.currentThread().sleep(400);
			
			simpleBean.setRetCode(code);
			
			log.info("Object Hashcode:" + simpleBean.hashCode());
			
			log.info("Value set:" + simpleBean.getRetCode());			
			
			simpleBean.setRetCode(code);
			simpleBean.setRetDesc("test");
			
			poolTargetSourceResultRest.releaseTarget(simpleBean);
			
			return simpleBean;
		} catch (Exception e) {
			log.error("changeProfile", e);
			return new ResultRest(-100, e.getMessage());
		}
		
	}
	
	@RequestMapping(value = "/file", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> file(@RequestParam("filename") String filename) {		
		try {			
			/*
			 * Return Object from Object Pool
			 */
			FileUtil simpleBean = (FileUtil)poolTargetSourceFileUtil.getTarget();			
			log.info("Object Hashcode:" + simpleBean.hashCode());
			/*
			 * Look for the file name contained 
			 */
			List<String> result = simpleBean.getFileByName(filename);			
			log.info("Found:" + result);
			/*
			 * Release the object			
			 */
			poolTargetSourceFileUtil.releaseTarget(simpleBean);
			
			return result;
		} catch (Exception e) {
			log.error("file", e);
			return null;
		}		
	}

}
