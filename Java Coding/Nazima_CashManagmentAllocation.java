//Dynamically Growing array & used for deallocation and reallocation process.
package selenium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Nazima_CashManagmentAllocation {
//	public static int tblTransaction[][]= {
//			{1,100001, 500,1},{1,100002, 250,1}, {1,100001, 100,1}
//			};
	
	public static int tblAsset[][]= {
			{2,1000,500,150},{3,5000,4300,0},{4,1000,700,400},{5,2000,1800,0},{6,2000,0,0}
			};
	public static List<int[]> tblAllocation = new ArrayList<int[]>();//Creating array list for dynamically growing array
	
	//public static int tblAllocation[][]= {
		//	{1,2,200},{2,2,200},{3,2,100},{4,3,4900},{5,4,900},{6,5,1800}
		//};
	public static int[] rowList;
	public static int  AssetBalance = 0;
	public static int TotalBalAmt=0;
	public static int tblPendingValue[][] = new int[10][2];
	public static void main(String[] args) {
		tblAllocation.add(new int[] {1,2,200});
		tblAllocation.add(new int[] {2,2,200});
		tblAllocation.add(new int[] {3,2,100});
		tblAllocation.add(new int[] {4,3,4900});
		tblAllocation.add(new int[] {5,4,900});
		tblAllocation.add(new int[] {6,5,1800});
		UpdateAssetSum();
		PrintTableValues("Before");

		
		ValueChanged();//deallocation occurs
		PrintTableValues("After");
	}
	public static void PrintTableValues(String desc)
	{
		System.out.println("-----------------------" + desc + "----------------------------");
		System.out.println("Asset Id\tMKTVAL\tUSED\tBalance\tNew MKTVAL");
		System.out.println("---------------------------------------------------------");
		for(int k=0;k<tblAsset.length;k++)
		{
			System.out.println(tblAsset[k][0] + "\t\t" + tblAsset[k][1] + "\t" + tblAsset[k][2] + "\t" + (tblAsset[k][1]-tblAsset[k][2]) + "\t" + tblAsset[k][3]);
		}
		System.out.println("---------------------------------------------------------");
		System.out.println("Allocation ID\tAsset Id\tAmount");
		System.out.println("---------------------------------------------------------");
//		for(int k=0;k<tblAllocation.length;k++)
//		{
//			System.out.println(tblAllocation[k][0] + "\t\t" + tblAllocation[k][1] + "\t\t" + tblAllocation[k][2]);
//		}
		int i=0;
		 for (int[] row : tblAllocation) {
		        System.out.println("Allocation = " + Arrays.toString(row));
		       
		        //System.out.println(tblAllocation.get(i));
		       //i++;
		    } 
		
		System.out.println("---------------------------------------------------------");
	}
	
	public static void Deposit()
	{
		
	}
	public static void Withdraw()
	{
		
	}
public static void UpdateAssetSum()
	{
		for(int k=0;k<tblAsset.length;k++)
		{
			tblAsset[k][2]=GetAllocationTotal(tblAsset[k][0]);
		}
	}
	public static int GetAllocationTotal(int AssetId)
	{
		int Total = 0; int k=0;
//		for(int k=0;k<tblAllocation.length;k++)
//		{
		for (int[] row : tblAllocation) {
			if (tblAllocation.get(k)[1] == AssetId) Total+=tblAllocation.get(k)[2];
			k++;
		}
		return Total;
	}
	public static void ValueChanged()//deallocation
	{
		//int tblPendingValue[][] = new int[10][2];
		
		int AssetId=0;
		int iRow = 0;
		int bal = 0;
		int x=0;
		int newmkvalue=0;
		for(int k=0;k<tblAsset.length;k++)
		{
			if(tblAsset[k][3]!=0)
			{
				newmkvalue=tblAsset[k][3];
				AssetId=tblAsset[k][0];
				bal=tblAsset[k][2]-newmkvalue;
				bal=Math.abs(bal);
				AssetBalance  = bal;
				while(bal>0)
				{
					int i=0;
					//for(int i=0;i<tblAllocation.length;i++)
					for(int[] row : tblAllocation)
					{
						if((bal<tblAllocation.get(i)[2]) && (AssetId==tblAllocation.get(i)[1]))
						{
							int y=tblAllocation.get(i)[2];
								tblAllocation.get(i)[2]=tblAllocation.get(i)[2]-bal;
								bal= bal-y;
							break;
						}
						else if((bal>tblAllocation.get(i)[2]) && (AssetId==tblAllocation.get(i)[1])) 
						{
							x=tblAllocation.get(i)[2];
							bal=bal-x;
							tblAllocation.get(i)[2]=x-tblAllocation.get(i)[2];
						}
						i++;
					}
						
				}
				
				tblAsset[k][1]=tblAsset[k][3];
				tblAsset[k][3]=0;

				tblPendingValue[iRow][0] = tblAsset[k][0];
				tblPendingValue[iRow][1] = AssetBalance ;//300,500
				iRow++;
			}
		}
		UpdateAssetSum();
		PrintTableValues("After ValueChange");
		Allocations(tblPendingValue);
	}
	public static void Allocations(int[][] tblPendingValue)//reallocation
	{
		for(int i=0;i<tblPendingValue.length;i++)
		{
			if (tblPendingValue[i][0] >0)
			{
				System.out.println("Asset Id:" + tblPendingValue[i][0] + " Amount : " + tblPendingValue[i][1]);
				TotalBalAmt=AssertBalanceSum();
				 if(TotalBalAmt>=tblPendingValue[i][1])
				 {
					 RecordCreation(tblPendingValue[i][1]);
					 //UpdateAssetSum();
					 PrintTableValues("After ReAllocation");
				 }
				 else
					 System.out.println("Not enough Asset Balance available");
			}
		}
	}
	
	public static int AssertBalanceSum()
	{int bal=0;int c=0;
		for(int j=0;j<tblAsset.length;j++)
		{
			//if(tblAsset[j][0]!=AssetId)
			{
				bal=tblAsset[j][1]-tblAsset[j][2];
				c=bal+c;
			}
			
		}
		return c;
		
	}
	public static void RecordCreation(int AllocationAmount)
	{
		int iAssetBalance=0;
		for(int j=0;j<tblAsset.length;j++)
		{
			iAssetBalance=tblAsset[j][1]-tblAsset[j][2];
			
			if(iAssetBalance>0)
			{
				if (iAssetBalance >= AllocationAmount)
				{
					tblAllocation.add(new int[] { tblAllocation.size()+1, tblAsset[j][0], AllocationAmount});
					tblAsset[j][2] += AllocationAmount;
					AllocationAmount = 0;
					break;
				}
				else
				{
					AllocationAmount-= iAssetBalance;
					tblAllocation.add(new int[] { tblAllocation.size()+1, tblAsset[j][0], iAssetBalance});
					tblAsset[j][2] += iAssetBalance;
				}
			}
		}
	}
}
