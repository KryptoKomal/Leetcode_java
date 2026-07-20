class LRUCache {

    private class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
            prev = null;
            next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;

        cache = new HashMap<>();

        // Dummy head and tail nodes
        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    // Removes a node from its current position
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Inserts a node right after head (Most Recently Used)
    private void insertToFront(Node node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    public int get(int key) {

        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);

        // Move the accessed node to the front
        remove(node);
        insertToFront(node);

        return node.value;
    }

    public void put(int key, int value) {

        // Key already exists
        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            node.value = value;

            // Move it to the front
            remove(node);
            insertToFront(node);
        }

        // New key
        else {

            // Cache is full
            if (cache.size() == capacity) {

                // Least Recently Used node
                Node lru = tail.prev;

                cache.remove(lru.key);
                remove(lru);
            }

            // Create new node
            Node node = new Node(key, value);

            cache.put(key, node);

            // Insert it as the Most Recently Used
            insertToFront(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key, value);
 */