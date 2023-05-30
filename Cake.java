/* You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:
horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut...
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the 
arrays horizontalCuts and verticalCuts...
* Eg 1 : h = 5  w = 4  horizontalCuts = [1,2,4]     VerticalCuts = [1,3]         Output = 4  
* Eg 2 : h = 5  w = 4  horizontalCuts = [3,1]       VerticalCuts = [1]           Output = 6
* Eg 3 : h = 5  w = 4  horizontalCuts = [3]         VerticalCuts = [3]           Output = 9
*/
import java.util.*;
public class Cake
{
      public int MaximalAreaFromCuts(int h, int w, int horizontalCuts[], int verticalCuts[])
      {
            int maxWidth = 0, maxHeight = 0;   //*  Variable => O(1)
            Arrays.sort(horizontalCuts);      //! Sorting => O(N log N) 
            Arrays.sort(verticalCuts);       //! Sorting => O(N log N)
            if(horizontalCuts.length == 1)    // In case of single Horizontal Cut...
                  maxHeight = horizontalCuts[0] > (h - horizontalCuts[0]) ? horizontalCuts[0] : h - horizontalCuts[0];
            if(verticalCuts.length == 1)      // In case of Single Vertical Cut...
                  maxWidth = verticalCuts[0] > (w - verticalCuts[0]) ? verticalCuts[0] : w - verticalCuts[0];
            for(int i = 0; i < horizontalCuts.length - 1; i++)    //! Comparison => O(N)
            {     // The Hieght of the peice is determined by adjacent cuts...
                  int height = horizontalCuts[i + 1] - horizontalCuts[i];
                  if(height > maxHeight)
                        maxHeight = Math.max(maxHeight, height);    // Updating the maximum Width...
            }
            if(h - horizontalCuts[horizontalCuts.length - 1] > maxHeight)  // Peice created by single cut...
                  maxHeight = Math.max(maxHeight, (h - horizontalCuts[horizontalCuts.length - 1]));
            for(int i = 0; i < verticalCuts.length - 1; i++)     //! Comparison => O(N)
            {     // The width of peice is determined by adjacent cuts...
                  int width = verticalCuts[i + 1] - verticalCuts[i];
                  if(width > maxWidth)
                        maxWidth = Math.max(maxWidth, width);    // Updating the maximum Height...
            }
            if(w - verticalCuts[verticalCuts.length - 1] > maxWidth)    // Peice created by a single cut...
                  maxWidth = Math.max(maxWidth, (w - verticalCuts[verticalCuts.length - 1]));
            return maxWidth * maxHeight;    // Returning the area...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            int height, width;
            System.out.print("Enter height of the cake : ");
            height = sc.nextInt();
            System.out.print("Enter width of the cake : ");
            width = sc.nextInt();
            int cuts;
            System.out.print("Enter number of Horizontal cuts : ");
            cuts = sc.nextInt();
            int horizontalCuts[] = new int[cuts];
            for(int i = 0; i < horizontalCuts.length; i++)
            {
                  System.out.print("Enter Cut Index : ");
                  horizontalCuts[i] = sc.nextInt();
            }
            System.out.print("Enter number of Horizontal cuts : ");
            cuts = sc.nextInt();
            int verticalCuts[] = new int[cuts];
            for(int i = 0; i < verticalCuts.length; i++)
            {
                  System.out.print("Enter Cut Index : ");
                  verticalCuts[i] = sc.nextInt();
            }
            Cake cake = new Cake();     // Object creation...
            int area = cake.MaximalAreaFromCuts(height, width, horizontalCuts, verticalCuts);
            System.out.println("The Maximal Cut Area : "+area);
            sc.close();
      }
}


//! Time Complexity => O(N log N)
//* Space Complexity => O(1)
/** //? DEDUCTIONS :-
 * ? We sort the cuts array, since the size of peice after cut is determined by two adjacent cuts...
 * ? Then we iterate over the sorted array to get the cut of maximum dimensions of width and height...
 */