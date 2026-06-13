Introduction
Behavioral design patterns focus on how objects interact and communicate with each other, helping to define the flow of control in a system. These patterns simplify complex communication logic between objects while promoting loose coupling.

Imagine a TV remote that lets you switch through channels one by one, without needing to know how the channels are stored internally. This kind of controlled access is exactly what behavioral patterns help us achieve.

One such pattern is the Iterator Pattern. Let's understand the Iterator Pattern in depth in the upcoming sections.

Iterator Pattern
The Iterator Pattern is a behavioral design pattern that provides a way to access the elements of a collection sequentially without exposing the underlying representation.
Formal Definition
The Iterator Pattern is a behavioral design pattern that entrusts the traversal behavior of a collection to a separate design object. It traverses the elements without exposing the underlying operations.

This means whether your collection is an array, a list, a tree, or something custom, you can use an iterator to traverse it in a consistent manner, one element at a time, without worrying about how the data is stored or managed internally.
Real-Life Analogy
Think of a vending machine. You don’t need to know how the snacks are arranged inside or where exactly your favorite drink is stored. You just press the "Next" button to scroll through options one by one. The vending machine controls the order and pace of traversal.

Similarly, an iterator acts like that "Next" button, giving you one item at a time, hiding the complexity of what’s going on behind the scenes.

Understanding the Problem
Let’s say we’re building a YouTube Playlist system. We want to store a list of videos and print their titles one by one. Let's look at the initial code setup:
Java


import java.util.*;

// A simple Video class with title
class Video {
    String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// YouTubePlaylist class holds a list of Video objects
class YouTubePlaylist {
    private List<Video> videos = new ArrayList<>();

    // Add a video to the playlist
    public void addVideo(Video video) {
        videos.add(video);
    }

    // Expose the video list
    public List<Video> getVideos() {
        return videos;
    }
}

// Client Code
class Main {
    public static void main(String[] args) {
        YouTubePlaylist playlist = new YouTubePlaylist();
        playlist.addVideo(new Video("LLD Tutorial"));
        playlist.addVideo(new Video("System Design Basics"));

        // Loop through videos and print titles
        for (Video v : playlist.getVideos()) {
            System.out.println(v.getTitle());
        }
    }
}
What are the Issues?
While the code works, there are several design-level concerns:
Exposes internal structure:
The internal list or array is directly returned via getVideos() or similar methods.
This breaks encapsulation, as clients can access or even modify the internal collection outside the owning class.
Tight coupling with underlying structure:
The external code is tightly bound to the specific type of collection used (like vector, list, etc.).
Any change in the internal structure may require changes in client code.
No control over traversal
Traversal logic is managed outside the class.
You can't enforce custom traversal behaviors (e.g., reverse, skip elements, filter) without modifying external code.
Difficult to support multiple independent traversals:
If two parts of your program want to iterate over the same playlist independently, there's no built-in way to do that cleanly.
You have to manage indexing and traversal state manually.

Let us now understand how we can solve this problem using the Iterator Pattern.

The Solution
To fix the issues like exposing internal data and lacking control over traversal, we can apply the Iterator Pattern. This pattern lets external code access playlist items sequentially without knowing or modifying the internal data structure.

Let’s implement this using custom interfaces and iterator classes.
Java


import java.util.*;

// ========== Video class representing a single video ==========
class Video {
    private String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// ========== YouTubePlaylist class (Aggregate) ==========
class YouTubePlaylist {
    private List<Video> videos = new ArrayList<>();

    // Method to add video to playlist
    public void addVideo(Video video) {
        videos.add(video);
    }

    // Method to expose internal video list 
    public List<Video> getVideos() {
        return videos;
    }
}

// ========== Iterator interface ==========
interface PlaylistIterator {
    boolean hasNext();
    Video next();
}

// ========== Concrete Iterator class ==========
class YouTubePlaylistIterator implements PlaylistIterator {
    private List<Video> videos;
    private int position;

