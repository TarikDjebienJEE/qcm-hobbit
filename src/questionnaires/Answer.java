package questionnaires;




public abstract class Answer <T> {

	/**
	 * @uml.property  name="value"
	 */
	protected T value;

	/**
	 */
	public Answer(T theRightAnswer){
		this.value = theRightAnswer;
	}

	/**
	 */
	public abstract boolean accept(String s);

	/**
	 */
	public abstract void createMyAnswerPanel();

	/**
	 */
	public T getValue(){
		return this.value;
	}

	/**
	 */
	public abstract String instruction();

	/**
	 */
	public boolean isCorrect(String text){
		return this.toString().equalsIgnoreCase(text);	
	}

	/**
	 */
	public String toString(){
		return this.getValue().toString();	
	}
	
	

}
