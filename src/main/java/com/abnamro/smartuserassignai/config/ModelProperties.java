package com.abnamro.smartuserassignai.config;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.beans.factory.annotation.Value;

public abstract class ModelProperties {
	@Value("${smartGroupAssignAgent.aimodel.base-url}")
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
