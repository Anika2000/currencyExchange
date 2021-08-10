package controllers

import play.api.mvc.{AnyContent, BaseController, ControllerComponents, Request}
import play.api.libs.json._

import scala.concurrent.Future
import scala.concurrent.duration._
import javax.inject.{Inject, Singleton}
import play.api.http.HttpEntity
import akka.actor.ActorSystem
import akka.actor.Status.Success
import akka.stream.scaladsl._
import akka.util.ByteString
import models.{Rates, RatesOne}

import scala.concurrent.ExecutionContext
import scala.concurrent.ExecutionContext.Implicits.global
import play.api.libs.ws._

import scala.util.Try

@Singleton
class CurrencyExchange @Inject()( ec: ExecutionContext,  ws: WSClient, val controllerComponents: ControllerComponents) extends BaseController{

  def currencyExchangeOne() = Action { implicit request: Request[AnyContent] =>
    val inputValue = request.body.asFormUrlEncoded
    inputValue.map { args =>
      val currency = args("currency").head.toUpperCase()

      // Note: I tried using the validation method but strangely I get back the whole JSON data instead of just the required part
//
//            implicit val ratesRead = Json.reads[Rates]
//      val futureResult: Future[JsResult[Rates]] = ws.url("http://api.exchangeratesapi.io/v1/latest?access_key=e237bb7d20eb066d0b335353e854dc02").get().map { response =>
//        (response.json \ "rates" \ "RatesOne" ).validate[Rates]
//      }
      //The Rates model contains the case classes for serializing which I implemented for the above 3 lines of code


      val futureResult: Future[Double] = ws.url("http://api.exchangeratesapi.io/v1/latest?access_key=e237bb7d20eb066d0b335353e854dc02").get().map { response =>
        (response.json \ "rates" \ s"$currency").as[Double]
      }

      Thread.sleep(5000)
      val values = futureResult.value.toString

      val pattern =  values.replaceAll("\\D+\\.?\\D+","")
      val len = pattern.length
      if(len > 100){
        Ok(views.html.currencyExchange(0.0, "Invalid Currency"))
      } else {
        val finalResult = pattern.toDouble
        Ok(views.html.currencyExchange(finalResult, currency))
      }
    }.getOrElse(Ok(views.html.currencyExchange( 0.0 , "Invalid Currency")))
  }

  def currency = Action { implicit request =>
    Ok(views.html.currencyExchange( 1.0, "EUR"))
  }


}
