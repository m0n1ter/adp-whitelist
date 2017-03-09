package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-08.
 */
class Bankcomm extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("1074419789", AccountType.MDN, Field.Url, "creditcard.bankcomm.com", gen feature("mobile"))
  }
}