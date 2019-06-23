import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class NisumProject {

	public static void main(String[] args) {
		//		System.out.println("Enter ranges , comma separted");
		//		Scanner scan = new Scanner(System.in);
		//		String str= scan.nextLine();
		String str= "[5,20] [1,2] [4,15]";
		String[] strArray =str.split(" ");
		List<NisumPojo> list= new ArrayList<NisumPojo>();
		List<NisumPojo> outputList = new ArrayList<NisumPojo>();
		NisumPojo pojo;
		int l1=0 , l2=0 ,u1=0 ,u2=0 ,templ=0 ,tempu=0;
		for(int i=0;i<strArray.length;i++)
		{
			String[] limits= strArray[i].replace("[", "").replace("]", "").split(",");
			pojo= new NisumPojo();
			pojo.setLowerLimit(limits[0]);
			pojo.setUpperLimit(limits[1]);
			list.add(pojo);
		}
		boolean flag=false;
		for(int i=0;i<list.size();i++)
		{
			flag=false;
			for(int j=i;j<list.size();j++)
			{
				if(!list.get(j).isFlag())
				{
					flag=true;
					if(i==j)
					{
						templ=Integer.parseInt(list.get(i).getLowerLimit());
						tempu=Integer.parseInt(list.get(i).getUpperLimit());
					}
					else
					{

						l2=Integer.parseInt(list.get(j).getLowerLimit());
						u2=Integer.parseInt(list.get(j).getUpperLimit());
						//logic for templ and tempu
						if((templ<=l2&&l2<=tempu)
								||
								(templ<=u2&&u2<=tempu))
						{
							if(l2<templ)
								templ=l2;
							if(u2>tempu)
								tempu=u2;
							list.get(j).setFlag(true);
						}
					}
				}
			}
			if(flag)
			{
				pojo=new NisumPojo();
				pojo.setLowerLimit(String.valueOf(templ));
				pojo.setUpperLimit(String.valueOf(tempu));
				outputList.add(pojo);
			}
		}
		System.out.println(outputList.toString());

	}

}
