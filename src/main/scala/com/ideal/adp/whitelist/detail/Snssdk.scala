package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-08.
 */
class Snssdk extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("1023357254", AccountType.IDFA, Field.Url, "is.snssdk.com", gen feature("idfa"))
  }
}