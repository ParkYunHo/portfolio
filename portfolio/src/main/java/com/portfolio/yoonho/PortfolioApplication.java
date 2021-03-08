package com.portfolio.yoonho;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/*
 *  @SpringBootApplication 
 *   - 기존 Spring에서 사용하는 @Configuration, @EnableAutoConfiguration, @EnableWebMvc, @ComponentScan 포함
 *   - 추가적인 설정파일 없이도 실행가능한 어플리케이션 구성
 */

@SpringBootApplication
@MapperScan(value = "com.portfolio.yoonho.dao")
public class PortfolioApplication {
	public static void main(String[] args) {
		SpringApplication.run(PortfolioApplication.class, args);
	}
	
	@Bean
    public SqlSessionFactory sqlSessionFactory(DataSource ds) throws Exception{
        SqlSessionFactoryBean sf = new SqlSessionFactoryBean();
        sf.setDataSource(ds);
        sf.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mappers/*.xml"));
        
        return sf.getObject();
    }
}

