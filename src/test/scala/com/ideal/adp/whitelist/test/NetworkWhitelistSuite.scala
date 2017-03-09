package com.ideal.adp.whitelist.test

import com.ideal.adp.whitelist.account.{AccountResolver, AccountType}
import com.ideal.adp.whitelist.account.AccountType._
import com.ideal.adp.whitelist.tool.{UriParser, Utilities}
import org.scalatest.{BeforeAndAfter, FunSuite}

import scala.collection.mutable
import com.ideal.adp.whitelist.LogicDefine._
import com.ideal.adp.whitelist.{BaseLibrary, Whitelist}

class NetworkWhitelistSuite extends FunSuite with BeforeAndAfter {

    var url: String = _
    var rawCookie: String = _
    var cache: Option[mutable.Map[String, mutable.Map[String, mutable.Set[(Logic, AccountType)]]]] = _
    private def parserCookie(cookie: String) = {
        val res = mutable.Map[String, String]()
        for(x <- cookie.split(";"); parts = x.split("=", 2); if(parts.length == 2)) {
            res += (parts(0).trim -> parts(1))
        }
        res
    }
    private def parseQuery(query: String) = Utilities.string2Map(query, "&", "=")

    before {
        url = "item.jd.com/crrvr?client=android&pin=18999999999&zz=0A.00.00.00.00.00"
        rawCookie = "client=android; =a%7c%e6%9f%a5%e6%9f%a5%7c%e4%bd%a0%e5%a5%bd; pin=18999999999"
        new BaseLibrary(AccountType.NETWORK).load()
        // cache = Whitelist.cache.get(Field.Cookie)
    }

    test("test network-whitelist") {
        val r = new AccountResolver(Whitelist.cache).resolve(url, Some(rawCookie), parserCookie, UriParser.getQuery(Some(url)), parseQuery)
        r match {
            case None => None
            case (Some(track)) => println(track)
        }
    }

/*    test("test terminal-whitelist") {
        val r =
    }*/

}