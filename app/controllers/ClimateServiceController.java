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
		int cnt = 1;
		List<ClimateService> cSList = new ArrayList<ClimateService>();
		ClimateService cS = new ClimateService();
		cS.setCount(cnt);
		cS.setName("Difference-Plot-of-Two-Time-Averaged-Variables");
		cS.setPurpose("This service calculates the differences between two specified variables and displays the lat-lon maps of the two variables and their differences.");
		cS.setScenario("1");
		cS.setVersionNo("2");
		cS.setRootServiceId(3);
		cS.setRandom(rand.nextInt(5));
		cS.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/diffPlot2Vars.html");
		cS.setStyle();
		cSList.add(cS);
		cnt++;

		ClimateService cS1 = new ClimateService();
		cS1.setCount(cnt);
		cS1.setName("2-D-Variable-Zonal-Mean");
		cS1.setPurpose("This service generates a graph of a 2-dimensional variable's zonal mean with time averaing. Select a data source (model or observation), a variable name, and a time range below.");
		cS1.setScenario("1");
		cS1.setVersionNo("2");
		cS1.setRootServiceId(3);
		cS1.setRandom(rand.nextInt(5));
		cS1.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/twoDimZonalMean.html");
		cS1.setStyle();
		cSList.add(cS1);
		cnt++;

		ClimateService cS2 = new ClimateService();
		cS2.setCount(cnt);
		cS2.setName("2-D-Variable-Map");
		cS2.setPurpose("This service generates a map of a 2-dimensional variable with time averaging and spatial subsetting. Select a data source (model or observation), a variable name, a time range, and a spatial range (lat-lon box) below.");
		cS2.setScenario("1");
		cS2.setVersionNo("2");
		cS2.setRootServiceId(3);
		cS2.setRandom(rand.nextInt(5));
		cS2.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/twoDimMap.html");
		cS2.setStyle();
		cSList.add(cS2);
		cnt++;

		ClimateService cS3 = new ClimateService();
		cS3.setCount(cnt);
		cS3.setName("3-D-Variable-2-D-Slice");
		cS3.setPurpose("This service generates a slice map of a 3-dimensional variable at a selected pressure level. Select a data source, a variable name, a time range, a spatial range, and a pressure level below.");
		cS3.setScenario("1");
		cS3.setVersionNo("2");
		cS3.setRootServiceId(3);
		cS3.setRandom(rand.nextInt(5));
		cS3.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/twoDimSlice3D.html");
		cS3.setStyle();
		cSList.add(cS3);
		cnt++;

		ClimateService cS4 = new ClimateService();
		cS4.setCount(cnt);
		cS4.setName("Scatter-and-Histogram-Plot-of-Two-Variables");
		cS4.setPurpose("This service generates a scatter plot between two specified variables and the histograms of the two variables, and calculates the correlation of the two variables.<br><br>");
		cS4.setScenario("1");
		cS4.setVersionNo("2");
		cS4.setRootServiceId(3);
		cS4.setRandom(rand.nextInt(5));
		cS4.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/scatterPlot2Vars.html");
		cS4.setStyle();
		cSList.add(cS4);
		cnt++;

		ClimateService cS5 = new ClimateService();
		cS5.setCount(cnt);
		cS5.setName("Conditional-Sampling");
		cS5.setPurpose("This service sorts one variable by the values of another variable (environmental condition, e.g. SST) and displays the averaged value of the first variable as a function of the bin value of the second variable.");
		cS5.setScenario("1");
		cS5.setVersionNo("2");
		cS5.setRootServiceId(3);
		cS5.setRandom(rand.nextInt(5));
		cS5.setUrl("http://www.cs.ucl.ac.uk/staff/w.langdon/bloat_csrp-97-29/node2.html");
		cS5.setStyle();
		cSList.add(cS5);
		cnt++;

		ClimateService cS6 = new ClimateService();
		cS6.setCount(cnt);
		cS6.setName("3-D-Variable-Average-Vertical-Profile");
		cS6.setPurpose("This service generates the average of a three-dimensional variable over a specified region and time and display the average as a function of pressure level as an X-Y plot.");
		cS6.setScenario("1");
		cS6.setVersionNo("2");
		cS6.setRootServiceId(3);
		cS6.setRandom(rand.nextInt(5));
		cS6.setUrl("http://einstein.sv.cmu.edu:9003/cmac/web/threeDimVarVertical.html");
		cS6.setStyle();
		cSList.add(cS6);

		System.out.println("Test");
		return ok(views.html.services.render(cSList));

		//return null;
	}
}



