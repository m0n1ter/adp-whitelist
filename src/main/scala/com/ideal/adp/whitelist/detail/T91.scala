package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-09.
 */
class T91 extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("-114359168", AccountType.IDFA, Field.Url, "tq.91.com", gen feature("idfa"))
  }
}
