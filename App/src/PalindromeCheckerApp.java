public class PalindromeCheckerApp {

    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {

        String input = "level";

        // Convert string to linked list
        Node head = null, tail = null;
        for (char c : input.toCharArray()) {
            Node newNode = new Node(c);
            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Find middle using slow & fast pointers
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node prev = null, current = slow;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Compare first half and reversed second half
        Node first = head;
        Node second = prev;
        boolean isPalindrome = true;

        while (second != null) {
            if (first.data != second.data) {
                isPalindrome = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        System.out.println("Input: " + input);
        System.out.println("Is Palindrome? " + isPalindrome);
    }
}