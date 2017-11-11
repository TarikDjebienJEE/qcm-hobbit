package questionnaires;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * @uml.dependency   supplier="questionnaires.Answer"
 */
public class AnswerFactory {

	/**
	 * @uml.property  name="FACTORY" readOnly="true"
	 */
	public static final AnswerFactory FACTORY = new AnswerFactory();
	/**
	 * @uml.property  name="MULTIPLE_CHOICE_SEPARATOR" readOnly="true"
	 */
	private static final String multiple_choice_separator = "|";
	/**
	 * @uml.property  name="MULTI_ANSWER_SEPARATOR" readOnly="true"
	 */
	private static final String multi_answer_separator = ";";

	/**
	 * @throws ClassNotFoundException 
	 * @throws NoSuchMethodException 
	 * @throws SecurityException 
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public Answer<?> buildAnswer(String answerText,String answerClassName) 
	throws ClassNotFoundException, SecurityException, NoSuchMethodException, IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		// On recupere l'object Class pour la classe de nom answerClassName
	Class<?> c = Class.forName(answerClassName);
		// On recupere pour cette classe la méthode de signature build(String)
	Method m = c.getMethod(new String("build"), String.class);
	    // On invoque la methode build avec comme 1er param = null car build est static
	Answer<?> answer = (Answer<?>) m.invoke(null, answerText);
	return answer;
		
	}








	/**
	 * @return the fACTORY
	 */
	public static AnswerFactory getFACTORY() {
		return FACTORY;
	}


	/**
	 * @return the multiple_choice_separator
	 */
	public static String getMultiple_choice_separator() {
		return multiple_choice_separator;
	}


	/**
	 * @return the multi_answer_separator
	 */
	public static String getMulti_answer_separator() {
		return multi_answer_separator;
	}

}
