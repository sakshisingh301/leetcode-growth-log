import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      StringBuilder sb=new StringBuilder();

        for(String s: strs)
        {
            sb.append(s.length()).append('#').append(s);

        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {

        List<String> decodedStrings=new ArrayList<>();
        int i=0;
        while(i<s.length())
        {
            int substring=Character.getNumericValue(s.charAt(i));
            int start= i+2;
            int end=start+substring;
            decodedStrings.add(start, String.valueOf(end));


        }

        return decodedStrings;
        //5#hello5#world

    }
}
