import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SearchDemo {
    
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(205, "Shoes", "Fashion"),
            new Product(150, "Phone", "Electronics"),
            new Product(303, "Watch", "Accessories"),
            new Product(175, "Bag", "Fashion")
        };

        Scanner sc = new Scanner(System.in);

        System.out.println("=== Available Products ===");
        displayAllProducts(products);

        System.out.print("\nEnter Product ID to search: ");
        int targetId = sc.nextInt();

        System.out.println("\nLinear Search:");
        Product result1 = linearSearch(products, targetId);
        System.out.println(result1 != null ? "Found: " + result1 : "Product not found");

        Arrays.sort(products, Comparator.comparingInt(p -> p.productId));
        System.out.println("\nSorted Products by ID:");
        displayAllProducts(products);

        System.out.println("\nBinary Search:");
        Product result2 = binarySearch(products, targetId);
        System.out.println(result2 != null ? "Found: " + result2 : "Product not found");

        System.out.print("\nEnter a category to filter products (e.g., Fashion): ");
        sc.nextLine(); // consume leftover newline
        String categoryInput = sc.nextLine();
        System.out.println("\nProducts in category '" + categoryInput + "':");
        filterByCategory(products, categoryInput);

        sc.close();
    }

    static void displayAllProducts(Product[] items) {
        for (Product p : items) {
            System.out.println(p);
        }
    }

    static Product linearSearch(Product[] items, int targetId) {
        for (Product item : items) {
            if (item.productId == targetId) return item;
        }
        return null;
    }

    static Product binarySearch(Product[] items, int targetId) {
        int left = 0, right = items.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid].productId == targetId) return items[mid];
            if (items[mid].productId < targetId) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    static void filterByCategory(Product[] items, String category) {
        boolean found = false;
        for (Product p : items) {
            if (p.category.equalsIgnoreCase(category)) {
                System.out.println(p);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No products found in this category.");
        }
    }
}
