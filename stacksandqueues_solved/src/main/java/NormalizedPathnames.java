import java.util.*;

import static java.util.Arrays.asList;

public class NormalizedPathnames {

    /*
    9.4
    */

    public static String shortestEquivalentPath(String path) {
        List<String> dirs;
        Deque<String> finalPath = new LinkedList<>();
        if (path.charAt(0) == '/') {
            finalPath.add("/");
            path = path.substring(1);
        }
        dirs = asList(path.split("/"));
        for (String current : dirs) {
            if (current.equals("..")) {
                if (finalPath.isEmpty() || finalPath.peek().equals("..")) {
                    finalPath.addFirst(current);
                } else {
                    finalPath.remove();
                }
            } else if (!current.equals(".") && !current.isEmpty()) {
                if (!finalPath.isEmpty() && finalPath.peek().equals("..")) {
                    finalPath.removeFirst();
                } else {
                    finalPath.addFirst(current);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if (!finalPath.isEmpty()) {
            Iterator<String> it = finalPath.descendingIterator();
            String prev = it.next();
            result.append(prev);
            while (it.hasNext()) {
                if (!prev.equals("/")) {
                    result.append("/");
                }
                prev = it.next();
                result.append(prev);
            }
        }
        return result.toString();
    }


    // FRom Book
    public static String shortestEquivalentPath(String path) {
        if (path.equals("")) {
            throw new IllegalArgumentException("Empty string is not a legal path.");
        }
        Deque<String> pathNames = new LinkedList<>();
// Special case: starts with which is an absolute path.
        if (path.startsWith("/")) {
            pathNames.addFirst("/");
        }
        for (String token : path.split("/")) {
            if (token.equals("..")) {
                if (pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
                    pathNames.addFirst(token);
                } else {
                    if (pathNames.peekFirst().equals("/")) {
                        throw new IllegalArgumentException(
                                "Path error, trying to go up root " + path);
                    }
                    pathNames.removeFirst();
                }

            } else if (!token.equals(".") && !token.isEmpty()) { // Must be a name.
                pathNames.addFirst(token);
            }
        }
        StringBuilder result = new StringBuilder();
        if (!pathNames.isEmpty()) {
            Iterator<String> it = pathNames.descendinglterator();
            String prev = it.next();
            result.append(prev);
            while (it.hasNext()) {
                if (!prev.equals("/")) {
                    result.append("/");
                }
                prev = it.next();
                result.append(prev);
            }
        }
        return result.toString();
    }
