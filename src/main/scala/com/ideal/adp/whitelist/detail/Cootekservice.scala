package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-08.
 */
class Cootekservice extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("1028700173", AccountType.MDN, Field.Url, "ws2.cootekservice.com", gen feature("other_phone"))

  }
}
