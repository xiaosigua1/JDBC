JDBC:(Java  DataBase  Connectivity,java���ݿ�����)
   01.ʹ��java�������������ݿ�ļ���
   02.����һ����java���Ա�д����ͽӿ���� ��JDBC API�� ���������ǵ����ݿ⣡
   03.��ͬ�����ݿ⳧���ṩ�˲�ͬ�����ݿ�����
 
JDBC��ODBC
   
JDBC��
   01.��ȫ��java���Ա�д
   02.���ܸߣ���ƽ̨
   03.���ʲ�ͬ�����ݿ���Ҫ���ز�ͬ��������
   
ODBC��
   01.���ܵͣ�ֻ����windowsϵͳ������
   02.����Ҫ���ز�ͬ��������
 
   
���õ�JDBC API:

1.Driver  ��ȡ���ݿ��������
     com.mysql.jdbc.Driver              mysql����
     oracle.jdbc.driver.OracleDriver    oracle����
     
2.Connection �ӿ�  ������ָ�������ݿ⽨������
     DriverManager.getConnection(url,userName,password)��������
  
  url:�������ݿ�ĵ�ַ
       jdbc:mysql://localhost:3306/easybuy
       jdbc:oracle:thin:@localhost:5512:easybuy
  userName:�û���
  password:����   
   
 �������ݿ����Ҫ�أ�
   01.������
   02.�������ݿ�ĵ�ַ
   03.�û���
   04.����   
   
   
  jdbc:mysql://localhost:  3306/   easybuy  ? useUnicode=true&characterEncoding=utf8
    Э��     ��Э��      ��������     �˿ں�    ���ݿ�����   ?  ������=����ֵ
   
3.Statement ִ��������д��sql��䣨�������ݿ�ȥִ�У�
  PreparedStatement  
       01.sqlԤ���빦��
       02.��ֹsqlע��

	01.select * from  student;  //��ѯstudent���е���������   
	û�в���
	
	
	02.select * from  student  where  studentName="С��"  //  ��ѯstudentName="С��"��ѧ������ 
	�в���
	   
	   С��
	   01.ʹ�û������
	   02.С�����ֵ �̶��� 
	   03.���ֵ������д��������
	   
	   
	select  * from  user  where  userName=xxx and password=xxx
	 
4.ResultSet ���صĽ����
     
     user���е��ֶ�
        1         2                   3                  4
     id��int��   userName��varchar�� password��varchar��   birthday��datetime��
 
  ���⣿
   01.�ֶε�����һ����
   02.��ô����ֶ����ͣ�
   
   ��ȡ������� ÿһ��ָ�����ֶΣ�
   
    01. rs.getInt(int  columnIndex)    �����ֶ��±��ȡ  
          rs.getInt(1)  
           �ֶ��±������Ǵ������ʱ�� �����Ѿ������ˣ�
    02. rs.getInt(String columnName)       
          rs.getInt("id")  
     
	   
JDBC�������ݿ�Ĳ���
 01.�������ݿ�����                      Class.forName(������ȫ����)       
 02.�������� ��Ҫ��Ҫ��              Connection con=DriverManager.getConnection(url,userName,password)
 03.��дsql��ִ��                       PreparedStatement ����Statement
 04.��������                             ResultSet(��ѯ)  int(��ɾ��)
 05.�ͷ���Դ                                �ȿ��ĺ��



