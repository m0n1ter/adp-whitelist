package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-09.
 */
class Jinjiang extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("-1155054808", AccountType.MDN, Field.Url, "www.jinjiang.com", gen feature("param"))

  }
}
