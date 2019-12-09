实验名称：学生选课系统设计 
实验目的：
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常
实验要求：一、系统角色分析及类设计
例如:学校有“人员”,分为“教师”和“学生”,教师教授“课程”学生选择课程
定义每种角色人员的属性,及其操作方法。
属性示例:人员(编号、姓名、性别……)
教师(编号、姓名、性别、所授课程
学生(编号、姓名、性别、所选课程
课程(编号、课程名称、上课地点、时间、授课教师、
心以上属性仅为示例。同学们可以自行扩展
二、要求
1、设计GUI窗体,支持学生注册、课程新加、学生选课、学生退课、打印学生选课列表等操作。
2、基于事件模型对业务逻辑编程,实现在界面上支持上述操作。
3、针对操作过程中可能会出现的各种异常,做异常处理
4、基于输入/输出编程,支持学生、课程、教师等数据的读写操作。
5、基于提交实验,包括实验SRC源文件夹程序、实验报告文档。
本次实验是综合性实验,在40%的实验成绩中占比最大,望同学们认真对待
7、提交截止时间:12月8日编写流程图
代码编辑流程图：




 
代码：
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	JPanel jp1,jp2,jp3;  //定义
	JButton Login;
	JLabel user,Id;    
	JTextField jtf1,jtf2;
	final Container c = getContentPane();//定义组件，并且为添加组件时使用

this.setTitle("学生管理系统");
		this.setSize(500, 500);
		this.setVisible(true);


		jp1 = new JPanel();
		user = new JLabel("用户名：");
		jtf1 = new JTextField(15);
		   jp1.add(user);
		   jp1.add(jtf1);
		   
		jp2 = new JPanel();
	    Id = new JLabel("学号：");
		jtf2 = new JTextField(15);
		 jp2.add(Id);
	     jp2.add(jtf2);
	     
	   jp3 = new JPanel();
	   Login = new JButton("登录");
	   jp3.add(Login);





  
	   c.setLayout(new GridLayout(5,1,10,10));
	   c.add(new JPanel());   
	   c.add(jp1);
	   c.add(jp2);
	   c.add(jp3);
	   c.add(new JPanel());
void init() {
		Login.addActionListener(new MyListener());
	}
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			String s1 = jtf1.getText();
			String s2 = jtf2.getText();
			if(s1.equals("李易安")&&s2.equals("7")) {
				new Choosing_courses();//显示选课界面
			} else {
				JOptionPane.showMessageDialog(null, "用户名或学号错误，请重新输入");
			}
		}
	}
	
	void init() {
		sure.addActionListener(new MyListener());
	}//在init方法中为确定按钮注册动作事件监听器

Teacher t1,t2,t3;
		t1 = new Teacher(1,"王浩楠","男","电路","教101","8:35am--11:15am",5);
		t2 = new Teacher(2,"姜姜"，"女","大物","教101","7:50am--11:15am",3);
		t3 = new Teacher(3,"张中媛","女","英语","教102","2:00pm--4:00pm",2);
		
		jp1 = new JPanel();//添加标签
		jl = new JLabel("请选课：");
		jp1.add(jl);
		contentPane.add(jl);

		jr1 = new JRadioButton(t1.toString());//显示单选按钮内容
		bg1 = new ButtonGroup();
		bg1.add(jr1);
		contentPane.add(jr1);
		jr2 = new JRadioButton(t2.toString());
		bg2 = new ButtonGroup();
		bg2.add(jr2);
		contentPane.add(jr2);
		jr3 = new JRadioButton(t3.toString());
		bg3 = new ButtonGroup();
		bg3.add(jr3);
		contentPane.add(jr3);
		
		jp1 = new JPanel();
		sure = new JButton("确定");
		bg4 = new ButtonGroup();
		bg4.add(sure);
		contentPane.add(sure);
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new courses1();
		}
	}

	JFrame jf = new JFrame("课表");
		jf.setSize(1000,500);
		jf.setVisible(true);
		JPanel contentPane = new JPanel();
		jf.setContentPane(contentPane);
		
		t1 = new Teacher(1,"王浩楠","男","电路","教101","8:35am--11:15am",5);
		t2 = new Teacher(2,"姜姜"，"女","大物","教101","7:50am--11:15am",3);
		t3 = new Teacher(3,"张中媛","女","英语","教102","2:00pm--4:00pm",2);

		
		jp1 = new JPanel();
		course1 = new JLabel(t1.toString());
		contentPane.add(course1);
		jp2 = new JPanel();
		course2 = new JLabel(t2.toString());
		contentPane.add(course2);
		jp3 = new JPanel();
		course3 = new JLabel(t3.toString());
		contentPane.add(course3);
		
		jp4 = new JPanel();
		drop = new JButton("退课");
		contentPane.add(drop);
	}
	
	class MyListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			new Drop();//打开退课系统界面
		}
	}

	    Teacher t1,t2,t3;
		t1 = new Teacher(1,"王浩楠","男","电路","教101","8:35am--11:15am",5);
		t2 = new Teacher(2,"姜姜"，"女","大物","教101","7:50am--11:15am",3);
		t3 = new Teacher(3,"张中媛","女","英语","教102","2:00pm--4:00pm",2);

		
		jp1 = new JPanel();
		jl = new JLabel("请退课（只允许退一门课）：");
		jp1.add(jl);
		contentPane.add(jl);

		jr1 = new JRadioButton(t1.toString());
		bg1 = new ButtonGroup();
		bg1.add(jr1);
		contentPane.add(jr1);
		jr2 = new JRadioButton(t2.toString());
		bg2 = new ButtonGroup();
		bg2.add(jr2);
		contentPane.add(jr2);
		jr3 = new JRadioButton(t3.toString());
		bg3 = new ButtonGroup();
		bg3.add(jr3);
		contentPane.add(jr3);
		
		jp1 = new JPanel();
		drop = new JButton("退课");
		bg4 = new ButtonGroup();
		bg4.add(drop);
运行图
 
 


感想与总结：在本次的实验中的实验中，我在刚开始独立的完成了部分，在编写代码过程中我又有很多的内容不会，还遇到了很多问题，在借助了参考资料以及在网上找到的资料。本次实验也是Java的最后一次实验，在这学期的java 学习中我学习到了很多的专业知识也得到了很多的帮助。

