package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import utils.Constants;
import utils.RESTfulAPICalls;

import javax.inject.Named;
import javax.inject.Singleton;

import models.ClimateService;

@Named
@Singleton
public class ClimateServiceController extends Controller {
	
	final static Form<ClimateService> climateServiceForm = Form
			.form(ClimateService.class);
 
	public Result addClimateService() {
		Form<ClimateService> cs = climateServiceForm.bindFromRequest();

		ObjectNode jsonData = Json.newObject();
		try {
			String climateServiceName = cs.field("Name").value();		

			if (climateServiceName != null && !climateServiceName.isEmpty()) {
				jsonData.put("climateServiceName", climateServiceName);
			}
			jsonData.put("purpose", cs.field("Purpose").value());
			jsonData.put("url", cs.field("Url").value());

			// add a new climate service by calling the RESTful API
			String apiString = Constants.RESTful_API_URL + Constants.ADD_CLIMATE_SERVICE;
			JsonNode response = RESTfulAPICalls.postAPI(apiString, jsonData);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirect("addWeb");
	}
	
	public Result getAllClimateServices(){
		return null;
	}
}



