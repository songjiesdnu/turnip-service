/**
 * 
 */
package com.robot.turnip.config;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * 配置文件解密
 * @author songjie
 *
 */
public class EncryptablePropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer {
	private Logger logger = LoggerFactory.getLogger(EncryptablePropertyPlaceholderConfigurer.class);

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
        throws BeansException {
    		Iterator<Entry<Object, Object>> it = props.entrySet().iterator();
    		while(it.hasNext()){
    			Entry<Object, Object> e = (Entry<Object, Object>)it.next();
    			String key = e.getKey().toString();
    			String value = e.getValue().toString();
    			String decodedValue = new String(Base64.decodeBase64(value));
    			logger.debug("key:{};value:{};decodedValue:{}", key, value, decodedValue);
    			props.setProperty(key, decodedValue);
    		}
    		super.processProperties(beanFactory, props);
        }
    }