package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

class Yhd extends LogicGenerable {
    override def load(): Unit = {
        val url = "yhd.com"
        networkWhitelist("id11", url, gen feature("yihaodian_uid"))
        networkWhitelist("id12", url, gen feature("uname") urlDecode())
        networkWhitelist("id13", url, gen feature("global_user_machine_sign-key"))
        networkWhitelist("id14", url, gens feature(Array("global_user_sign", "guid")))
        networkWhitelist("id15", url, gen feature("ac") urlDecode())

        terminalWhitelist("1036919497", AccountType.MDN, Field.Cookie, "tracker.yhd.com", gen feature("ac"))

    }

    // Terminal load ...
}
