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

@Named
@Singleton
public class ApplicationController extends Controller {
 
	public Result index() {
		return ok(index.render());
	}
	public Result services() {
		String temp = " ";
		return ok(services.render(temp));
	}
	public Result aboutUs() {
		return ok(aboutUs.render());
	}
	public Result accountSummary() {
		return ok(accountSummary.render());
	}
	public Result addWeb() {
		return ok(addWeb.render());
	}
	public Result catalog() {
		return ok(catalog.render());
	}
	public Result contactUs() {
		return ok(contactUs.render());
	}
	public Result deleteUser() {
		return ok(deleteUser.render());
	}
	public Result logIn() {
		return ok(logIn.render());
	}
	public Result searchServiceLog() {
		return ok(searchServiceLog.render());
	}
	public Result serviceLog() {
		return ok(serviceLog.render());
	}
	public Result servicesclass() {
		return ok(servicesclass.render());
	}
	public Result signUp() {
		return ok(signUp.render());
	}
	public Result updateUser() {
		return ok(updateUser.render());
	}
}