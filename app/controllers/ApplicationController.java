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
		return ok(services.render());
	}
}