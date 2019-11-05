package examples;

import lemma.Lemmatizer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.SAXException;
import pos.POSTagger;
import split.SentenceSplitter;
import token.Tokenizer;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.InvalidPropertiesFormatException;

/**
 * @author Badenes Olmedo, Carlos <cbadenes@fi.upm.es>
 */

public class GlobalExample {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExample.class);


    public static void main(String[] args) {

        String text = "Era uma vez um gato maltês, tocava piano e falava "
                + "francês. O rato roeu a rolha da garrafa de rum do Rei da "
                + "Rússia. A rápida raposa castanha salta sobre o cão preguiçoso.";

        try {
            Tokenizer tokenizer = new Tokenizer();
            POSTagger tagger = new POSTagger();
            SentenceSplitter splitter = new SentenceSplitter();
            Lemmatizer lemmatizer = new Lemmatizer();

            String[] sentences = splitter.split(text);
            for (String sentence : sentences) {
                String[] tokens = tokenizer.tokenize(sentence, true);
                String[] tags = tagger.tag(tokens);
                String[] lemmas = lemmatizer.lemmatize(tokens, tags);

                StringBuffer buffer = new StringBuffer();

                for (int i = 0; i < tokens.length; i++) {
                    buffer.append(tokens[i] + "#" + tags[i] + ":" + lemmas[i] + " ");
                }

                System.out.println(buffer.toString().trim());

            }

            System.out.println("Done!");





        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }
}
