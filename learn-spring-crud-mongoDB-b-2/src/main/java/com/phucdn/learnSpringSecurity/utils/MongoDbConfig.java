package com.phucdn.learnSpringSecurity.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * This config  auto remove "_class" in document's MongoDB
 * @author ASUS
 *
 */

@Configuration
public class MongoDbConfig {
	
	@Autowired
	private MongoDatabaseFactory mongDbFactory;

	@Autowired
	private MongoMappingContext mongoMappingContext;
	
	@Bean
	public MappingMongoConverter mappingMongoConvert() {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongDbFactory);
		MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		
		return converter;
	}
}
