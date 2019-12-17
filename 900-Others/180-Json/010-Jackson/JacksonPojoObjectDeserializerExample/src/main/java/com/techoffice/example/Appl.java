package com.techoffice.example;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import lombok.extern.slf4j.Slf4j;

/**
 * This example show how to use Jackson to convert POJO to JSON String.
 *
 * @author Ben_c
 */
@Slf4j
public class Appl {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Group.class, new JsonDeserializer<CustomGroup>() {
            @Override
            public CustomGroup deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
                final TreeNode treeNode =jsonParser.getCodec().readTree(jsonParser);
                ObjectMapper objectMapper = new ObjectMapper();
                CustomGroup customGroup = objectMapper.readValue(treeNode.toString(), CustomGroup.class);
                return customGroup;
            }
        });
        mapper.registerModule(simpleModule);
        User user = mapper.readValue("{\"name\": \"Testing name\", \"customGroup\": {\"name\": \"Testing Group Name\"}}", User.class);
        log.info(user.getName());
        log.info(user.getCustomGroup().getName());
    }
}
