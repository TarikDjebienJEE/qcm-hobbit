package questionnaires;

import java.util.ArrayList;
import java.util.List;



public class MultiAnswer extends Answer<List<String>> {


	/**
	 */
	public MultiAnswer(List<String> theRightAnswer){
		super(theRightAnswer);
	}

	@Override
	public boolean accept(String s) {
		return (!(s.length()==0));
	}

	@Override
	public void createMyAnswerPanel() {
	}

	@Override
	public String instruction() {
		return "("+this.getValue().size()+" réponses possibles)";
	}

	@Override
	public boolean isCorrect(String text) {
		return this.getValue().contains(text.toLowerCase());
	}
	
	public static Answer<?> build(String answerText) throws IllegalArgumentException{
		String[] res = answerText.split(";");
		List<String> l = new ArrayList<String>();
		for(int i=0;i<res.length;i++) l.add(res[i].toLowerCase());
		return new MultiAnswer(l);
	}

}
