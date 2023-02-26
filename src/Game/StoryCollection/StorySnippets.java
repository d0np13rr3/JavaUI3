package Game.StoryCollection;
import java.util.ArrayList;
public class StorySnippets {

    public static String[] storySnippets() {
        String[] storiesArray;
        ArrayList<String> storySnippets = new ArrayList<String>();
        storySnippets.add("---STORY----\n\n" + "Here you are, entering a strange portal. They say curiousity killed the dog. You had nothing to lose, so you went for it. Dog or no dog.\n"
                          +"\n\n---ACTIONS---\n\n" + "Make one character."
        );
        storiesArray = storySnippets.toArray(new String[0]);
        return storiesArray;
    }


}
