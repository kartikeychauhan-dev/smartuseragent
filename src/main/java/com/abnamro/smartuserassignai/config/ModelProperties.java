package com.abnamro.smartuserassignai.Config;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.beans.factory.annotation.Value;

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
