import java.util.Deque;
import java.util.LinkedList;

class Solution {

    public String simplifyPath(String path) {

        // Split the path into directory names
        String[] tokens = path.split("/");

        // Stack to keep track of valid directories
        Deque<String> stack = new LinkedList<>();

        // Process each token
        for (String token : tokens) {

            // Ignore empty strings and current directory (.)
            if (token.isEmpty() || token.equals(".")) {
                continue;
            }

            // ".." means move to the parent directory
            if (token.equals("..")) {

                // Go back one directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }

            } else {

                // Normal directory name
                stack.push(token);
            }
        }

        // Root directory
        if (stack.isEmpty()) {
            return "/";
        }

        // Build the canonical path
        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append("/").append(stack.removeLast());
        }

        return sb.toString();
    }
}
