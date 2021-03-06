package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

class Dangdang extends LogicGenerable {
    override def load(): Unit = {
        val url = "dangdang.com"
        networkWhitelist("id100", url, gen feature("ddoy"))
        networkWhitelist("id101", url, gen feature("ddoy") urlDecode() stringToMap("&", "=") find("email"))
        networkWhitelist("id103", url, gen feature("ddoy") urlDecode() stringToMap("&", "=") find("uname"))

        terminalWhitelist("1026018160", AccountType.MAC,Field.Url,"mcheckout.dangdang.com", gen feature ("macaddress") )
        terminalWhitelist("1543132582", AccountType.IMEI,Field.Url,"e.dangdang.com", gen feature ("deviceSerialNo") )
	}
}
