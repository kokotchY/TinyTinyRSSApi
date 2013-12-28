package be.kokotchy.api.tinytinyrss;

import be.kokotchy.api.tinytinyrss.response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: canas
 * Date: 12/26/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestBinder {
	public static void main(String[] args) {
		new TestBinder();
	}

	public TestBinder() {
		try {
			ObjectMapper objectMapper = new ObjectMapper();

			LabelsResponse response = objectMapper.readValue("{\"seq\":0,\"status\":0,\"content\":[{\"id\":2,\"caption\":\"Test Label\",\"fg_color\":\"#ff0000\",\"bg_color\":\"\",\"checked\":false}]}", LabelsResponse.class);

			for (LabelsResponseContent labelsResponseContent : response.getContent()) {
				System.out.println("- "+labelsResponseContent.getCaption()+" in "+labelsResponseContent.getFgColor());
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
