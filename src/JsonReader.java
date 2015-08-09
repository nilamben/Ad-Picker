import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;

public class JsonReader {
	public static Map<Integer, StringBuilder> inputData = new HashMap<Integer, StringBuilder>();
	public static Map<Integer, ArrayList<String>> keywords_map = new HashMap<Integer, ArrayList<String>>();

	public static void main(String[] args) throws Exception {
		JSONParser parser = new JSONParser();

		try {
			System.out.println("Reading JSON file from Java program");
			FileReader fileReader = new FileReader(args[0]);
			JSONObject json = (JSONObject) parser.parse(fileReader);

			JSONArray myJsonArray = (JSONArray) json.get("videos");
			for (int i = 0; i < myJsonArray.size(); i++) {
				JSONObject myJObject = (JSONObject) myJsonArray.get(i);
				JSONObject snippet = (JSONObject) myJObject.get("snippet");
				String title = snippet.get("title").toString();
				int catId = Integer.parseInt(snippet.get("categoryId")
						.toString());
				StringBuilder sb = new StringBuilder();
				if (inputData.containsKey(catId)) {
					sb.append(inputData.get(catId));
					sb.append(" " + title);
				} else {
					sb.append(title);
				}
				inputData.put(catId, sb);
			}
			for (Map.Entry<Integer, StringBuilder> entry : inputData.entrySet()) {

				// Tag words
				MaxentTagger tagger = new MaxentTagger(
						"taggers/left3words-wsj-0-18.tagger");
				String title = tagger.tagTokenizedString(entry.getValue()
						.toString());
				System.out.println("----------Tagged texts-----");
				System.out.println(" CatId: " + entry.getKey() + " Title: "
						+ title);

				// Get desired keywords
				ArrayList<String> keywords = new ArrayList<String>();
				String[] taggedText = title.split(" ");
				for (String tt : taggedText) {
					if (tt.contains("_NNP") || tt.contains("_NN")
							|| tt.contains("_NNPS") || tt.contains("_NNS")
							|| tt.contains("_CD") || tt.contains("_JJ") || tt.contains("_JJS") || tt.contains("_JJR")) {
						String[] kw = tt.split("_NNP|_NN|_NNPS|_NNS|_CD|_JJ|_JJR|_JJS");
						keywords.add(kw[0]);						
					}
				}
				keywords_map.put(entry.getKey(), keywords);
//				System.out.println(" CatId: " + entry.getKey() + " Title: "
//						+ entry.getValue());
				System.out.println("---------Keywords--------");
				System.out.println(" CatId: " + entry.getKey() + " Title: "
						+ keywords);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
