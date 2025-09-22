package com.abnamro.smartuserassignai.Config;

import dev.langchain4j.model.chat.ChatModel;
import org.springframework.beans.factory.annotation.Value;

public abstract class ModelProperties {
	@Value("${smartuseragent.aimodel.base-url}")
	public String apiUrl;
	@Value("${smartuseragent.aimodel.chat.model}")
	public String modelName;
	@Value("${smartuseragent.aimodel.temperature}")
	public double temperature;
	@Value("${smartuseragent.aimodel.apiKey}")
	public String apiKey;
	@Value("${smartuseragent.aimodel.timeout.inMins}")
	long timeout;


	public abstract ChatModel getModel();
}
