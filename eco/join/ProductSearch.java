import java.util.Scanner;
public class ProductSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        System.out.println("Enter the number of product IDs:");
        int n = scanner.nextInt();
        int[] productIds = new int[n];
        System.out.println("Enter the product IDs in sorted order:");
        for (int i = 0; i < n; i++) {
            productIds[i] = scanner.nextInt(); 
        }
        System.out.println("Enter the target product ID to search:");
        int targetId = scanner.nextInt();
        int index = binarySearch(productIds, targetId);
        if (index != -1) {
            System.out.println("Product ID " + targetId + " found at index " + index);
        } else {
            System.out.println("Product ID " + targetId + " not found.");
        }
        scanner.close();
    }
    public static int binarySearch(int[] array, int target) {
        int left = 0; 
        int right = array.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; 
            if (array[mid] == target) {
                return mid;
            }
            if (array[mid] > target) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
}                                                                                                                                                                           //2311CS020674
