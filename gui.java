package GUItest;
import java.awt.*;
import Customer.*;

import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.*;
import java.awt.event.*;
public class gui extends JFrame{
	JPanel jp1,jp2,jp3;
	JButton jb1,jb2,jb3,jb4;
	JLabel jlb1,jlb2;
	JTextField jtf1,jtf2;
    JTextArea jta = null;
    JScrollPane jsp = null;
	public static void main(String arcs[]) throws IOException{
		gui d1=new gui();	
	}
	public gui()throws IOException
	{	
		RandomAccessFile raf =new RandomAccessFile("d:/test3.txt","rw");
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
	       jlb1 = new JLabel("FirstName");
	        jlb2 = new JLabel("LastName");

	        jb1 = new JButton("�����û���Ϣ");
	        jb1.addActionListener(
	        		new ActionListener()
	        		{
	        			public void actionPerformed(ActionEvent e)
	        			{	if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty())
	        	        {
	        	            JOptionPane.showMessageDialog(null, "��Ϣ�п�ȱ���벹ȫ��","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
	        	        }
	        			else
	        				{
	        				String fn=jtf1.getText();
	        				String ln=jtf2.getText();
	        				Customer acustomer=new Customer(fn,ln);
	        				try {
								acustomer.write(raf);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	        				JOptionPane.showMessageDialog(null,"ע��ɹ���","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
	        			}
	        			}
	        		});
	        
	        jb2 = new JButton("�˳�");
	        jb2.addActionListener(
	        		new ActionListener()
	        		{
	        			public void actionPerformed(ActionEvent e)
	        			{	
	        				JOptionPane.showMessageDialog(null,"�����˳�","�ݰ�",JOptionPane.WARNING_MESSAGE);
	        				System.exit(0);
	        			}
	        		});
	        jb3=new JButton("ɾ���ü�¼");
	        jb3.addActionListener(
	        		new ActionListener()
	        		{
	        			public void actionPerformed(ActionEvent e)
	        			{
	        				if (jtf1.getText().isEmpty()||jtf2.getText().isEmpty())
		        	        {
		        	            JOptionPane.showMessageDialog(null, "��Ϣ�п�ȱ���벹ȫ��","��Ϣ��ʾ",JOptionPane.WARNING_MESSAGE);
		        	        }
		        			else
		        				{
		        				String fn=jtf1.getText();
		        				String ln=jtf2.getText();
		        				Customer acustomer=new Customer(fn,ln);
		        				try {
									if(acustomer.deleteCustomer(raf))
									JOptionPane.showMessageDialog(null,"ɾ���ɹ� "+fn+ln+"�ѱ�ɾ��","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
									else
									JOptionPane.showMessageDialog(null,"ɾ��ʧ�ܣ� ԭ��û����","��ʾ��Ϣ",JOptionPane.WARNING_MESSAGE);
								} catch (HeadlessException | IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
		        			}
	        			}
	        		});
	        jb4=new JButton("ˢ���ı���");
	        jb4.addActionListener(
	        		new ActionListener()
	        		{
	        			public void actionPerformed(ActionEvent e)
	        			{	
	        				jta.setText(null);
	        		        try {
								raf.seek(0);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	        				try {
								while(raf.getFilePointer()!=raf.length())
								{	
									String temp=raf.readUTF();
									jta.append(temp);
									jta.append("  ");
								}
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
	        			}
	        		});

	        jtf1 = new JTextField(10);

	        jtf2 = new JTextField(10);// ���ò��ֹ���(�������ǣ�extends JFrame�����������)
	        this.setLayout(new GridLayout(3, 1));
	        jta = new JTextArea();
	        jta.setEditable(false);
	        jsp = new JScrollPane(jta);
	        // ����������
	        jp1.add(jlb1);
	        jp1.add(jtf1);

	        jp2.add(jlb2);
	        jp2.add(jtf2);

	        jp3.add(jb1);
	        jp3.add(jb2);
	        jp3.add(jb3);
	        jp3.add(jb4);
	        // ���뵽JFrame
	        this.add(jp1);
	        this.add(jp2);
	        this.add(jp3);
	        this.add(jta);
	        this.setSize(500, 300);
	        this.setTitle("��¼");
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        this.setVisible(true);
	}
	
}
