package questionnaires;


public class TextAnswer extends Answer<String> {


	/**
	 */
	public TextAnswer(String theRightAnswer){
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
		return "(symbolique)";
	}
	
	public static Answer<?> build(String answerText) throws IllegalArgumentException{
	  
	  Answer<String> res = new TextAnswer(answerText);
	  return res;
	
	}

}
