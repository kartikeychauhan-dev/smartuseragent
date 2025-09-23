package com.abnamro.smartuserassignai.service;

import java.util.HashMap;

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



	@Override public String getUserGroupAssignedByAi(String shortdesc, String desc) {
//		String prompt = "Which only one team looks suitable for Desc This "+desc +  " and short description"+ short_desc+ " with confidence of "+confidence+ "% of pridicting "+ Arrays.toString(teams.toArray()) + " if not confident return Service Support team and return only team name one word";

		var values = new HashMap<String, Object>();
		values.put("desc", desc);
		values.put("shortdesc", shortdesc);
		values.put("teamDesc", teamDescription);
		values.put("confidence", confidence);
		values.put("defaultTeamName", defaultTeam);
		var promptTemplate = PromptTemplate.from(prompt).apply(values).text();
		UserMessage userMessage = UserMessage.from(promptTemplate);
		String result= chatModel.chat(userMessage).aiMessage().text();

		return result;
	}
}
