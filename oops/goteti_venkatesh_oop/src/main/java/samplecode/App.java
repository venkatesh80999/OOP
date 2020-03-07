package samplecode;
import java.util.*;

public class App 
{
    public static void main( String[] args )
    {
    	Scanner in=new Scanner(System.in);
        List<Sweet> s=new ArrayList<Sweet>();
        s.add(new Chocolate("DairyMilk",180,200.0f,62));
        s.add(new Chocolate("KitKat",20,50.5f,50));
        s.add(new Chocolate("MilkyBar",10,20.4f,40));
        s.add(new Chocolate("FerreroRocher",200,180.7f,75));
        s.add(new Jelly("JustJelly",30,20.6f,25));
        s.add(new Jelly("JollyRancher",20,15.6f,20));
        s.add(new Jelly("JellyBelly",50,20.6f,65));
        s.add(new Candy("Hershey's_Kisses",60,8.1f,90));
		s.add(new Candy("LaffyTaffy",90,30.1f,75));
		s.add(new Candy("Nerds",10,2.6f,10));
		s.add(new Candy("MilkyWay",30,15.6f,25));
		s.add(new Candy("DoubleBubbleGum",5,3.0f,15));
		List<Sweet> ch=new ArrayList<Sweet>();
		int n=s.size();
		float tw=0.0f;
		for(int i=0;i<n;i++) tw+=s.get(i).weight;
		System.out.println("Total Weight of Gift is : "+tw);
		for(int i=0;i<n;i++) {
			if(s.get(i) instanceof Chocolate) ch.add(s.get(i));
		}
		System.out.print("Enter the Option :\n1.sortByCost\n2.sortByWeight\n3.sortBySweetness\n4.don't sort\n");
		int option=in.nextInt();
		if(option==1) Collections.sort(ch,new sortByCost());
		else if(option==2) Collections.sort(ch,new sortByWeight());
		else if(option==3) Collections.sort(ch,new sortBySweetness());
		System.out.println("Chocolates Present in the Gift are:");
		System.out.printf("\n%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
		for(int i=0;i<ch.size();i++){
			System.out.printf("%-15s %3d %8.4f %6d\n\n",ch.get(i).Name,ch.get(i).cost,ch.get(i).weight,ch.get(i).sweetness);
		}
		System.out.println("Do you Want List of Candies(y/n)");
		char c=in.next().charAt(0);
		if(c=='y'||c=='Y'){
			System.out.print("Enter the Option :\n1.Cost\n2.Weight\n3.Sweetness\n");
			option=in.nextInt();
			System.out.println("Enter the Range");
			int min=in.nextInt();
			int max=in.nextInt();
			System.out.printf("%-15s %-6s %-6s %12s\n\n","NAME","COST","WEIGHT","SWEETNESS");
			Sweet curr;
			int f=0;
			if(option==1) {
				for(int i=0;i<n;i++) {
					curr=s.get(i);
					if(curr instanceof Candy && curr.cost>=min && curr.cost<=max){
						f=1;
						System.out.printf("%-15s %3d %8.2f %6d\n\n",curr.Name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with cost of given range is not available");
			}
			else if(option==2) {
				for(int i=0;i<n;i++) {
					curr=s.get(i);
					if(curr instanceof Candy && curr.weight>=min && curr.weight<=max){
						f=1;
						System.out.printf("%-15s %3d %8.4f %6d\n\n",curr.Name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with weight of given range is not available");
			}
			else {
				for(int i=0;i<n;i++) {
					curr=s.get(i);
					if(curr instanceof Candy && curr.sweetness>=min && curr.sweetness<=max){
						f=1;
						System.out.printf("%-15s %3d %8.4f %6d\n\n",curr.Name,curr.cost,curr.weight,curr.sweetness);
					}
				}
				if(f==0) System.out.println("\nCandies with sweetness of given range is not available");
			}
		}
		in.close();
    }
}
