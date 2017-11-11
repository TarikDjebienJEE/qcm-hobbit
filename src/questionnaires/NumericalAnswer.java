package questionnaires;


public class NumericalAnswer extends Answer<Integer> {


	/**
	 */
	public NumericalAnswer(Integer theRightAnswer){
		super(theRightAnswer);
	}

	@Override
	public boolean accept(String s) {
	  boolean res = true;
	  int i=0;
	  while (i<s.length() && res==true){
		  if (!Character.isDigit(s.charAt(i))) 
		  res = false;
		  i++;
	  }
	  return res;
	}

	@Override
	public void createMyAnswerPanel() {
	}

	@Override
	public String instruction() {
		return "(numerique)";
	}
	
	public static Answer<?> build(String answerText) throws IllegalArgumentException{
		boolean isNumber = true;
		for(int i=0;i<answerText.length();i++){
			if(!Character.isDigit(answerText.charAt(i))){
				isNumber = false;
			}
		}
		if(isNumber==true){
			Answer<Integer> res = new NumericalAnswer(Integer.valueOf(answerText));
			return res;
		}
		else throw new IllegalArgumentException();
	}

}
