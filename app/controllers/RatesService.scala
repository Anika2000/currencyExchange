package controllers

import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}
import models.Rates
import play.api.libs.json.{JsResult, Json}
import play.api.libs.ws._

import javax.inject.Inject
import scala.concurrent.{ExecutionContext, Future}

class RatesService @Inject() (ec: ExecutionContext, ws: WSClient, val controllerComponents: ControllerComponents) extends BaseController {

}
