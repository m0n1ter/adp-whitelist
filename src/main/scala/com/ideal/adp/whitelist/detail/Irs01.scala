package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-08.
 */
class Irs01 extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("1088256414", AccountType.ANDROIDID, Field.Url, "irs01.com", gen feature("androidid"))
    terminalWhitelist("1116513149", AccountType.IMEI, Field.Url, "irs01.com", gen feature("cupid_id") )
    terminalWhitelist("1141927647", AccountType.IMEI, Field.Url, "irs01.com", gen feature("aqyid") split("_", 0))
  }
}