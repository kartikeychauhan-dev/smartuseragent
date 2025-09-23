package com.abnamro.smartuserassignai.config;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public abstract class ModelProperties {
	@Value("${smartGroupAssignAgent.aimodel.baseUrl}")
	public String apiUrl;
	@Value("${smartGroupAssignAgent.aimodel.chat.model}")
	public String modelName;
	@Value("${smartGroupAssignAgent.aimodel.temperature}")
	public double temperature;
	@Value("${smartGroupAssignAgent.aimodel.apiKey}")
	public String apiKey;
	@Value("${smartGroupAssignAgent.aimodel.timeout.inMins}")
	long timeout;


	public abstract ChatModel getModel();
}
