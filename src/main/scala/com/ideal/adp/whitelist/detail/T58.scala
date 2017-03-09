package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-08.
 */
class T58 extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("-1038987675", AccountType.MDN, Field.Url, "verifycode.58.com", gen feature("tel_number"))

  }
}
