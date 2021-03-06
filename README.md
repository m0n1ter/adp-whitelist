##开发环境  
开发环境是使用Intellij，操作系统：Windows，Linux都可以  
Intellij需要安装scala插件，并配置scala sdk  
代码编码格式：UTF-8，CRLF  

###准备工作  
你需要从git仓库中下载本代码，并确保使用maven能正确编译本项目代码  

###如何创建白名单  
1.在src/main/scala的com.ideal.adp.whitelist.detail包中，含有多个文件，每个文件以host命名，你可以自己添加相应的host文件  
2.以Baidu.scala为例，每个白名单文件都有一个类 extends LogicGenerable，并override load()方法，你的白名单规则可以写在这个方法中  
  一般的，程序内置了一些通用方法以供调用，当然你也可以自己编写方法进行白名单规则的书写  

####如何编写一条终端白名单  
只要在上述提及的load()方法中，添加以下这行代码，就代表编辑了一条白名单规则  
terminalWhitelist(ruleId, accountType, field, url, logic)  
ruleId: String类型，表示这条白名单的规则ID  
accountType: AccountType类型，可选值：IMEI, IMSI, MDN, IDFA, ANDROIDID, MAC  
field: Field类型，可选值：Url, Cookie，代表账号值取自于哪个字段  
url：表示这条白名单的url  
logic：表征这条白名单的取数逻辑，由gen进行链式推导，gen是内置的logic生成器对象，我们用它就可以编写自己的取数logic chain  

下面，介绍一些logic的具体写法  
1.使用内置规则书写logic  
gen feature("imei") filter("000000000000000") regex()  
假设原始数据中的cookie是这样的：cc=apple; imei=8600000023344213，那么使用上述规则，就可以取到账号值8600000023344213  
上述规则中的feature()、filter()和regex()方法都是程序内置的方法，更多内置方法，请查阅com.ideal.adp.whitelist.LogicDefine中的第30行开始的代码  

2.使用自定义函数书写logic  
（1）自定义函数的要求：返回值必须是Option[?]类型  
（2）如何将自定义函数添加到原有的logic chain中？  
     答：gen feature("deviceID") add(len(1415)) regex()  
         def len1415(str: String) = if (str.length == 14 || str.length == 15) Some(str) else None  


###如何测试白名单  
1.在src/test的NetworkWhitelistSuite.scala代码中，before代码块的第一、二行是用来创造原始数据；  
  第三行代码块是用来加载白名单规则的  
2.执行NetworkWhitelistSuite类就可以进行测试了，在控制台能够看到相应的测试结果  

###备注  
当前项目仅依赖scala-library和json4s类库，请慎重引用apache类库（包括hadoop类库），以避免与上层spark代码发生冲突  