package models
import play.api.libs.functional.syntax.{toFunctionalBuilderOps, unlift}
import play.api.libs.json._
import play.api.libs.json.Json._
import play.api.mvc.Filters
import play.api.libs.json.Reads
import scala.language.postfixOps

case class RatesOne(AED:Float, AFN:Float, ALL:Float, AMD:Float, ANG:Float, AOA:Float, ARS:Float, AUD:Float, AWG:Float, AZN:Float)
object RatesOne{
  implicit val ratesOneFormat = Json.format[RatesOne]
}

case class RatesTwo(BAM:Float, BBD:Float, BDT:Float, BGN:Float, BHD:Float, BIF:Float, BMD:Float, BND:Float, BOB:Float, BRL:Float)
object RatesTwo {
  implicit val ratesTwoFormat = Json.format[RatesTwo]
}

case class RatesThree(BSD:Float, BTC:Float, BTN:Float, BWP:Float, BYN:Float, BYR:Float, BZD:Float, CAD:Float, CDF:Float, CHF:Float)
object RatesThree {
  implicit val ratesThreeFormat = Json.format[RatesThree]
}

case class RatesFour(CLF:Float, CLP:Float, CNY:Float, COP:Float, CRC:Float, CUC:Float, CUP:Float, CVE:Float, CZK:Float, DJF:Float)
object RatesFour {
  implicit val ratesFourFormat = Json.format[RatesFour]
}

case class RatesFive(DKK:Float, DOP:Float, DZD:Float, EGP:Float, ERN:Float, ETB:Float, EUR:Float, FJD:Float, FKP:Float, GBP:Float)
object RatesFive {
  implicit val ratesFiveFormat = Json.format[RatesFive]
}

case class RateSix(GEL:Float, GGP:Float, GHS:Float, GIP:Float, GMD:Float, GNF:Float, GTQ:Float, GYD:Float, HKD:Float, HNL:Float)
object RateSix {
  implicit val rateSixFormat = Json.format[RateSix]
}

case class RateSeven(HRK:Float, HTG:Float, HUF:Float, IDR:Float, ILS:Float, IMP:Float, INR:Float, IQD:Float, IRR:Float, ISK:Float, JEP:Float)
object RateSeven {
  implicit val rateSevenFormat = Json.format[RateSeven]
}

case class RateEight(JMD:Float, JOD:Float, JPY:Float, KES:Float, KGS:Float, KHR:Float, KMF:Float, KPW:Float, KRW:Float, KWD:Float, KYD:Float, KZT:Float, LAK:Float, LBP:Float, LKR:Float)
object RateEight {
  implicit val rateEightFormat = Json.format[RateEight]
}

case class RateNine(LRD:Float, LSL:Float, LTL:Float, LVL:Float, LYD:Float, MAD:Float, MDL:Float, MGA:Float, MKD:Float, MMK:Float, MNT:Float, MOP:Float, MRO:Float, MUR:Float)
object RateNine {
  implicit val rateNineFormat = Json.format[RateNine]
}

case class RateTen(MVR:Float, MWK:Float, MXN:Float, MYR:Float, MZN:Float, NAD:Float, NGN:Float, NIO:Float, NOK:Float, NPR:Float, NZD:Float, OMR:Float, PAB:Float, PEN:Float, PGK:Float, PHP:Float, PKR:Float)
object RateTen {
  implicit val rateTenFormat = Json.format[RateTen]
}

case class RateEleven(PLN:Float,PYG:Float, QAR:Float, RON:Float, RSD:Float, RUB:Float, RWF:Float, SAR:Float, SBD:Float, SCR:Float, SDG:Float, SEK:Float, SGD:Float, SHP:Float, SLL:Float)
object RateEleven {
  implicit val rateElevenFormat = Json.format[RateEleven]
}

case class RateTwelve(SOS:Float, SRD:Float, STD:Float, SVC:Float, SYP:Float, SZL:Float, THB:Float, TJS:Float, TMT:Float, TND:Float, TOP:Float, TRY:Float, TTD:Float, TWD:Float, TZS:Float)
object RateTwelve {
  implicit val rateTwelveFormat = Json.format[RateTwelve]
}

case class RateThirteen(UAH:Float, UGX:Float, USD:Float, UYU:Float, UZS:Float, VEF:Float, VND:Float, VUV:Float, WST:Float, XAF:Float, XAG:Float, XAU:Float, XCD:Float, XDR:Float, XOF:Float, XPF:Float, YER:Float, ZAR:Float, ZMK:Float, ZMW:Float, ZWL:Float)
object RateThirteen {
  implicit val rateThirteenFormat = Json.format[RateThirteen]
}

case class Rates(ratesOne: RatesOne, ratesTwo: RatesTwo, ratesThree: RatesThree, ratesFour: RatesFour,
                 ratesFive: RatesFive, rateSix: RateSix, rateSeven: RateSeven, rateEight: RateEight,
                 rateNine: RateNine, rateTen: RateTen, rateEleven: RateEleven, rateTwelve: RateTwelve,
                 rateThirteen: RateThirteen)
object Rates {

  implicit val ratesRead = (
    JsPath.read[RatesOne] and
      JsPath.read[RatesTwo] and
      JsPath.read[RatesThree] and
      JsPath.read[RatesFour] and
      JsPath.read[RatesFive] and
      JsPath.read[RateSix] and
      JsPath.read[RateSeven] and
      JsPath.read[RateEight] and
      JsPath.read[RateNine] and
      JsPath.read[RateTen] and
      JsPath.read[RateEleven] and
      JsPath.read[RateTwelve] and
      JsPath.read[RateThirteen]
  )(Rates.apply _)

  implicit val ratesWrites = (
    JsPath.write[RatesOne] and
    JsPath.write[RatesTwo] and
    JsPath.write[RatesThree] and
    JsPath.write[RatesFour] and
    JsPath.write[RatesFive] and
    JsPath.write[RateSix] and
    JsPath.write[RateSeven] and
    JsPath.write[RateEight] and
    JsPath.write[RateNine] and
    JsPath.write[RateTen] and
    JsPath.write[RateEleven] and
    JsPath.write[RateTwelve] and
    JsPath.write[RateThirteen]
  )(unlift(Rates.unapply))
}
