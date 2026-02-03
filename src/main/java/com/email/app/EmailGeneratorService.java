package com.email.app;

import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class EmailGeneratorService {
	public String generateEmailReply(EmailRequest emailRequest) {
		// Build the prompt
		String prompt = builtPrompt(emailRequest);
		// Craft request
		
		Map<String,  Object> requestBody = Map.of(
				"contents",
				new Object[] {
						Map.of("parts", new Object[] {
							Map.of("text", prompt)
						})
				}
				);
		// Do request and get Response
		// return response
		return prompt;
	}

	private String builtPrompt(EmailRequest emailRequest) {

		StringBuilder prompt = new StringBuilder();

		prompt.append(
				"generate a profession email reply  for the folloing  email content. Please don't generate a subject line");
		
		if(emailRequest.getTone() != null && !emailRequest.getTone().isEmpty())
		{
			prompt.append("Use a ").append(emailRequest.getTone()).append(" tone.");
		}
		
		prompt.append("\n Original email: \n").append(emailRequest.getEmailContent());
		return prompt.toString();
	}

}
