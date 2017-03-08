import java.util.Scanner;
public class ArrayManip
{
	public static void main(String [] args)
	{
		testContainsAll();
	}

	public static boolean searchNum(int myArray[], int num)
	{
		boolean flag = false;
		int counter = 0;
		while(flag==false && counter<myArray.length)
		{
			if(num == myArray[counter])
				flag=true;

			counter++;
		}
		return flag;
	}

	public static void testSearchNum()
	{	
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of input array");
		int array[] = new int[input.nextInt()]; 
		System.out.println("Enter number of ints required");

		for(int i=0; i<array.length; i++)
		{
			array[i] = input.nextInt();
		}
		
		System.out.println("Enter number to search for");
		int findNum = input.nextInt();

		boolean result = searchNum(array,findNum);
		if(result == true)
			System.out.println("Num found");
		else
			System.out.println("Num not found");
	}

	public static boolean hasDuplicates(int arrayNum[])
	{
		boolean dupFound = false;
		int ctr1 =0;

		while (ctr1<arrayNum.length && !dupFound)
		{
			int ctr2 = ctr1+1; // be 1 ahead each time ctr1 increments
			while(ctr2<arrayNum.length)
			{
				if(arrayNum[ctr1] == arrayNum[ctr2])
					dupFound = true;
				ctr2++;
			}
			ctr1++;
		}		

		return dupFound;
	}

	public static int[] removeDuplicates(int[] arrayNum)
	{
		if(hasDuplicates(arrayNum) == false)
			return arrayNum;
		else
		{
			int outArray[] = new int[arrayNum.length]; 
			int ctr1=0;
			int ctr2 = ctr1+1;
			int index = 0;
			boolean dupFound = false;
			
			while(ctr1<arrayNum.length)
			{	
				dupFound = false;
				ctr2 = ctr1+1;

				while(ctr2<arrayNum.length && !dupFound)
				{
					if(arrayNum[ctr1] == arrayNum[ctr2])
						dupFound = true;
					ctr2++;
				}
				
				if(dupFound == false)
				{
					outArray[index] = arrayNum[ctr1]; 
					index++;
				}

				ctr1++;
			}
			return outArray;
		}	
	}

	public static boolean containsAll( int[] listA, int[] listB)
	{
		boolean containsAll = true;
		int ctr1 = 0;

		while(ctr1 < listA.length && containsAll)
		{		
			containsAll = searchNum(listB,listA[ctr1]);	
			ctr1++;
		}
		return containsAll;
	}

	public static void testContainsAll()
	{
		Scanner input1 = new Scanner(System.in);
		System.out.println("Enter size of  first array");
		int array1[] = new int[input1.nextInt()];
		
		System.out.println("Enter number of ints required");
		for(int i=0; i<array1.length; i++)
		{
			array1[i] = input1.nextInt();
		}

		Scanner input2 = new Scanner(System.in);
		System.out.println("Enter size of  second array");
		int array2[] = new int[input2.nextInt()];
		
		System.out.println("Enter number of ints required");
		for(int i=0; i<array2.length; i++)
		{
			array2[i] = input2.nextInt();
		}

		boolean containsAll = containsAll(array1,array2);
		if(containsAll == true)
			System.out.print("listB contains all elements of listA");
		else
			System.out.print("listB doesn't contain all elements of listA");
	}

	public static void testRemoveDuplicates()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of input array");
		int array[] = new int[input.nextInt()];
		
		System.out.println("Enter number of ints required");
		for(int i=0; i<array.length; i++)
		{
			array[i] = input.nextInt();
		}

		System.out.println("\nNo duplicates array:");
		int outArray[];
		outArray = removeDuplicates(array);
		for(int i=0; i<outArray.length; i++)
		{
			System.out.println(outArray[i]);
		}
	}

	public static void testHasDuplicates()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter size of input array");
		int array[] = new int[input.nextInt()];

		System.out.println("Enter number of ints required");
		for(int i=0; i<array.length; i++)
		{
			array[i] = input.nextInt();
		}

		boolean result = hasDuplicates(array);
		if(result == true)
			System.out.println("Duplicate found");
		else
			System.out.println("No duplicates found");
	}

}