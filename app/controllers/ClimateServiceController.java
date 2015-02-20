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

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import views.html.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

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

//		try {
//			// add a new climate service by calling the RESTful API
//			String apiString = Constants.RESTful_API_URL + Constants.GET_ALL_CLIMATE_SERVICE;
//			JsonNode response = RESTfulAPICalls.getAPICall(apiString);
//
//			List<String>name = new ArrayList<String>();
//			List<String>purpose = new ArrayList<String>();
//			for (int i = 0; i < response.length() ;  ++i) {
//				 name.add(response.findPath("name").getTextValue());
//				 purpose.add(response.findPath("purpose").getTextValue());
//			}
//
//
//		} catch (IllegalStateException e) {
//			e.printStackTrace();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		Random rand = new Random();

		List<ClimateService> cSList = new ArrayList<ClimateService>();
		ClimateService cS = new ClimateService();
		cS.setName("Difference Plot of Two Time Averaged Variables");
		cS.setPurpose("This service calculates the differences between two specified variables and displays the lat-lon maps of the two variables and their differences.");
		cS.setScenario("1");
		cS.setVersionNo("2");
		cS.setRootServiceId(3);
		cS.setRandom(rand.nextInt(2));
		cS.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/diffPlot2Vars.html");
		cSList.add(cS);

		ClimateService cS1 = new ClimateService();
		cS1.setName("2-D Variable Zonal Mean");
		cS1.setPurpose("This service generates a graph of a 2-dimensional variable's zonal mean with time averaing. Select a data source (model or observation), a variable name, and a time range below.");
		cS1.setScenario("1");
		cS1.setVersionNo("2");
		cS1.setRootServiceId(3);
		cS.setRandom(rand.nextInt(2));
		cS1.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/twoDimZonalMean.html");
		cSList.add(cS1);

		System.out.println("Test");
		return ok(views.html.services.render(cSList));

		//return null;
	}
}



