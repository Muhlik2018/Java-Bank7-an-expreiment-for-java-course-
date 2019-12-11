package Customer;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Customer{
	String Fname;
	String Lname;
	public Customer()
	{
	}
	public Customer(String Fname,	String Lname)
	{	
		this.Fname=Fname;
		this.Lname=Lname;
	}
	public void write(RandomAccessFile raf)throws IOException
	{	
		raf.writeUTF(Fname);
		raf.writeUTF(Lname);

	}
	public void read(RandomAccessFile raf)throws IOException
	{	
		this.Fname=raf.readUTF();
		this.Lname=raf.readUTF();
	}
	public boolean deleteCustomer(RandomAccessFile raf)throws IOException
	{	
		int flag=0;
		raf.seek(0);
		String tempFname=Fname;
		long tempPos;
		long tempPos2;
		String tempS=new String(" ");
		while(raf.getFilePointer()!=raf.length())
		{	
			tempPos=raf.getFilePointer();
			String temp=raf.readUTF();
			System.out.println(temp);
			if(temp.equalsIgnoreCase(Fname))
			{	
				raf.readUTF();
				tempPos2=raf.getFilePointer();
				raf.seek(tempPos);
				while(raf.getFilePointer()<tempPos2)
					{
					raf.writeUTF(tempS);
					}
				flag=1;
				break;
			}
		}
		if(flag==0)
			return false;
		else
			return true;
	}
	public String getFname()
	{
		return Fname;
	}
	
	public String getLname()
	{
		return Lname;
	}
}
