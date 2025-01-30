package se.inera.intyg.fmbaiservice;

import java.util.List;
import java.util.Map;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.vectorstore.azure.AzureVectorStore;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import se.inera.intyg.fmbaiservice.dto.ResponseDTO;

@RestController
public class ChatController {

  private final ChatClient chatClient;

  public ChatController(ChatClient.Builder builder, AzureVectorStore vectorStore) {
    this.chatClient = builder
        //.defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
        .build();
  }

  @PostMapping
  public List<ResponseDTO> chat(@RequestBody Map<String, String> input) {
    return chatClient.prompt()
        .system(SystemPromt.PROMT_RETURN_DATA + FMBData.J20_Akut_Bronkit)
        .user(
            input.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .reduce((a, b) -> a + "\n" + b)
                .orElseThrow()
        )
        .call()
        .entity(new ParameterizedTypeReference<>() {
        });
  }
}