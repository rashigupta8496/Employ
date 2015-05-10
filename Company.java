import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Company {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub

		Scanner s=new Scanner(new File("ip.txt"));
		int n=s.nextInt();
		s.nextLine();
		ArrayList<Emp> eHQ=new ArrayList<Emp>(n);
		for(int i=0;i<n;i++)
		{
			String edata[];
			edata=s.nextLine().split(",");
			eHQ.add(new Emp((int)Integer.parseInt(edata[0]),edata[1],(int)Integer.parseInt(edata[2]),(int)Integer.parseInt(edata[3])));
		}
		int m=s.nextInt();
		int k=s.nextInt();
		s.nextLine();
		ArrayList<Emp> eopt=new ArrayList<Emp>(m);
		for(int i=0;i<m;i++)
		{
			eopt.add(search(eHQ,s.nextInt()));
				
		}
		ArrayList<Emp> enew=new ArrayList<Emp>(Math.min(m, k));
		for(int i=0;i<Math.min(m, k);i++)
		{
			Emp b=eopt.get(0);
			for(int j=0;j<eopt.size();j++)
			{
				if((eopt.get(j).getTen()>b.getTen()) || ((eopt.get(j).getTen()==b.getTen())&&(eopt.get(j).getSal()>b.getSal())) )
						{
							b=eopt.get(j);
						}
				
			}
			enew.add(b);
			eopt.remove(b);
			
		}
		System.out.println("HQ");
		for(int i=0;i<eHQ.size();i++)
			System.out.println(eHQ.get(i).getRoll());
		
		System.out.println("NEW");
		for(int i=0;i<enew.size();i++)
			System.out.println(enew.get(i).getRoll());
	}
		
		public static Emp search(ArrayList<Emp> hq,int id)
		{
			for(int i=0;i<hq.size();i++)
			{
				if(hq.get(i).getRoll()==id)
				{
					return hq.get(i);
				}
			}
			return null;
		}
	}


