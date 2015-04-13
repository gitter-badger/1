package modeling.mybishe;

import java.util.ArrayList;
import java.util.Iterator;

import model.State;
import model.Statechart;
import model.Transition;
import modeling.sign.ElementSign;
import modeling.sign.impl.JavaStateSign;
import modeling.sign.impl.JavaTransitionSign;

public class JavaAnnotationAnalyst {

	private Statechart statechart;
	// private ArrayList<ElementSign> signList;
	private JavaStateSign javaStateSign;
	private JavaTransitionSign javaStatetransSign;

	public JavaAnnotationAnalyst() {
		statechart = new Statechart();
		// signList = new ArrayList<ElementSign>();
		javaStateSign = new JavaStateSign();
		javaStatetransSign = new JavaTransitionSign();
	}

	public void analysisState(String line) {
		if (javaStateSign.hasThisSign(line)) {
			State state = javaStateSign.stateExtractState(line);
			if(!statechart.getStates().contains(state)){
				statechart.addState(state);
			}
		
		}
	}

	// public void analysisTransition(String line) {
	// if (javaStatetransSign.hasThisSign(line)) {
	// Iterator<State> stateIter = javaStatetransSign.stateExtract(line);
	// while (stateIter.hasNext()) {
	// statechart.addState(stateIter.next());
	// }
	//
	// Transition transition = javaStatetransSign.transitionExtract(line);
	// statechart.addTransition(transition);
	// }
	// }

	public void analysisTransition(String line) {	
		if (javaStatetransSign.hasThisSign(line)) {		
			Transition transition = javaStatetransSign.transitionExtract(line,statechart.getStates());
			statechart.addTransition(transition);		
		}
	}

	public Statechart getStatechart() {
		return statechart;
	}

	public void setStatechart(Statechart statechart) {
		this.statechart = statechart;
	}

	public JavaTransitionSign getJavaStatetransSign() {
		return javaStatetransSign;
	}

	public void setJavaStatetransSign(JavaTransitionSign javaStatetransSign) {
		this.javaStatetransSign = javaStatetransSign;
	}

}
