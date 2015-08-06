import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.text.html.HTMLDocument.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonReader {
	public static Map<String, Integer> inputData = new HashMap<String, Integer>();

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
				System.out.println("Title :" + title.toString() + " CatId: "
						+ catId);

				inputData.put(title, catId);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
