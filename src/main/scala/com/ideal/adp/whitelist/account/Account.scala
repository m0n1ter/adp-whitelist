package com.ideal.adp.whitelist.account

import AccountType.AccountType

object AccountType extends Enumeration with Serializable {
    type AccountType = Value
    val NETWORK,
        IMEI, IMSI, MDN, ANDROIDID, IDFA, MAC, EMAIL,
        AUDIT,
        RETAIN = Value
}

abstract class Account extends Serializable {
    def acId: String // 账号种类
    def v: String // 账号值
    def acType: AccountType // 账号类型

    override def equals(obj: scala.Any): Boolean = obj match {
        case that: Account => this.acType == that.acType && this.v == that.v
        case _ => false
    }

    override def toString: String = acId + ":" + acType.toString + ":" + v

    // reduceByKey depends on it
    override def hashCode(): Int = toString.hashCode

    def ==(that: Account):Boolean = {
        if(that == None) false
        else if(this.acId == that.acId && this.acType.toString == that.acType.toString && this.v == that.v) true
        else false
    }

}

object Account {
    class TerminalAccount(accountId: String, accountType: AccountType, value: String) extends Account {
        val acId = accountId
        val v = value
        val acType = accountType
    }

    class NetworkAccount(accountId: String, value: String) extends Account {
        val acId = accountId
        val v = value
        val acType = AccountType.NETWORK
    }

    def account(accountId: String, accountType: AccountType, value: String) = accountType match {
        case AccountType.NETWORK => new NetworkAccount(accountId, value)
        case AccountType.AUDIT | AccountType.RETAIN => throw new IllegalArgumentException("Not supported AccountType:" + accountType)
        case _ => new TerminalAccount(accountId, accountType, value)
    }

    def account(accountId: String, value: String) = new NetworkAccount(accountId, value)

/*    def main(args: Array[String]): Unit = {
        val c = Account.account("id999", AccountType.NETWORK, "111111")
        val d = Account.account("id999", "111111")
        println(c == d)
    }*/

}
