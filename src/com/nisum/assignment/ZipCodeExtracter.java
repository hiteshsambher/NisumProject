package com.nisum.assignment;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class ZipCodeExtracter {
	
	
	

	public static void main(String[] args) throws Exception {
		String str= "[11115,11120] [11111,11112] [11114,11115]";
		List<ZipCodeRange> outputList = mergeZipCodeRange(str);
		System.out.println(outputList.toString());

	}

	public static List<ZipCodeRange> mergeZipCodeRange(String str) throws Exception {
		String[] strArray =str.split(" ");
		List<ZipCodeRange> list= new ArrayList<ZipCodeRange>();
		List<ZipCodeRange> outputList = new ArrayList<ZipCodeRange>();
		ZipCodeRange pojo;
		int l2=0 ,u2=0 ,templ=0 ,tempu=0;
		for(int i=0;i<strArray.length;i++)
		{
			String[] limits= strArray[i].replace("[", "").replace("]", "").split(",");
			pojo= new ZipCodeRange();
			String l1 = limits[0];
			String u1 = limits[1];
			Pattern p = Pattern.compile("\\d+");
			if(l1.length()==5 && u1.length()==5 && p.matcher(l1).matches() && p.matcher(u1).matches()) {
				pojo.setLowerLimit(l1);
				pojo.setUpperLimit(u1);
				list.add(pojo);
			}else {
				throw new Exception("Zip code should be of length 5 and should be number");
			}
			
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
				pojo=new ZipCodeRange();
				pojo.setLowerLimit(String.valueOf(templ));
				pojo.setUpperLimit(String.valueOf(tempu));
				outputList.add(pojo);
			}
		}
		return outputList;
	}

}
