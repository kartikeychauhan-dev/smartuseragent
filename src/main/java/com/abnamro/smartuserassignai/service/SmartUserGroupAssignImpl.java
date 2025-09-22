package com.abnamro.smartuserassignai.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

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
	String confidence;

	List<String> teams = Arrays.asList("BI Team" ,"Data Team" ,"Mendix Team" ,"Backend Team");

	@Value("${smartGroupAssignAgent.prompt}")
	private String prompt;

	@Value("${smartGroupAssignAgent.defaultTeam}")
	private String defaultTeam;

	@Value("${smartGroupAssignAgent.teamDescription}")
	private String teamDescription;



	@Override public String getUserGroupAssignedByAi(String short_desc, String desc) {
//		String prompt = "Which only one team looks suitable for Desc This "+desc +  " and short description"+ short_desc+ " with confidence of "+confidence+ "% of pridicting "+ Arrays.toString(teams.toArray()) + " if not confident return Service Support team and return only team name one word";
		var values = new HashMap<String, String>();
		values.put("Confidence", confidence);
		values.put("Description", desc);
		values.put("ShortDescription", short_desc);
		values.put("DefaultTeam", defaultTeam);
		values.put("TeamDescription", teamDescription);
		String promptemplate = PromptTemplate.from(prompt).apply(values).text();
		UserMessage userMessage = UserMessage.from(promptemplate);
		String result= chatModel.chat(userMessage).aiMessage().text();

		return result;
	}
}
