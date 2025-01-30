package se.inera.intyg.fmbaiservice;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vectorstore.azure.AzureVectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

  private final ChatClient chatClient;

  public ChatController(ChatClient.Builder builder, AzureVectorStore vectorStore) {
    this.chatClient = builder
        //.defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
        .build();
  }

  @GetMapping
  public String chat() {
    return chatClient.prompt()
        .system(SystemPromt.PROMT_RETURN_DATA + FMBData.J20_Akut_Bronkit)
        .user(CertificateData.J20_Akut_Bronkit)
        .call()
        .content();
  }
}