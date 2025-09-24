package com.abnamro.smartuserassignai.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.validation.constraints.NotNull;

import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.input.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service class SmartUserGroupAssignImpl implements SmartUserGroupAssign {

	private final ChatModel chatModel;

	public SmartUserGroupAssignImpl(ChatModel chatModel) {
		this.chatModel = chatModel;
	}

	@Value("${smartGroupAssignAgent.confidence}")
	private String confidence;

	@Value("${smartGroupAssignAgent.prompt}")
	private String prompt;

	@Value("${smartGroupAssignAgent.defaultTeamName}")
	@NotNull
	private String defaultTeam;

	@Value("${smartGroupAssignAgent.teamDescription}")
	private String teamDescription;

	List<String> teams = Arrays.asList("Backend Team", "Data Team", "BI Team", "Mendix Team", teamDescription);

	@Override public String getUserGroupAssignedByAi(String shortdesc, String desc) {
		var values = new HashMap<String, Object>();
		values.put("Description", desc);
		values.put("ShortDescription", shortdesc);
		values.put("TeamDescription", teamDescription);
		values.put("Confidence", confidence);
		values.put("DefaultTeamName", defaultTeam);
		var promptTemplate = PromptTemplate.from(prompt).apply(values).text();
		UserMessage userMessage = UserMessage.from(promptTemplate);
		String result= chatModel.chat(userMessage).aiMessage().text().trim();
		 if(result.isEmpty() || !teams.contains(result)){
			return defaultTeam;
		}
		return result;
	}
}
