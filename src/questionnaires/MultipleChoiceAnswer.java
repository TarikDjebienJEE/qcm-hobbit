package questionnaires;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;



public class MultipleChoiceAnswer extends TextAnswer {

	/**
	 * @uml.property  name="thePropositions"
	 */
	private List<String> thePropositions;

	public MultipleChoiceAnswer(String theRightAnswer, List<String> otherPropositions){
		super(theRightAnswer);
		this.thePropositions = otherPropositions;
	}

	public List<String> getThePropositions(){
		return this.thePropositions;
	}

	@Override
	public boolean accept(String s) {
		return this.getThePropositions().contains(s.toLowerCase());
	}

	@Override
	public void createMyAnswerPanel() {
	}

	@Override
	public String instruction() {
		return this.getThePropositions().toString();
	}
	
	@Override
	public boolean isCorrect(String text){
		return this.getThePropositions().get(0).equalsIgnoreCase(text);
	}	
	
	public static Answer<?> build(String answerText) throws IllegalArgumentException{
		StringTokenizer s = new StringTokenizer(answerText,"|");
		List<String> l = new ArrayList<String>();
		
		while(s.hasMoreTokens()) l.add(s.nextToken().toLowerCase());
	
		return new MultipleChoiceAnswer(l.get(0),l);
	}

}