JdbcDemo���ڵ����⣺
  01.������ɾ�Ĵ��� ���� sql���֮�⣬���������ظ���JDBC API,�ͷ���Դ��
  02.sql������еĲ�����Ӧ���ڷ����Ĳ����б��У���Ϊ��Щ��������ǰ���û����ݹ�����
     ���˵�û�������10��������������һ������ô����Ӧ��ʹ��JavaBean��
  03.sql����ִ����ʹ�õ�Statement,����ȫ�����ܵ�
             ����sqlע��   
             û�ж�sql������Ԥ����
     ����loginUser()�е�password д��  aaa'or'1'='1 Ҳ���Ե�¼��
     
     
     
 ��com.xdf.pre���е�   JdbcDemo���Ż�����
 
  �Ż�����
  һ���Ż�JDBC API
	  01.��5�������е�JDBC API��ȡ��ȫ�ֱ���
	  02.������ʹ�õ�Statement��λ���滻��PreparedStatement(��ֹsqlע��)
	      Statement��PreparedStatement����
	      01.Statement����Ԥ����sql��䣬��PreparedStatement����
	      02.Statement����sqlע�룬PreparedStatement������
	      03.Statement��sql����еĲ�������ֻ��ͨ��������ƴ��ʵ��
	         PreparedStatementҲ����ʹ��ռλ���ķ�ʽʵ�֣�����ʹ�ã�
	      04.Statement��ͨ��connecetion.createStatement()����Ҫsql��Ϊ����
	         Statement��ִ��sql����ʱ����Ҫsql��Ϊ������
	        PreparedStatement��ͨ��connecetion.prepareStatement(sql)��Ҫsql��Ϊ����
	        PreparedStatement��ִ��sql����ʱ�򣬲���Ҫsql��Ϊ������
	  03.��sql���������ʹ�ñ����ĵط�����ռλ�� ��?��
	  04.��ռλ����ֵ
  
 ���⣿
 01.����������Ĳ������ǻ���user��� �����������һ��Animal�ࣿ
        ��ô�����ǲ���Ҳ���Ҷ�Ӧ����ɾ�Ĳ�һЩ�з���
 02.�������ǵļ����������Լ���ȡ���ݿ����Ӻ��ͷ���Դ�Ĵ��� ��û���Ż���       
        
 �����Ż�   ���ݿ����� 
   ���ݿ����ӵ���Ҫ��
    Driver(��ͬ�����ݿ⳧���в�ͬ��������)   Url   userName   password
    
 ���ʣ�
   ������ǰ�   ���ݿ����ӵ���Ҫ�� д�������Ǵ����У�
     01.������������
     02.��������ʹ�õ���mysql���ݿ⣬�����������ݿ��oracle?
              ��ȥ���ǵ���Ŀ���ҵ����ݿ����ӵ���Ҫ�� ���ڵ�λ�� ֮����ģ�
              
              
01.��������Ҫ�����ݿ���Ҫ�� �Ž� properties�ļ���
02.�б�Ҫÿ���û�����һ��ר�ŵĶ���������properties�ļ��е�����
	    ���е��û��������һ��properties�ļ�����
	    ʹ�õ�����
03.������ȡ  properties�ļ����ݵĵ�����
04.ȥcom.xdf.jdbcpro.JdbcDemo�޸Ĵ���   
    ֮ǰ����ʹ�ù̶���ʽ��driver,url,userName,password
   ȫ��ͨ��ConfigManager���е�getValue(Stirng  key)����ȡ��
  
  
  ���⣺
   01.ʹ�÷�����Ƽ����������Լ���ȡ���ݿ����ӵĴ��뻹���ظ�
   02.�ͷ���Դ���뻹���ظ�  
   03.����ֻ��һ��userҵ�����˵����������ҵ�񣬱���˵���ǵ��˵�����Ʒ.....
            ���ҵ�����еĴ��ظ���
      
    
 �����Ż�   
            
    �������ظ��Ĵ�����ȡ��һ�����������У������ǵ�ҵ����̳�����������࣡����
    
01.���������й�����������ȡ��com.xdf.util.BaseDao�У�
02.�ѷ�����Ƽ����������Լ���ȡ���ݿ����ӵĴ�����ȡ��com.xdf.util.BaseDao�У�

 ���������⣺
   01.getConncetion�����Լ�if�ж�
   02.�ر���Դû���Ż�
   03.���е���ɾ�Ķ���һ������executeUpdate()
   04.���еĲ�ѯ����һ������executeQuery()
   05.��������� ��������һ�ű�����javaBean

















	   
   
   
   
   