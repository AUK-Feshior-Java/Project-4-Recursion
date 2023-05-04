import java.util.ArrayList;

public class Main {

    //1.1 The sum of the first n positive integers (3 pts.)
    public static int sum1toN(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum1toN(n - 1);
        }
    }

    //Part 1.2 Write a recursive method that computes and returns xn (3 pts.)
    public static double power(double x, int n) {
        return n == 0 ? 1 : x * power(x, n - 1);
    }


    //Part 2.1. Recursive linear search (4 pts.)
    public static int recLinearSearch(ArrayList<String> list, String key, int beginIdx, int endIdx) {
        //Base case, if we reach the end of the list, return -1
        if (beginIdx > endIdx)
            return -1;

        //If the element is found, return the index
        if (list.get(beginIdx).equals(key))
            return beginIdx;

        //Increase the start index and make recursive call
        return recLinearSearch(list, key, beginIdx + 1, endIdx);
    }

    //Part 2.2. Binary search for an array (3 pts.)
    public static int binarySearch(int[] array, int search) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (array[mid] == search) {
                return mid; // Element found
            } else if (array[mid] < search) {
                left = mid + 1; // Search right half
            } else {
                right = mid - 1; // Search left half
            }
        }

        return -1; // Element not found
    }

    //Part 2.2. Recursive Binary Search for an array (3 pts.)
    public static int recursiveBinarySearch(int[] a, int search, int low, int high) {
        if (low > high) //Base case if we reach the end of the array
            return -1;

        int mid = (low + high) / 2; // Find the middle index

        if (a[mid] == search)
            return mid; //Return the index if the element is found
        else if (search < a[mid])
            //Returning mid as high, because we know that the element is not in the right half
            return recursiveBinarySearch(a, search, low, mid - 1);
        else
            //Returning mid as low, because we know that the element is not in the left half
            return recursiveBinarySearch(a, search, mid + 1, high);

    }


    public static void main(String[] args) {
        System.out.println(power(2, 5)); // 2^5

        int[] a = { 2, 3, 5, 10, 16, 24, 32, 48, 96, 120, 240, 360, 800, 1600 };
        System.out.println(binarySearch(a, 10));
        System.out.println(recursiveBinarySearch(a, 10, 0, a.length - 1));






    }
}