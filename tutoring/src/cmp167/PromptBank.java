package cmp167;

import java.util.Random;
import java.util.regex.Matcher;

public class PromptBank {

    String [] questions;
    String [] statements;

    public PromptBank(){
        questions = new String[3]; //initialize your array to the correct length to match your number of questions you populate it with
        statements = new String[3]; //initialize your array to the correct length to match your number of questions you populate it with
    }

    public void populateStatementsArray(){
        statements[0] = "Tell me more about BLANK1 and BLANK2.";
        statements[1] = "BLANK1 seems important to you, so does BLANK2. Please tell me more.";
        statements[2] = "BLANK1 and BLANK2 seem to be on your mind. Let's talk about it.";
        /*complete this method with your other statements using BLANK1 for word1
         * and BLANK2 for word2 place holder
         */
    }

    public void populateQuestionsArray(){
        questions[0] = "Is there anything else about BLANK1 and BLANK2?";
        questions[1] = "Does BLANK1 bother you? How about BLANK2?";
        questions[2] = "Are BLANK1 and BLANK2 things you think about often?";
        /*complete this method with your other questions using BLANK1 for word1
         * and BLANK2 for word2 place holder
         */

    }

    public String question(String str){ // Replace BLANK1 and BLANK2 for questions
        String[] words = str.trim().substring(0, str.length()-1).split(" "); // words = { "I", "am", "felling", "for", "coding"};
        String blank1 = words[0]; //First word
        String blank2 = words[words.length-1]; // Last word;
        String[] q = getRandomQuestionTrunk().trim().split(" "); // We get a random question out 3

        for(int i = 0; i < q.length; i++){

            if(q[i].startsWith("BLANK1")){ // replace blank 1 by first word
                q[i] = (q[i].length() > blank1.length()) ? blank1 + q[i].charAt(q[i].length()-1) : blank1;
            }
            if(q[i].startsWith("BLANK2")){ // replace blank 2 by last word
                q[i] = (q[i].length() > blank2.length()) ? blank2 + q[i].charAt(q[i].length()-1) : blank2;
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < q.length; i++){ // myVariable =  (statement) ? result1 : result2;
            strBuilder.append(q[i]).append((i == q.length - 1) ? "" : " ");
        }
        str = strBuilder.toString();

        return str;
    }

    public String statement(String str){ // Replace BLANK1 and BLANK2 for questions
        String[] words = str.trim().substring(0, str.length()-1).split(" "); // words = { "I", "me", "felling", "for", "coding"};
        String blank1 = words[0]; //First word
        String blank2 = words[words.length-1]; // Last word;
        String[] s = getRandomStatementTrunk().trim().split(" "); // We get a random question out 3

        for(int i = 0; i < s.length; i++){
            if(s[i].startsWith("BLANK1")){ // replace blank 1 by first word
                s[i] = (s[i].length() > blank1.length()) ? blank1 + s[i].charAt(s[i].length()-1) : blank1;
            }
            if(s[i].startsWith("BLANK2")){ // replace blank 2 by last word
                s[i] = (s[i].length() > blank2.length()) ? blank2 + s[i].charAt(s[i].length()-1) : blank2;
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++){ // myVariable =  (statement) ? result1 : result2;
            strBuilder.append(s[i]).append((i == s.length - 1) ? "" : " ");
        }
        str = strBuilder.toString();

        return str;
    }

	public String getRandomStatementTrunk(){
		//fill in the method so it randomly selects the statement template
		//from the questions array ... hint use Math.random() to get the random index
		//so you can replace BLANK1 and BLANK2 with the appropriate words

        populateStatementsArray();
        int index = new Random().nextInt(3);
        return statements[index];
	}


	public String getRandomQuestionTrunk(){
		//fill in the method so it randomly selects the question template
		//from the questions array ... hint use Math.random() to get the random index
		//so you can replace BLANK1 and BLANK2 with the appropriate words

        populateQuestionsArray();
        int index = new Random().nextInt(6);
        return questions[index];
	}

    public static void pln(Object o) {
        System.out.println(o);
    }

    public static void p(Object o) {
        System.out.print(o);
    }

}