    // Constructor takes the list to iterate on
    public YouTubePlaylistIterator(List<Video> videos) {
        this.videos = videos;
        this.position = 0;
    }

    // Check if more videos are left to iterate
    @Override
    public boolean hasNext() {
        return position < videos.size();
    }

    // Return the next video in sequence
    @Override
    public Video next() {
        return hasNext() ? videos.get(position++) : null;
    }
}

// ========== Main method (Client code) ==========
public class Main {
    public static void main(String[] args) {
        // Create a playlist and add videos
        YouTubePlaylist playlist = new YouTubePlaylist();
        playlist.addVideo(new Video("LLD Tutorial"));
        playlist.addVideo(new Video("System Design Basics"));

        // Client directly creates the iterator using internal list (not ideal)
        PlaylistIterator iterator = new YouTubePlaylistIterator(playlist.getVideos());

        // Use the iterator to loop through the playlist
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}
How This Solves the Problem:
With the iterator pattern in place, we’ve clearly separated the concern of how elements are traversed from the actual data structure that stores them. Here's how this improves our design:

Problem	How Iterator Pattern Solves It
Direct access to internal data structure	The collection no longer exposes its internal data (like a list or array) directly for traversal. Instead, an iterator is used to access elements one-by-one, encapsulating the structure.
No standard way to iterate	All traversal is now handled through a consistent interface (hasNext() / next()), regardless of how the data is stored internally. This ensures uniformity in how iteration happens.
Traversal logic spread across client code	The logic for maintaining iteration state (e.g., index or position) is encapsulated within the iterator class itself, keeping the client code clean and focused only on usage.
Difficult to customize traversal	Custom iterator classes can easily be extended to provide different traversal strategies (e.g., reverse, filtering, skipping), without changing the underlying collection.
Tight coupling to collection type	Client code no longer depends on the exact type of data structure (like array, list, vector). It interacts only with the iterator, reducing dependencies and improving flexibility.
One Major Issue Still Remains...
Even though we’ve abstracted the traversal logic into an iterator class, the client is still responsible for creating and using the iterator, which is not ideal. The goal of true encapsulation would be to hide even the creation of the iterator, something we’ll address now with a more refined approach in the next section.

More Refined Approach
This version fully aligns with the Iterator Design Pattern, where the collection itself provides the iterator, and the client is decoupled from the internal list structure.
Java


import java.util.*;

// ========== Video class representing a single video ==========
class Video {
    private String title;

    public Video(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}

// ================ Playlist interface ================
// (acts as a contract for collections that are iterable) 
interface Playlist {
    // Method to return an iterator for the collection
    PlaylistIterator createIterator();
}

// ========== YouTubePlaylist class (Aggregate) ==========
// Implements Playlist to guarantee it provides an iterator
class YouTubePlaylist implements Playlist {
    private List<Video> videos = new ArrayList<>();

    // Method to add a video to the playlist
    public void addVideo(Video video) {
        videos.add(video);
    }

    // Instead of exposing the list, return an iterator
    @Override
    public PlaylistIterator createIterator() {
        return new YouTubePlaylistIterator(videos);
    }
}

// ========== Iterator interface (defines traversal contract) ==========
interface PlaylistIterator {
    boolean hasNext();   // Checks if more elements are left
    Video next();        // Returns the next element
}

// ========== Concrete Iterator class ==========
// Implements the actual logic for traversing the YouTubePlaylist
class YouTubePlaylistIterator implements PlaylistIterator {
    private List<Video> videos;
    private int position;

    // Constructor takes the collection to iterate over
    public YouTubePlaylistIterator(List<Video> videos) {
        this.videos = videos;
        this.position = 0;
    }

    // Check if more videos are left
    @Override
    public boolean hasNext() {
        return position < videos.size();
    }

