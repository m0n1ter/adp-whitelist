package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

class Youku extends LogicGenerable {
    override def load(): Unit = {
        val url = "youku.com"
        networkWhitelist("id60", url, gen feature("__ysuid"))
        networkWhitelist("id61", url, gen feature("ykss"))
        networkWhitelist("id62", url, gen feature("u"))

        terminalWhitelist("1028186493", AccountType.IMEI, Field.Url, "a.play.api.3g.youku.com", gen feature("imei"))
        terminalWhitelist("-103971436", AccountType.MDN, Field.Cookie, "hd.api.mobile.youku.com", gen feature("k"))
        terminalWhitelist("-1040632284", AccountType.MAC, Field.Url, "das.api.mobile.youku.com", gen feature("mac"))
        terminalWhitelist("-1063407606", AccountType.MAC, Field.Url, "val.atm.youku.com", gen feature("mac"))
    }
}
