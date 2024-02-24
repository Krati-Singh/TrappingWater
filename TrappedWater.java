import java.lang.Math;
public class TrappedWater 
{
    public static int Rainwater(int a[])
    {
        //left-boundary array
        int leftHeight[] = new int[a.length];
        leftHeight[0]= a[0];
        for(int i=1; i<a.length; i++)
        {
            leftHeight[i]= Math.max(a[i],leftHeight[i-1]);

        }
        //right-boundary array
        int rightHeight[]= new int[a.length];
        rightHeight[a.length-1]= a[a.length-1];
        for(int i=a.length-2; i>=0; i--)
        {
            rightHeight[i]= Math.max(a[i],rightHeight[i+1]);
        }
        //Trapped-water level calculation
        int trappedWater=0;
        for(int i=0; i<a.length; i++)
        {
        int waterLevel = Math.min(leftHeight[i],rightHeight[i]);
        trappedWater+= waterLevel - a[i];          //Formula used
        }
        return trappedWater;
    }
    public static void main(String args[])    
    {
        int a[] ={4,2,0,6,3,2,5};         //Array containing the heights of all the blocks
        System.out.print("Total trapped water: \n" + Rainwater(a));
    }
}
