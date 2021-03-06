package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Whitelist._

class Rong360 extends LogicGenerable {
    override def load(): Unit = {
        val url = "rong360.com"
        networkWhitelist("id70", url, gen feature("RONGID"))
        networkWhitelist("id71", url, gen feature("mobile_user_token") urlDecode())
        networkWhitelist("id72", url, gen feature("mobile_user_token") urlDecode() split("\\|", 2, 3))
    }

}
