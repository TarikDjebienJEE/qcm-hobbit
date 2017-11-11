package questionnaires;


public class YesNoAnswer extends Answer<YesNo> {


	/**
	 */
	public YesNoAnswer(YesNo theRightAnswer){
		super(theRightAnswer);
	}

	@Override
	public boolean accept(String s) {
		String oui = new String("vrai");
		String non = new String("faux");
		if (s.equalsIgnoreCase(oui)||s.equalsIgnoreCase(non))
			return true;
		else 
			return false;
	}

	@Override
	public void createMyAnswerPanel() {
	}

	@Override
	public String instruction() {
		return "(vrai/faux)";
	}
	
	@Override
	public boolean isCorrect(String s){
		return s.equalsIgnoreCase(this.value.name());
	}
	
	public static Answer<?> build(String answerText) throws IllegalArgumentException{
		if (answerText.equalsIgnoreCase("vrai")){
			Answer<YesNo> res = new YesNoAnswer(YesNo.vrai);
			return res;
		}
		else 
		if (answerText.equalsIgnoreCase("faux")){
			Answer<YesNo> res = new YesNoAnswer(YesNo.faux);
			return res;
		}
		else throw new IllegalArgumentException();
	}

}
