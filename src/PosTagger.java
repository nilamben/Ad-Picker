import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import java.io.IOException;

public class PosTagger {

	public static void main(String[] args) throws IOException, ClassNotFoundException{		
		String str = "I like watching movies";
		MaxentTagger tagger = new MaxentTagger("taggers/left3words-wsj-0-18.tagger");
		String tagged = tagger.tagString(str);
		System.out.println(tagged);
	}
}
