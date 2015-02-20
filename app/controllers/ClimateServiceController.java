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
			String climateServiceName = cs.field("name").value();		

			if (climateServiceName != null && !climateServiceName.isEmpty()) {
				jsonData.put("name", climateServiceName);
			}
			jsonData.put("creatorId", "007");
			jsonData.put("purpose", cs.field("purpose").value());
			jsonData.put("url", cs.field("url").value());
			jsonData.put("scenario", cs.field("scenario").value());
			jsonData.put("versionNo", cs.field("version").value());
			jsonData.put("rootServiceId", cs.field("rootService").value());
			jsonData.put("createTime", "2015-02-14'T'00:00:01");

			System.out.println("test!!!!!!");
			System.out.println(jsonData);
			// add a new climate service by calling the RESTful API
			//String apiString = Constants.RESTful_API_URL + Constants.ADD_CLIMATE_SERVICE;
			//JsonNode response = RESTfulAPICalls.postAPI(apiString, jsonData);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return redirect("/addWeb");
		//return ok(addWeb.render());
	}
	
	public Result getAllClimateServices(){
		return null;
	}
}



