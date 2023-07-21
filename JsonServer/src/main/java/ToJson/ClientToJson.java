package ToJson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Model.Client;

public class ClientToJson {
	
	public String toJson(Client client) throws JsonProcessingException  {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(client);
    }
}