    // Return the next video in the playlist
    @Override
    public Video next() {
        return hasNext() ? videos.get(position++) : null;
    }
}

// ========== Main method (Client code) ==========
public class Main {
    public static void main(String[] args) {
        // Create a playlist and add videos to it
        YouTubePlaylist playlist = new YouTubePlaylist();
        playlist.addVideo(new Video("LLD Tutorial"));
        playlist.addVideo(new Video("System Design Basics"));

        // Client simply asks for an iterator — no access to internal data structure
        PlaylistIterator iterator = playlist.createIterator();

        // Iterate through the playlist using the provided interface
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getTitle());
        }
    }
}
Key Improvements
The YouTubePlaylist class no longer exposes its internal implementation of Videos.
The client does not manage or know about the internal structure.
The Playlist interface allows us to make other types of playlists (e.g., MusicPlaylist) that can also be iterable.
Fully aligns with the Iterator Design Pattern principles.

Ideal Scenarios for Using the Iterator Pattern
The Iterator Pattern isn’t meant for every situation, but it becomes incredibly useful in specific cases. Here are the key situations where this pattern shines:
You want to traverse a collection without exposing its internal structure:
Instead of revealing whether it's an ArrayList, Vector, or a custom tree, the pattern lets clients access elements one-by-one, safely and uniformly.
You need multiple ways to traverse a collection:
For example, forward traversal, reverse traversal, or skipping every second element. Each of these can be handled by a different iterator implementation without changing the collection itself.
You want a unified way to traverse different types of collections:
Whether it’s a list of videos, a set of songs, or a stack of documents, clients should be able to iterate over them using a common interface.
You want to decouple iteration logic from collection logic:
By separating how elements are stored from how they’re accessed, you reduce complexity and improve maintainability. Changes in iteration logic won’t affect how the collection is structured, and vice versa.

Real World Examples
The Iterator Pattern is deeply embedded in software systems where data needs to be traversed without exposing its internal structure. Here are two crisp, real-world examples:
1. Java Collection Framework
In Java, every collection class, like ArrayList, HashSet, TreeSet, implements the Iterable interface, which returns an Iterator via the iterator() method:
Java


List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");

Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}

The client doesn’t need to know how the list is implemented internally, just how to get the next element.

2. Java Streams and Spliterator
Java Streams internally rely on a traversal mechanism called Spliterator (Split + Iterator). It is designed to iterate elements efficiently and also supports splitting the data for parallel processing. This becomes extremely useful when dealing with large datasets, where Java can process data in multiple threads using parallel streams.

For example, when you call stream() or parallelStream() on a collection, Java obtains a Spliterator behind the scenes to traverse elements and optionally split the workload.

Java


List<Integer> nums = Arrays.asList(10, 20, 30, 40);

// Stream traversal (internally uses a Spliterator)
nums.stream().forEach(System.out::println);

// Parallel stream traversal (Spliterator can split work across threads)
nums.parallelStream().forEach(System.out::println);

So even though you do not explicitly create an iterator here, Java is still using the same underlying idea: traversing elements sequentially without exposing how the collection is structured, which is exactly what the Iterator Pattern is about.

Pros and Cons
Pros of Iterator Pattern
Hides internal structure:
You can traverse a collection without knowing how it's built internally.
Unified way to traverse:
You use the same methods (hasNext, next) regardless of the collection type.
Supports multiple traversal strategies:
You can easily create different iterators (e.g., forward, reverse, filtered).
Follows SRP and OCP principles:
Iteration logic is separated (Single Responsibility), and new iterators can be added without modifying existing code (Open/Closed).

Cons of Iterator Pattern
Adds extra classes/interfaces:
Requires more boilerplate code to set up custom iterators.
Can be overkill for simple data structures:
For small lists, a direct for loop might be more straightforward.
External iteration is manual:
Client has to manage the loop using hasNext() and next() unless abstracted further.

Class Diagram