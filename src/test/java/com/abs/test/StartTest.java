package com.abs.test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.abs.service.TestService;

/**
 * @ClassName: Test
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2018年3月22日 下午1:49:22
 */
public class StartTest {
    public static void main(String[] args)  throws Exception{
//    	代码生成
    	generateCode();
	}
    
    public static void generateCode() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException{
    	List<String> warnings = new ArrayList<String>();
        boolean overwrite = true;
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(new ClassPathResource("generatorConfig.xml").getInputStream());
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
    }
    
    @Test
    public void beanTest() {
    	ClassPathXmlApplicationContext cxa = new ClassPathXmlApplicationContext("classpath*:applicationcontext.xml");
		TestService services =  (TestService)cxa.getBean("testService");
		System.out.println(services.getName());
    }
}
