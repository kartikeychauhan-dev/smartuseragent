package com.abnamro.smartuserassignai.serviceimpl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.abnamro.smartuserassignai.service.SmartUserAssign;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.input.PromptTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmartUserAssignImpl implements SmartUserAssign {

	private final ChatModel chatModel;
	String confidence = "100";
	 List<String> teams = Arrays.asList("BI Team" ,"Data Team" ,"Mendix Team" ,"Backend Team");
	 @Value("${smartuseragent.prompt}")
	 private String prompt;

	public SmartUserAssignImpl(ChatModel chatModel) {
		this.chatModel = chatModel;
	}

	@Override public String getUserAssignedFormAi(String short_desc, String desc) {
		String prompt = "Which only one team looks suitable for Desc This "+desc +  " and short description"+ short_desc+ " with confidence of "+confidence+ "% of pridicting "+ Arrays.toString(teams.toArray()) + " if not confident return Service Support team and return only team name one word";
		var values = new HashMap<String, String>();
		values.put("Confidence", confidence);
		values.put("Team", prompt);
//		PromptTemplate promptTemplate = PromptTemplate.from();
		UserMessage userMessage = UserMessage.from(prompt);
		String result= chatModel.chat(userMessage).aiMessage().text();

		return result;
	}
}
