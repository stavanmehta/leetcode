public class Codec {
    HashMap<Integer,String> store = new HashMap<Integer,String>();
    
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int key = longUrl.hashCode();
        store.put(key,longUrl);
        return "http://tinyurl.com/"+key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return store.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/","")));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
