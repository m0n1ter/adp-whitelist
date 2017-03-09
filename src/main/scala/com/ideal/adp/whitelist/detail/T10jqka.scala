package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-08.
 */
class T10jqka extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("1093952276", AccountType.MDN, Field.Url, "eq.10jqka.com.cn", gen feature("userid"))

  }
}
