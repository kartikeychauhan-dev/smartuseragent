package com.abnamro.smartuserassignai.config;

import java.time.Duration;
import java.util.Map;

import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.ollama.OllamaChatModel;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OllamaConfiguration extends ModelProperties {
	@Bean
	public ChatModel getModel() {
		return OllamaChatModel
				.builder()
				.modelName(modelName)
				.customHeaders(Map.of("Authorization", "Bearer " + apiKey))
				.baseUrl(apiUrl)
				.temperature(temperature)
				.timeout(Duration.ofMinutes(timeout))
				.build();
	}

}
