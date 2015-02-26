package utils;

import play.libs.Json;
import play.libs.F.Function;
import play.libs.F.Promise;
import play.libs.ws.WS;
import play.libs.ws.WSResponse;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class RESTfulAPICalls {
	public static enum ResponseType {
		SUCCESS, GETERROR, SAVEERROR, DELETEERROR, RESOLVEERROR, TIMEOUT, 
		CONVERSIONERROR, UNKNOWN
	}

	public static JsonNode getAPICall(String apiString) {
		Promise<WSResponse> responsePromise = WS.url(apiString).get();
		
		Promise<JsonNode> jsonPromise = responsePromise.map(
				new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						if (response.getStatus() == 200
								|| response.getStatus() == 201) {
							System.out.printf("good");
							return response.asJson();
						} else { // no response from the server
							return createResponse(ResponseType.GETERROR);
						}
					}
		});

		try {
			return jsonPromise.get(10000L);
		} catch (Exception e) {
			return createResponse(ResponseType.TIMEOUT);
		}

	}

	public static JsonNode postAPI(String apiString, JsonNode jsonData) {
		Promise<WSResponse> responsePromise = WS.url(apiString).post(jsonData);
		
		Promise<JsonNode> bodyPromise = responsePromise.map(
				new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response) {
						if ((response.getStatus() == 201 || response
								.getStatus() == 200)
								&& !response.getBody().contains("not")) {
							return createResponse(ResponseType.SUCCESS);
						} else { // other response status from the server
							return createResponse(ResponseType.SAVEERROR);
						}
					}
		});
		
		try {
			return bodyPromise.get(10000L);
		} catch (Exception e) {
			return createResponse(ResponseType.TIMEOUT);
		}
	}

	public static JsonNode putAPI(String apiString, JsonNode jsonData) {
		Promise<WSResponse> responsePromise = WS.url(apiString).put(jsonData);
		final Promise<JsonNode> bodyPromise = responsePromise.map(
				new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response)
							throws Throwable {
						if ((response.getStatus() == 201 || response
								.getStatus() == 200)
								&& !response.getBody().contains("not")) {
							return createResponse(ResponseType.SUCCESS);
						} else { // other response status from the server
							return createResponse(ResponseType.SAVEERROR);
						}
					}
				});
		
		try {
			return bodyPromise.get(10000L);
		} catch (Exception e) {
			return createResponse(ResponseType.TIMEOUT);
		}
	}
	
	public static JsonNode deleteAPI(String apiString) {
		Promise<WSResponse> responsePromise = WS.url(apiString).delete();
		Promise<JsonNode> bodyPromise = responsePromise.map(
				new Function<WSResponse, JsonNode>() {
					public JsonNode apply(WSResponse response)
							throws Throwable {
						if ((response.getStatus() == 200 || response
								.getStatus() == 201)
								&& !response.getBody().contains("not")) {
							return createResponse(ResponseType.SUCCESS);
						} else { // no response from the server
							return createResponse(ResponseType.DELETEERROR);
						}
					}
				});
		
		try {
			return bodyPromise.get(10000L);
		} catch (Exception e) {
			return createResponse(ResponseType.TIMEOUT);
		}

	}

	public static JsonNode createResponse(ResponseType type) {
		ObjectNode jsonData = Json.newObject();
		
		switch (type) {
			case SUCCESS:
				jsonData.put("success", "Success!");
				break;
			case GETERROR:
				jsonData.put("error", "Cannot get data from server");
				break;
			case SAVEERROR:
				jsonData.put("error", "Cannot be saved. The data must be invalid!");
				break;
			case DELETEERROR:
				jsonData.put("error", "Cannot be deleted on server");
				break;
			case RESOLVEERROR:
				jsonData.put("error", "Cannot be resolved on server");
				break;
			case TIMEOUT:
				jsonData.put("error", "No response/Timeout from server");
				break;
			case CONVERSIONERROR:
				jsonData.put("error", "Conversion error");
				break;
			default:
				jsonData.put("error", "Unknown errors");
				break;
		}
		
		return jsonData;
	}
}