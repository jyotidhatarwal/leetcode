        
        createHuffmanTable(root, ""); // Filling huffmanTable to see our encodings
        
        StringBuilder url = new StringBuilder("http://tinyurl.com/");
        for(int i = 0 ; i < len ; i++) {
            char c = longUrl.charAt(i);
            url.append(huffmanTable.get(c));
        }
​
        return url.toString();
    }
​
    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int len = shortUrl.length();
        StringBuilder url = new StringBuilder();
        
        // {0..18} is "http://tinyurl.com/" so ignore it during decoding
        for(int i = 19 ; i < len ;) {
            Node node = root; // Always start at root of Huffman tree
            
            // Only leaf nodes have valid characters rest are '\u0000'
            while(node.left != null && node.right != null) {
                // If '0', go left in Huffman tree else go right
                if(shortUrl.charAt(i) == '0') {
                    node = node.left;
                } else {
                    node = node.right;
                }
                i++;
            }
            
            // Append leaf node's character to the url
            url.append(node.c);
        }
        return url.toString();
    }
}
