import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Graphics;
public class MoneyExchangeRate {

	public static void main(String[] args)
	{
		new 	MTFunction().performed();
	}
}
class MTFunction{
	JFrame f;
	public TextField tf1=new TextField(23);
	public TextField tf2=new TextField(15);
	public TextField tf3=new TextField(15);
	public TextArea ta=new TextArea("欢迎使用小郭制作的汇率计算器");
	String s;
	String t;
	Choice inmoney;
	Choice outmoney;
	Double []need;
	Double taneed;
	String money[]={"人民币","美元","日元","欧元","港币","韩元"};
	final Double rate[][]={{1.0,0.1465,13.5709 ,0.1016 ,1.136 ,165.6158 },
            {6.8276 ,1.0, 92.656, 0.694, 7.756, 1130.75 },
            {0.0804,0.0122,1.0,0.0091,0.0946,13.6447},
            {8.8295,1.3399,110.1032,1.0,10.4122,1500.0000},
            { 0.8803,0.1289,11.9463,0.0895,1.0, 145.7896},
            {0.006,0.0009,0.0819,0.0006,0.0069,1.0}};
	public void performed()
	{
		f=new JFrame("欢迎使用小郭制作的汇率转换器");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		f.setBounds(300, 300, 500, 300);
		f.setLayout(new GridLayout(4,1));
		f.addWindowListener(new Win());
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.setVisible(true);
		inmoney=new Choice();
		inmoney.addItem("请选择");
		inmoney.addItem("人民币");
		inmoney.addItem("美元");
		inmoney.addItem("日元");
		inmoney.addItem("欧元");
		inmoney.addItem("港币");
		inmoney.addItem("韩元");
		outmoney=new Choice();
		outmoney.addItem("请选择");
		outmoney.addItem("人民币");
		outmoney.addItem("美元");
		outmoney.addItem("日元");
		outmoney.addItem("欧元");
		outmoney.addItem("港币");
		outmoney.addItem("韩元");
		Label label=new Label("汇率为：");
		JButton btnEqual=new JButton("兑换");
		p1.add(new Label("原始货币："));
		p1.add(inmoney);
		MMonitor m=new MMonitor();
		inmoney.addItemListener(m);
		s=(String)inmoney.getSelectedItem();
		p1.add(tf1);
		p2.add(new Label("目标货币："));
		p2.add(outmoney);
		MyMonitor mm=new MyMonitor();
		outmoney.addItemListener(mm);
		t=(String)outmoney.getSelectedItem();
		p2.add(label);
		p2.add(tf2);
		tf2.setText(String.valueOf(rate[0][0]));
		p3.add(btnEqual);
		Monitor bh1=new Monitor();
		btnEqual.addActionListener(bh1);
		p3.add(tf3);
		p4.add(ta);
		ta.setEditable(false);
		f.setVisible(true);
		
	}
	
	class MMonitor implements ItemListener{
		public void itemStateChanged(ItemEvent e)
		{
			for(int i=0;i<=5;i++)
			{
				s=(String)inmoney.getSelectedItem();
				if(s.equals(money[i]))
				{
					need=rate[i];
					tf2.setText(String.valueOf(need[0]));
				}
			}
		}
		
	}
	class MyMonitor implements ItemListener{
		public void itemStateChanged(ItemEvent e)
		{for(int i=0;i<=5;i++)
		{    t=(String)outmoney.getSelectedItem();
			if(t.equals(money[i]))
				{taneed=need[i];
				tf2.setText(String.valueOf(need[i]));}
		    }
		}
	}
	class Monitor implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try{
			if(Double.parseDouble(tf1.getText())>=0){
			Double n1= Double.parseDouble(tf1.getText());
			Double n2 = Double.parseDouble(tf2.getText());
			tf3.setText(String.valueOf(n1*n2));
			System.out.println("所得汇款转换已经完成!");
			ta.setText("1 "+inmoney.getSelectedItem()+"="+taneed+outmoney.getSelectedItem());
			}
			else
				{tf3.setText("你输入的金额错误！");
				 ta.setText("无法交易");
				}	
			}
			catch(Exception a){
				new DialogShow().perfomed();
			}
}
}
}
class Win extends WindowAdapter{
	//WindowAdapter是一个系统类，它实现了窗口事件监听接口，可以接收窗口事件；
	//其子类生成的对象可作为事件监听者，具有事件监听功能
	public void windowClosing(WindowEvent e){
		System.exit(0);	
		}
	}

class DialogShow{//("请输入金额！");
	public  void perfomed()
	 {
	  JOptionPane.showMessageDialog(null, "请输入金额！", "汇率转换错误！", JOptionPane.ERROR_MESSAGE);
	  }

	 }
