package com.ideal.adp.whitelist.detail

import com.ideal.adp.whitelist.Field
import com.ideal.adp.whitelist.Whitelist._
import com.ideal.adp.whitelist.account.AccountType

/**
 * Created by jason on 2017-03-09.
 */
class Diditaxi extends LogicGenerable{
  override def load(): Unit = {
    terminalWhitelist("1156247630", AccountType.MAC, Field.Url, "conf.diditaxi.com.cn", gen feature("mac"))
  }
}