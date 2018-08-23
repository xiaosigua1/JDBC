JDBC:(Java  DataBase  Connectivity,java数据库连接)
   01.使用java代码来连接数据库的技术
   02.是由一组用java语言编写的类和接口组成 （JDBC API） 来访问我们的数据库！
   03.不同的数据库厂商提供了不同的数据库驱动
 
JDBC和ODBC
   
JDBC：
   01.完全是java语言编写
   02.性能高，跨平台
   03.访问不同的数据库需要下载不同的驱动包
   
ODBC：
   01.性能低，只能在windows系统下运行
   02.不需要下载不同的驱动包
 
   
常用的JDBC API:

1.Driver  获取数据库的驱动包
     com.mysql.jdbc.Driver              mysql驱动
     oracle.jdbc.driver.OracleDriver    oracle驱动
     
2.Connection 接口  与我们指定的数据库建立连接
     DriverManager.getConnection(url,userName,password)返回连接
  
  url:连接数据库的地址
       jdbc:mysql://localhost:3306/easybuy
       jdbc:oracle:thin:@localhost:5512:easybuy
  userName:用户名
  password:密码   
   
 连接数据库的四要素：
   01.驱动包
   02.连接数据库的地址
   03.用户名
   04.密码   
   
   
  jdbc:mysql://localhost:  3306/   easybuy  ? useUnicode=true&characterEncoding=utf8
    协议     子协议      主机名称     端口号    数据库名称   ?  参数名=参数值
   
3.Statement 执行我们书写的sql语句（交给数据库去执行）
  PreparedStatement  
       01.sql预编译功能
       02.防止sql注入

	01.select * from  student;  //查询student表中的所有数据   
	没有参数
	
	
	02.select * from  student  where  studentName="小黑"  //  查询studentName="小黑"的学生数据 
	有参数
	   
	   小黑
	   01.使用户输入的
	   02.小黑这个值 固定吗？ 
	   03.这个值还不能写死！！！
	   
	   
	select  * from  user  where  userName=xxx and password=xxx
	 
4.ResultSet 返回的结果集
     
     user表中的字段
        1         2                   3                  4
     id（int）   userName（varchar） password（varchar）   birthday（datetime）
 
  问题？
   01.字段的类型一样吗？
   02.怎么辨别字段类型？
   
   获取结果集中 每一个指定的字段！
   
    01. rs.getInt(int  columnIndex)    根据字段下标获取  
          rs.getInt(1)  
           字段下标在我们创建表的时候 ，就已经生成了！
    02. rs.getInt(String columnName)       
          rs.getInt("id")  
     
	   
JDBC连接数据库的步骤
 01.加载数据库驱动                      Class.forName(驱动类全名称)       
 02.建立连接 需要四要素              Connection con=DriverManager.getConnection(url,userName,password)
 03.书写sql并执行                       PreparedStatement 或者Statement
 04.处理结果集                             ResultSet(查询)  int(增删改)
 05.释放资源                                先开的后关



JdbcDemo存在的问题：
  01.我们增删改代码 除了 sql语句之外，其他代码重复（JDBC API,释放资源）
  02.sql语句所有的参数，应该在方法的参数列表中，因为这些参数都是前端用户传递过来的
     如果说用户传递了10个参数，都属于一个表，那么我们应该使用JavaBean！
  03.sql语句的执行是使用的Statement,不安全，性能低
             可以sql注入   
             没有对sql语句进行预编译
     我们loginUser()中的password 写成  aaa'or'1'='1 也可以登录！
     
     
     
 在com.xdf.pre包中的   JdbcDemo中优化代码
 
  优化步骤
  一：优化JDBC API
	  01.将5个方法中的JDBC API提取成全局变量
	  02.把所有使用到Statement的位置替换成PreparedStatement(防止sql注入)
	      Statement和PreparedStatement区别
	      01.Statement不能预编译sql语句，而PreparedStatement可以
	      02.Statement可以sql注入，PreparedStatement不允许
	      03.Statement在sql语句中的参数设置只能通过变量的拼接实现
	         PreparedStatement也可以使用占位符的方式实现（必须使用）
	      04.Statement在通过connecetion.createStatement()不需要sql作为参数
	         Statement在执行sql语句的时候，需要sql作为参数！
	        PreparedStatement在通过connecetion.prepareStatement(sql)需要sql作为参数
	        PreparedStatement在执行sql语句的时候，不需要sql作为参数！
	  03.把sql语句中所有使用变量的地方换成占位符 （?）
	  04.给占位符赋值
  
 问题？
 01.我们整个类的操作都是基于user表的 ，如果右来了一个Animal类？
        那么我们是不是也得右对应的增删改查一些列方法
 02.而且我们的加载驱动，以及获取数据库连接和释放资源的代码 还没有优化？       
        
 二：优化   数据库连接 
   数据库连接的四要素
    Driver(不同的数据库厂商有不同的驱动包)   Url   userName   password
    
 疑问？
   如果我们把   数据库连接的四要素 写在了我们代码中？
     01.代码和连接耦合
     02.现在我们使用的是mysql数据库，后续更换数据库成oracle?
              得去我们的项目中找到数据库连接的四要素 存在的位置 之后更改！
              
              
01.把我们需要的数据库四要素 放进 properties文件中
02.有必要每个用户都有一个专门的对象来保存properties文件中的内容
	    所有的用户共享这个一个properties文件对象！
	    使用单例！
03.创建读取  properties文件内容的单例类
04.去com.xdf.jdbcpro.JdbcDemo修改代码   
    之前所有使用固定格式的driver,url,userName,password
   全部通过ConfigManager类中的getValue(Stirng  key)来获取！
  
  
  问题：
   01.使用反射机制加载驱动包以及获取数据库连接的代码还是重复
   02.释放资源代码还是重复  
   03.现在只有一个user业务，如果说多了其他的业务，比如说我们的账单，商品.....
            多个业务类中的带重复！
      
    
 三：优化   
            
    把所有重复的代码提取到一个公共的类中，让我们的业务类继承这个公共的类！！！
    
01.把所有类中公共的属性提取到com.xdf.util.BaseDao中！
02.把反射机制加载驱动包以及获取数据库连接的代码提取到com.xdf.util.BaseDao中！

 遗留的问题：
   01.getConncetion还可以加if判断
   02.关闭资源没有优化
   03.所有的增删改都是一个方法executeUpdate()
   04.所有的查询都是一个方法executeQuery()
   05.如果参数多 而且属于一张表，是用javaBean

















	   
   
   
   
   