/*
Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of 
students, and the task is to allocate all the books to the students.

Allocate books in such a way that:

Each student gets at least one book.
Each book should be allocated to only one student.
Book allocation should be in a contiguous manner.
You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. 
If the allocation of books is not possible. return -1.

Example 1:
Input Format:
 n = 4, m = 2, arr[] = {12, 34, 67, 90}
Result:
 113
Explanation: The allocation of books will be 12, 34, 67 | 90. One student will get the first 3 books and the other will get the last one.

Example 2:
Input Format:
 n = 5, m = 4, arr[] = {25, 46, 28, 49, 24}
Result:
 71
Explanation: The allocation of books will be 25, 46 | 28 | 49 | 24.
*/

import java.util.Scanner;

public class _22_AllocateBooks {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] books = new int[n];
        for(int i=0; i<n; i++) {
            books[i] = in.nextInt();
        }
        int student  = in.nextInt();
        System.out.println(findPages(books, n, student));
        in.close();
    }

    private static int findPages(int[] books, int n, int student) {
        if(student > books.length) return -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(books[i] > max) {
                max = books[i];
            }
            sum += books[i];
        }

        int low = max;
        int high = sum;

        while(low <= high) {
            int mid = low + (high - low) / 2;
            int noOfStudents = getStudentWithMinimumPages(books, n, mid);
            if(noOfStudents > student) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int getStudentWithMinimumPages(int[] books, int n, int pages) {
        int noOfStudents = 1;
        int noOfPages = 0;
        for(int i=0; i<n; i++) {
            if(books[i]+noOfPages <= pages) {
                noOfPages += books[i];
            }
            else {
                noOfStudents++;
                noOfPages = books[i];
            }
        }
        return noOfStudents;
    }
}
